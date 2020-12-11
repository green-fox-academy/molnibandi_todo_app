package com.greenfox;

public class ArgumentHandler {

    String[] arguments;

    public ArgumentHandler(String[] arguments) {
        this.arguments = arguments;
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

}
