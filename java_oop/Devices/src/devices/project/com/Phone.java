package devices.project.com;

public class Phone extends Device {

	 public void makeCall() {
	     if (battery < 5) {
	         System.out.println("Battery too low to make a call. (" + battery + ")");
	         return;
	     }
	     battery -= 5;
	     System.out.println("You made a call.");
	     checkBatteryStatus();
	 }

	 public void playGame() {
	     if (battery < 25) {
	         System.out.println("Battery too low to play a game. (" + battery + ")");
	         return;
	     }
	     battery -= 20;
	     System.out.println("You played a game.");
	     checkBatteryStatus();
	 }

	 public void charge() {
	     battery += 50;
	     if (battery > 100) {
	         battery = 100;
	     }
	     System.out.println("You charged the phone.");
	     displayBatteryStatus();
	 }

	 private void checkBatteryStatus() {
	     if (battery < 10) {
	         System.out.println("Low battery! (" + battery + ")");
	     }
	     displayBatteryStatus();
	 }
}
