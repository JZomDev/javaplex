package kekolab.javaplex;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import kekolab.javaplex.mappers.BooleanDeserializer;
import kekolab.javaplex.mappers.TimestampDeserializer;
import org.apache.hc.core5.net.URIBuilder;

public class PlexServer extends PlexMediaContainer {
	String friendlyName;
	String identifier;
	String machineIdentifier;
	Integer size;
	@JsonProperty("Server")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<PlexServers.PlexServer> servers;

	public List<PlexServers.PlexServer> getServers() {
		fetch();
		return servers;
	}

	public PlexServer(PlexMediaServer server, PlexHTTPClient client, String token) throws URISyntaxException
	{
		super(new URIBuilder("https://plex.tv/api/servers").appendPath(server.getMachineIdentifier()).build(), client, token);
	}

	public PlexServer(PlexServers servers,PlexHTTPClient client, String token) throws URISyntaxException
	{
		super(new URIBuilder("https://plex.tv/api/servers").appendPath(servers.machineIdentifier).build(), client, token);
	}

	public PlexServer(String machineIdentifier,PlexHTTPClient client, String token) throws URISyntaxException
	{
		super(new URIBuilder("https://plex.tv/api/servers").appendPath(machineIdentifier).build(), client, token);
	}

	@Override
	protected void clear() {
		super.clear();
		friendlyName = null;
		identifier = null;
		machineIdentifier = null;
		servers.clear();
		size = null;
	}

	@Override
	protected void update(BaseItem source) {
		super.update(source);
		if (source instanceof PlexServer plexServer) {
			friendlyName = plexServer.friendlyName;
			identifier = plexServer.identifier;
			machineIdentifier = plexServer.machineIdentifier;
			servers.addAll(plexServer.servers);
		} else {
			throw new ClassCastException("Cannot cast source to PlexServer");
		}
	}

	@Override
	public Integer getSize()
	{
		return size;
	}

	@Override
	public void setSize(Integer size)
	{
		this.size = size;
	}

	public String getFriendlyName() {
		fetch();
		return friendlyName;
	}

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	public String getIdentifier() {
		fetch();
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getMachineIdentifier() {
		fetch();
		return machineIdentifier;
	}

	public void setMachineIdentifier(String machineIdentifier) {
		this.machineIdentifier = machineIdentifier;
	}
}