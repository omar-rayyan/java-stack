package zoo.project.com;

public class Mammal {
	protected int energy;
	
	public Mammal() {
		energy = 100;
	}
	
	public int displayEnergy() {
		System.out.println("Mammal's energy level is: " + energy);
		return energy;
	}
}
