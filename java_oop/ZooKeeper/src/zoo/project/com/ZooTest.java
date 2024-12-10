package zoo.project.com;

public class ZooTest {

	public static void main(String[] args) {
		Gorilla someGorilla = new Gorilla();
		
		someGorilla.throwSomething();
		someGorilla.throwSomething();
		someGorilla.throwSomething();
		
		someGorilla.eatBananas();
		someGorilla.eatBananas();
		
		someGorilla.climb();
		
		someGorilla.displayEnergy();
		
		
		Bat someBat = new Bat();
		
		someBat.attackTown();
		someBat.attackTown();
		someBat.attackTown();
		
		someBat.eatHumans();
		someBat.eatHumans();
		
		someBat.fly();
		someBat.fly();
		
		someBat.displayEnergy();
	}

}
