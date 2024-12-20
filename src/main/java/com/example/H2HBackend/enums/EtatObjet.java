package com.example.H2HBackend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EtatObjet {
    COMMENEUF("Comme neuf"),
    BONETAT("Bon etat"),
    ETATMOYEN("Etat moyen"),
    ABRICOLER("A bricoler");


    String value;

    EtatObjet(String value) {
        this.value =value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static EtatObjet fromValue(String value) {
        for (EtatObjet myEnum : EtatObjet.values()) {
            if (myEnum.value.equals(value)) {
                return myEnum;
            }
        }
        throw new IllegalArgumentException("Invalid MyEnum value: " + value);
    }
}
