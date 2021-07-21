package com.Altshuler.utilTest;

import com.Altshuler.model.Course;
import com.Altshuler.util.MarkUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MarkUtilTest {
    MarkUtil markUtil = new MarkUtil();
    Course course = Course.builder().build();


    @Test
    void initializeMarks() {
        try {
            markUtil.initializeMarks(course);
            fail();
        } catch (NullPointerException e) {
            assertNotEquals("", e.getMessage());
        }

    }

    @Test
    void getIsFinished() {
        int result = -1;
        try {
            result = markUtil.getIsFinished(course);
            fail();
        } catch (NullPointerException e) {
            assertEquals(result, -1);
        }
    }

    @Test
    void calculateIndividualStatistics() {
        try {
            markUtil.calculateIndividualStatistics(course);
            fail();
        } catch (NullPointerException e) {
            assertNotEquals("", e.getMessage());
        }
    }

    @Test
    void calculateTotalStatistics() {
        try {
            markUtil.calculateTotalStatistics(course);
            fail();
        } catch (NullPointerException e) {
            assertNotEquals("", e.getMessage());
        }

    }
}
