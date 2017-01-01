import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.Action;

public class MinionGUI {
	
	private Random rand = new Random();
	
	private JFrame frame;
	private final Action action = new SwingAction();
	private int level = 0;
	private ArrayList<Ability> avalableMniAbi = new ArrayList();

	/**
	 * Create the application.
	 */
	
	
	public MinionGUI() {
		this.initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select a level", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setBounds(11, 11, 125, 25);
		frame.getContentPane().add(comboBox);
		
		
		JButton btnAbility = new JButton("Ability");
		btnAbility.setBounds(10, 40, 125, 23);
		frame.getContentPane().add(btnAbility);
		
		JButton button_0 = new JButton("Ability");
		button_0.setBounds(10, 65, 125, 23);
		frame.getContentPane().add(button_0);
		
		JButton button_1 = new JButton("Ability");
		button_1.setBounds(10, 90, 125, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Ability");
		button_2.setBounds(10, 165, 125, 23);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Ability");
		button_3.setBounds(10, 115, 125, 23);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("Ability");
		button_4.setBounds(10, 140, 125, 23);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("Ability");
		button_5.setBounds(10, 190, 125, 23);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("Ability");
		button_6.setBounds(10, 215, 125, 23);
		frame.getContentPane().add(button_6);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(comboBox.getSelectedIndex() != 0)
				{
					comboBox.enable(false);
					avalableMniAbi = MinionAbilities.getLevelAbilities(comboBox.getSelectedIndex());
					btnAbility.setText(addToChoices());
					button_0.setText(addToChoices());
					button_1.setText(addToChoices());
					button_2.setText(addToChoices());
					button_3.setText(addToChoices());
					button_4.setText(addToChoices());
					button_5.setText(addToChoices());
					button_6.setText(addToChoices());
					
				}
			}
			});
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private String addToChoices()
	{
		int ran = 0;
		String abiName = "Ability";
		if(avalableMniAbi.size()>0)
		{
			ran = rand.nextInt(avalableMniAbi.size());
			abiName = avalableMniAbi.get(ran).getDescription();
			avalableMniAbi.remove(ran);
		}
		return abiName;
	}
}
