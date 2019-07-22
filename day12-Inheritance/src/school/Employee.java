package school;

public class Employee extends Person {
	private String dept;
	
	public String toString() {
		return super.toString() + dept;
	}
}
