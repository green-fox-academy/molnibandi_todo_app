package com.greenfox;

public class ArgumentHandler {

    static String[] arguments;

    public ArgumentHandler(String[] arguments) {
        ArgumentHandler.arguments = arguments;
    }

    public boolean noArgument() {
        return arguments.length == 0;
    }

    public boolean validLength() {
        return arguments.length == 1 || arguments.length == 2;
    }

    public boolean validArg() {
        return arguments[0].equals("-l") || arguments[0].equals("-a") || arguments[0].equals("-r")
                || arguments[0].equals("-c");
    }

    public static void handleList() {
        if (arguments[0].equals("-l")) {
            TaskHandler.printTasks();
        } else if (arguments[0].equals("-a")) {
            TaskHandler.add();
        } else if (arguments[0].equals("-r")) {
            TaskHandler.removeTask();
        } else if (arguments[0].equals("-c")) {
            TaskHandler.checkTask();
        }
    }

}
