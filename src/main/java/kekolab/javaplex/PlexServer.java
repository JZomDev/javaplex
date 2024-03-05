package kekolab.javaplex;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import java.util.Date;
import java.util.List;
import kekolab.javaplex.mappers.TimestampDeserializer;

public class PlexServer extends BaseItem
{
	private String accessToken;
	private String name;
	private String address;
	private String port;
	private String version;
	private String scheme;
	private String host;
	private String localAddresses;
	private String machineIdentifier;
	@JsonDeserialize(using = TimestampDeserializer.class)
	private Date createdAt;
	@JsonDeserialize(using = TimestampDeserializer.class)
	private Date updatedAt;
	private String owned;
	private String synced;

	@JsonProperty("Section")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<PlexServersSection> serversSections;

	@Override
	protected void clear()
	{
		super.clear();
		accessToken = null;
		address = null;
		createdAt = null;
		port = null;
		version = null;
		scheme = null;
		host = null;
		name = null;
		localAddresses = null;
		owned = null;
		machineIdentifier = null;
		updatedAt = null;
		serversSections.clear();
	}

	@Override
	protected void update(BaseItem source)
	{
		super.update(source);
		if (source instanceof PlexServer plexServer)
		{
			serversSections.clear();
			serversSections.addAll(plexServer.serversSections);
			accessToken = plexServer.accessToken;
			address = plexServer.address;
			createdAt = plexServer.createdAt;
			port = plexServer.port;
			version = plexServer.version;
			scheme = plexServer.scheme;
			host = plexServer.host;
			name = plexServer.name;
			localAddresses = plexServer.localAddresses;
			owned = plexServer.owned;
			machineIdentifier = plexServer.machineIdentifier;
			updatedAt = plexServer.updatedAt;

		}
		else
		{
			throw new ClassCastException("Cannot cast source to PlexServer");
		}
	}

	public String getAccessToken()
	{
		return accessToken;
	}

	public void setAccessToken(String accessToken)
	{
		this.accessToken = accessToken;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPort()
	{
		return port;
	}

	public void setPort(String port)
	{
		this.port = port;
	}

	public String getVersion()
	{
		return version;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

	public String getScheme()
	{
		return scheme;
	}

	public void setScheme(String scheme)
	{
		this.scheme = scheme;
	}

	public String getHost()
	{
		return host;
	}

	public void setHost(String host)
	{
		this.host = host;
	}

	public String getLocalAddresses()
	{
		return localAddresses;
	}

	public void setLocalAddresses(String localAddresses)
	{
		this.localAddresses = localAddresses;
	}

	public String getMachineIdentifier()
	{
		return machineIdentifier;
	}

	public void setMachineIdentifier(String machineIdentifier)
	{
		this.machineIdentifier = machineIdentifier;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}

	public void setCreatedAt(Date createdAt)
	{
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt()
	{
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt)
	{
		this.updatedAt = updatedAt;
	}

	public String getOwned()
	{
		return owned;
	}

	public void setOwned(String owned)
	{
		this.owned = owned;
	}

	public String getSynced()
	{
		return synced;
	}

	public void setSynced(String synced)
	{
		this.synced = synced;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public void setServersSections(List<PlexServersSection> serversSections)
	{
		this.serversSections = serversSections;
	}

	public List<PlexServersSection> getServersSections()
	{
		return serversSections;
	}
}
