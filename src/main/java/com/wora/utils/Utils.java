package com.wora.utils;

public class Utils {
    public static <T> void notNull(T item, String message) {
        if (item == null)
            throw new IllegalArgumentException(message);
    }

    public static void positive(int num, String message) {
        notNull(num, "Number not be null");

        if (num <= 0)
            throw new IllegalArgumentException(message);
    }
}
