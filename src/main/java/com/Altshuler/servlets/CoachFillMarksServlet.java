package com.Altshuler.servlets;

import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Course;
import com.Altshuler.service.Manager;
import com.Altshuler.service.MarkSetter;
import com.Altshuler.servletService.CourseServletService;
import com.Altshuler.util.MarkUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/coachFillMarksServlet")
public class CoachFillMarksServlet extends HttpServlet {
    private final MarkUtil markUtil = new MarkUtil();
    private final CourseServletService courseServletService = new CourseServletService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int numLesson = Integer.parseInt(request.getParameter("numLesson"));
        Enumeration<String> params = request.getParameterNames();
        Map<String, String> studentsAndMarks = new HashMap<>();
        while (params.hasMoreElements()) {
            String param = params.nextElement();
            if (!param.equals("numLesson"))
                studentsAndMarks.put(param, request.getParameter(param));
        }
        markUtil.setLessonMarks(ProjectInfo.getCourse(), studentsAndMarks, numLesson);
        request.setAttribute("courses", courseServletService.getAll());
        request.getRequestDispatcher("/coachSuccessPutMarks.jsp").forward(request, response);
    }
}
