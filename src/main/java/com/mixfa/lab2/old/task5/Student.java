package com.mixfa.lab2.old.task5;

public final class Student {
    public final String name;
    public final int id;

    public Student(String name,
                   int id) {
        this.name = name;
        this.id = id;
    }


    @Override
    public String toString() {
        return "Student[" +
                "name=" + name + ", " +
                "id=" + id + ']';
    }

}
