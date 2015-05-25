package it.objectway.corsi.codfis.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by stageusr2015 on 11/05/2015.
 */
public class CharacterUtilsTest {
    @Test
    public void testIsVowel(){
        /* Assert */
        assertTrue(CharacterUtils.isVowel('a'));
        assertFalse(CharacterUtils.isVowel('b'));
    }

    public void testIsConsonant() {
        /* Assert */
        assertFalse(CharacterUtils.isConsonant('a'));
        assertTrue(CharacterUtils.isConsonant('b'));
    }
}