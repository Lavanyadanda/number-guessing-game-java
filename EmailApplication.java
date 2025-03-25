import java.util.Scanner;



public class EmailApplication {

    public static void main(String[] args) {
        // Input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        // Create an email object
        Email email = new Email(firstName, lastName);

        // Display the generated email and password
        System.out.println("\nYour new email account has been created!");
        System.out.println("Email: " + email.getEmail());
        System.out.println("Password: " + email.getPassword());
        System.out.println("Mailbox Capacity: " + email.getMailboxCapacity() + "MB");
        System.out.println("User info:"+email.showInfo());


        // Set mailbox capacity
        System.out.print("Enter new mailbox capacity (in MB): ");
        int newCapacity = scanner.nextInt();
        email.setMailboxCapacity(newCapacity);
        System.out.println("Updated Mailbox Capacity: " + email.getMailboxCapacity() + "MB");

        // Set alternate email
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter alternate email: ");
        String alternateEmail = scanner.nextLine();
        email.setAlternateEmail(alternateEmail);
        System.out.println("Alternate Email: " + email.getAlternateEmail());

        // Change password
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        email.changePassword(newPassword);
        System.out.println("Updated Password: " + email.getPassword());

        // Display all user info
        System.out.println("\nFinal User Information:");
        System.out.println(email.showInfo());


        scanner.close();
    }
}

class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500; // Default mailbox capacity in MB
    private String alternateEmail;
    private String companySuffix = "company.com";

    // Constructor to initialize first name, last name, and department
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method to ask for the department
        this.department = setDepartment();

        // Call a method to generate a random password
        this.password = generateRandomPassword(10);

        // Generate email
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    // Ask for the department
    private String setDepartment() {
        System.out.print("Enter department code (1 for Sales, 2 for Development, 3 for Accounting, 0 for none): ");
        Scanner scanner = new Scanner(System.in);
        int departmentChoice = scanner.nextInt();
        scanner.close();

        switch (departmentChoice) {
            case 1:
                return "sales";
            case 2:
                return "dev";
            case 3:
                return "acct";
            default:
                return "";
        }
    }

    // Generate a random password
    private String generateRandomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }

    // Set mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // Change password
    public void changePassword(String password) {
        this.password = password;
    }

    // Get mailbox capacity
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    // Get alternate email
    public String getAlternateEmail() {
        return alternateEmail;
    }

    // Get password
    public String getPassword() {
        return password;
    }

    // Get email
    public String getEmail() {
        return email;
    }

    // Display user info
    public String showInfo() {
        return "Name: " + firstName + " " + lastName +
                "\nEmail: " + email +
                "\nMailbox Capacity: " + mailboxCapacity + "MB";
    }
}