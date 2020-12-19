import java.util.Scanner;

public class Email {
    private Scanner scanner;
    private String email;
    private String companySuffix;
    private String firstName;
    private String lastName;
    private String password;
    private String dept;
    private int capacity;
    private int defaultPassLength;
    private String altEmail;

    public Email(String firstName, String lastName) {
        scanner = new Scanner(System.in);
        this.companySuffix = "company.com";
        this.firstName = firstName;
        this.lastName = lastName;
        this.dept = setDepartment();
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() +
                "@" + this.dept + companySuffix;
        System.out.println("The email is: " + this.email);
        this.defaultPassLength = 8;
        this.password = randomPassword(defaultPassLength);
        System.out.println("The password for this account is: " + password);
        //combine elements to generate email
    }

    private String setDepartment() {
        System.out.print("\nEnter the department code:\n1 for Sales" +
                "\n2 for Development\n3 for Accounting\n4 for None\n");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: return "sales.";
            case 2: return "development.";
            case 3: return "accounting.";
            default: return "";
        }
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setAltEmail(String altEmail) {
        this.altEmail = altEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {return this.email;}

    public String getCapacity() {return this.capacity + "mb";}

    public String getAltEmail() {return this.altEmail;}

    public String getPassword() {return this.password;}

    //takes how long the password should be so can change
    //if requirements change
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%";
        //generate a random number and find the value of this array at
        //any given number
        char[] password = new char[length];
        //iterate through value of length
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        //returning the password
        return new String(password);
    }

    public String showInfo() {
        return "\nDISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + this.capacity + "mb";
    }

}
