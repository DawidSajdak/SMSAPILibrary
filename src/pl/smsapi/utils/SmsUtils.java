package pl.smsapi.utils;

/**
 * SmsUtils class
 * Created by Dawid Sajdak <dawid@trzy.it> on 13:02 - 19.06.13.
 */
public class SmsUtils {

    /**
     * This method check, if string is null or empty.
     * @param s String
     * @return true | false
     */
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.trim().equals("");
    }

}
