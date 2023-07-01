package com.first.demo.services;
import com.first.demo.entity.Course;
import java.util.List;
public interface CourseService {
    public List<Course> getCourses();
    public Course getCourses(long courseId);

    public Course addCourse(Course course);

    public void deleteCourse(long courseId);
}
