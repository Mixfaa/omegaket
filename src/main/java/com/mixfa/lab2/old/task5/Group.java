package com.mixfa.lab2.old.task5;

import java.util.Arrays;

public final class Group {
    public final String name;
    public final Student[] students;

    public Group(
            String name,
            Student[] students) {
        this.name = name;
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group[" +
                "name=" + name + ", " +
                "students=" + Arrays.toString(students) + ']';
    }

}