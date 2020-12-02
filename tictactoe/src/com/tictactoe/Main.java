package com.tictactoe;
//what a nice script! I should learn OOP.

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        boolean playAgain = false;
        do {
            String readout;
            Scanner scanner = new Scanner(System.in);
            String[] boxes = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
            int turn = 0;
            String input = "If you are reading this, the game broke";
            String turnString = "If you are reading this, the game broke";
            boolean quitting = false;
            boolean win = false;
            int i;
            playAgain = false;
            while (true) {

                if (turn > 0) {
                    if (turn % 2 == 1) {
                        turnString = "X";
                    } else {
                        turnString = "O";
                    }
                    System.out.println("Turn: " + turn);
                    System.out.println("Player " + turnString + "'s turn!");

                    while (true) {
                        try {//in case they don't like following directions
                            input = scanner.nextLine();
                            int x = Integer.parseInt(input);
                            boolean e = (parseInt(input) + 7 > 9);
                        } catch (NumberFormatException ex) {
                            if (input.equals("quit")) {
                                quitting = true;
                            }
                            if (quitting) {
                                break;
                            }
                            System.out.println("Please enter only a number, with no extra characters or spaces!");
                            continue;
                        }
                        break;
                    }
                    if (quitting) {
                        System.out.println("quitting...");
                        break;
                    }
                    do {
                        while (true) {
                            if ((parseInt(input) > 9) || (parseInt(input) < 1)) {//in case they mistype
                                System.out.println("Please enter a number between 1 and 9");
                                input = scanner.nextLine();
                                continue;
                            }
                            break;

                        }
                        if ((boxes[parseInt(input) - 1] == "X") || (boxes[parseInt(input) - 1] == "O")) {//In case they try to rewrite a space
                            System.out.println("That's not valid, try a empty space.");
                        }

                    } while ((boxes[parseInt(input) - 1] == "X") || (boxes[parseInt(input) - 1] == "O") || (parseInt(input) > 9) || (parseInt(input) < 1));

                    boxes[parseInt(input) - 1] = turnString;//Marks the box

                } else {//Turn 0 stuff
                    System.out.println("Let's play Tic-Tac-Toe!");
                    System.out.println("Every box has a number in it, until it is reset. \nWhen you enter a number, if it correlates to an unused box, \nThe box will get an X or O in it, depending on who's turn it is. \nType 'quit' to quit. \nLet's look at the board!");
                }

                // Do stuff
                System.out.println("Board State:");//board generator
                for (int c = 0; c < 3; c++) { //Board Generator
                    System.out.println(boxes[c * 3] + " | " + boxes[c * 3 + 1] + " | " + boxes[c * 3 + 2]);
                    if (c < 2) {
                        System.out.println("--+---+--");
                    }
                }
                i = 0;
                for (int b = 0; b < 3; b++) {//check if anyone has won

                    readout = boxes[i] + boxes[i + 1] + boxes[i + 2]; //horizontal
                    if ((readout.equals("XXX")) || (readout.equals("OOO"))) {
                        win = true;
                    }
                    readout = boxes[b] + boxes[b + 3] + boxes[b + 6];//vertical
                    if ((readout.equals("XXX")) || (readout.equals("OOO"))) {
                        win = true;
                    }

                    i = i + 3;
                }
                readout = boxes[0] + boxes[4] + boxes[8];//diagonal \
                if ((readout.equals("XXX")) || (readout.equals("OOO"))) {
                    win = true;
                }
                readout = boxes[2] + boxes[4] + boxes[6];// diagonal /
                if ((readout.equals("XXX")) || (readout.equals("OOO"))) {
                    win = true;
                }


                if (win) {//do prompts for game end
                    System.out.println("Player " + turnString + " has won!");
                    System.out.println("Play again? y/n");

                    while (true) {
                        input = scanner.nextLine();
                        if (input.equals("y") || input.equals("n")) {
                            if (input.equals("y")) {
                                System.out.println("resetting...");
                                playAgain = true;
                            } else {
                                quitting = true;
                            }
                            break;
                        } else {
                            System.out.println("Please enter 'y' to continue or 'n' to quit.");
                        }
                    }

                }
                if (turn > 9) {//stalemate sensor, after turn 9
                    System.out.println("Stalemate!");
                    System.out.println("Play again? y/n");
                    while (true) {
                        input = scanner.nextLine();
                        if (input.equals("y") || input.equals("n")) {
                            if (input.equals("y")) {
                                System.out.println("resetting...");
                                playAgain = true;
                            } else {
                                quitting = true;
                            }
                            break;
                        } else {
                            System.out.println("Please enter 'y' to continue or 'n' to quit.");
                        }
                    }
                }
                if (quitting) {
                    break;
                }
                if (playAgain) {
                    break;
                }
                turn++; //ticks up turn/action number

            }
        } while (playAgain); // repeats code
    }
}
