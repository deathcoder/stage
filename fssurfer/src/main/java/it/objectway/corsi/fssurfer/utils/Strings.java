package it.objectway.corsi.fssurfer.utils;

/**
 * Created by stageusr2015 on 15/05/2015.
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
