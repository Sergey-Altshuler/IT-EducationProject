package com.Altshuler.service;

import java.sql.Date;
import java.time.LocalDate;

public class DataParser {
    public static Date parseDate(String element){
        LocalDate localDate = LocalDate.parse(element);
        return Date.valueOf(localDate);
    }
}
