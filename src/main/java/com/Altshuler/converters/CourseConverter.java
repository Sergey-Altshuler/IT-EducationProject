package com.Altshuler.converters;

import com.Altshuler.model.Course;
import com.Altshuler.util.CourseGroupUtil;
import com.Altshuler.util.ParseUtil;

import javax.servlet.http.HttpServletRequest;

public class CourseConverter {
    CourseGroupUtil courseGroupUtil = new CourseGroupUtil();
    ParseUtil parseUtil = new ParseUtil();

    public Course convert(HttpServletRequest request) {
        return Course.builder()
                .title(request.getParameter("title"))
                .educationType(request.getParameter("educationType"))
                .price(Integer.parseInt(request.getParameter("price")))
                .numOfLessons(Integer.parseInt(request.getParameter("numOfLessons")))
                .address(request.getParameter("address"))
                .numOfStudents(Integer.parseInt(request.getParameter("numOfStudents")))
                .subgroupNum(courseGroupUtil.getCourseGroup(request.getParameter("title")))
                .startDate(parseUtil.parseDate(request.getParameter("startDate")))
                .finishDate(parseUtil.parseDate(request.getParameter("finishDate")))
                .isStarted("No")
                .coachRequired("Yes")
                .remaining(Integer.parseInt(request.getParameter("numOfStudents"))).build();

    }
}
