package com.cmcc.dao;

import com.cmcc.entity.Student;

public interface StudentDao {
    public Student findStudentById(String idCard);
}
