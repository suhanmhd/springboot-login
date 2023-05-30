package com.example.logincredentials;


public class Student {
    private String name;
    private int rollno;
    private  String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }



    public Student(String name, int rollno,String department) {
        this.name = name;
        this.rollno = rollno;
        this.department=department;
    }

    public String getName() {
        return name;
    }

    public int getRollno() {
        return rollno;
    }


}