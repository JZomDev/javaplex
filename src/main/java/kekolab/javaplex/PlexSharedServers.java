package kekolab.javaplex;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.net.URIBuilder;

public class PlexSharedServers extends ServerMediaContainer
{
	private String friendlyName;
	private String identifier;
	private String machineIdentifier;
	private int size;

	@JsonProperty("SharedServer")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<PlexSharedServer> plexSharedServers;

	public List<PlexSharedServer> getServers()
	{
		fetch();
		plexSharedServers.stream().filter(PlexServers.class::isInstance).map(PlexServers.class::cast);
		return plexSharedServers;
	}

	@Override
	protected void clear()
	{
		super.clear();
		plexSharedServers.clear();
		friendlyName = null;
		identifier = null;
		machineIdentifier = null;
		size = 0;
	}

	public PlexSharedServers(PlexMediaServer server, PlexHTTPClient client, String token) throws URISyntaxException
	{
		super(new URIBuilder("https://plex.tv/api/servers").appendPath(server.getMachineIdentifier()).appendPath("shared_servers").build(), client, token, server);
	}

	public PlexServersSharedServersInvite sendInvite(PlexSharedServer plexSharedServer) throws UnsupportedEncodingException
	{
		ClassicHttpRequest request = ClassicRequestBuilder
			.post(uri())
			.build();

		String body = server().friendRequestBuilder(plexSharedServer);

		HttpEntity entity = new ByteArrayEntity(body.getBytes("UTF-8"), ContentType.APPLICATION_JSON);
		request.setEntity(entity);

		return client().executeAndCreateFromResponse(request, PlexServersSharedServersInvite.class, token());
	}

	@Override
	protected void update(BaseItem source)
	{
		super.update(source);
		if (source instanceof PlexSharedServers plexSharedServers)
		{
			this.plexSharedServers.clear();
			this.plexSharedServers = plexSharedServers.plexSharedServers;
			this.friendlyName = plexSharedServers.friendlyName;
			this.identifier = plexSharedServers.identifier;
			this.machineIdentifier = plexSharedServers.machineIdentifier;
			this.size = plexSharedServers.size;
		}
		else
		{
			throw new ClassCastException("Cannot cast source to PlexSharedServers");
		}
	}

	public String getFriendlyName()
	{
		fetch();
		return friendlyName;
	}

	public void setFriendlyName(String friendlyName)
	{
		this.friendlyName = friendlyName;
	}

	public String getIdentifier()
	{
		fetch();
		return identifier;
	}

	public void setIdentifier(String identifier)
	{
		this.identifier = identifier;
	}

	public String getMachineIdentifier()
	{
		fetch();
		return machineIdentifier;
	}

	public void setMachineIdentifier(String machineIdentifier)
	{
		this.machineIdentifier = machineIdentifier;
	}

	public Integer getSize()
	{
		fetch();
		return size;
	}

	public void setSize(int size)
	{
		this.size = size;
	}

	public void setPlexSharedServers(List<PlexSharedServer> plexSharedServers)
	{
		this.plexSharedServers = plexSharedServers;
	}
}
