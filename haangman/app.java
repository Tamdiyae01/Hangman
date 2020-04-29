package haangman;

import java.util.Scanner;
import java.util.Random;
/**
 * Hello world!
 */
public class App {
    

    /**
     
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random  = new Random();
        String[] guesses = {"Test", "Test2", "Test3", "Test4" };
        boolean weArePlay = true;
        while (weArePlay) {
            System.out.println("Välkommen till spelet hänga gubbe"); // GUBBE -> G,U,B,B,E
            char[] randomWordToGuess = guesses[random.nextInt(guesses.length)].toCharArray();
            int amountOfGuesses = randomWordToGuess.length; //lägg in antalet gissningar
            char[] playerGuess = new char[amountOfGuesses]; // _ _ _ _

            for(int i = 0; i < playerGuess.length; i++) {
                playerGuess[i] = '_'; 
            }

            boolean wordIsGuessed = false;
            int tries = 0;

            while(!wordIsGuessed && tries != amountOfGuesses) {
                System.out.println("Current guesses: ");
                printArray(playerGuess);
                System.out.printf("you have %d tries left. %n", amountOfGuesses - tries);
                System.out.println("Enter a single characater");
                char input = scanner.nextLine().charAt(0); //även om input är haudsahuid tas bara h (problematisk vid tom input)
                tries++;
                if(input == '-') {
                    weArePlay = false;
                    wordIsGuessed = true;
                } else {
                    for(int i = 0; i < randomWordToGuess.length; i++) {
                        if(randomWordToGuess[i] == input) {
                            playerGuess[i] = input;
                        }
                    }
                    if(isTheWordGuessed(playerGuess)) {
                        wordIsGuessed = true;
                        System.out.println("Congratulations You won");
                    }
                }
            }
            if(!wordIsGuessed) System.out.println("You ran out of guesses!");
            System.out.println("Do you want to play another game of hangman? (yes/no)");
            String anotherGame = scanner.nextLine();
            if(anotherGame.equals("no")) weArePlay = false;
        }

        System.out.println("Game over");
    }

    public static void printArray(char[] array) {
        for(int i = 0; i < playerGuess.length; i++) {
            System.out.print(array[i]+ " ");
        }
        System.out.println();
    }
public static boolean isTheWordGuessed(char[] array) {
    for(int i = 0; i < playerGuess.length; i++) {
        if (array[i] == '_') return false;
    }
    return true;
}


}




/**


public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random  = new Random();
        String[] guesses = {"Test", "Test2", "Test3", "Test4" };

        boolean weArePlay = true;
        while (weArePlay) {
            println("Välkommen till spelet hänga gubbe"); // GUBBE -> G,U,B,B,E
            char[] randomWordToGuess = guesses[random.nextInt(guesses.lenght)].toCharArray();
            int amountOfGuesses = randomWordToGuess.length; //lägg in antalet gissningar
            char[] playerGuess = new Char[amountOfGuesses]; // _ _ _ _

            for(int i = 0; i < playerGuess.length; i++) {
                playerGuess[i] = '_'; 
            }

            boolean wordIsGuessed = false;
            int tries = 0;

            while(!wordIsGuessed && tries != amountOfGuesses) {
                println("Current guesses: ");
                printArray(playerGuess);
                printf("you have %d tries left. \n", amountOfGuesses = tries);
                println("Enter a single characater");
                char input = scanner.nextLine().charAt(0); //även om input är haudsahuid tas bara h (problematisk vid tom input)
                tries++;
                if(input == '-') {
                    weArePlay = false;
                    wordIsGuessed = true;
                } else {
                    for(int i = 0; i < randomWordToGuess.length; i++) {
                        if(randomWordToGuess[i] == input) {
                            playerGuess[i] = input;
                        }
                    }
                    if(isTheWordGuessed(playerGuess)) {
                        wordIsGuessed = true;
                        println("Congratulations You won");
                    }
                    
                }
            }
            
        }

        println("Game over");
    }

    public static void printArray(char[] array) {
        for(int i = 0; i < playerGuess.length; i++) {
            print(array[i]+ " ");
        }
        println();
    }
}
 */