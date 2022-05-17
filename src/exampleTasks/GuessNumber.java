package exampleTasks;
/**
 * Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
 * При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
 * После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
 **/

import java.util.Scanner;

public class GuessNumber {
    public static Scanner scanner = new Scanner(System.in);
    public static String rep;
    public static int number, rnd;
    public static int repeat = 3;
    public static boolean ref = true;

    public static void main(String[] args) {
        rnd = (int) (10 * Math.random());
        while (ref) {
            while (repeat > 0) {
                String realy = "";
                System.out.println("Введите целое число от 0 до 9: ");
                number = scanner.nextInt();
                if (number >= 0 && number <= 9) {
                    if (rnd == number) {
                        System.out.println("Вы угадали");
                        break;
                    } else {
                        if (rnd > number) realy = "больше";
                        else realy = "меньше";
                        repeat--;
                        System.out.format("Вы не угадали, число %s, осталось %s попытки\n", realy, repeat);
                        if (repeat == 0) System.out.println("Вы проиграли");
                    }
                } else {
                    System.out.println("Введенное число не в диапазоне указанных чисел");
                }
            }
            System.out.print("Хотите еще (y/n)? ");
            rep = scanner.next();
            if (rep.equals("y")) {
                repeat = 3;
                ref = true;
            } else {
                ref = false;
            }
        }
        System.out.println("Игра окончена");
    }
}
