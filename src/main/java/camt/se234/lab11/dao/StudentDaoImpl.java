package camt.se234.lab11.dao;

import camt.se234.lab11.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    List<Student> students;
    public StudentDaoImpl(){
        students = new ArrayList<>();
        students.add(new Student("123","A","temp",2.33));
        students.add(new Student("135","B","dee",3.86));
        students.add(new Student("133","C","omg",3.58));
        students.add(new Student("142","D","lip",2.98));
        students.add(new Student("147","E","piece",3.23));


    }

    @Override
    public List<Student> findAll() {

        return this.students;
    }

    @Override
    public double getAverageGpa() {
        return 0;
    }


}
