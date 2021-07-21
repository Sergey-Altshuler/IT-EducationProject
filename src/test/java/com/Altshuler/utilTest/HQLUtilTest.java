package com.Altshuler.utilTest;

import com.Altshuler.H2DataGenerator;
import com.Altshuler.util.HQLUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HQLUtilTest extends H2DataGenerator {
    HQLUtil hqlUtil = new HQLUtil();
    @Test
    void checkCoach(){
        assertEquals(coach.getPassword(), hqlUtil.checkCoach("login","password").getPassword());
    }

    @Test
    void checkStudent(){
        assertEquals(student.getPassword(), hqlUtil.checkStudent("login","password").getPassword());
    }
}
