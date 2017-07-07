package com.sd1x.whackamole;

import java.util.*;
import java.lang.Math;

public class WhackAMoleLauncher {
    public static void main(String[] args){

        WhackAMole gameWAM = new WhackAMole(50, 10);

        int molesPlaced = 0;

        do {
            boolean placed = gameWAM.place((int) (Math.random() * 10), (int) (Math.random() * 10));
            if (placed == true) {
                molesPlaced++;
                gameWAM.molesLeft++;
            }
        } while (molesPlaced < 10);

        while (WhackAMole.attempts > 0 && WhackAMole.molesLeft > 0) {
            gameWAM.printGridToUser();
            System.out.println("Please input a row number between 0 and 9: ");
            Scanner guess = new Scanner(System.in);
            int rowGuess = guess.nextInt();
            System.out.println("Please input a column number between 0 and 9: ");
            int colGuess = guess.nextInt();

            if (rowGuess == -1 && colGuess == -1) {
                gameWAM.printGrid();
                break;
            }
            gameWAM.whack(rowGuess, colGuess);
        }
    }
}