package camt.se234.lab11.dao;

import camt.se234.lab11.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();
    double getAverageGpa();
}
