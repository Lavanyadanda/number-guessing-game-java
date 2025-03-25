import java.util.Random;
import java.util.Scanner;

public class Number_Guess {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int chances = 8;
        int finals = 0;
        boolean playAgain = true;
        System.out.println("Welcome buddy!");
        System.out.println("You have about " + chances + " chances to win the game.");

        while (playAgain) {
            int rand = getRandN(1, 100);
            boolean guess = false;

            for (int i = 0; i < chances; i++) {
                System.out.println("Chance " + (i + 1) + ": Enter your guess");
                int user = sc.nextInt();

                if (user == rand) {
                    guess = true;
                    finals += 1;
                    System.out.println("You win the game!");
                    break;
                } else if (user < rand) {
                    System.out.println("Too low.....");
                } else {
                    System.out.println("Too high.....");
                }
            }

            if (!guess) {
                System.out.println("Sorry buddy, you lost the chances. The number was " + rand);
            }

            System.out.println("Do you want to play again? (y/n)");
            String PA = sc.next();
            playAgain = PA.equalsIgnoreCase("y");
        }

        System.out.println("That's it buddy, hope you enjoyed it!");
        System.out.println("Here is your score: " + finals);

        sc.close(); // Close the scanner
    }

    static int getRandN(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}