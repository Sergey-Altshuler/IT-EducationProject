package com.Altshuler.servlets;

import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Course;
import com.Altshuler.model.Student;
import com.Altshuler.servlce.CourseServletService;
import com.Altshuler.util.ParseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet("/coachPutMarksServlet")
public class CoachPutMarksServlet extends HttpServlet {
    CourseServletService courseServletService = new CourseServletService();
    ParseUtil parseUtil = new ParseUtil();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Course course = courseServletService.getById(Integer.parseInt(request.getParameter("number")));
        ProjectInfo.setCourse(course);
        Student anyStudent = course.getStudents().stream().findAny().get();
        Map<Student, Map<String,String>> courseMap = ProjectInfo.getMarks().get(course);
        request.setAttribute("courseMap",courseMap);
        request.setAttribute("titles", courseMap.get(anyStudent));
        Map<Integer, String> studentAdditionalMap = new LinkedHashMap<>();
        for (Student student: course.getStudents()){
            studentAdditionalMap.put(student.getId(), parseUtil.parseStudent(student));
        }
        request.setAttribute("studentMap", studentAdditionalMap);
        request.getRequestDispatcher("/coachPutMarks.jsp").forward(request,response);

    }
}
