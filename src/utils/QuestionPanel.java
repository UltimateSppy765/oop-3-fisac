package utils;

import javax.swing.*;

public class QuestionPanel extends JPanel {
	
	private static final long serialVersionUID = 3897953528889694096L;
	public Question question;
	ButtonGroup radioGroup = new ButtonGroup();
	
	public QuestionPanel (Question question) {
		this.question = question;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(new JLabel(question.toString()));
		JRadioButton jrb;
		for (var o: question.options) {
			jrb = new JRadioButton(o);
			radioGroup.add(jrb);
			add(jrb);
		}
	}
}
