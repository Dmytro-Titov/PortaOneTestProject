package task;

public class Solution {
    public static char findFirstUniqueLetterInText(String text) {
        if (text == null || text.isEmpty()) {
            System.out.println("The provided text is null or empty");
            return '\0';
        }
        String[] words = text.split("[\\p{Punct}\\s]+");
        String uniqueLettersFromWords = findFirstUniqueLetterInWord(words);

        char letter = '\0';

        for (int i = 0; i < uniqueLettersFromWords.length(); i++) {
            letter = uniqueLettersFromWords.charAt(i);
            if (isUnique(uniqueLettersFromWords, letter, i)) {
                break;
            }
            letter = '\0';
        }
        if (letter == '\0') {
            System.out.println("Sorry, the text you provided doesn't contain unique first letters");
        }
        return letter;
    }

    private static String findFirstUniqueLetterInWord(String[] words) {
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                if (isUnique(word, letter, i)) {
                    result.append(word.charAt(i));
                    break;
                }
            }
        }
        return result.toString();
    }

    private static boolean isUnique(String letters, char letter, int i) {
        StringBuilder allLettersExceptThis = new StringBuilder(letters);
        allLettersExceptThis.deleteCharAt(i);
        return !allLettersExceptThis.toString().contains(String.valueOf(letter));
    }
}
