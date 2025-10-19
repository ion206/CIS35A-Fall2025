/**
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 2A
Due: Oct 19th 2025
Submitted: Oct 19th 2025


Person.java
 
Class representing the information of a person and holds personal data: name, address, age, and phone number.

Design:

Variables:
name (string) - Name of the person
address (string) - Address of the person
age (int) - person's age as a number
phoneNumber (String) - Person's phone number - saving as a string because integer would be too big and not as useful

Has one Default and one overloaded Constructor:
Person() and Person(String, String, int, String) [name, address, age, phone#]

Public Getter and Setter methods for all 4 variables

print() - prints the Person's personal record as a formatted table
 */

public class Person {
    // 1. Instance Variables (must be private)
    private String name;
    private String address;
    private int age;
    private String phoneNumber;

    // 2. Constructors

    /**
     * Default Constructor.
     * Initializes instance variables to safe or default values.
     */
    public Person() {
        this.name = "Unknown Name";
        this.address = "No Address Provided";
        this.age = 0;
        this.phoneNumber = "000-000-0000";
    }

    /**
     * Overloaded Constructor.
     * Accepts input for all four variables to fully initialize the object.
     *
     *  name (string) The name of the person.
     *  address (string) The address of the person.
     *  age (int) The age of the person.
     *  phoneNumber (string) The phone number of the person.
     */
    public Person(String name, String address, int age, String phoneNumber) {
        this.name = name;
        this.address = address;
        // Basic validation for age
        this.age = (age >= 0) ? age : 0;
        this.phoneNumber = phoneNumber;
    }

    // 3. Getter Methods (Accessors - must be public)

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // 4. Setter Methods (Mutators - must be public)

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        // Basic validation
        this.age = (age >= 0) ? age : this.age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // 5. Business Method - print()

    /**
     * Prints the values of all instance variables in a formatted output.
     */
    public void print() {
        System.out.println("\n--- Personal Record ---");
        System.out.printf("Name:        %s\n", this.name);
        System.out.printf("Address:     %s\n", this.address);
        System.out.printf("Age:         %d years old\n", this.age);
        System.out.printf("Phone:       %s\n", this.phoneNumber);
        System.out.println("-----------------------\n");
    }
}
