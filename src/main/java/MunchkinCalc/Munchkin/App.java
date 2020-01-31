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
import MunchkinCalc.Munchkin.Player;

public class App {
	String[] nr = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	ArrayList<String> playersNames = new ArrayList<String>();
	ArrayList<Integer> playersStrength = new ArrayList<Integer>();
	ArrayList<Object> playerObject = new ArrayList<Object>();
	JFrame mainFrame = new JFrame();
	JPanel mainPanel = new JPanel();

	App() {
		initComponets();
	}

	void initComponets() {
		/*
		 * Asking for confirmation of exiting the program
		 */
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int i = JOptionPane.showConfirmDialog(mainFrame, "Do you want to exit?");
				if (i == 0) {
					System.exit(0);
				}
			}

		});
		/*
		 * Setting the bounds and properties of mainFrame
		 */
		mainFrame.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width / 3,
				Toolkit.getDefaultToolkit().getScreenSize().height / 3,
				Toolkit.getDefaultToolkit().getScreenSize().width / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		mainFrame.add(mainPanel);
		mainPanel.setLayout(new GridLayout(0, 6));
		String playersNumber = (String) JOptionPane.showInputDialog(mainFrame, "Enter number of players",
				"Number of Players", JOptionPane.QUESTION_MESSAGE, null, nr, nr[0]);
		int playersNr = Integer.parseInt(playersNumber);

		/*
		 * creating new players
		 */
		Player player = new Player(mainFrame, mainPanel, playersNr, playersStrength);
//		System.out.println(playersStrength.get(player.getClass().hashCode()));
		
	}

	public static void main(String[] args) {
		new App();
	}

}
