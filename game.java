import java.io.*;
import java.util.ArrayList;
public class game 
{

		public void run()
		{
		String outMsg = "";
		
		HangmanWindow window = new HangmanWindow();
		//window.initialize();
		
		wordBank wordBank = new wordBank();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//System.out.println("HANGMAN\n" + "Enter the size of your word");
		int num = window.getSize();
		while(window.getSize() == 0)
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			num = window.getSize();
		}
		
		wordBank.wordLengths(num);
		String let = window.getLetter();
		while(true)
		{
			//num = (in.readLine()).toUpperCase();
			//System.out.println(wordBank.guessALetter(num));
			let = null;
			while(let == null)
			{
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				let = window.getLetter();
				window.removeLetter();
				outMsg = "";
			}
			
				if(let != null)
				{
					wordBank.guessALetter(let);
					outMsg += wordBank.getOutMsg() + "\n";
					//System.out.println(wordBank.guessALetter(let));
					outMsg += "Wrong guesses: " + wordBank.getGuesses() + "\n";
					if(wordBank.hasWon())
					{
						break;
					}
					//break;
				}
				
				window.addOutMsg(outMsg, wordBank.isWrong());
				
			}
		outMsg += "YOU WIN! \n";
		window.addOutMsg(outMsg, true);
		double time = System.currentTimeMillis();
			
			while(time+5000>System.currentTimeMillis())
			{
				window.addOutMsg(outMsg + "\n" + "New game in: " + (int)((time+5000 - System.currentTimeMillis())*0.001), true);
			}
			
			
			this.run();
		}
		//System.out.println("YOU WIN!!!");
}
