package exampleTasks;

/**
 * Инвертирование букв и слов
 */
public class ReversedString {
    private static final String WHITESPACE = " ";

    private static String reversString(String str) {
        StringBuilder reversStr = new StringBuilder();
        String[] words = str.split(WHITESPACE);
        for (String word: words) {
            StringBuilder reversedWord = new StringBuilder();
            for (int i = word.length() -1; i >= 0; i--) {
                reversedWord.append(word.charAt(i));
            }
            reversStr.append(reversedWord).append(WHITESPACE);
        }
        return reversStr.toString();
    }


    public static void main(String[] args) {
        String str = "java python";
        System.out.println("Revers String: " + reversString(str));
    }


}
