package zoo.project.com;

public class Gorilla extends Mammal{
	
	public Gorilla() {
		super();
	}
	
	public void throwSomething() {
		energy -= 5;
		System.out.println("The gorilla threw something.");
	}
	
	public void eatBananas() {
		energy += 10;
		System.out.println("The gorilla is now satisfied. It ate a banana!");
	}
	
	public void climb() {
		energy -= 10;
		System.out.println("The gorilla has climbed a tree.");
	}
}
