package com.Altshuler.service;

import com.Altshuler.model.Student;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DataParserTest {

    @Test
    public void parseDate(){ // переделать с h2!! после того, как поменяешь логику всю! после того как почистишь ui
        String example = "2020-12-02";
        Date date = Date.valueOf(LocalDate.parse(example));
        assertEquals(date, DataParser.parseDate(example));
        String wrongDate = "2020-13-24";
        Throwable exc = assertThrows(Exception.class, () ->{
            DataParser.parseDate(wrongDate);
        });
        assertNotNull(exc.getMessage());
    }
    @Test
    public void parseStudent(){
        Student student = Student.builder().id(2).name("Name").surname("Surname").build();
        assertEquals("№2. Name Surname", DataParser.parseStudent(student));
    }
}
