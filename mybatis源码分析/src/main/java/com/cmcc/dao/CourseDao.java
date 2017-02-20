package com.cmcc.dao;

import com.cmcc.entity.Course;

public interface CourseDao {
    public Course findCourseById(int courseId);
}
