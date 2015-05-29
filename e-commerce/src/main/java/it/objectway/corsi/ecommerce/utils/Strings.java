package it.objectway.corsi.ecommerce.utils;

/**
 * Created by stageusr2015 on 29/05/2015.
 */
public class Strings {
    public static StringBuilder buildString(Object... blocks) {
        StringBuilder sb = new StringBuilder();
        for(Object block: blocks) {
            sb.append(block);
        }
        return sb;
    }
}
