package kekolab.javaplex;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.hc.core5.net.URIBuilder;

public class PlexServers extends ServerMediaContainer
{
	String friendlyName;
	String identifier;
	String machineIdentifier;
	int size;
	@JsonProperty("Server")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<PlexServer> plexServers;

	public List<PlexServer> getServers()
	{
		fetch();
		plexServers.stream().filter(PlexServer.class::isInstance).map(PlexServer.class::cast);
		return plexServers;
	}

	public PlexServers(PlexMediaServer server, PlexHTTPClient client, String token) throws URISyntaxException
	{
		super(new URIBuilder("https://plex.tv/api/servers").appendPath(server.getMachineIdentifier()).build(), client, token, server);
	}

	@Override
	protected void clear()
	{
		super.clear();
		friendlyName = null;
		identifier = null;
		machineIdentifier = null;
		size = 0;
		plexServers.clear();
	}

	@Override
	protected void update(BaseItem source)
	{
		super.update(source);
		if (source instanceof PlexServers plexServers)
		{
			this.plexServers.clear();
			this.plexServers.addAll(plexServers.plexServers);
			this.friendlyName = plexServers.friendlyName;
			this.identifier = plexServers.identifier;
			this.machineIdentifier = plexServers.machineIdentifier;
			this.size = plexServers.size;
		}
		else
		{
			throw new ClassCastException("Cannot cast source to PlexServers");
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
}