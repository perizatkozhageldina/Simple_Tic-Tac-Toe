package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int m = 3;
        char[][] array = new char[m][m];

        for (char[] arr : array) {
            Arrays.fill(arr, '_');
        }

        System.out.println("---------");
        for (char[] arr : array) {
            System.out.print("| ");
            for (char anArr : arr) {
                System.out.print(anArr + " ");
            }
            System.out.println("|");
        }
        System.out.print("---------");

        while (true) {
            if (isOWins(array)) {
                System.out.print("O wins");
                break;
            } else if (isDraw(array)) {
                System.out.print("Draw");
                break;
            } else {
                enterCoordinates(array, 'X');
            }
            if (isXWins(array)) {
                System.out.print("X wins");
                break;
            } else if (isDraw(array)) {
                System.out.print("Draw");
                break;
            } else {
                enterCoordinates(array, 'O');
            }
        }
    }

    public static void enterCoordinates(char[][] moves, char symbol) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("\nEnter the coordinates: ");
                int row = scanner.nextInt();
                int cell = scanner.nextInt();

                if (row < 1 || row > 3 || cell < 1 || cell > 3) {
                    System.out.print("Coordinates should be from 1 to 3!");
                } else if (moves[row - 1][cell - 1] == 'X' || moves[row - 1][cell - 1] == 'O') {
                    System.out.print("This cell is occupied! Choose another one!");
                } else {
                    moves[row - 1][cell - 1] = symbol;
                    break;
                }
            } catch (java.util.InputMismatchException ex) {
                System.out.print("You should enter numbers!");
                scanner.nextLine();
            }
        }

        System.out.println("---------");
        for (char[] move : moves) {
            System.out.print("| ");
            for (char aMove : move) {
                System.out.print(aMove + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    public static boolean isOWins(char[][] moves) {

        int oDiagonal = 0;
        int oReDiagonal = 0;
        int oHorizontal = 0;
        int oVertical = 0;
        boolean oWins = false;

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < moves[i].length; j++) {
                if (moves[i][j] == 'O') {
                    oHorizontal++;
                }
                if (moves[j][i] == 'O') {
                    oVertical++;
                }
                if (i == j && moves[i][j] == 'O') {
                    oDiagonal++;
                }
                if (i + j == moves.length - 1 && moves[i][j] == 'O') {
                    oReDiagonal++;
                }
                if (oHorizontal == 3) {
                    oWins = true;
                }
                if (oVertical == 3) {
                    oWins = true;
                }
            }
            oHorizontal = 0;
            oVertical = 0;
        }

        if (oDiagonal == 3) {
            oWins = true;
        }
        if (oReDiagonal == 3) {
            oWins = true;
        }
        return oWins;
    }
    public static boolean isXWins(char[][] moves) {
        int xDiagonal = 0;
        int xReDiagonal = 0;
        int xHorizontal = 0;
        int xVertical = 0;
        boolean xWins = false;

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < moves[i].length; j++) {
                if (moves[i][j] == 'X') {
                    xHorizontal++;
                }
                if (moves[j][i] == 'X') {
                    xVertical++;
                }
                if (i == j && moves[i][j] == 'X') {
                    xDiagonal++;
                }
                if (i + j == moves.length - 1 && moves[i][j] == 'X') {
                    xReDiagonal++;
                }
                if (xHorizontal == 3) {
                    xWins = true;
                }
                if (xVertical == 3) {
                    xWins = true;
                }
            }
            xHorizontal = 0;
            xVertical = 0;
        }
        if (xDiagonal == 3) {
            xWins = true;
        }
        if (xReDiagonal == 3) {
            xWins = true;
        }
        return xWins;
    }
    public static boolean isDraw(char[][] moves) {
        boolean isDrawn = true;
        for (char[] move : moves) {
            for (char c : move) {
                if (c == '_' || c == ' ') {
                    isDrawn = false;
                    break;
                }
            }
        }
        return isDrawn;
    }
}
