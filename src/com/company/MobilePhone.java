package com.company;

import java.util.ArrayList;

public class MobilePhone {
    ArrayList<Contact> contacts;

    public MobilePhone() {
        this.contacts = new ArrayList<>();
    }

    public void printContactList() {
        System.out.println("Your contacts: ");
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);

            System.out.println("Contact number: " + (i + 1) + "\n" +
                    "Name -" + contact.getName() + "\n" +
                    "Number: " + contact.getNumber());
        }
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            System.out.println("Contact found ");
            return contacts.get(position);

        } else {
            return null;
        }

    }

    public boolean deleteContact(Contact contact) {
        int position = findContact(contact);
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact with name " + contact.getName() + " deleted");
            contacts.remove(contact);
            return true;
        }
        return false;
    }

    public boolean updateContact(Contact existingContact, Contact newContact) {
        int position = findContact(existingContact.getName());
        if (position < 0) {
            System.out.println("Such contact doesn't exist");
            return false;
        } else if (findContact(newContact.getName()) != -1) {
            System.out.println("Contact already exists ");
            return false;
        }

        this.contacts.set(position, newContact);
        System.out.println(existingContact.getName() + " was updated to " + newContact.getName() +
                "and number " + newContact.getNumber());
        return true;
    }

    public boolean addContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            return false;
        }

        contacts.add(contact);

        return true;
    }

    private int findContact(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = this.contacts.get(i);
            if (contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private int findContact(Contact contact) {
        return this.contacts.indexOf(contact);
    }
}
