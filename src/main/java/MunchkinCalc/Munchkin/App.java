package MunchkinCalc.Munchkin;

import java.awt.GridLayout;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class App
{
	String[] nr = {"2","3","4","5","6","7","8","9","10","11","12"};
	ArrayList<String> playersNames = new ArrayList<String>();
	ArrayList<Integer> playersStrength = new ArrayList<Integer>();
	JFrame mainFrame = new JFrame();
	JPanel mainPanel = new JPanel();
	
	int gearValue = 0;
	int lvlValue = 0;
	
	App()
	{
		initComponets();
	}
	
	void initComponets()
	{
		/*
		 * Asking for confirmation of exiting the program
		 */
		mainFrame.addWindowListener(new WindowAdapter()
				{
			public void windowClosing(WindowEvent e) {
				int i = JOptionPane.showConfirmDialog(mainFrame, "Do you want to exit?");
				if(i == 0)
				{
					System.exit(0);
				}
			}

				});
		/*
		 * Setting the bounds and properties of mainFrame
		 */
		mainFrame.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/3, Toolkit.getDefaultToolkit().getScreenSize().height/3, Toolkit.getDefaultToolkit().getScreenSize().width/2, Toolkit.getDefaultToolkit().getScreenSize().height/2);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		mainFrame.add(mainPanel);
		mainPanel.setLayout(new GridLayout(0,6));
		String playersNumber = (String) JOptionPane.showInputDialog(mainFrame,"Enter number of players","Number of Players",JOptionPane.QUESTION_MESSAGE, null,nr,nr[0]);
		int playersNr = Integer.parseInt(playersNumber);
		
		/*
		 * Loop for crating players
		 */
		for(int i=0; i<=playersNr; i++)
		{
			/*
			 * Creating option panes to insert
			 * players names and adding them to variable
			 */
			JTextField xField = new JTextField(5);
			JPanel myPanel = new JPanel();
		    myPanel.add(new JLabel("enter name of player "+i));
		    myPanel.add(xField);
		    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
		   
		      int result = JOptionPane.showConfirmDialog(null, myPanel, 
		               "Please enter players name", JOptionPane.OK_CANCEL_OPTION);
		      if (result == JOptionPane.OK_OPTION) {
		         System.out.println("name: " + xField.getText());
		         playersNames.add(i,xField.getText().toString());
		         	      }
		      else if(result == JOptionPane.CANCEL_OPTION) {
		    	  break;
		      }
		      /*
		       * Adding labels and spinners to mainPanel and
		       * creating change listeners for spinners
		       */
		      JLabel name = new JLabel(playersNames.get(i));
			  JLabel lvl = new JLabel("Lvl");
			  final JSpinner lvlSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
			      	lvlSpinner.addChangeListener(new ChangeListener() {
						public void stateChanged(ChangeEvent e) {
							int lvlValue = (Integer) lvlSpinner.getValue();
							System.out.println(lvlValue);
						}
			      	});
			      	
			   JLabel gear = new JLabel("Gear lvl");
			   final JSpinner gearSpinner = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
			      	gearSpinner.addChangeListener(new ChangeListener() {
						public void stateChanged(ChangeEvent e) {
							int gearValue = (Integer) gearSpinner.getValue();
							System.out.println(gearValue);
						}
			      	});
			    int summLvlValue = gearValue + lvlValue;
			    playersStrength.add(i, summLvlValue);
			    JLabel summLvl = new JLabel("Strenght: " + summLvlValue);
			    mainPanel.add(name);
			    mainPanel.add(lvl);
			    mainPanel.add(lvlSpinner);
			    mainPanel.add(gear);
			    mainPanel.add(gearSpinner);
			    mainPanel.add(summLvl);
	
		}
		/*
		 * Refresing mainFrame
		 */
		mainFrame.revalidate();
		mainFrame.repaint();
		
	}
	
    public static void main( String[] args )
    {
    	new App();
    }

}
