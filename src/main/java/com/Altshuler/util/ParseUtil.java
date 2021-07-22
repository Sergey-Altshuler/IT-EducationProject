package com.Altshuler.util;

import com.Altshuler.model.Student;

import java.sql.Date;
import java.time.LocalDate;

public class ParseUtil {
    public Date parseDate(String element) {
        LocalDate localDate = LocalDate.parse(element);
        return Date.valueOf(localDate);
    }

    public String parseStudent(Student student) {
        return "№" + student.getId() + ". " + student.getName() + " " + student.getSurname();
    }
}
