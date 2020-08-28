package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
        startPhone();
        boolean turnOn = true;

        printOptions();

        while (turnOn) {
            System.out.println("Choose you action");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    mobilePhone.printContactList();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    findContact();
                    break;
                case 6:
                    System.out.println("Turning off....");
                    turnOn = false;

            }
        }
    }

    private static void findContact() {
        System.out.println("Enter existing contact name");
        String name = sc.next();
        sc.nextLine();

        Contact contact = mobilePhone.queryContact(name);
    }

    private static void deleteContact() {
        System.out.println("Enter existing contact name");
        String name = sc.next();

        Contact contact = mobilePhone.queryContact(name);
        if (contact == null ) {
            System.out.println("Contact doesn't exists");
        }
        mobilePhone.deleteContact(contact);

    }

    private static void updateContact() {
        System.out.println("Enter existing contact name");
        String name = sc.next();
        sc.nextLine();

        Contact contact = mobilePhone.queryContact(name);
        if (contact == null) {
            System.out.println("Contact doesn't exists");
        }
        if (contact != null) {
            System.out.println("Enter new name: ");
            String newName = sc.next();
            sc.nextLine();
            System.out.println("Enter new number");
            int newNumber = sc.nextInt();

            Contact newContact = new Contact(newName, newNumber);

            mobilePhone.updateContact(contact, newContact);
        }
    }

    private static void addContact() {
        System.out.println("Enter contacts name: ");
        String name = sc.next();
        sc.nextLine();
        System.out.println("Enter phone number: ");
        int number = sc.nextInt();
        sc.nextLine();

        Contact contact = Contact.createContact(name, number);

        if (mobilePhone.addContact(contact)) {
            System.out.println("Contact: " + contact.getName() + " with phone number: " + contact.getNumber() + " added to the contact list");

        } else {
            System.out.println("Contact already exists ");
        }

    }

    private static void printOptions() {
        System.out.println("Possible options: ");
        System.out.println("Option 1: Print Contacts");
        System.out.println("Option 2: Add Contact");
        System.out.println("Option 3: Update Contact");
        System.out.println("Option 4: Delete Contact");
        System.out.println("Option 5: Find Contact");
        System.out.println("Option 6: Turn of phone");
    }

    private static void startPhone() {

        System.out.println("Phone is online");
    }


}
