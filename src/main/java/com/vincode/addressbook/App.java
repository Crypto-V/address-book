package com.vincode.addressbook;

import com.vincode.addressbook.controler.MainController;
import com.vincode.addressbook.dao.AddressBookImpl;
import com.vincode.addressbook.ui.UserConsoleIO;
import com.vincode.addressbook.ui.UserConsoleImpl;
import com.vincode.addressbook.ui.UserConsoleView;


public class App {
    public static void main(String[] args) {
        UserConsoleIO io = new UserConsoleImpl();
        UserConsoleView view = new UserConsoleView(io);
        AddressBookImpl dao = new AddressBookImpl();
        MainController controller = new MainController(view,dao);

        controller.run();
    }
}
