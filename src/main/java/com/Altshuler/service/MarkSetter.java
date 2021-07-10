package com.Altshuler.service;

import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Course;
import com.Altshuler.model.Student;

import java.util.HashMap;
import java.util.Map;

public class MarkSetter {
    public static void initializeMarks(Course course){
        Map<Course, Map<Student, Map<String, String>>> markMap = ProjectInfo.getMarks();
        Map<String, String> miniMap=new HashMap<>();
        for (int i=0; i<course.getNumOfLessons(); i++){
            miniMap.put(String.valueOf(i+1),"-" );
        }
        miniMap.put("Avg_mark", "-");
        miniMap.put("attendance", "-");
        Map<Student, Map<String, String>> middleMap = new HashMap<>();
        for (Student student:course.getStudents()){
            middleMap.put(student,miniMap);
        }
        markMap.put(course, middleMap);
        ProjectInfo.setMarks(markMap);

    }
}
