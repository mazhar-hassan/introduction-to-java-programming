package com.learn.java;

import java.util.Random;
import java.util.Scanner;

/**
 * Introduction to Java Programming:
 *
 * video: https://www.youtube.com/watch?v=rAtpu-Vd9mA&list=PLLqjNYIgOqeSmeb7_KNIfPQ41rMm069qB&index=2
 */
public class GuessNumberGame2 {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        //number to to hold generated random number by computer
        int computerNumber = 0;
        //number to hold user input from the keyboard.
        int guess = 0;
        //total chances left
        int chances = 3;
        int win = 0;
        int lost = 0;

        int gameCounter = 1;
        showUpdatedStatus(chances, win, lost);

        while (chances > 0 && win < 5) {

            System.out.println("************************** Game:"+gameCounter+" **************************");
            gameCounter++;
            //1 - computer generate a random number
            computerNumber = rand.nextInt(10) + 1; // 0+1 = 1, 9+1 = 10

            for (int i = 1; i <= 3; i++) { //1, 2, 3
                System.out.println("--------- [Try:"+i+"] ---------");
                guess = takeInput(input);
                matchInputShowMessage(computerNumber, guess);

                if (computerNumber == guess) {
                    break;
                }
            }

            if (computerNumber == guess) {
                win++;
                chances++;
            } else {
                lost++;
                chances--;
            }

            showUpdatedStatus(chances, win, lost);

        }//end while

        if (win >= 5) {
            System.out.println("**************    Hurray : you won " + win + " game(s)");
        } else {
            System.err.println("@@@@@@@@@@@@@@@@@ You lose");
        }
    }

    private static void showUpdatedStatus(int chances, int win, int lost) {
        //5 - show the latest status
        System.out.println("chances:" + chances + ", win:" + win + ", lost:" + lost);
        System.out.println("---------------------------------------------------------");
    }

    private static int takeInput(Scanner input) {
        //2 - Ask user to input a number
        System.out.println("Please enter a number between 1 to 10");
        //3 - Take user input
        return input.nextInt();
    }

    public static void matchInputShowMessage(int computerNumber, int guess) {
        //4 - match the input, and updated counts
        if (guess == computerNumber) {
            System.err.println("You got it Right!!!!");
        } else {
            if (computerNumber > guess) {
                System.err.println("The number was greater than yours");
            } else {
                System.err.println("The number was less than yours");
            }
        }
    }
}
