package com.vincode.addressbook.dao;

import com.vincode.addressbook.dto.Address;
import com.vincode.addressbook.dto.AddressBook;

import java.util.List;

public interface IAddressBook {

    AddressBook createAddressBookEntry(AddressBook addressBook);

    AddressBook getAddressById(int id);

    List<AddressBook> getAllAddressBooksEntries();

    AddressBook removeAddressBook(int id);

    Address getAddressByName(String lastName);
}
