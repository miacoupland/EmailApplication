public class Main {

    public static void main(String[] args) {
        EmailApp app = new EmailApp();
        app.menu();
    }
}


/*TODO:
    - Generate an email with the following syntax:
        firstname.lastname@department.company.com
    - Determine the department (sales, development, accounting, if none
        leave blank
    - Generate random password string
    - Have set methods to change the password, set the mailbox capacity,
        define an alternative email address
    - Have get methods to display the name, email, and mailbox capacity
 */