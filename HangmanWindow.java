import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

import java.awt.Button;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.JEditorPane;
import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.DropMode;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Choice;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Panel;

public class HangmanWindow {

	private JFrame frame;
	private JTable table;
	private final Action action = new SwingAction();
	
	private ArrayList<String> letters = new ArrayList();
	private Component horizontalGlue;
	private Component horizontalGlue_1;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Component horizontalStrut_2;
	private Component horizontalStrut_5;
	private Component horizontalStrut_8;
	private Component horizontalStrut_9;
	private Component horizontalStrut_10;
	private Component horizontalStrut_11;
	private Component horizontalStrut_12;
	private Component horizontalStrut_3;
	private Component horizontalStrut_4;
	private final JTextField txtT = new JTextField();
	private JComboBox comboBox;
	private Component horizontalStrut_7;
	private Component horizontalStrut_13;
	private Component horizontalStrut_14;
	private Component horizontalStrut_6;
	private Component horizontalStrut_15;
	private Component horizontalStrut_16;
	private Component horizontalStrut_17;
	private Component horizontalStrut_19;
	private Component horizontalStrut_20;
	
	private int wordSize = 0;
	private JTextArea textArea;
	private Component horizontalStrut_22;
	private Component horizontalStrut_21;
	private JTextArea txta;
	
	private String outMsg = "";
	private ArrayList<String> deaths = new ArrayList();
	private int deathCount = 7;
	private int dead = 1;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public HangmanWindow()
	{
		this.initialize();
	}
	
