package it.objectway.corsi.codfis.util;

/**
 * Created by stageusr2015 on 11/05/2015.
 */
public class StringUtils {

    /* Extracts up to n consonants */
    public static String extractConsonants(String fromString, int n) {
        String result = "";
        for (int i = 0; i < fromString.length() && result.length() < n; i++) {
            if (CharacterUtils.isConsonant(fromString.charAt(i))) {
                result += fromString.charAt(i);
            }
        }
        return result;
    }

    /* Extracts up to n vowels */
    public static String extractVowels(String fromString, int n) {
        String result = "";
        for (int i = 0; i < fromString.length() && result.length() < n; i++) {
            if (CharacterUtils.isVowel(fromString.charAt(i))) {
                result += fromString.charAt(i);
            }
        }
        return result;
    }

    public static String extractIndexes(String fromString, int... indexes) {
        String result = "";
        for(Integer i: indexes) {
            result += fromString.charAt(i);
        }
        return result;
    }

    public static StringBuilder buildString(Object... blocks) {
        StringBuilder sb = new StringBuilder();
        for (Object block : blocks) {
            sb.append(block);
        }
        return sb;
    }
}
