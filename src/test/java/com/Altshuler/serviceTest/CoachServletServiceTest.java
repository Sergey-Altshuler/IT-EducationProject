package com.Altshuler.serviceTest;

import com.Altshuler.dao.DAOCoach;
import com.Altshuler.dao.DAOCoachImpl;
import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Coach;
import com.Altshuler.servlce.CoachServletService;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoachServletServiceTest {
    DAOCoach daoCoach = new DAOCoachImpl();
    CoachServletService coachServletService = new CoachServletService();

    @Test
    void add(){
        try {
            List<Coach> list1 =  daoCoach.getAll(Coach.class);
            coachServletService.add(Coach.builder().name("new Coach").build());
            List<Coach> list2 =  daoCoach.getAll(Coach.class);
            assertEquals(list1.size()+1, list2.size());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Test
    void validate(){
        coachServletService.add(Coach.builder().login("test").password("test").build());
        assertTrue(coachServletService.validate("test", "test"));
    }
    @Test
    void logIn(){
        coachServletService.add(Coach.builder().login("test2").password("test2").build());
        coachServletService.logIn("test2","test2");
        assertEquals(ProjectInfo.getCoach().getPassword(),"test2");
    }
}
