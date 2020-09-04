package com.acme.edu;

public class Logger {

    public static final String PREFIX_PRIMITIVE = "primitive: ";
    public static final String PREFIX_CHAR = "char: ";
    public static final String PREFIX_STRING = "string: ";
    public static final String PREFIX_REFERENCE = "reference: ";

    public static String type = "";
    public static int int_buffer = 0;
    public static byte byte_buffer = 0;
    public static String string_buffer = "";


    public static void log(int message) {
        if (type.equals("")) {
                type = "int";
                int_buffer = message;
            } else {
                    if ("int".equals(type) && (Integer.MAX_VALUE - int_buffer >= message)) {
                        int_buffer += message;
                    } else {
                        chooseMessageWriter();
                        type = "int";
                        int_buffer = message;
                    }
            }
    }

    public static void log(byte message) {
        if (type.equals("")) {
            type = "byte";
            byte_buffer = message;
        } else {
            if ("byte".equals(type) && (Byte.MAX_VALUE - byte_buffer >= message)) {
                byte_buffer += message;
            } else {
                chooseMessageWriter();
                type = "byte";
                byte_buffer = message;
            }
        }
    }

     public static void log(char message) {
        chooseMessageWriter();
        writeMessage(PREFIX_CHAR + message);
        type = "";
    }

    public static void log(boolean message) {
        chooseMessageWriter();
        writeMessage(PREFIX_PRIMITIVE + message);
        type = "";
    }

    public static void log(String message) {
        if (type.equals("")) {
            type = "string";
            string_buffer = message;
        } else {
            if ("string".equals(type)) {
                string_buffer += message;
            } else {
                chooseMessageWriter();
                type = "string";
                string_buffer = message;
            }
        }
    }

    public static void log(Object message) {
        chooseMessageWriter();
        writeMessage(PREFIX_REFERENCE + message);
        type = "";
    }

    private static void writeMessage(String message) {
        System.out.println(message);
    }

    public static void flush() {
        chooseMessageWriter();
        type = "";

    }
    
    private static void chooseMessageWriter(){
        switch (type){
            case "int":{
                writeMessage(PREFIX_PRIMITIVE + int_buffer);
                int_buffer = 0;
                break;
            }
            case "byte":{
                writeMessage(PREFIX_PRIMITIVE + byte_buffer);
                byte_buffer = 0;
                break;
            }
            case "string":{
                writeMessage(PREFIX_STRING+ string_buffer);
                string_buffer = "";
                break;
            }
            case "":
                break;
        }
    }
}
