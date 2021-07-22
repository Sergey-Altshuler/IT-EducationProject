package com.Altshuler.util;

import com.Altshuler.info.ProjectInfo;

import java.util.Map;

public class CourseGroupUtil {
    public int getCourseGroup(String title) {
        int result = 1;
        Map<String, Integer> groupMap = ProjectInfo.getCourseGroups();
        if (groupMap.containsKey(title)) {
            result = groupMap.get(title) + 1;
        }
        groupMap.put(title, result);
        ProjectInfo.setCourseGroups(groupMap);
        return result;
    }
}
