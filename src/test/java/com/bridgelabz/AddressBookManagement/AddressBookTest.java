package com.bridgelabz.AddressBookManagement;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AddressBookTest {
	static AddressBook addressBook = new AddressBook();
	@BeforeClass
	public static void createAddressBookObject() {
		addressBook.setAddressBookName("book1");
	}
	@Test
	public void givenDetails_ShouldAddToContactList() {
		ContactPerson person = new ContactPerson();
		addressBook.addContact("Raj", new ContactPerson("Raj","Chowhan","raj@gmail.com",832860,"Rjy","AP",533101));
		addressBook.addContact("Prudhvi", new ContactPerson("Prudhvi","Kumar","Prudhvi@gmail.com",957363,"Kkd","AP",533106));
		int listSize = addressBook.contactList.size();
		Assert.assertEquals(2, listSize);
	}
	@Test
	public void given2Contacts_WhenWrittenToFile_ShouldMatchEntries()
	{
		AddressBookFileIO addressFileIO = new AddressBookFileIO();
		addressFileIO.writeToAddressBookFile("book1.txt", addressBook.contactList);
		addressFileIO.printData("book1.txt");
		long entries = addressFileIO.countEntries("book1.txt");
		Assert.assertEquals(2, entries);
	}
	@Test
	public void givenFile_WhenRead_ShouldReturnNumberOfEntries() {
		AddressBookFileIO addressFileIO = new AddressBookFileIO();
		List<String> entries = addressFileIO.readDataFromFile("book1.txt");
		long countEntries = entries.size();
		Assert.assertEquals(2, countEntries);
	}
}