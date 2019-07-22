package school;

public abstract class Person {
	private String id;
	private String name;
	private int age;
	
	public void print() {
		System.out.println();
	}
	
	public String toString() {
		return String.format("id: %s name: %s age: %d", id, name, age);
	}
	
}
