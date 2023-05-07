package com.vincode.addressbook.controler;

import com.vincode.addressbook.dao.AddressBookImpl;
import com.vincode.addressbook.dto.Address;
import com.vincode.addressbook.dto.AddressBook;
import com.vincode.addressbook.ui.UserConsoleView;

import java.util.List;

public class MainController {

    UserConsoleView view;
    AddressBookImpl dao;

    public MainController(UserConsoleView view, AddressBookImpl dao) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        int menuselection = 1;

        try {
            while (menuselection != 0) {

                menuselection = getMenuSelection();

                switch (menuselection) {
                    case 1 -> createNewEntry();
                    case 2 -> viewEntry();
                    case 3 -> viewAllEntries();
                    case 4 -> removeAddressRecord();
                    case 5 -> getAddressByName();
                    case 6 -> menuselection = 0;

                    default -> System.out.println("Unknown command!");
                }
            }
            System.out.println("Good bye!!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getMenuSelection() {
        return view.displayMenuAndGetUserSelection();
    }

    private void createNewEntry() {
        view.displayCreateNewEntry();
        AddressBook addressBook = view.getNewAddressBookEntry();
        dao.createAddressBookEntry(addressBook);
        view.displaySuccessBanner();
        view.displayNewEntry(addressBook);
    }

    private void viewEntry() {
        int id = view.getAddressBookIdChoice();
        AddressBook addressBook = dao.getAddressById(id);
        view.displayAddressBookEntry(id, addressBook);
    }

    private void viewAllEntries() {
        view.displayAllAddressesBanner();
        List<AddressBook> addressBookList = dao.getAllAddressBooksEntries();
        view.displayAddressBookEntries(addressBookList);
    }

    private void removeAddressRecord() {
        int id = view.getAddressBookIdChoice();
        boolean confirmed = view.getUserConfirmation();
        if (confirmed) {
            dao.removeAddressBook(id);
        } else {
            view.displayMenuAndGetUserSelection();
        }

    }

    private void getAddressByName(){
        String str = view.getAddressByNameChoice();
        Address address  = dao.getAddressByName(str);
        view.displayAddressById(address.getAddressId(),address);
    }


}
