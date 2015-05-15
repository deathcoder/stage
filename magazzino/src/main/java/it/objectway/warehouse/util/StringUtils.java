package it.objectway.warehouse.util;

/**
 * Created by stageusr2015 on 15/05/2015.
 */
public class StringUtils {
    public static String buildString(Object... blocks) {
        StringBuilder sb = new StringBuilder();
        for(Object block: blocks) {
            sb.append(block);
        }
        return sb.toString();
    }
}
