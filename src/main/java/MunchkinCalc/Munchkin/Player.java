package MunchkinCalc.Munchkin;

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

/*
 * Class to make players and add them to Frame
 */
public class Player {
	ArrayList<String> playersNames = new ArrayList<String>();
	ArrayList<Integer> playersStrength = new ArrayList<Integer>();
	int gearValue = 0;
	int lvlValue = 0;
	int summLvlValue = gearValue + lvlValue;

	Player(JFrame mainFrame, JPanel mainPanel, int playersNr, final ArrayList<Integer> playersStrength) {
//		playersStrength.add(Player.class.hashCode(), summLvlValue);
		for (int i = 0; i <= playersNr; i++) {
			/*
			 * Creating option panes to insert players names and adding them to variable
			 */
			JTextField xField = new JTextField(5);
			JPanel myPanel = new JPanel();
			final JLabel summLvl = new JLabel("Strenght: " + summLvlValue);

			myPanel.add(new JLabel("enter name of player " + i));
			myPanel.add(xField);
			myPanel.add(Box.createHorizontalStrut(15)); // a spacer

			int result = JOptionPane.showConfirmDialog(null, myPanel, "Please enter players name",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				System.out.println("name: " + xField.getText());
				playersNames.add(i, xField.getText().toString());
			} else if (result == JOptionPane.CANCEL_OPTION) {
				break;
			}
			/*
			 * Adding labels and spinners to mainPanel and creating change listeners for
			 * spinners
			 */
			JLabel name = new JLabel(playersNames.get(i));
			JLabel lvl = new JLabel("Lvl");
			final JSpinner lvlSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
			lvlSpinner.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					lvlValue = (Integer) lvlSpinner.getValue();
					System.out.println(lvlValue);
					summLvlValue = gearValue + lvlValue;
					summLvl.setText("Strenght: " + summLvlValue);
//					playersStrength.set(Player.class.hashCode(), summLvlValue);
				}
			});

			JLabel gear = new JLabel("Gear lvl");
			final JSpinner gearSpinner = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
			gearSpinner.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					gearValue = (Integer) gearSpinner.getValue();
					System.out.println(gearValue);
					summLvlValue = gearValue + lvlValue;
					summLvl.setText("Strenght: " + summLvlValue);
//					playersStrength.set(Player.class.hashCode(), summLvlValue);
				}
			});

			playersStrength.add(i, summLvlValue);
			mainPanel.add(name);
			mainPanel.add(lvl);
			mainPanel.add(lvlSpinner);
			mainPanel.add(gear);
			mainPanel.add(gearSpinner);
			mainPanel.add(summLvl);
			/*
			 * Refresing mainFrame
			 */
			mainFrame.revalidate();
			mainFrame.repaint();
			System.out.println();
		}

	}

}
