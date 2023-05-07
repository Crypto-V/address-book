package com.vincode.addressbook.dao;

import com.vincode.addressbook.dto.Address;
import com.vincode.addressbook.dto.AddressBook;
import com.vincode.addressbook.dto.User;

import java.util.*;

public class AddressBookImpl implements IAddressBook {

    Map<Integer, AddressBook> addressBookMap = new HashMap<>();


    @Override
    public AddressBook createAddressBookEntry(AddressBook addressBook) {
        addressBookMap.put(addressBook.getId(), addressBook);
        return addressBook;
    }

    @Override
    public AddressBook getAddressById(int id) {
        return addressBookMap.get(id);
    }

    @Override
    public List<AddressBook> getAllAddressBooksEntries() {
        return new ArrayList<>(addressBookMap.values());
    }

    @Override
    public AddressBook removeAddressBook(int id) {
        return addressBookMap.remove(id);
    }

    @Override
    public Address getAddressByName(String lastName) {
        Map<String, Address> addressByNameMap = new HashMap<>();

        for (AddressBook addressBook : addressBookMap.values()) {
            User user = addressBook.getUser();
            Address address = addressBook.getAddress();
            addressByNameMap.put(user.getLastName(), address);
        }
        return addressByNameMap.get(lastName);

//        List<AddressBook> addressBooks = new ArrayList<>(addressBookMap.values());
//        Address address = null;
//
//        for (AddressBook adBook : addressBooks) {
//            if(adBook.getUser().getLastName().equals(lastName))
//                address = adBook.getAddress();
//        }
//        return address;
    }
}
