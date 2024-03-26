package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import kekolab.javaplex.model.PlexMediatag;
import kekolab.javaplex.model.PlexPlaylist;
import kekolab.javaplex.model.PlexPlaylistEditor;

abstract class Playlist<M extends PlexMediatag<?>> extends Metadata implements PlexPlaylist<M> {
	public static final String TYPE_DESCRIPTION = "playlist";

	private Long duration;
	@JsonDeserialize(using = TimestampDeserializer.class)
	private Date lastViewedAt;
	private Integer leafCount;
	private String playlistType;
	private Boolean smart;
	private UriProvider art;
	private UriProvider thumb;
	private UriProvider composite;

	public Playlist() {
		art = new UriProvider(this::uri);
		composite = new UriProvider(this::uri);
		thumb = new UriProvider(this::uri);
	}

	@Override
	void update(Metadata source) {
		super.update(source);
		Playlist<?> p = (Playlist<?>) source;
		setDuration(p.getDuration());
		setLastViewedAt(p.getLastViewedAt());
		setLeafCount(p.getLeafCount());
		setPlaylistType(p.getPlaylistType());
		setSmart(p.getSmart());
		setArt(p.getArt());
		setThumb(p.getThumb());
		setComposite(p.getComposite());
	}

	public Boolean getSmart() {
		ensureDetailed(smart);
		return smart;
	}

	public void setSmart(Boolean smart) {
		this.smart = smart;
	}

	public String getPlaylistType() {
		ensureDetailed(playlistType);
		return playlistType;
	}

	public void setPlaylistType(String playlistType) {
		this.playlistType = playlistType;
	}

	public Date getLastViewedAt() {
		ensureDetailed(lastViewedAt);
		return lastViewedAt;
	}

	public void setLastViewedAt(Date lastViewedAt) {
		this.lastViewedAt = lastViewedAt;
	}

	public Long getDuration() {
		ensureDetailed(duration);
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Integer getLeafCount() {
		ensureDetailed(leafCount);
		return leafCount;
	}

	public void setLeafCount(Integer leafCount) {
		this.leafCount = leafCount;
	}

	public String getComposite() {
		ensureDetailed(composite.getValue());
		return (String) composite.getValue();
	}

	public URI composite() {
		ensureDetailed(composite.uri());
		return composite.uri();
	}

	public void setComposite(String composite) {
		this.composite.setValue(composite);
	}

	public List<M> children() {
		return new MetadataContainer<M, Directory>(key(), getServer()).getMetadata();
	}

	@Override
	public URI ratingKey() {
		if (getRatingKey() != null)
			try {
				return new URIBuilder(getServer().getUri())
						.appendPathSegments("playlists", Integer.toString(getRatingKey()))
						.build();
			} catch (URISyntaxException e) {
				throw new PlexException(e);
			}
		return null;
	}

	public String getArt() {
		ensureDetailed(art.getValue());
		return (String) art.getValue();
	}

	public void setArt(String art) {
		this.art.setValue(art);
	}

	public URI art() {
		ensureDetailed(art.getValue());
		return art.uri();
	}

	public String getThumb() {
		ensureDetailed(thumb.getValue());
		return (String) thumb.getValue();
	}

	public void setThumb(String thumb) {
		this.thumb.setValue(thumb);
	}

	public URI thumb() {
		ensureDetailed(thumb.getValue());
		return thumb.uri();
	}

	@Override
	public PlexPlaylistEditor editor() {
		return new PlaylistEditor(this, ratingKey());
	}
}
