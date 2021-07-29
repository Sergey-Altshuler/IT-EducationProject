package com.Altshuler.utilTest;

import com.Altshuler.H2DataGenerator;
import com.Altshuler.util.HQLUtil;
import org.junit.jupiter.api.Test;

import static com.Altshuler.TestInfo.TestConstants.LOGIN;
import static com.Altshuler.TestInfo.TestConstants.PASSWORD;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HQLUtilTest extends H2DataGenerator {
    HQLUtil hqlUtil = new HQLUtil();

    @Test
    void checkCoach() {
        assertEquals(coach.getPassword(), hqlUtil.checkCoach(LOGIN, PASSWORD).getPassword());
    }

    @Test
    void checkStudent() {
        assertEquals(student.getPassword(), hqlUtil.checkStudent(LOGIN, PASSWORD).getPassword());
    }
}
