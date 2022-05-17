package exampleTasks;

import java.util.Random;
import java.util.Scanner;

/**
 * Игра Крестики нолики на поле 3Х3
 */

public class TicTacToe {
    public static char[][] square;
    public static final int SIZE = 3;

    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static Scanner scanner = new Scanner(System.in);
    public static Random rnd = new Random();

    public static void initSquare() {
        square = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                square[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printSquare() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (square[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void stepHuman() {
        int x, y;
        do {
            System.out.println("Введите координаты во формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        square[y][x] = DOT_X;
    }

    public static void stepComp() {
        int x, y;
        do {
            x = rnd.nextInt(SIZE);
            y = rnd.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер сходил в точку :" + (x + 1) + (y + 1));
        square[y][x] = DOT_O;
    }

    public static boolean isSquareFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (square[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean checkWin0(char symb) {
        for (int i = 0; i < SIZE; i++) {
            int x = 0, y = 0, d1 = 0, d2 = 0;
            for (int j = 0; j < SIZE; j++) {
                x += square[i][j] == symb ? 1 : 0;
                y += square[j][i] == symb ? 1 : 0;
                d1 += square[j][j] == symb ? 1 : 0;
                d2 += square[j][square.length - j - 1] == symb ? 1 : 0;
                if (x == square.length || y == square.length || d1 == square.length || d2 == square.length) return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        initSquare();
        printSquare();
        while (true) {
            stepHuman();
            printSquare();
            if (checkWin0(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isSquareFull()) {
                System.out.println("Ничья");
                break;
            }
            stepComp();
            printSquare();
            if (checkWin0(DOT_O)) {
                System.out.println("Победил компьютер");
                break;
            }
            if (isSquareFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра окончена");
    }
}
