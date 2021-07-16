package com.Altshuler.servletService;

import com.Altshuler.dao.DAOAdmin;
import com.Altshuler.dao.DAOAdminImpl;
import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Admin;

import java.sql.SQLException;

public class AdminServletService {
    private final DAOAdmin daoAdmin = new DAOAdminImpl();

    public void initialize() {
        Admin admin = Admin.builder().login("admin").password("password").build();
        try {
            daoAdmin.save(admin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeProperties(String login, String password) {
        try {
            Admin admin = daoAdmin.get(1, Admin.class);
            admin.setLogin(login);
            admin.setPassword(password);
            daoAdmin.save(admin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean validate(String login, String password){
        Admin admin=Admin.builder().build();
        try{
            admin = daoAdmin.get(1, Admin.class);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return admin.getLogin().equals(login)&&admin.getPassword().equals(password);
    }

}