	public void addOutMsg(String outmsg, Boolean wrong)
	{
		outMsg = outmsg;
		txta.setText(outMsg);
		if(!wrong)
		{
		deathCount--;
		}
		
		if(deathCount < 0)
		{
		deathCount = 7;
		deaths.remove(0);
		dead += 1;
		deaths.add(0, "  _____\r\n|/     \\|\r\n| R.I.P |\r\n|       |\r\n|  try  |\r\n| again |\r\n|  #"+ dead +"   |\r\n|_______|");
		}
		
		textArea.setText(deaths.get(deathCount));
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void initialize() 
	{
		frame = new JFrame();
		frame.setTitle("Hangman");
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		horizontalStrut_4 = Box.createHorizontalStrut(20);
		frame.getContentPane().add(horizontalStrut_4);
		
		horizontalStrut_13 = Box.createHorizontalStrut(20);
		frame.getContentPane().add(horizontalStrut_13);
		
		horizontalStrut_5 = Box.createHorizontalStrut(20);
		frame.getContentPane().add(horizontalStrut_5);
		
		horizontalStrut_8 = Box.createHorizontalStrut(20);
		frame.getContentPane().add(horizontalStrut_8);
		
		horizontalStrut_2 = Box.createHorizontalStrut(20);
		frame.getContentPane().add(horizontalStrut_2);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		frame.getContentPane().add(horizontalStrut);
		
		JEditorPane dtrpnEnterALetter = new JEditorPane();
		dtrpnEnterALetter.setEditable(false);
		dtrpnEnterALetter.setBackground(UIManager.getColor("Button.background"));
		dtrpnEnterALetter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dtrpnEnterALetter.setText("Select your \n word size");
		frame.getContentPane().add(dtrpnEnterALetter);
		
		horizontalStrut_1 = Box.createHorizontalStrut(20);
		frame.getContentPane().add(horizontalStrut_1);
		
		horizontalStrut_9 = Box.createHorizontalStrut(20);
		frame.getContentPane().add(horizontalStrut_9);
		
		horizontalStrut_10 = Box.createHorizontalStrut(20);
		frame.getContentPane().add(horizontalStrut_10);
		
		horizontalStrut_14 = Box.createHorizontalStrut(20);
		frame.getContentPane().add(horizontalStrut_14);
		
		horizontalStrut_11 = Box.createHorizontalStrut(20);
		frame.getContentPane().add(horizontalStrut_11);
		
		horizontalStrut_12 = Box.createHorizontalStrut(20);
		frame.getContentPane().add(horizontalStrut_12);
		
		horizontalStrut_20 = Box.createHorizontalStrut(20);
		frame.getContentPane().add(horizontalStrut_20);
		
		horizontalStrut_17 = Box.createHorizontalStrut(20);
		frame.getContentPane().add(horizontalStrut_17);
		
		horizontalStrut_22 = Box.createHorizontalStrut(20);
		frame.getContentPane().add(horizontalStrut_22);
		
		horizontalStrut_7 = Box.createHorizontalStrut(20);
		frame.getContentPane().add(horizontalStrut_7);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Enter the size of the word you want", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(comboBox.getSelectedIndex() != 0)
				{
				wordSize = comboBox.getSelectedIndex();
				//System.out.println(wordSize + " hi");
				comboBox.enable(false);
				dtrpnEnterALetter.setText("Guess a letter");
				}
			}
			});
		frame.getContentPane().add(comboBox);
		
		horizontalStrut_6 = Box.createHorizontalStrut(20);
		frame.getContentPane().add(horizontalStrut_6);
		
		horizontalStrut_15 = Box.createHorizontalStrut(20);
		frame.getContentPane().add(horizontalStrut_15);
		
		horizontalStrut_16 = Box.createHorizontalStrut(20);
		frame.getContentPane().add(horizontalStrut_16);
		
		horizontalStrut_19 = Box.createHorizontalStrut(20);
		frame.getContentPane().add(horizontalStrut_19);
		
		horizontalGlue_1 = Box.createHorizontalGlue();
		frame.getContentPane().add(horizontalGlue_1);
		
		String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		for(int i = 0; i < alphabet.length; i++)
		{
			//button press = new button(alphabet[i]);
			JButton pre = new JButton(alphabet[i]);
			pre.setName(alphabet[i]);
			pre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Color color = new Color(192, 192, 192);
				if(pre.getBackground() == color) 
				{
					
				}
				else
				{
					pre.setBackground(color);
					letters.add(pre.getName());
					
				}
			}
			});
			frame.getContentPane().add(pre);
			
			
		}
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		/*0*/deaths.add("  _____\r\n|/     \\|\r\n| R.I.P |\r\n|       |\r\n|  try  |\r\n| again |\r\n|  #"+ dead +"   |\r\n|_______|");//Dead
		/*1*/deaths.add("    .____   \r\n    |    |   \r\n    |    O   \r\n    | ---|---   \r\n    |    |   \r\n   /\\   / \\   \r\n   /\\  /   \\   \r\n   /\\   ");   //o[]/\|
		/*2*/deaths.add("    .____   \r\n    |    |   \r\n    |    O   \r\n    |    |---   \r\n    |    |   \r\n   /\\   / \\   \r\n   /\\  /   \\   \r\n   /\\   ");  //o?]/\|
		/*3*/deaths.add("    .____   \r\n    |    |   \r\n    |    O   \r\n    |    |      \r\n    |    |   \r\n   /\\   / \\   \r\n   /\\  /   \\   \r\n   /\\   "); //o??/\|
		/*4*/deaths.add("    .____   \r\n    |    |   \r\n    |    O   \r\n    |    |      \r\n    |    |   \r\n   /\\     \\   \r\n   /\\      \\   \r\n   /\\   ");//o???\|
		/*5*/deaths.add("    .____   \r\n    |    |   \r\n    |    O   \r\n    |    |      \r\n    |    |   \r\n   /\\        \r\n   /\\         \r\n   /\\   ");   //o????|
		/*6*/deaths.add("    .____   \r\n    |    |   \r\n    |    O   \r\n    |          \r\n    |       \r\n   /\\        \r\n   /\\         \r\n   /\\   ");    //o?????
		/*7*/deaths.add("    .____   \r\n    |    |   \r\n    |   { }   \r\n    |          \r\n    |       \r\n   /\\        \r\n   /\\         \r\n   /\\   ");  //base, arm, and noose
		textArea.setText(deaths.get(deathCount));
		frame.getContentPane().add(textArea);
		
		txta = new JTextArea();
		txta.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		txta.setEditable(false);
		txta.setText(outMsg);
		frame.getContentPane().add(txta);
		txta.setColumns(10);
		
		table = new JTable();
		frame.getContentPane().add(table);
		frame.setVisible(true);
	
		}
		
		

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	public String getLetter()
	{
		if(!letters.isEmpty())
		{
			String let = letters.get(0);
			return let;
		}
		else
		{
			return null;
		}
	}
	
	
	
	public void removeLetter()
	{
		if(!letters.isEmpty())
		letters.remove(0);
	}
	
	public int getSize()
	{
		if(wordSize != 0)
		{
		return wordSize;
		}
		return 0;
	}
}
