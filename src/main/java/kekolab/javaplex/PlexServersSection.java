package kekolab.javaplex;

public class PlexServersSection extends BaseItem
{
	private String id;
	private String key;
	private String title;
	private String type;
	private String shared;

	@Override
	protected void clear()
	{
		super.clear();
		id = null;
		key = null;
		title = null;
		type = null;
		shared = null;
	}

	@Override
	protected void update(BaseItem source)
	{
		super.update(source);
		if (source instanceof PlexServersSection plexServersServer)
		{
			id = plexServersServer.id;
			key = plexServersServer.key;
			title = plexServersServer.title;
			type = plexServersServer.type;
			shared = plexServersServer.shared;
		}
		else
		{
			throw new ClassCastException("Cannot cast source to PlexServersSharedServersSection");
		}
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getShared()
	{
		return shared;
	}

	public void setShared(String shared)
	{
		this.shared = shared;
	}
}
