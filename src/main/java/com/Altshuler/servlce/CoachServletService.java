package com.Altshuler.servlce;

import com.Altshuler.dao.DAOCoach;
import com.Altshuler.dao.DAOCoachImpl;
import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Coach;
import com.Altshuler.util.HQLUtil;

import java.sql.SQLException;

public class CoachServletService {
    private final DAOCoach daoCoach = new DAOCoachImpl();
    private final HQLUtil hqlUtil = new HQLUtil();

    public void add(Coach coach) {
        try {
            daoCoach.save(coach);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean validate(String login, String password) {
        return hqlUtil.checkCoach(login, password) != null;
    }

    public void logIn(String login, String password) {
        ProjectInfo.setCoach(hqlUtil.checkCoach(login, password));
    }

}
