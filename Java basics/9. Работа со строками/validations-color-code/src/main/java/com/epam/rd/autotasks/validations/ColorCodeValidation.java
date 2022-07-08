package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {

        if (color == null || color.length() == 0) {
            return false;
        }

        String regex = "#[a-fA-F0-9]{6}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(color);
        if(m.matches()) {
            return true;
        }

        regex = "#[a-fA-F0-9]{3}";
        p = Pattern.compile(regex);
        m = p.matcher(color);
        return m.matches();
    }
}





