package com.example.itmentor.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DateUtils {
    private DateUtils() {
    }

    public static Timestamp getCurrentDate() {
        return Timestamp.valueOf(LocalDateTime.now());
    }
}
