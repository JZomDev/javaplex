package kekolab.javaplex;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.net.URIBuilder;

public class PlexServersSharedServersInvite extends BaseItem
{
	private String friendlyName;
	private String identifier;
	private String machineIdentifier;
	private int size;

	@JsonProperty("SharedServer")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<PlexSharedServer> plexSharedServers;

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


	@Override
	protected void update(BaseItem source)
	{
		super.update(source);
		if (source instanceof PlexServersSharedServersInvite plexServersSharedServersInvite)
		{
			plexSharedServers.clear();
			plexSharedServers = plexServersSharedServersInvite.plexSharedServers;
			this.friendlyName = plexServersSharedServersInvite.friendlyName;
			this.identifier = plexServersSharedServersInvite.identifier;
			this.machineIdentifier = plexServersSharedServersInvite.machineIdentifier;
			this.size = plexServersSharedServersInvite.size;
		}
		else
		{
			throw new ClassCastException("Cannot cast source to PlexServersSharedServersInvite");
		}
	}

	public String getFriendlyName()
	{
		return friendlyName;
	}

	public void setFriendlyName(String friendlyName)
	{
		this.friendlyName = friendlyName;
	}

	public String getIdentifier()
	{
		return identifier;
	}

	public void setIdentifier(String identifier)
	{
		this.identifier = identifier;
	}

	public String getMachineIdentifier()
	{
		return machineIdentifier;
	}

	public void setMachineIdentifier(String machineIdentifier)
	{
		this.machineIdentifier = machineIdentifier;
	}

	public Integer getSize()
	{
		return size;
	}

	public void setSize(int size)
	{
		this.size = size;
	}

	public void setGetSharedServers(List<PlexSharedServer> plexSharedServers)
	{
		this.plexSharedServers = plexSharedServers;
	}

	public void setPlexSharedServers(List<PlexSharedServer> plexSharedServers)
	{
		this.plexSharedServers = plexSharedServers;
	}
}
