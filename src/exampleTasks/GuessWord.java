package exampleTasks;

/**
 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
 * "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
 * "pear", "pepper", "pineapple", "pumpkin", "potato"}. При запуске программы компьютер загадывает слово, запрашивает
 * ответ у пользователя, сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь. Если слово не
 * угадано, компьютер показывает буквы, которые стоят на своих местах. apple – загаданное apricot - ответ игрока
 * ap############# (15 символов, чтобы пользователь не мог узнать длину слова) Играем до тех пор, пока игрок не отгадает
 * слово. Используем только маленькие буквы.
 **/

import java.util.Scanner;

public class GuessWord {
    public static String wordClient, wordRandom;
    public static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
            "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
            "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
            "potato"};
    public static int index;
    public static int reshetka = 15;
    public static int indexWord = 0;
    public static boolean repeat = true;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        index = (int) (words.length * Math.random());
        wordRandom = words[index];
        System.out.println(wordRandom);
        while (repeat) {
            System.out.print("Угадайте слово: ");
            wordClient = scanner.nextLine();
            String wordMaska = "";
            if (wordRandom.equals(wordClient)) {
                System.out.println("вы угадали");
                repeat = false;
            } else {
                System.out.println("Вы не угадали");
                wordMaska = wordMaska + wordRandom.charAt(indexWord);
                indexWord++;
                if (indexWord == wordRandom.length()) {
                    System.out.println("Вы проиграли");
                    repeat = false;
                    System.out.println("это слово " + wordMaska);
                    break;
                } else {
                    String str = "";
                    for (int i = 0; i < reshetka; i++) {
                        str += "#";
                    }
                    reshetka--;
                    System.out.println("это слово " + wordMaska + str);
                }
            }
        }
        System.out.println("Игра окончена");
    }
}
