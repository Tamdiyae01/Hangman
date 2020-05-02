package haangman;

import java.util.Scanner;
import jdk.internal.org.jline.utils.InputStreamReader;
import java.net.*;
import java.util.Random;
import Java.util.LinkedList;
import java.io.*;  

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
        LinkedList<String> guesses = new LinkedList<String>;

        System.out.println("Välkommen till spelet hänga gubbe"); // GUBBE -> G,U,B,B,E
        System.out.println("Enter a username");
        String userName = scanner.nextLine(); 
        System.out.println(userName +",Choose male or female (male/female)");
        String tempSex = scanner.nextLine();
        String sex;

            if (!"male".equals(tempSex) || !"female".equals(tempSex)) {
                System.out.println( userName + "Only male or female are available (male/female)");
            } else {
                sex = scanner.nextLine(); 
            }

            System.out.println("Okay " + sex +" "+ userName + " Enter clas");
            String klass = scanner.nextLine(); 
            System.out.println("Final step, please choose race  (human/drawf/priest/orc)");
            String tempRace = scanner.nextLine();
            String race;

            if (!"human".equals(tempRace) || !"drawf".equals(tempRace) || !"priest".equals(tempRace) || !"orc".equals(tempRace)) {
                System.out.println( userName + "Only following races");
            } else {
                race = scanner.nextLine(); 
            }
            String switchStatement = "'Perfect!' + userName + sex + klass + race";
            switch(race) {
                case "human": 
                System.out.println(switchStatement + "SKRIV DITT INTRO1"); 
                break; 
            case "drawf": 
                System.out.println(switchStatement + "SKRIV DITT INTRO2"); 
                break; 
            case "priest": 
                System.out.println(switchStatement + "SKRIV DITT INTRO3"); 
                break; 
            case "orc": 
                System.out.println(switchStatement + "SKRIV DITT INTRO4"); 
                break; 
            default: 
                System.out.println(switchStatement + "SKRIV DITT INTRO5"); 
            }


        boolean weArePlay = true;
        while (weArePlay) {
            
            
            char[] randomWordToGuess = guesses.get(random.nextInt(guesses.size())).toCharArray();
            int amountOfGuesses = randomWordToGuess.length; //lägg in antalet gissningar
            char[] playerGuess = new char[amountOfGuesses]; // _ _ _ _

            for(int i = 0; i < playerGuess.length; i++) playerGuess[i] = '_'; 
            

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
                        if(randomWordToGuess[i] == input) playerGuess[i] = input;
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

public static LinkedList<String> getWordList() {
    LinkedList<String> list = new LinkedList<String>();
    int counter = 0;
    int maxWords = 1000;
    Scanner sc = new Scanner("haangman\\wordlist.txt");
    BufferedReader in = new BufferedReader(new InputStreamReader(sc.openStream()));

    String inputLine;
    

    while ((inputLine = in.readLine() != null)) {
        list.add(inputLine);
        counter++;
        if (counter == maxWords) break;
    }
    in.close();

    return list;
}

}

