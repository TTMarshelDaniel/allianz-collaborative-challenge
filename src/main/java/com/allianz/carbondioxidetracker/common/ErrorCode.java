package com.allianz.carbondioxidetracker.common;

public enum ErrorCode {

    NULL_REQUEST("NULL_REQUEST") ,
    BAD_REQUEST("BAD_REQUEST")
            ;

    private final String value;

    ErrorCode(String value) {
        this.value = value ;
    }

    public String getValue() {
        return value;
    }
}
