package com.greenfox;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TodoAppMain {

    public static void main(String[] args) {
        if (args.length > 0) {
            for (String s : args) {
                switch (s) {
                    case "-a":
                        add();
                        break;
                    case "-l":
                        list();
                        break;
                    case "-r":
                        remove();
                        break;
                    case "-c":
                        complete();
                        break;
                    default:
                        printMenu();
                }
            }
        } else {
            printMenu();

        }
    }

    private static void printMenu() {
        try {
            Path filePath = Paths.get("C:\\Users\\molna\\Desktop\\greenfox\\molnibandi_todo_app\\out\\production\\molnibandi_todo_app\\todoMenu.txt");
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                System.out.println(line);
            }

        } catch (Exception e) {
            System.out.println("Not able to read the file!");
        }
    }

    public static void add() {
        System.out.println("Add a task");
    }

    public static void list() {
        System.out.println("List tasks");
    }

    public static void remove() {
        System.out.println("Remove a task");
    }

    public static void complete() {
        System.out.println("Complete a task");
    }
}
