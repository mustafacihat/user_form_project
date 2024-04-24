package com.cydeo.user_creation.enums;

import lombok.Getter;

@Getter
public enum Gender {

    FEMALE("Female"), MALE("Male");

    private final String value;

    Gender(String value) {
        this.value = value;
    }
}
