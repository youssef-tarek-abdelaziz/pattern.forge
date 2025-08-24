package com.pattern.forge.patientManagement.domain;

import lombok.Getter;

import java.util.regex.Pattern;

@Getter
public class PhoneNumber {
    private String phone;

    private static final String PHONE_REGEX = "^\\+?[0-9\\s\\-\\(\\)]{7,20}$";
    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);

    public PhoneNumber(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }
    private void validatePhone(String phone) {
        if (phone == null) return;
        if(!PHONE_PATTERN.matcher(phone).matches()) {
            throw new RuntimeException("Wrong phone number format");
        }
    }
}
