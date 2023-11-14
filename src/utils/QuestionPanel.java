package utils;

import javax.swing.*;

public class QuestionPanel extends JPanel {
	
	private static final long serialVersionUID = 3897953528889694096L;
	public Question question;
	private JLabel questionLabel;
	private JRadioButton answer;
	public ButtonGroup radioGroup = new ButtonGroup();
	
	public QuestionPanel (Question question) {
		this.question = question;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		questionLabel = new JLabel(question.toString());
		add(questionLabel);
		JRadioButton jrb;
		for (var o: question.options) {
			jrb = new JRadioButton(o);
			if (question.checkAnswer(o)) answer = jrb;
			radioGroup.add(jrb);
			add(jrb);
		}
	}
	
	public boolean correctAnswer () {
		// https://stackoverflow.com/a/15230216
		return answer.getModel().equals(radioGroup.getSelection());
	}
	
	public void showStatus () {
		questionLabel.setIcon(new ImageIcon(
			QuestionPanel.class.getResource(
				correctAnswer() ? "/media/Checkmark.png" : "/media/Cross.png"
			)
		));
		if (!correctAnswer())
			answer.setIcon(new ImageIcon(
				QuestionPanel.class.getResource("/media/Checkmark.png")
			));
	}
}