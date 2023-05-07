package com.vincode.addressbook.ui;

public interface UserConsoleIO {

    void print(String prompt);
    int readIntOption(String prompt);
    int readIntOption(String prompt,int min, int max);
    String readStringOption(String prompt);
    boolean readConfirmation();
}
