package screens;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import app.*;
import utils.*;

public class QuizPanel extends JPanel {

	private static final long serialVersionUID = 5714451967759499690L;
	AppFrame owner;
	private JSplitPane splitPane;
	public JLabel loggedInDetails = new JLabel("Logged in: ");
	private QuestionPanel questions[];

	/**
	 * Create the panel.
	 */
	public QuizPanel(AppFrame owner) {
		this.owner = owner;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 0, 100};
		gridBagLayout.rowHeights = new int[]{100, 0, 100};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0};
		setLayout(gridBagLayout);
		
		JPanel upView = new JPanel(), down = new JPanel();
		JScrollPane up = new JScrollPane(upView); 
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, up, down);
		splitPane.setResizeWeight(1.0);
		splitPane.setDividerSize(0);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.insets = new Insets(0, 0, 5, 5);
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 1;
		gbc_splitPane.gridy = 1;
		add(splitPane, gbc_splitPane);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resultsMode();
			}
		});
		down.add(submitButton);
		down.add(loggedInDetails);
		
		up.setColumnHeaderView(new JLabel("Answer the following questions:"));
		upView.setLayout(new BoxLayout(upView, BoxLayout.Y_AXIS));
		
		questions = new QuestionPanel[Question.questionStore.length];
		for (int i = 0; i < Question.questionStore.length; ++i) {
			questions[i] = new QuestionPanel(Question.questionStore[i]);
			upView.add(new JSeparator());
			upView.add(questions[i]);
		}
	}
	
	void resultsMode () {
		int score = 0;
		
		for (var q : questions) {
			if (q.correctAnswer()) ++score;
			AbstractButton ab;
			var itr = q.radioGroup.getElements();
			while (itr.hasMoreElements()) {
				ab = itr.nextElement();
				ab.setEnabled(false);
			} q.showStatus();
		}
		
		JPanel panel = new JPanel();
		
		JLabel scoreLabel = new JLabel();
		scoreLabel.setText("You scored: " + score + "/5");
		panel.add(scoreLabel);
		
		JButton logoutButton = new JButton("Logout"), exitButton = new JButton("Exit");
		logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				owner.loggedInStudent = null;
				owner.showPanel(AppFrame.panelNames[0]);
				owner.remove(owner.panels[1]);
				owner.panels[1] = new QuizPanel(owner);
				owner.getContentPane().add(owner.panels[1], AppFrame.panelNames[1]);
			}
		}); panel.add(logoutButton);
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);		
			}
		}); panel.add(exitButton);
		panel.add(loggedInDetails);
		splitPane.setBottomComponent(panel);
	}
}