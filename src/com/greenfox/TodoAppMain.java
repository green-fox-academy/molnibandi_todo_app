package com.greenfox;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TodoAppMain {

    public static void main(String[] args) {

        ArgumentHandler handler = new ArgumentHandler(args);

        if (handler.noArgument()) {
            printMenu();
        } else if (!handler.validArg() || !handler.validLength()) {
            System.out.println("Unsupported argument");
            printMenu();
        } else {
            TaskHandler myTodoList = new TaskHandler(args);
            myTodoList.handleList();
        }
    }


    private static void printMenu() {
        try {
            Path filePath = Paths.get("todoMenu.txt");
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                System.out.println(line);
            }

        } catch (Exception e) {
            System.out.println("Not able to read the file!");
        }
    }
}
