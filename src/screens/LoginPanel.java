package screens;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = -1222413331511075593L;
	private JFormattedTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setName("Login Panel");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.rowWeights = new double[]{0.0};
		gridBagLayout.columnWeights = new double[]{0.0};
		setLayout(gridBagLayout);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 0;
		add(splitPane, gbc_splitPane);
		
		JLabel imageLabel = new JLabel(new ImageIcon(LoginPanel.class.getResource("/media/SchoolRoom.jpg")));
		splitPane.setLeftComponent(imageLabel);
		
		JPanel optionsPanel = new JPanel();
		splitPane.setRightComponent(optionsPanel);
		GridBagLayout gbl_optionsPanel = new GridBagLayout();
		gbl_optionsPanel.columnWidths = new int[]{15, 0, 15, 0};
		gbl_optionsPanel.rowHeights = new int[]{0, 5, 0, 10, 0, 0};
		gbl_optionsPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_optionsPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		optionsPanel.setLayout(gbl_optionsPanel);
		
		JPanel usernamePanel = new JPanel();
		GridBagConstraints gbc_usernamePanel = new GridBagConstraints();
		gbc_usernamePanel.anchor = GridBagConstraints.SOUTH;
		gbc_usernamePanel.insets = new Insets(0, 0, 5, 5);
		gbc_usernamePanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_usernamePanel.gridx = 1;
		gbc_usernamePanel.gridy = 0;
		optionsPanel.add(usernamePanel, gbc_usernamePanel);
		
		JLabel usernameLabel = new JLabel("Username");
		usernamePanel.add(usernameLabel);
		
		usernameField = new JFormattedTextField();
		usernameLabel.setLabelFor(usernameField);
		usernameField.setColumns(10);
		usernamePanel.add(usernameField);
		
		JPanel passwordPanel = new JPanel();
		GridBagConstraints gbc_passwordPanel = new GridBagConstraints();
		gbc_passwordPanel.insets = new Insets(0, 0, 5, 5);
		gbc_passwordPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordPanel.gridx = 1;
		gbc_passwordPanel.gridy = 2;
		optionsPanel.add(passwordPanel, gbc_passwordPanel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordPanel.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordLabel.setLabelFor(passwordField);
		passwordField.setColumns(10);
		passwordPanel.add(passwordField);
		
		JPanel buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.insets = new Insets(0, 0, 0, 5);
		gbc_buttonPanel.anchor = GridBagConstraints.NORTH;
		gbc_buttonPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonPanel.gridx = 1;
		gbc_buttonPanel.gridy = 4;
		optionsPanel.add(buttonPanel, gbc_buttonPanel);
		
		JButton loginButton = new JButton("Login");
		buttonPanel.add(loginButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		buttonPanel.add(exitButton);
	}

}
