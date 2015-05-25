package it.objectway.corsi.codfis;

import org.junit.Test;

import java.util.Date;

import static it.objectway.corsi.codfis.CodiceFiscaleGenerator.codFisCalc;
import static org.junit.Assert.assertEquals;

/**
 * Created by stageusr2015 on 11/05/2015.
 */
public class CodiceFiscaleGeneratorTest {

    @Test
    public void AcceptanceTest(){
        /* Arrange */
        String lastname = "Capozzi";
        String firstname = "Davide";
        Date birthday = new Date(1993, 10, 1);
        String sex = "M";
        String birthplace = "Garbagnate Milanese";
        String expected = "CPZDVD93A10D912M";

        /* Act */
        String result = codFisCalc(lastname, firstname, birthday, sex, birthplace);

        /* Assert */
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateLastnameLettersFromCapozzi() {
        /* Arrange */
        String lastname = "Capozzi";
        String expected = "CPZ";

        /* Act */
        String result = CodiceFiscaleGenerator.generateLastnameLetters(lastname);

        /* Assert */
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateLastnameLettersFromAbbate() {
        /* Arrange */
        String lastname = "Abbate";
        String expected = "BBT";

        /* Act */
        String result = CodiceFiscaleGenerator.generateLastnameLetters(lastname);

        /* Assert */
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateLastnameLettersFromRosi() {
        /* Arrange */
        String lastname = "Rosi";
        String expected = "RSO";

        /* Act */
        String result = CodiceFiscaleGenerator.generateLastnameLetters(lastname);

        /* Assert */
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateLastnameLettersFromRe() {
        /* Arrange */
        String lastname = "Re";
        String expected = "REX";

        /* Act */
        String result = CodiceFiscaleGenerator.generateLastnameLetters(lastname);

        /* Assert */
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateFirstnameLettersFromCapozzi() {
        /* Arrange */
        String firstname = "Capozzi";
        String expected = "CZZ";

        /* Act */
        String result = CodiceFiscaleGenerator.generateFirstnameLetters(firstname);

        /* Assert */
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateFirstnameLettersFromAbbate() {
        /* Arrange */
        String firstname = "Abbate";
        String expected = "BBT";

        /* Act */
        String result = CodiceFiscaleGenerator.generateFirstnameLetters(firstname);

        /* Assert */
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateFirstnameLettersFromRosi() {
        /* Arrange */
        String firstname = "Rosi";
        String expected = "RSO";

        /* Act */
        String result = CodiceFiscaleGenerator.generateFirstnameLetters(firstname);

        /* Assert */
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateFirstnameLettersFromRe() {
        /* Arrange */
        String firstname = "Re";
        String expected = "REX";

        /* Act */
        String result = CodiceFiscaleGenerator.generateFirstnameLetters(firstname);

        /* Assert */
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateBirthyearDigitsFrom1993() {
        /* Arrange */
        int year = 1993;
        String expected = "93";

        /* Act */
        String result = CodiceFiscaleGenerator.generateBirthyearDigits(year);

        /* Assert */
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateBirthyearDigitsFrom1982() {
        /* Arrange */
        int year = 1982;
        String expected = "82";

        /* Act */
        String result = CodiceFiscaleGenerator.generateBirthyearDigits(year);

        /* Assert */
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateBirthmonthLetterFromJanuary() {
        int month = 1;

    }
}