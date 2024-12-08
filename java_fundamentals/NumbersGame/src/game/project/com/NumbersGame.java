package game.project.com;
import java.util.Random;
import java.util.Scanner;

public class NumbersGame {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
            System.out.println("Hello, human. I am thinking of a number between 0 and 10.");
            System.out.println("*********************************************************");
            System.out.println("Can you guess the number?");
            System.out.println("If you are not up to the task, you can always type 'q' to quit.");

            int answer = new Random().nextInt(10);
            int attempts = 0;
            int maxAttempts = 3;

            while (true) {
                System.out.print("Enter your guess: ");
                String guess = scanner.nextLine();

                if (guess.equals("q")) {
                    System.out.println("I knew you didn't have it in you.");
                    System.out.println("Shutting down...");
                    break;
                }

                try {
                    int guessedNumber = Integer.parseInt(guess);
                    if (guessedNumber == answer) {
                        System.out.println("Lucky guess! You got it!");
                        break;
                    } else {
                        attempts++;
                        if (attempts == maxAttempts) {
                            System.out.println("You lost and ran out of attempts! The correct number was: " + answer);
                            break;
                        }
                        System.out.println(String.format("Swing and a miss! Keep trying... (%d attempts left)", maxAttempts - attempts));
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number between 0 and 10, or 'q' to quit.");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.nextLine().toLowerCase();
        } while (playAgain.equals("yes"));

        System.out.println("Game over. Shutting down...");
        scanner.close();
    }
}
