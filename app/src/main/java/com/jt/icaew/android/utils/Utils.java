package com.jt.icaew.android.utils;

import android.util.Log;

import com.jt.icaew.android.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Wandy on 7/10/2016.
 */
public class Utils {

    public static void d(final String TAG, final String desc)
    {
        Log.d(TAG, desc);
    }

    public static String getTimeForEvent(Date startDate)
    {
        String simpleDate = getStartDateTimeInTimezone().format(startDate);
        return simpleDate;
    }

    public static SimpleDateFormat getStartDateTimeInTimezone()
    {
        SimpleDateFormat format = new SimpleDateFormat("MMM d");
        /*if(timezone == null || timezone.isEmpty())
        {
            format.setTimeZone(TimeZone.getDefault());
        }
        else format.setTimeZone(TimeZone.getTimeZone("GMT+" + timezone));*/
        return format;
    }

    public static SimpleDateFormat getEndDateTimeInTimezone(String timezone)
    {
        SimpleDateFormat format = new SimpleDateFormat("h:mm a");
        if(timezone == null || timezone.isEmpty())
        {
            format.setTimeZone(TimeZone.getDefault());
        }
        else format.setTimeZone(TimeZone.getTimeZone("GMT+" + timezone));
        return format;
    }

    public static String getDate(final String date)
    {
        //return date dalam bentuk Jan 16 atau Apr 28
        try {
            final Date startDate = Constant.ISO8601_DATE_FORMAT_UTC.parse(date);
            return Utils.getTimeForEvent(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getHtml(final String text)
    {
        final String result = text
                .replace("span style=\"color:", "font color=\"")
                .replace(";\"","\"")
                /*.replaceAll("\\r\\n|\\r|\\n", " ")*/
                .replace("</span>", "</font>")
                .replace("<li>", "<br/>\u2022")
                .replace("\t", "")
                .replace("\n", "")
                .replace("</li>", "<br/>")
                .replace("<ul>", "<br/>")
                .replace("</ul>", "<br/>")
                .replace("<pre>", "")
                .replace("\r", "")
                /*.replace("\\r\\n|\\r|\\n", " ")
                .replace("<pre>", "")*/;
        return result;
    }

    public static String getVideoId(final String original) {
        final String divider = "?v=";
        if (original.contains(divider)) {
            //StringTokenizer tokenizer = new StringTokenizer("?v=");
            final int index = original.indexOf(divider);
            String result = original.substring(index + 3, original.length());
            return result;
        } else return original;
    }
}
