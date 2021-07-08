package com.Altshuler.filters;

import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Student;
import com.Altshuler.service.Manager;
import lombok.SneakyThrows;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter(urlPatterns = "/studentServlet")
public class StudentFilter implements Filter {
    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        List<Student> studentList = Manager.getAllStudents();
        boolean isStudent = false;
        for (Student student : studentList) {
            if ((req.getParameter("login").equals(student.getLogin())) && (req.getParameter("password")).equals(student.getPassword())) {
                {
                    isStudent = true;
                    ProjectInfo.setStudent(student);
                }
            }
        }
        if (isStudent)
            filterChain.doFilter(req, resp);
        else resp.sendRedirect(contextPath + "/wrongData.jsp");

    }
}
