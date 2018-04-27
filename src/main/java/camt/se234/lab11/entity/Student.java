package camt.se234.lab11.entity;

import java.util.Objects;

public class Student {
    String studentId;
    String name;
    String surName;
    Double gpa;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getStudentId(), student.getStudentId()) &&
                Objects.equals(getName(), student.getName()) &&
                Objects.equals(getSurName(), student.getSurName()) &&
                Objects.equals(getGpa(), student.getGpa());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getStudentId(), getName(), getSurName(), getGpa());
    }

    public Student(String studentId, String name, String surName, Double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.surName = surName;
        this.gpa = gpa;

    }
  public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Double getGpa() {
        return gpa;
    }
    
}
