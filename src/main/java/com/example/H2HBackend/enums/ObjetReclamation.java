package com.example.H2HBackend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ObjetReclamation {
    OBJETNONCONFORME("Objet non conforme"),
    ABSCENCECONTACT("Abscence contact"),
    COMPORTEMENT_INAPPROPRIE("Comportement inapproprie"),
    AUTRE("AUTRE");


    String value;

    ObjetReclamation(String value) {
        this.value =value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static ObjetReclamation fromValue(String value) {
        for (ObjetReclamation myEnum : ObjetReclamation.values()) {
            if (myEnum.value.equals(value)) {
                return myEnum;
            }
        }
        throw new IllegalArgumentException("Invalid MyEnum value: " + value);
    }
}
