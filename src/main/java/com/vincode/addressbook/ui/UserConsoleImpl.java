package com.vincode.addressbook.ui;

import java.util.Scanner;

public class UserConsoleImpl implements UserConsoleIO {
    Scanner input = new Scanner(System.in);

    public void print(String prompt) {
        System.out.println(prompt);
    }

    @Override
    public int readIntOption(String prompt) {
        boolean invalidInput = true;
        int num = 0;
        while (invalidInput) {
            try {
                // print the message msgPrompt (ex: asking for the # of cats!)
                String stringValue = this.readStringOption(prompt);
                // Get the input line, and try and parse
                num = Integer.parseInt(stringValue); // if it's 'bob' it'll break
                invalidInput = false; // or you can use 'break;'
            } catch (NumberFormatException e) {
                // If it explodes, it'll go here and do this.
                this.print("Input error. Please try again.");
            }
        }
        return num;
    }

    public int readIntOption(String prompt, int min, int max) {
        int result;
        do {
            result = readIntOption(prompt);
        } while (result < min || result > max);

        return result;
    }

    public String readStringOption(String prompt) {
        print(prompt);
        return input.nextLine();
    }

    @Override
    public boolean readConfirmation() {
        print("Do you want to continue? y/n");
        String userInput = input.nextLine().toLowerCase();

        if(userInput.equals("y") || userInput.equals("yes"))
            return true;
        else{
            print("You entered no or you something else, either way the process will be canceled.");
            return false;
        }
    }
}
