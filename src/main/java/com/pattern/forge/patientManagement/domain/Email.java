package com.pattern.forge.patientManagement.domain;

import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class Email {
    private String email;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public Email(String email) {
        validateEmailFormat(email);
        this.email = email;
    }
    private void validateEmailFormat(String email) {
        if(email == null) return;
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        if (!matcher.matches()) {
            throw new RuntimeException("Wrong Email format");
        }
    }
}
