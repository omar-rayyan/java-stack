import java.util.ArrayList;

public class TestPuzzleJava {
    public static void main(String[] args) {
        PuzzleJava puzzle = new PuzzleJava();

        System.out.println("----- getTenRolls Test -----");
        ArrayList<Integer> randomRolls = puzzle.getTenRolls();
        System.out.println("Random Rolls: " + randomRolls);

        System.out.println("\n----- getRandomLetter Test -----");
        char randomLetter = puzzle.getRandomLetter();
        System.out.println("Random Letter: " + randomLetter);

        System.out.println("\n----- generatePassword Test -----");
        String randomPassword = puzzle.generatePassword();
        System.out.println("Random Password: " + randomPassword);

        System.out.println("\n----- getNewPasswordSet Test -----");
        ArrayList<String> passwordSet = puzzle.getNewPasswordSet(5);
        System.out.println("Password Set: " + passwordSet);

        System.out.println("\n----- shuffleArray Test -----");
        int[] arrayToShuffle = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Original Array: ");
        for (int num : arrayToShuffle) {
            System.out.print(num + " ");
        }
        System.out.println();
        puzzle.shuffleArray(arrayToShuffle);
        System.out.println("Shuffled Array: ");
        for (int num : arrayToShuffle) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}