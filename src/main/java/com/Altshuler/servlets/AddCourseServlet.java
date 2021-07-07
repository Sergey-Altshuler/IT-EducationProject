package com.Altshuler.servlets;

import com.Altshuler.model.Coach;
import com.Altshuler.model.Course;
import com.Altshuler.service.DataParser;
import com.Altshuler.service.HQLWorker;
import com.Altshuler.service.Manager;
import lombok.SneakyThrows;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(name = "addCourseServlet", value = "/addCourseServlet")
public class AddCourseServlet extends HttpServlet {
    @SneakyThrows
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext servletContext = getServletContext();
        Course course = Course.builder().title(request.getParameter("title")).educationType
                (request.getParameter("educationType")).price(Integer.parseInt(request.getParameter("price"))).address(request.getParameter("address")).numOfStudents(Integer.parseInt(request.getParameter("numOfStudents"))).build();
        int subgroupNum= HQLWorker.getSubgroupNum(request.getParameter("title"));

        Date startDate = DataParser.parseDate(request.getParameter("startDate"));
        Date finishDate = DataParser.parseDate(request.getParameter("finishDate"));
        course.setSubgroupNum(subgroupNum);
        course.setStartDate(startDate);
        course.setFinishDate(finishDate);

        Manager.addCourse(course);

      /*  RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/adminActions.jsp");
        requestDispatcher.forward(request, response);*/
    }
}
