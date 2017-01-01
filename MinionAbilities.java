import java.util.ArrayList;

public class MinionAbilities 
{
	final static ArrayList<Ability> abilitiesAvalable = new ArrayList();
	
	public MinionAbilities()
	{
		abilitiesAvalable.add(new Ability(1, "Nothing yet 1"));
		
		abilitiesAvalable.add(new Ability(2, "Nothing yet 2"));
		
		abilitiesAvalable.add(new Ability(3, "Nothing yet 3"));
		abilitiesAvalable.add(new Ability(3, "Nothing yet 3 but a second one"));
		
		abilitiesAvalable.add(new Ability(4, "Nothing yet 4"));
		abilitiesAvalable.add(new Ability(4, "Nothing yet 4 but a second one"));
		
		abilitiesAvalable.add(new Ability(5, "Nothing yet 3"));
		abilitiesAvalable.add(new Ability(5, "Nothing yet 3 but a second one"));
		
		abilitiesAvalable.add(new Ability(6, "Nothing yet 6"));
		abilitiesAvalable.add(new Ability(6, "Nothing yet 6 but a second one"));
	}
	
	public static ArrayList<Ability> getLevelAbilities(int level)
	{
		ArrayList<Ability> levelAbilitiesAvalable = new ArrayList();
		for(int i = 0; i < abilitiesAvalable.size(); i++)
		{
			if(abilitiesAvalable.get(i).getLevel() <= level)
			{
				levelAbilitiesAvalable.add(abilitiesAvalable.get(i));
			}
		}
		return levelAbilitiesAvalable;
	}
}
