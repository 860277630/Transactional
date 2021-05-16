package com.example.demo.word;

import java.util.UUID;

public class UUIDUtils {
    public static String getUUID() {

        UUID uuid = UUID.randomUUID();
        return uuid.toString().toUpperCase().replace("-","");
    }
}
