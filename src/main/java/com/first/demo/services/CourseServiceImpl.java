package com.first.demo.services;

import com.first.demo.entity.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{
    private List<Course> list;

    public CourseServiceImpl() {
        this.list = new ArrayList<>();
        this.list.add(new Course(1, "Maths", "This is Mathematics."));
        this.list.add(new Course(2, "Science", "This is Science."));
    }

    @Override
    public List<Course> getCourses() {
        return this.list;
    }

    @Override
    public Course getCourses(long courseId) {
        Course c = null;
        for(Course course:list) {
            if(course.getId()==courseId) {
                c = course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        this.list.add(course);
        return course;
    }

    @Override
    public void deleteCourse(long courseId) {
        this.list = this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
    }
}
