package com.vincode.addressbook.ui;

import com.vincode.addressbook.dto.Address;
import com.vincode.addressbook.dto.AddressBook;
import com.vincode.addressbook.dto.User;
import java.util.List;


public class UserConsoleView {
    UserConsoleIO io;

    public UserConsoleView(UserConsoleIO io) {
        this.io = io;
        io.print("Hello and welcome to your APP! ");
    }


    public int displayMenuAndGetUserSelection() {

        io.print("1. Create a new address. ");
        io.print("2. View the address. ");
        io.print("3. View all the addresses. ");
        io.print("4. Remove the address. ");
        io.print("5. Get address by last name. ");
        io.print("6. Exit. ");

        return io.readIntOption("Please select one of the options!", 1, 6);
    }

    public AddressBook getNewAddressBookEntry() {
        System.out.println("Provide the info about the person you are registering:");
        String entryFirstName = io.readStringOption("What is the person first name? ").toUpperCase();
        String entrySecondName = io.readStringOption("What is the person second name? ").toUpperCase();
        User user = new User(entryFirstName, entrySecondName);

        io.print("Now, lets get the address of the user:");
        int houseNumber = io.readIntOption("What is the user house number?  ");
        String firstLineOfAddress = io.readStringOption("What is the user first line of the address?  ").toUpperCase();
        String city = io.readStringOption("What is the user city?  ").toUpperCase();
        String state = io.readStringOption("What is the user country state?  ").toUpperCase();
        String postcode = io.readStringOption("What is the user postcode?  ").toUpperCase();

        Address address = new Address(houseNumber, firstLineOfAddress, city, state, postcode);

        return new AddressBook(user, address);

    }

    public void displayCreateNewEntry() {
        io.print("Create new address in your address book:");
    }

    public void displaySuccessBanner() {
        io.print("New address successfully uploaded to your address book.");
    }

    public void displayNewEntry(AddressBook addressBook) {
        if (addressBook != null) {
            String addressBookInfo = String.format("%d : %s", addressBook.getId(), addressBook.getUser().toString() + " : " + addressBook.getAddress().toString());
            io.print(addressBookInfo);
        } else {
            io.print("Something went wrong!");
        }
        io.readStringOption("Hit enter to continue! ");
    }

    public int getAddressBookIdChoice() {
        return io.readIntOption("Enter the id of the record you want to view?");

    }

    public void displayAddressBookEntry(int id, AddressBook addressBook) {

        if (addressBook != null) {
            io.print("The entry with the id: " + id + " is: ");
            String addressBookInfo = String.format("%s : {%s}", addressBook.getUser().getFirstName(), addressBook.getAddress().toString());
            io.print(addressBookInfo);
        } else {
            io.print("Invalid Id entered! Or non-existent address requested!!");
        }

        io.readStringOption("Hit enter to continue! ");
    }

    public void displayAllAddressesBanner() {
        io.print("Here is the list of all your entries: ");
    }

    public void displayAddressBookEntries(List<AddressBook> addressBookList) {
        addressBookList.forEach((addressBook) -> {
            System.out.println(addressBook.getId() + ": " + addressBook);
        });
        io.readStringOption("Hit enter to continue! ");

    }

    public boolean getUserConfirmation() {
        return io.readConfirmation();
    }

    public String getAddressByNameChoice() {
        return io.readStringOption("Enter the last name of the person you want the address? ").toUpperCase();
    }

    public void displayAddressById(int addressId, Address address) {
        if (address != null) {
            String tempString = String.format("%d : %S", addressId, address);
            io.print(tempString);
        } else {
            io.print("No User Found!! ");
        }
    }
}
