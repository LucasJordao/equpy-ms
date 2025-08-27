package com.app.application.utils;

public class FormatUtils {
    public static String getOnlyNumbers(String text) {
        if(text == null) {
            return null;
        } else {
            return text.replaceAll("[^0-9]", "");
        }
    }
}
