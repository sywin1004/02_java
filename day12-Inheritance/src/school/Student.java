package school;

public class Student extends Person {
	private String major;
	
	public String toString() {
		return major + super.toString();
	}
}
