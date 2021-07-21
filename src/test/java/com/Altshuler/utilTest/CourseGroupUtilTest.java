package com.Altshuler.utilTest;

import com.Altshuler.util.CourseGroupUtil;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseGroupUtilTest {
    CourseGroupUtil courseGroupUtil = new CourseGroupUtil();
    @Test
    void getCourseGroup(){
        assertEquals(1,courseGroupUtil.getCourseGroup("TestGroup"));
        assertEquals(2,courseGroupUtil.getCourseGroup("TestGroup"));
    }
}
