package emailapp;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private int mailBoxCapacity = 500;

    // Constructur to recive names
    public Email() {
        String[] fullName = new String[2];
        String full = setNames();
        fullName[0] = full.split(" ")[0];
        fullName[1] = full.split(" ")[1];
        this.firstName = fullName[0];
        this.lastName = fullName[1];

        // Call a method asking for department -return the department
        this.department = setDepartment();

        // Call a method to return random password
        this.password = generatePassword(defaultPasswordLength);

        // Combine
        email = fullName[0].toLowerCase() + "." + fullName[1].toLowerCase() + "@" + department + ".aeycompany.com";
    }
    // Ask names
    private String setNames() {
        System.out.println("Enter your first name:\n");
        Scanner in = new Scanner(System.in);
        String first = in.nextLine();
        System.out.println("Enter your last name\n");
        String last = in.nextLine();
        return new String(first + " " + last);
    }
    // Ask department
    private String setDepartment() {
        System.out.println("Enter the department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        in.close();
        if (depChoice == 1) { return "sales"; }
        else if (depChoice == 2) { return "dev"; }
        else if (depChoice == 3) { return "acct"; }
        else {return ""; }
    }
    // Generate random password
    private String generatePassword(int len) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789>!(@#${}";
        char[] password = new char[len];
        for (int i = 0; i < len; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }
    // Set alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
    // Change password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() { return mailBoxCapacity; }
    public String getAlternateEmail() { return alternateEmail; }
    public String getPassword() { return password; }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailBoxCapacity + "mb" +
                "\nPASSWORD: " + password;
    }
}
