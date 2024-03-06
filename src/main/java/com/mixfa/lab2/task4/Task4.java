package com.mixfa.lab2.task4;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

public class Task4 {
    public static void readSortWrite(String input, String output) throws IOException {
        try (var fileWriter = new PrintWriter(output)) {

            try (var lines = Files.lines(Path.of(input))) {
                lines
                        .filter((line) -> line.contains("a"))
                        .sorted(Comparator.comparing(String::length))
                        .forEach(fileWriter::println);
            }

        }
    }

    public static void main(String[] args) throws IOException {
        readSortWrite("input.txt", "output.txt");
    }
}
