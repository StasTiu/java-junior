package com.acme.edu.message;

public class ByteMessage extends LoggerMessage {
    public static final String PREFIX_PRIMITIVE = "primitive: ";

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public boolean isSameType(LoggerMessage currentState) {
        return false;
    }
}

