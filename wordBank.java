import java.util.ArrayList;

public class wordBank 
{
	private static String blank = "_";
	
	private ArrayList<String> guessed = new ArrayList();
	private String newLetterPlace = "";
	private ArrayList<String> words = new ArrayList();
	private ArrayList<String> longest = new ArrayList();
	private int length = 0;
	private String printWord = "";
	
	private String outMsg = "";
	private boolean wrong;
	private int guesses = 0;
	private boolean win = false;
	public wordBank()
	{
		
	}
	
	
	
	public int getGuesses()
	{
		return guesses;
	}
	
	public boolean hasWon()
	{
		return win;
	}
	
	public void wordLengths(int l)
	{
		length = l;
		wordBank1 wb1 = new wordBank1();
		words.addAll(wb1.wordLengths(l));
		wordBank2 wb2 = new wordBank2();
		words.addAll(wb2.wordLengths(l));
		wordBank3 wb3 = new wordBank3();
		words.addAll(wb3.wordLengths(l));
		wordBank4 wb4 = new wordBank4();
		words.addAll(wb4.wordLengths(l));
		wordBank5 wb5 = new wordBank5();
		words.addAll(wb5.wordLengths(l));
		wordBank6 wb6 = new wordBank6();
		words.addAll(wb6.wordLengths(l));
		wordBank7 wb7 = new wordBank7();
		words.addAll(wb7.wordLengths(l));
		wordBank8 wb8 = new wordBank8();
		words.addAll(wb8.wordLengths(l));
		wordBank9 wb9 = new wordBank9();
		words.addAll(wb9.wordLengths(l));
		wordBank10 wb10 = new wordBank10();
		words.addAll(wb10.wordLengths(l));
		
		for(int i = 0; i < length; i++)
		{
			printWord += blank;
		}
		
	}
	
	private String addNewLetter(String l)
	{
		String fin = "";
		for(int i = 0; i < l.length(); i++)
		{
			String letter = l.substring(i, i+1);
			if(letter.equalsIgnoreCase(blank))
			{
				fin += printWord.substring(i, i+1);
			}
			else
			{
				fin += letter;
			}
		}
		win = !fin.contains(blank);
		return fin;
	}
	
	public boolean isWrong()
	{
		return wrong;
	}
	
	public String wordReady(String w)
	{
		String ret = "";
		for(int i = 0; i < w.length(); i++)
		{
			String letter = w.substring(i, i+1);
			if(letter.equalsIgnoreCase(blank))
			{
				ret += printWord.substring(i, i+1) + " ";
			}
			else
			{
				ret += letter + " ";
			}
		}
		return ret;
	}
	
	public String guessALetter(String l)
	{	
		wrong = true;
		outMsg = "";
		if(guessed.contains(l))
		{
			outMsg = "You have already guessed that letter \n";
			wrong = true;
			return "You have already guessed that letter";
		}
		ArrayList<Integer> places = new ArrayList();
		
		words = coppyOver(guessedLetter(l));
		
		printWord = addNewLetter(toHyph(words.get(0), l));
		
		guessed.add(l);
		//System.out.println("Guessed letters: " + guessed);
		
		if(!printWord.contains(l))
		{
			guesses += 1;
			wrong = false;
		}
		String pw = wordReady(printWord);
		outMsg += pw + "\n";
		return printWord;
	}
	
	public ArrayList<String> guessedLetter(String l)
	{
		longest = coppyOver(words);
		ArrayList<String> most = new ArrayList();
		ArrayList<String> made = new ArrayList();
		Boolean has = false;
		for(int i = 0; longest.size() > i; i++)
		{
			String w = longest.get(i);
			made = getTheLike(w, l);
			if(made.size() > most.size())
			{
				most = coppyOver(made);
			}
		}
		return most;
	}
	
	public ArrayList<String> getTheLike(String s, String l)
	{
		ArrayList<String> theLike = new ArrayList();
		for(int i = 0; longest.size() > i; i++)
		{
			if(toHyph(longest.get(i), l).equalsIgnoreCase(toHyph(s, l)))
			{
				theLike.add(longest.get(i));
				longest.remove(i);
				i -=1 ;
			}
		}
		return theLike;
	}
	
	public String toHyph(String s, String l)
	{
		String hyph = "";
		for(int i = 0; s.length() > i; i++)
		{
			if(s.substring(i, i+1).equalsIgnoreCase(l))
			{
				hyph += l;
			}
			else
			{
				hyph += blank;
			}
		}
		return hyph;
	}
	
	public ArrayList coppyOver(ArrayList words)
	{
		ArrayList w = new ArrayList();
		for(int i = 0; i < words.size(); i++)
		{
			w.add(words.get(i));
		}
		return w;
	}
	
	public String toString()
	{
		return words.toString() + words.size();
	}
	
	public String getOutMsg()
	{
		return outMsg;
	}
}
