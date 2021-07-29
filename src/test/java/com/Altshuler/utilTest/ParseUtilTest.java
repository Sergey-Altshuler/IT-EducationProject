package com.Altshuler.utilTest;

import com.Altshuler.TestInfo.TestDataCreator;
import com.Altshuler.model.Student;
import com.Altshuler.util.ParseUtil;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

import static com.Altshuler.TestInfo.TestConstants.FAIL_DATE;
import static com.Altshuler.TestInfo.TestConstants.SUCCESS_DATE;
import static org.junit.jupiter.api.Assertions.*;

public class ParseUtilTest {
    ParseUtil parseUtil = new ParseUtil();

    @Test
    void parseRightDate() {
        String stringDate = SUCCESS_DATE;
        Date date = Date.valueOf(LocalDate.parse(stringDate));
        assertEquals(date, parseUtil.parseDate(stringDate));
    }

    @Test
    void parseWrongDate() {
        try {
            parseUtil.parseDate(FAIL_DATE);
            fail();
        } catch (Exception e) {
            assertNotEquals("", e.getMessage());
        }
    }

    @Test
    void parseStudent() {
        Student student = TestDataCreator.createTestStudentForParsing();
        assertEquals("№1. name surname", parseUtil.parseStudent(student));
    }
}
