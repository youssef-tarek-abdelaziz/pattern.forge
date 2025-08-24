package com.pattern.forge.patientManagement.domain;

import lombok.Getter;

@Getter
public class Name {
    private String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }
    private void validateName(String name) {
        if(name == null) return;

        if(name.length() < 2 || name.length() > 50) {
            throw new RuntimeException("Name length must be between 2 and 50 characters");
        }

    }
}
