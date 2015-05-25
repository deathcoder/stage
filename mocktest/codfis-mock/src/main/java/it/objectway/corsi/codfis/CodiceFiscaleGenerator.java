package it.objectway.corsi.codfis;

import it.objectway.corsi.codfis.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by stageusr2015 on 04/05/2015.
 */
public class CodiceFiscaleGenerator {
    protected static int THREELETTERS = 3;
    protected static int FOURLETTERS = 4;
    protected static int FIRSTLETTER = 0;
    protected static int THIRDLETTER = 2;
    protected static int FOURTHLETTER = 3;
    private static final Map<Integer, String> monthsMap = new HashMap<Integer, String>();

    protected static String generateLastnameLetters(String lastname) {
        lastname = lastname.toUpperCase();
        String result = StringUtils.extractConsonants(lastname, THREELETTERS);
        if(result.length() == THREELETTERS) {
            return result;
        }

        int lettersLeft = THREELETTERS - result.length();
        result += extractVowelsPaddedWithXes(lastname, lettersLeft);
        return result;
    }

    public static String codFisCalc(String lastname, String firstname, Date birthday, String sex, String birthplace) {
        return StringUtils.buildString(
                generateLastnameLetters(lastname),
                generateFirstnameLetters(firstname),
                generateBirthyearDigits(birthday.getYear())
        ).toString();
    }

    protected static String generateFirstnameLetters(String firstname) {
        firstname = firstname.toUpperCase();
        String result = StringUtils.extractConsonants(firstname, FOURLETTERS);

        if(result.length() == THREELETTERS){
            return result;
        }
        if(result.length() == FOURLETTERS) {
            return StringUtils.extractIndexes(result, FIRSTLETTER, THIRDLETTER, FOURTHLETTER);
        }
        int lettersLeft = THREELETTERS - result.length();
        result += extractVowelsPaddedWithXes(firstname, lettersLeft);
        return result;
    }

    /* extract n vowels padded with Xes if necessary */
    protected static String extractVowelsPaddedWithXes(String fromString, int n) {
        String result = StringUtils.extractVowels(fromString, n);
        if(result.length() == n) {
            return result;
        }

        while(result.length() < n) {
            result += "X";
        }
        return result;
    }

    protected static String generateBirthyearDigits(int year) {
        Integer secondDigit = year % 10;
        year /= 10;
        Integer firstDigit = year % 10;

        return firstDigit.toString() + secondDigit;
    }

    protected static String generateBirthmonthLetter(int month) {
        return getMonthsMap().get(month);
    }

    protected static Map<Integer, String> getMonthsMap() {
        if(monthsMap.isEmpty()){
            monthsMap.put(1, "A");
            monthsMap.put(2, "B");
            monthsMap.put(3, "C");
            monthsMap.put(4, "D");
            monthsMap.put(5, "E");
            monthsMap.put(6, "H");
            monthsMap.put(7, "L");
            monthsMap.put(8, "M");
            monthsMap.put(9, "P");
            monthsMap.put(10, "R");
            monthsMap.put(11, "S");
            monthsMap.put(12, "T");
        }
        return monthsMap;
    }
}
