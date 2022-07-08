package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {

        if (email == null || email.length() == 0) {
            return false;
        }

        String regex = "[a-zA-Z]+_[a-zA-Z]+[1-9\\d?]?@epam\\.com";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        return m.matches();
    }
}





