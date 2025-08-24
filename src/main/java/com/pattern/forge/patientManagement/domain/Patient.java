package com.pattern.forge.patientManagement.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Patient {
    private final Name name;
    private final Email email;
    private final PhoneNumber phone;
    private final LocalDateTime dateOfBirth;

    public Patient(String name, String email, String phone, LocalDateTime dateOfBirth) {
        this.name = new Name(name);
        this.email = new Email(email);
        this.phone = new PhoneNumber(phone);
        this.dateOfBirth = dateOfBirth;
    }
}
