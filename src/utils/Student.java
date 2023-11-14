package utils;

public class Student {
	
	private String username;
	private String password;
	public String displayName;
	
	private Student (String uname, String pw, String dname) {
		username = uname;
		password = pw;
		displayName = dname;
	}
	
	public static Student findStudent (String username, String password) {
		for (var s : studList) {
			if (s.username.equals(username) && s.password.equals(password)) return s;
		} return null;
	}
	
	public static Student studList[];
	
	static {
		studList = new Student[] {
			new Student("st1", "st1", "Student1"),
			new Student("st2", "st2", "Student2"),
			new Student("st3", "st3", "Student3"),
			new Student("st4", "st4", "Student4"),
			new Student("st5", "st5", "Student5")
		};
	}
}