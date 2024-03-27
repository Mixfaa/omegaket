package com.mixfa.lab2.old.task2;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileWalker {

    private static void printDirs1(File path) {
        var list = path.listFiles();
        if (list == null)
            return;

        for (File file : list) {
            if (file.isFile())
                System.out.println(file.getName());
            else if (file.isDirectory())
                printDirs1(file);
        }
    }

    private static void printDirs2(Path path) throws IOException {
        try (var stream = Files.walk(path, FileVisitOption.FOLLOW_LINKS)) {
            stream
                    .forEach((path_) -> {
                        if (Files.isRegularFile(path_))
                            System.out.println(path_.getFileName());
                    });
        }


    }

    public static void main(String[] args) throws IOException {
        var scanner = new Scanner(System.in);
        System.out.println("Enter path");
        var path = scanner.nextLine();

        File filePath = new File(path);
        if (!filePath.isDirectory()) {
            System.out.println("Entered path is file, not a directory");
            return;
        }

        System.out.println("_________________Using java.io.File_________________");
        printDirs1(filePath);
        System.out.println("_________________Using java.nio_________________");
        printDirs2(Path.of(path));
    }

}
