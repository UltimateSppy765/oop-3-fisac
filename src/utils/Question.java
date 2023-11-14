package utils;

public class Question {
	
	public int id;
	public String question;
	public String options[];
	private String answer;
	
	private Question(int id, String q, String ops[], int ansIndex) {
		this.id = id;
		question = q;
		options = ops;
		answer = ops[ansIndex];
	}
	
	public String toString () {
		return id + ") " + question;
	}
	
	boolean checkAnswer (String option) {
		return answer.equals(option);
	}
	
	public static Question questionStore[];
	
	static {
		String ops[] = {"2", "3", "4", "5"};
		questionStore = new Question[] {
			new Question(1, "What is 0+2?", ops, 0),
			new Question(2, "What is 1+2?", ops, 1),
			new Question(3, "What is 2+2?", ops, 2),
			new Question(4, "What is 2+1?", ops, 1),
			new Question(5, "What is 2+3?", ops, 3)
		};
	}
}