/*made with Master Skills https://www.youtube.com/watch?v=U3Ibvu0htNs&feature=emb_logo
a command line program for a system administrator to generate email accounts,
email addresses, passwords, etc.

expanded slightly from the video to include a menu*/

import java.util.ArrayList;
import java.util.Scanner;

public class EmailApp {
    ArrayList<Email> emails = new ArrayList<>();
    Scanner scan;

    public EmailApp() {
        this.emails = new ArrayList<>();
        this.scan = new Scanner(System.in);
    }

    public void menu() {
        System.out.println("Welcome to the email application!");
        while (true) {
            System.out.println("\nOPTIONS:" +
                    "\n1. Add user" + "\n2. Change user details" + "\n3. Get user info" +
                     "\n4. View users" + "\n5. End");
            int choice = Integer.valueOf(scan.nextLine());
            switch(choice) {
                case 1: addUser(); break;
                case 2: changeDetails();break;
                case 3: getInfo(); break;
                case 4: viewUsers(); break;
                case 5: System.exit(0);
                default:
                    System.out.println("Pick a valid option.");
                    break;
            }
        }
    }

    public void addUser() {
        System.out.println("Enter a first name for the user: ");
        String firstName = scan.nextLine();
        System.out.println("Enter a surname: ");
        String lastName = scan.nextLine();
        Email email = new Email(firstName, lastName);
        emails.add(email);
    }

    public void changeDetails() {
        System.out.println("\nWhat would you like to change?" +
                "\n1. Mailbox capacity" +
                "\n2. Set alternate email" +
                "\n3. Set password" +
                "\n4. Back");
        int choice = Integer.valueOf(scan.nextLine());
        System.out.println("\nEnter the user's email: ");
        String userEmail = scan.nextLine();
        for (Email email : emails) {
            if (email.getEmail().equals(userEmail)) {
                switch (choice) {
                    case 1:
                        editCapacity(email);
                        return;
                    case 2:
                        addAlternate(email);
                        return;
                    case 3:
                        editPass(email);
                        return;
                    case 4:
                        return;
                    default:
                        System.out.println("Enter a valid choice");
                        return;
                }
            }
        }
        System.out.println("Email did not match stored users");
    }

    public void editCapacity(Email email) {
        System.out.println("\nEnter desired capacity: ");
        int capacity = Integer.valueOf(scan.nextLine());
        email.setCapacity(capacity);
    }

    public void addAlternate(Email email) {
        System.out.println("\nEnter alternate email");
        String altemail = scan.nextLine();
        email.setAltEmail(altemail);
    }

    public void editPass(Email email) {
        System.out.println("\nEnter new password");
        String pass = scan.nextLine();
        email.setPassword(pass);
    }

    public void getInfo() {
        System.out.println("\nEnter user's email");
        String userEmail = scan.nextLine();
        System.out.println("\nWhat info are you looking for?" +
                "\n1. Capacity" +
                "\n2. Alternate Email" +
                "\n3. End");
        int choice = Integer.valueOf(scan.nextLine());
        for (Email email : emails) {
            if (email.getEmail().equals(userEmail)) {
                switch(choice) {
                    case 1:
                        System.out.println(email.getCapacity());
                        return;
                    case 2:
                        System.out.println(email.getAltEmail());
                        return;
                    case 3:
                        return;
                }
            }
        }
        System.out.println("User could not be found");
    }

    public void viewUsers() {
        for (Email email : emails) {
            System.out.println(email.showInfo());
        }
    }
}
