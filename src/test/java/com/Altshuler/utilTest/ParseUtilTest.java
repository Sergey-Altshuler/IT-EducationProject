package com.Altshuler.utilTest;

import com.Altshuler.model.Student;
import com.Altshuler.util.ParseUtil;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ParseUtilTest {
    ParseUtil parseUtil = new ParseUtil();

    @Test
    void parseRightDate() {
        String stringDate = "2020-12-12";
        Date date = Date.valueOf(LocalDate.parse(stringDate));
        assertEquals (date, parseUtil.parseDate(stringDate));
    }
    @Test
    void parseWrongDate(){
       try {
            parseUtil.parseDate("2020-12-32");
            fail("Expected ParseException");
        }
        catch (Exception e){
            assertNotEquals("", e.getMessage());
        }
    }

    @Test
    void parseStudent(){
        Student student = Student.builder().id(1).name("name").surname("surname").build();
        assertEquals("№1. name surname", parseUtil.parseStudent(student));
    }
}
