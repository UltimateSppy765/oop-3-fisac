import java.awt.*;

import javax.swing.*;

public class AppFrame extends JFrame {

	private static final long serialVersionUID = -7550168408532481572L;

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
				} frame.showPanel("Login Panel");
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
		// TO-DO: Change this to DO_NOTHING_ON_CLOSE after testing
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Cannot close the window
		setResizable(false); // Cannot resize the window
		setSize(Toolkit.getDefaultToolkit().getScreenSize()); // Full screens the window
		setType(Type.UTILITY); // Prevents window from minimizing, and persists across desktops
		setUndecorated(true); // Removes the title bar

		// https://stackoverflow.com/a/6010949
		setLayout(new CardLayout());
		
		/** 
		 * These will be cards inside the card layout
		 * Refer: https://docs.oracle.com/javase/tutorial/uiswing/layout/card.html
		 */
		add(new screens.LoginPanel());
	}

	void showPanel (String panelName) {
		var cpane = getContentPane();
		/** 
		 * A particular card can be shown to the user
		 * Refer: https://docs.oracle.com/javase/tutorial/uiswing/layout/card.html
		 */
		((CardLayout) cpane.getLayout()).show(cpane, panelName);
	}
}
