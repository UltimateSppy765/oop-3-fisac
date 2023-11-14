package app;

import java.awt.*;

import javax.swing.*;

import screens.*;
import utils.Student;

public class AppFrame extends JFrame {

	private static final long serialVersionUID = -7550168408532481572L;
	public final JPanel panels[] = {new LoginPanel(this), new QuizPanel(this)};
	public static final String panelNames[] = {"Login Panel", "Quiz Panel"};
	public Student loggedInStudent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				AppFrame frame = null;
				try {
					frame = new AppFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} frame.showPanel(panelNames[0]);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AppFrame() {
		/**
		 * An actual test taker will hate the following block of code
		 */
		setAlwaysOnTop(true); // Window sits on top
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // Cannot close the window
		setResizable(false); // Cannot resize the window
		setMinimumSize(Toolkit.getDefaultToolkit().getScreenSize()); // Full screens the window
		setType(Type.UTILITY); // Prevents window from minimizing, and persists across desktops
		setUndecorated(true); // Removes the title bar
		
		// https://stackoverflow.com/a/6010949
		setLayout(new CardLayout());
		
		/** 
		 * These will be cards inside the card layout
		 * Refer: https://docs.oracle.com/javase/tutorial/uiswing/layout/card.html
		 */
		for (int i = 0; i < panels.length; ++i)
			add(panels[i], panelNames[i]);
	}

	public void showPanel (String panelName) {
		var cpane = getContentPane();
		/** 
		 * A particular card can be shown to the user
		 * Refer: https://docs.oracle.com/javase/tutorial/uiswing/layout/card.html
		 */
		((CardLayout) cpane.getLayout()).show(cpane, panelName);
	}
}