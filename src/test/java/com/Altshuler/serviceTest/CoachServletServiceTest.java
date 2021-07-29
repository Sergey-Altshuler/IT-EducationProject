package com.Altshuler.serviceTest;

import com.Altshuler.TestInfo.TestDataCreator;
import com.Altshuler.dao.DAOCoach;
import com.Altshuler.dao.DAOCoachImpl;
import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Coach;
import com.Altshuler.servlce.CoachServletService;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

import static com.Altshuler.TestInfo.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

public class CoachServletServiceTest {
    DAOCoach daoCoach = new DAOCoachImpl();
    CoachServletService coachServletService = new CoachServletService();

    @Test
    void add() {
        try {
            List<Coach> list1 = daoCoach.getAll(Coach.class);
            coachServletService.add(TestDataCreator.createNewTestCoach());
            List<Coach> list2 = daoCoach.getAll(Coach.class);
            assertEquals(list1.size() + 1, list2.size());
        } catch (SQLException e) {
            fail();
        }
    }

    @Test
    void validate() {
        coachServletService.add(TestDataCreator.createValidateTestCoach());
        assertTrue(coachServletService.validate(VALIDATE_LOGIN, VALIDATE_PASSWORD));
    }

    @Test
    void logIn() {
        coachServletService.add(TestDataCreator.createLoginTestCoach());
        coachServletService.logIn(ENTER_LOGIN, ENTER_PASSWORD);
        assertEquals(ProjectInfo.getCoach().getPassword(), ENTER_PASSWORD);
    }
}
