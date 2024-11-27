package com.example.H2HBackend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum typeAnnonce {
    OBJET("Objet"),
    NOURITTURE("Nouritture");


    String value;

    typeAnnonce(String value) {
        this.value =value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static typeAnnonce fromValue(String value) {
        for (typeAnnonce myEnum : typeAnnonce.values()) {
            if (myEnum.value.equals(value)) {
                return myEnum;
            }
        }
        throw new IllegalArgumentException("Invalid MyEnum value: " + value);
    }
}
