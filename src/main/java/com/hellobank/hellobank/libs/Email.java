package com.hellobank.hellobank.libs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    
    public static boolean validar(String email){

        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()) {
                return false;

            }

           
        }
        return true;
    }
}
