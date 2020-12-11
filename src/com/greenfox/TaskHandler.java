package com.greenfox;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TaskHandler {

    static String[] arguments;
    static Path myListPath;
    static List<String> lines;

    public TaskHandler(String[] arguments) {
        TaskHandler.arguments = arguments;
        try {
            myListPath = Paths.get("todoList.txt");
            lines = Files.readAllLines(myListPath);
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public static void writeFile() {
        try {
            Files.write(myListPath, lines);
        } catch (Exception e) {
            System.out.println("error");
        }
    }
    public static void printTasks() {
        if (lines.size() == 0) {
            System.out.println("No todos for today! :)");
        } else {
            for (int i = 0; i < lines.size(); i++) {
                System.out.println((i + 1) + " - " + lines.get(i));
            }
        }
    }

    public static void add() {
        if (arguments.length == 1) {
            System.out.println("Unable to add: no task provided");
        } else {
            arguments[1] = "[ ] " + arguments[1];
            lines.add(arguments[1]);
        }
        writeFile();
    }

    public static void removeTask() {
        int toRemove = checkIndex("remove");
        if (toRemove >= 0) {
            lines.remove(toRemove);
            writeFile();
        }
    }

    public static void checkTask() {
        int toCheck = checkIndex("check");
        if (toCheck >= 0) {
            String taskToCheck = lines.get(toCheck).substring(3);
            lines.remove(toCheck);
            lines.add(toCheck, "[X]" + taskToCheck);
            writeFile();
        }
    }

    public static int checkIndex(String task) {
        int toHandle;

        if (arguments.length == 1) {
            System.out.println("Unable to " + task + ": no index provided");
            return -1;
        }

        try {
            toHandle = Integer.parseInt(arguments[1]) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Unable to " + task + ": index is not a number");
            return -1;
        }

        if (toHandle > lines.size()) {
            System.out.println("Unable to " + task + ": index is out of bound");
            return -1;
        }

        return toHandle;
    }
}
