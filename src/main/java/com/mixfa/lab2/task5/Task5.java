package com.mixfa.lab2.task5;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task5 {
    private static final XStream xmlXStream = new XStream(new StaxDriver());
    private static final XStream jsonXStream = new XStream(new JettisonMappedXmlDriver());

    static {
        var allowedClasses = new Class[]{
                Group.class,
                Student.class
        };
        jsonXStream.allowTypes(allowedClasses);
        xmlXStream.allowTypes(allowedClasses);
    }

    public static Group getGroupWithStudents() {
        var students = new Student[]{
                new Student("Misha", 0),
                new Student("Antonio", 1),
                new Student("Eugen", 2)
        };

        return new Group("KN-222a", students);
    }

    public static void writeToJsonFile(Group group, String filename) throws IOException {
        try (var outputStream = new FileOutputStream(filename)) {
            jsonXStream.toXML(group, outputStream);
        }
    }

    public static void writeToXmlFile(Group group, String filename) throws IOException {

        try (var outputStream = new FileOutputStream(filename)) {
            xmlXStream.toXML(group, outputStream);
        }
    }

    public static Group readFromJsonFile(String filename) {
        return (Group) jsonXStream.fromXML(new File(filename));
    }

    public static Group readFromXmlFile(String filename) {
        return (Group) xmlXStream.fromXML(new File(filename));
    }

    public static void main(String[] args) throws IOException {
        writeToXmlFile(getGroupWithStudents(), "group.xml");
        writeToJsonFile(getGroupWithStudents(), "group.json");

        System.out.println("Deserializing from json");
        Group jsonDeserializedGroup = readFromJsonFile("group.json");
        System.out.println(jsonDeserializedGroup);

        System.out.println("Deserializing from xml");
        Group xmlDeserizaliedGroup = readFromXmlFile("group.xml");
        System.out.println(xmlDeserizaliedGroup);
    }

}
