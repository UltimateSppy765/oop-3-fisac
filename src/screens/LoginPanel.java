package screens;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = -1222413331511075593L;
	private JFormattedTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		super(new GridBagLayout());
		setName("Login Panel");
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		add(splitPane);
		
		splitPane.setLeftComponent(new JLabel(
			new ImageIcon(
				LoginPanel.class.getResource("/media/SchoolRoom.jpg")
			)
		));
		
		JPanel optionsPanel = new JPanel();
		splitPane.setRightComponent(optionsPanel);
		GridBagLayout gbl_optionsPanel = new GridBagLayout();
		gbl_optionsPanel.columnWidths = new int[]{15, 0, 15};
		gbl_optionsPanel.rowHeights = new int[]{0, 0, 10, 0};
		optionsPanel.setLayout(gbl_optionsPanel);
		
		JPanel usernamePanel = new JPanel();
		GridBagConstraints gbc_usernamePanel = new GridBagConstraints();
		gbc_usernamePanel.anchor = GridBagConstraints.SOUTH;
		gbc_usernamePanel.gridx = 1;
		optionsPanel.add(usernamePanel, gbc_usernamePanel);
		
		JLabel usernameLabel = new JLabel("Username");
		usernamePanel.add(usernameLabel);
		
		usernameField = new JFormattedTextField();
		usernameLabel.setLabelFor(usernameField);
		usernameField.setColumns(10);
		usernamePanel.add(usernameField);
		
		JPanel passwordPanel = new JPanel();
		GridBagConstraints gbc_passwordPanel = new GridBagConstraints();
		gbc_passwordPanel.gridx = 1;
		optionsPanel.add(passwordPanel, gbc_passwordPanel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordPanel.add(passwordLabel);
		
		passwordField = new JPasswordField(10);
		passwordLabel.setLabelFor(passwordField);
		passwordPanel.add(passwordField);
		
		JPanel buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.anchor = GridBagConstraints.NORTH;
		gbc_buttonPanel.gridx = 1;
		gbc_buttonPanel.gridy = 3; // Row 2 becomes vertical gap
		optionsPanel.add(buttonPanel, gbc_buttonPanel);
		
		JButton loginButton = new JButton("Login");
		buttonPanel.add(loginButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}); buttonPanel.add(exitButton);
	}
}