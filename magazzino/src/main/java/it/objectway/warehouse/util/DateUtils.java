package it.objectway.warehouse.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by stageusr2015 on 15/05/2015.
 */
public class DateUtils {

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getFormattedTimestamp(String format, long timestamp) {
        return new SimpleDateFormat(format).format(timestamp);
    }
}
