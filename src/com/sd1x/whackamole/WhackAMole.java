package com.sd1x.whackamole;

public class WhackAMole {
    int score;
    public static int molesLeft;
    public static int attempts;
    public char[][] moleGrid;

    WhackAMole(int numAttempts, int gridDimension) {
        moleGrid = new char[gridDimension][gridDimension];
        attempts = numAttempts;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                moleGrid[i][j] = '*';
            }
        }
    }

    public boolean place(int x, int y) {
        if (moleGrid[x][y] != 'M') {
            moleGrid[x][y] = 'M';
            return true;
        }
        else {
            return false;
        }
    }

    public void whack(int x, int y) {
        if (moleGrid[x][y] == 'M') {
            moleGrid[x][y] = 'W';
            molesLeft--;
            score++;
        }
        else {
            moleGrid[x][y] = 'O';
        }
        attempts--;
    }

    void printGridToUser() {
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid[i].length; j++) {
                if (moleGrid[i][j] == 'M') {
                    System.out.print('*' + " ");
                }
                else {
                    System.out.print(moleGrid[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void printGrid() {
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid[i].length; j++)
                System.out.print(moleGrid[i][j] + " ");
            System.out.println();
        }
    }
}
