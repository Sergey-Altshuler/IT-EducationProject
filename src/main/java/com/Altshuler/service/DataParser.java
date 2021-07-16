package com.Altshuler.service;

import com.Altshuler.model.Student;

import java.sql.Date;
import java.time.LocalDate;

public class DataParser { // в util
    public static Date parseDate(String element){
        LocalDate localDate = LocalDate.parse(element);
        return Date.valueOf(localDate);
    }
    public static String parseStudent (Student student){
        return "№" + student.getId() + ". " + student.getName() + " " + student.getSurname();
    }
}
