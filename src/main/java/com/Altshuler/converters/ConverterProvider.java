package com.Altshuler.converters;

import com.Altshuler.model.Coach;
import com.Altshuler.model.Course;
import com.Altshuler.model.Student;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ConverterProvider {
    private static final Map<Class<?>, Converter<?>> CONVERTER_MAP;

    public static Map<Class<?>, Converter<?>> getConverterMap() {
        return CONVERTER_MAP;
    }

    static {
        CONVERTER_MAP = new HashMap<>();
        CONVERTER_MAP.put(Coach.class, new CoachConverter());
        CONVERTER_MAP.put(Course.class, new CourseConverter());
        CONVERTER_MAP.put(Student.class, new StudentConverter());
    }

    public static Converter<?> getConverter(Class<?> clazz) throws Exception {
        return Optional.ofNullable(CONVERTER_MAP.get(clazz)).orElseThrow(Exception::new);
    }

    @SuppressWarnings("unchecked")
    public static <T> T convert(Class<?> clazz, HttpServletRequest request) throws Exception {
        return (T) ConverterProvider.getConverter(clazz).convert(request);
    }
}
