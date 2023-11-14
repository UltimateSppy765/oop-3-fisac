package screens;

import java.awt.*;

import javax.swing.*;

import utils.*;

public class QuizPanel extends JPanel {

	private static final long serialVersionUID = 5714451967759499690L;
	private QuestionPanel questions[];

	/**
	 * Create the panel.
	 */
	public QuizPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 0, 100};
		gridBagLayout.rowHeights = new int[]{100, 0, 100};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0};
		setLayout(gridBagLayout);
		
		JPanel upView = new JPanel(), down = new JPanel();
		JScrollPane up = new JScrollPane(upView); 
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, up, down);
		splitPane.setResizeWeight(1.0);
		splitPane.setDividerSize(0);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 1;
		gbc_splitPane.gridy = 1;
		add(splitPane, gbc_splitPane);
		
		JButton submitButton = new JButton("Submit");
		down.add(submitButton);
		
		up.setColumnHeaderView(new JLabel("Answer the following questions:"));
		upView.setLayout(new BoxLayout(upView, BoxLayout.Y_AXIS));
		
		questions = new QuestionPanel[Question.questionStore.length];
		for (int i = 0; i < Question.questionStore.length; ++i) {
			questions[i] = new QuestionPanel(Question.questionStore[i]);
			upView.add(new JSeparator());
			upView.add(questions[i]);
		}
	}

}
