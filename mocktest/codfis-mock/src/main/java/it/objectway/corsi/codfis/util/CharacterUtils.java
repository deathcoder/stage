package it.objectway.corsi.codfis.util;

/**
 * Created by stageusr2015 on 11/05/2015.
 */
public class CharacterUtils {
    protected static final String VOWELS = "aeiou";
    protected static final String CONSONANTS = "bcdfghjklmnpqrstvxzwy";

    public enum ChrType {
        VOWEL, CONSONANT
    }

    public static boolean isVowel(Character chr) {
        return VOWELS.indexOf(Character.toLowerCase(chr)) >= 0;
    }

    public static boolean isConsonant(char chr) {
        return CONSONANTS.indexOf(Character.toLowerCase(chr)) >= 0;
    }
}
