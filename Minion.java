import java.util.ArrayList;

public class Minion
{
	MinionAbilities allAbilities = GameStart.getMinionAbilities();
	private int level = 0;
	ArrayList<Ability> abilities = new ArrayList();
	
	
	
	public Minion()
	{
		MinionGUI setMinion = new MinionGUI();
		setMinion.initialize();
	}
	
	public void getAbilities(int level)
	{
		allAbilities.getLevelAbilities(level);
	}

}
