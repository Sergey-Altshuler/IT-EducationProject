package com.Altshuler.util;

import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Course;
import com.Altshuler.model.Stats;
import com.Altshuler.model.Student;
import com.Altshuler.servletService.CourseServletService;
import com.Altshuler.servletService.StatsServletService;
import com.Altshuler.servletService.StudentServletService;

import java.util.LinkedHashMap;
import java.util.Map;

public class MarkUtil {
    private final ParseUtil parseUtil = new ParseUtil();
    private final CourseServletService courseServletService = new CourseServletService();
    private final StudentServletService studentServletService = new StudentServletService();
    private final StatsServletService statsServletService = new StatsServletService();
    private final String regexMark = "[0-9]|10";
    private final String regexAttendance = "N";

    public void initializeMarks(Course course) {
        Map<Course, Map<Student, Map<String, String>>> markMap = ProjectInfo.getMarks();
        Map<String, String> miniMap = new LinkedHashMap<>();
        miniMap.put("Student", null);
        for (int i = 0; i < course.getNumOfLessons(); i++) {
            miniMap.put(String.valueOf(i + 1), "-");
        }
        miniMap.put("Avg_mark", "-");
        miniMap.put("attendance", "-");
        Map<Student, Map<String, String>> middleMap = new LinkedHashMap<>();
        for (Student student : course.getStudents()) {
            Map<String, String> studentMarkMap = new LinkedHashMap<>(miniMap);
            studentMarkMap.put("Student", parseUtil.parseStudent(student));
            middleMap.put(student, new LinkedHashMap<>(studentMarkMap));
        }
        markMap.put(course, middleMap);
        ProjectInfo.setMarks(markMap);
    }

    public int getIsFinished(Course course) {
        Map<Course, Map<Student, Map<String, String>>> markMap = ProjectInfo.getMarks();
        Map<Student, Map<String, String>> utilMap = markMap.get(course);
        Student student = course.getStudents().stream().findAny().get();
        Map<String, String> miniMap = utilMap.get(student);
        int result = 0;
        for (int i = 1; i < miniMap.size() - 2; i++) {
            if ((miniMap.get(String.valueOf(i)) != null) && (miniMap.get(String.valueOf(i)).equals("-"))) {
                result = i;
                break;
            }
        }
        return result;
    }

    public void setLessonMarks(Course course, Map<String, String> studentsMarksMap, int numLesson) {
        Map<Course, Map<Student, Map<String, String>>> markMap = ProjectInfo.getMarks();
        Map<Student, Map<String, String>> middleMap = markMap.get(course);
        for (Map.Entry<String, String> mapEntry : studentsMarksMap.entrySet()) {
            Student student = studentServletService.getById(Integer.parseInt(mapEntry.getKey()));
            middleMap.get(student).put(String.valueOf(numLesson), mapEntry.getValue());
        }
        markMap.put(course, middleMap);
        ProjectInfo.setMarks(markMap);
    }

    public void calculateIndividualStatistics(Course course) {
        Map<Course, Map<Student, Map<String, String>>> markMap = ProjectInfo.getMarks();
        Map<Student, Map<String, String>> middleMap = markMap.get(course);

        int numOfLessons = course.getNumOfLessons();
        for (Map.Entry<Student, Map<String, String>> mapEntry : middleMap.entrySet()) {
            Student student = mapEntry.getKey();
            Map<String, String> miniMap = mapEntry.getValue();
            int numOfAbsence = 0;
            double sumMarks = 0;
            for (Map.Entry<String, String> miniMapEntry : miniMap.entrySet()) {
                if (miniMapEntry.getValue().matches(regexMark))
                    sumMarks += Double.parseDouble(miniMapEntry.getValue());
                if (miniMapEntry.getValue().matches(regexAttendance))
                    numOfAbsence++;
            }
            double avgMark = sumMarks / (numOfLessons - numOfAbsence);
            double percentAttendance = 100.0 - ((double) (numOfAbsence) / numOfLessons * 100);
            String avg = String.format("%.2f", avgMark);
            String attend = String.format("%.1f", percentAttendance);
            middleMap.get(student).put("Avg_mark", avg);
            middleMap.get(student).put("attendance", attend);
        }
        markMap.put(course, middleMap);
        ProjectInfo.setMarks(markMap);
    }

    public void calculateTotalStatistics(Course course) {
        Map<Course, Map<Student, Map<String, String>>> markMap = ProjectInfo.getMarks();
        Map<Student, Map<String, String>> middleMap = markMap.get(course);
        int numOfStudents = course.getNumOfStudents();
        double avgAttendance = 0d;
        double avgMark = 0d;
        for (Map.Entry<Student, Map<String, String>> miniMapEntry : middleMap.entrySet()) {
            String attend = miniMapEntry.getValue().get("attendance");
            String attendFinal = attend.replace(",", ".");
            avgAttendance = avgAttendance + Double.parseDouble(attendFinal);
            String avg = miniMapEntry.getValue().get("Avg_mark");
            String avgFinal = avg.replace(",", ".");
            avgMark = avgMark + Double.parseDouble(avgFinal);
        }
        double courseAttendance = (Math.round(avgAttendance / numOfStudents * 1000)) / 1000.0;
        double courseMark = (Math.round(avgMark / numOfStudents * 1000)) / 1000.0;
        Stats stats = Stats.builder().avgMark(courseMark).attendance(courseAttendance).build();
        stats.setCourse(course);
        course.setStats(stats);
        ProjectInfo.setCourse(course);
        courseServletService.add(course);
        statsServletService.add(stats);

    }
}
