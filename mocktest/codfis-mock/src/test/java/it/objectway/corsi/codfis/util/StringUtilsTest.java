package it.objectway.corsi.codfis.util;

import org.junit.Test;

import static it.objectway.corsi.codfis.util.StringUtils.extractConsonants;
import static it.objectway.corsi.codfis.util.StringUtils.extractIndexes;
import static it.objectway.corsi.codfis.util.StringUtils.extractVowels;
import static org.junit.Assert.assertEquals;

/**
 * Created by stageusr2015 on 11/05/2015.
 */
public class StringUtilsTest {
    protected static int THREELETTERS = 3;
    protected static int FOURLETTERS = 4;
    protected static int FIRSTLETTER = 0;
    protected static int THIRDLETTER = 2;
    protected static int FOURTHLETTER = 3;
    @Test
    public void testExtractConsonantsFromCapozzi() {
        /* Arrange */
        String string = "Capozzi";
        String expected = "Cpz";

        /* Act */
        String result = extractConsonants(string, THREELETTERS);

        /* Assert */
        assertEquals(expected, result);
    }

    @Test
    public void testExtractConsonantsFromRosi() {
        /* Arrange */
        String string = "Rosi";
        String expected = "Rs";

        /* Act */
        String result = extractConsonants(string, THREELETTERS);

        /* Assert */
        assertEquals(expected, result);
    }

    @Test
    public void testExtractVowelsFromRosi() {
        /* Arrange */
        String string = "Rosi";
        String expected = "oi";

        /* Act */
        String result = extractVowels(string, THREELETTERS);

        /* Assert */
        assertEquals(expected, result);
    }

    @Test
    public void testExtractVowelsFromCapozzi() {
        /* Arrange */
        String string = "Capozzi";
        String expected = "aoi";

        /* Act */
        String result = extractVowels(string, THREELETTERS);

        /* Assert */
        assertEquals(expected, result);
    }

    @Test
    public void testExtractIndexesFromCapozzi() {
        /* Arrange */
        String string = "Capozzi";
        String expected = "Cpo";

        /* Act */
        String result = extractIndexes(string, FIRSTLETTER, THIRDLETTER, FOURTHLETTER);

        /* Assert */
        assertEquals(expected, result);
    }

    @Test
    public void testExtractIndexesFromRosi() {
        /* Arrange */
        String string = "Rosi";
        String expected = "Rsi";

        /* Act */
        String result = extractIndexes(string, FIRSTLETTER, THIRDLETTER, FOURTHLETTER);

        /* Assert */
        assertEquals(expected, result);
    }
}