
public class Ability 
{
	private int level;
	private String description;
	public Ability(int level, String description)
	{
		this.level = level;
		this.description = description;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public String getDescription()
	{
		return description;
	}
}
