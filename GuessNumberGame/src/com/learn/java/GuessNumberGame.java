package com.learn.java;

import java.util.Random;
import java.util.Scanner;
/**
 * Introduction to Java Programming:
 *
 * video: https://www.youtube.com/watch?v=guLcKhXD8l8&list=PLLqjNYIgOqeSmeb7_KNIfPQ41rMm069qB&index=1
 */


/*
In this guess number game, the system will generate a random number 1 to 10.

you will have 3 chances by default to a guess a number.
if you guess it right one more chance will be added, if wrong you lose one chance.

If you keep loosing chances until no chances left your game will be over.

If you guess the correct number 5 times you will win the game.

When the user input a number check if it's less than or greater than the number and hence show the message like

The number is greater than your input.
or
The number is less than your input.

When user guess the number correct show the message
You got it right

Show the number of chances left
Chances left: 0

Display the number of wins and lost games
win: 3 and lost: 2
 */
public class GuessNumberGame {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        int computerNumber = 0;
        int guess = 0;
        int chances = 3;
        int win = 0;
        int lost = 0;

        System.out.println("chances:"+chances+", win:"+win+", lost:"+lost);
        System.out.println("---------------------------------------------------------");

        while (chances > 0 && win < 5) {

            //1 - computer generate a random number
            computerNumber = rand.nextInt(10) + 1; // 0+1 = 1, 9+1 = 10
            //2 - Ask user to input a number
            System.out.println("Please enter a number between 1 to 10");
            //3 - Take user input
            guess = input.nextInt();

            //4 - match the input, and updated counts
            if (guess == computerNumber) {
                win++;
                chances++;
                System.out.println("You got it Right!!!!");
            } else {
                lost++;
                chances--;

                if (computerNumber > guess) {
                    System.out.println("The number was greater than yours");
                } else {
                    System.out.println("The number was less than yours");
                }
            }

            //5 - show the latest status
            System.out.println("chances:"+chances+", win:"+win+", lost:"+lost);
            System.out.println("---------------------------------------------------------");
        }//end while

        if (win >= 5) {
            System.out.println("**************    Hurray : you won "+win+" game(s)");
        } else {
            System.err.println("@@@@@@@@@@@@@@@@@ You lose");
        }
    }
}
