import java.util.Scanner;
import java.util.Calendar;

class Contact {
    private String contactId;
    private String name;
    private String phoneNumber;
    private String company;
    private double salary;
    private String birthday;
    
    public Contact(String contactId, String name, String phoneNumber, 
                   String company, double salary, String birthday) {
        this.contactId = contactId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.company = company;
        this.salary = salary;
        this.birthday = birthday;
    }
    
    public String getContactId() { return contactId; }
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getCompany() { return company; }
    public double getSalary() { return salary; }
    public String getBirthday() { return birthday; }
    
    public void setName(String name) { this.name = name; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setCompany(String company) { this.company = company; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setBirthday(String birthday) { this.birthday = birthday; }
    
    public void displayDetails() {
        System.out.println("\n+--------------------------------------------+");
        System.out.println("|           CONTACT DETAILS                  |");
        System.out.println("+--------------------------------------------+");
        System.out.println("  Contact ID    : " + contactId);
        System.out.println("  Name          : " + name);
        System.out.println("  Phone Number  : " + phoneNumber);
        System.out.println("  Company       : " + company);
        System.out.println("  Salary        : Rs. " + String.format("%.2f", salary));
        System.out.println("  Birthday      : " + birthday);
        System.out.println("+--------------------------------------------+");
    }
    
    @Override
    public String toString() {
        return String.format("%-10s %-20s %-15s %-20s %-15.2f %-12s",
                contactId, name, phoneNumber, company, salary, birthday);
    }
}

class ContactManager {
    private Contact[] contacts;
    private int contactCount;
    private static final int MAX_CONTACTS = 100;
    private Scanner scanner;
    
    public ContactManager() {
        contacts = new Contact[MAX_CONTACTS];
        contactCount = 0;
        scanner = new Scanner(System.in);
    }
    
    public void addContacts() {
        while (true) {
            clearConsole();
            System.out.println("+--------------------------------------------+");
            System.out.println("|           ADD NEW CONTACT                 |");
            System.out.println("+--------------------------------------------+");
            
            String newId = generateContactId();
            System.out.println("  Generated Contact ID: " + newId);
            System.out.println("  -------------------------------------------");
            
            String name = getValidName();
            String phone = getValidPhone();
            System.out.print("  Enter Company       : ");
            String company = scanner.nextLine();
            double salary = getValidSalary();
            String birthday = getValidBirthday();
            
            contacts[contactCount] = new Contact(newId, name, phone, company, salary, birthday);
            contactCount++;
            
            System.out.println("\n  Contact added successfully!");
            System.out.println("  -------------------------------------------");
            System.out.print("  Add another contact? (Y/N): ");
            String again = scanner.nextLine();
            if (!again.equalsIgnoreCase("Y")) {
                break;
            }
        }
    }
    
    public void updateContacts() {
        while (true) {
            clearConsole();
            System.out.println("+--------------------------------------------+");
            System.out.println("|           UPDATE CONTACT                  |");
            System.out.println("+--------------------------------------------+");
            System.out.print("  Search by Name or Phone: ");
            String keyword = scanner.nextLine();
            
            if (keyword.matches("\\d+") && !isValidPhoneFormat(keyword)) {
                System.out.println("  Invalid phone number format! Must start with 0 and have 10 digits.");
                pressEnterToContinue();
                continue;
            }
            
            int index = findContactIndex(keyword);
            if (index == -1) {
                System.out.println("  Contact not found!");
                pressEnterToContinue();
                continue;
            }
            
            contacts[index].displayDetails();
            
            System.out.println("\n  What do you want to update?");
            System.out.println("  [1] Name");
            System.out.println("  [2] Phone Number");
            System.out.println("  [3] Company");
            System.out.println("  [4] Salary");
            System.out.println("  [5] Birthday");
            System.out.print("  Enter choice: ");
            int choice = getIntInput("");
            
            switch (choice) {
                case 1:
                    contacts[index].setName(getValidName());
                    break;
                case 2:
                    contacts[index].setPhoneNumber(getValidPhone());
                    break;
                case 3:
                    System.out.print("  Enter new Company: ");
                    contacts[index].setCompany(scanner.nextLine());
                    break;
                case 4:
                    contacts[index].setSalary(getValidSalary());
                    break;
                case 5:
                    contacts[index].setBirthday(getValidBirthday());
                    break;
                default:
                    System.out.println("  Invalid choice!");
                    pressEnterToContinue();
                    continue;
            }
            
            System.out.println("\n  Update successful!");
            
            System.out.print("\n  Update another contact? (Y/N): ");
            String again = scanner.nextLine();
            if (!again.equalsIgnoreCase("Y")) {
                break;
            }
        }
        pressEnterToContinue();
    }
    
    public void deleteContacts() {
        clearConsole();
        System.out.println("+--------------------------------------------+");
        System.out.println("|           DELETE CONTACT                  |");
        System.out.println("+--------------------------------------------+");
        System.out.print("  Enter Phone Number or Name: ");
        String keyword = scanner.nextLine();
        
        if (keyword.matches("\\d+") && !isValidPhoneFormat(keyword)) {
            System.out.println("  Invalid phone number format! Must start with 0 and have 10 digits.");
            pressEnterToContinue();
            return;
        }
        
        int index = findContactIndex(keyword);
        if (index == -1) {
            System.out.println("  Contact not found!");
            pressEnterToContinue();
            return;
        }
        
        contacts[index].displayDetails();
        
        System.out.print("\n  Are you sure you want to delete this contact? (Y/N): ");
        String confirm = scanner.nextLine();
        
        if (confirm.equalsIgnoreCase("Y")) {
            for (int i = index; i < contactCount - 1; i++) {
                contacts[i] = contacts[i + 1];
            }
            contacts[contactCount - 1] = null;
            contactCount--;
            System.out.println("\n  Contact deleted successfully!");
        } else {
            System.out.println("\n  Deletion cancelled.");
        }
        pressEnterToContinue();
    }
    
    public void searchContacts() {
        clearConsole();
        System.out.println("+--------------------------------------------+");
        System.out.println("|           SEARCH CONTACT                  |");
        System.out.println("+--------------------------------------------+");
        System.out.print("  Enter Phone Number or Name: ");
        String keyword = scanner.nextLine();
        
        if (keyword.matches("\\d+") && !isValidPhoneFormat(keyword)) {
            System.out.println("  Invalid phone number format! Must start with 0 and have 10 digits.");
            pressEnterToContinue();
            return;
        }
        
        int index = findContactIndex(keyword);
        if (index == -1) {
            System.out.println("  Contact not found!");
        } else {
            contacts[index].displayDetails();
        }
        pressEnterToContinue();
    }
    
    public void listContacts() {
        while (true) {
            clearConsole();
            System.out.println("+--------------------------------------------+");
            System.out.println("|           LIST CONTACTS                   |");
            System.out.println("+--------------------------------------------+");
            System.out.println("  [1] Sort by Name");
            System.out.println("  [2] Sort by Salary");
            System.out.println("  [3] Sort by Birthday");
            System.out.println("  [4] Sort by Company");
            System.out.print("  Enter choice: ");
            int choice = getIntInput("");
            
            switch (choice) {
                case 1:
                    sortByName();
                    System.out.println("\n  --- Contacts sorted by Name ---");
                    break;
                case 2:
                    sortBySalary();
                    System.out.println("\n  --- Contacts sorted by Salary ---");
                    break;
                case 3:
                    sortByBirthday();
                    System.out.println("\n  --- Contacts sorted by Birthday ---");
                    break;
                case 4:
                    sortByCompany();
                    System.out.println("\n  --- Contacts sorted by Company ---");
                    break;
                default:
                    System.out.println("  Invalid choice.");
                    pressEnterToContinue();
                    continue;
            }
            
            displayAllContacts();
            
            System.out.print("\n  Stay here? (Y to stay / N to main menu): ");
            String stay = scanner.nextLine();
            if (!stay.equalsIgnoreCase("Y")) {
                break;
            }
        }
    }
    
    private void sortByName() {
        for (int i = 0; i < contactCount - 1; i++) {
            for (int j = 0; j < contactCount - i - 1; j++) {
                if (contacts[j].getName().compareToIgnoreCase(contacts[j + 1].getName()) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }
    
    private void sortBySalary() {
        for (int i = 0; i < contactCount - 1; i++) {
            for (int j = 0; j < contactCount - i - 1; j++) {
                if (contacts[j].getSalary() > contacts[j + 1].getSalary()) {
                    swap(j, j + 1);
                }
            }
        }
    }
    
    private void sortByBirthday() {
        for (int i = 0; i < contactCount - 1; i++) {
            for (int j = 0; j < contactCount - i - 1; j++) {
                if (contacts[j].getBirthday().compareTo(contacts[j + 1].getBirthday()) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }
    
    private void sortByCompany() {
        for (int i = 0; i < contactCount - 1; i++) {
            for (int j = 0; j < contactCount - i - 1; j++) {
                if (contacts[j].getCompany().compareToIgnoreCase(contacts[j + 1].getCompany()) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }
    
    private void swap(int i, int j) {
        Contact temp = contacts[i];
        contacts[i] = contacts[j];
        contacts[j] = temp;
    }
    
    private boolean isValidPhoneFormat(String phone) {
        return phone != null && phone.matches("0\\d{9}");
    }
    
    private String getValidName() {
        String name;
        while (true) {
            System.out.print("  Enter Name          : ");
            name = scanner.nextLine();
            if (!name.trim().isEmpty()) {
                break;
            }
            System.out.println("  Name cannot be empty!");
        }
        return name;
    }
    
    private String getValidPhone() {
        String phone;
        while (true) {
            System.out.print("  Enter Phone Number  : ");
            phone = scanner.nextLine();
            if (phone.matches("0\\d{9}")) {
                break;
            }
            System.out.println("  Invalid! Must start with 0 and have 10 digits.");
        }
        return phone;
    }
    
    private double getValidSalary() {
        double salary;
        while (true) {
            System.out.print("  Enter Salary        : ");
            if (scanner.hasNextDouble()) {
                salary = scanner.nextDouble();
                scanner.nextLine();
                if (salary > 0) {
                    break;
                }
                System.out.println("  Salary must be positive!");
            } else {
                scanner.nextLine();
                System.out.println("  Invalid input! Please enter a number.");
            }
        }
        return salary;
    }
    
    private String getValidBirthday() {
        String birthday;
        while (true) {
            System.out.print("  Enter Birthday      : ");
            birthday = scanner.nextLine();
            if (isValidDate(birthday)) {
                break;
            }
            System.out.println("  Invalid! Use YYYY-MM-DD (not a future date).");
        }
        return birthday;
    }
    
    private boolean isValidDate(String date) {
        if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) return false;
        
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        
        if (month < 1 || month > 12) return false;
        
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            daysInMonth[1] = 29;
        }
        if (day < 1 || day > daysInMonth[month - 1]) return false;
        
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        int currentMonth = cal.get(Calendar.MONTH) + 1;
        int currentDay = cal.get(Calendar.DAY_OF_MONTH);
        
        if (year > currentYear) return false;
        if (year == currentYear && month > currentMonth) return false;
        if (year == currentYear && month == currentMonth && day > currentDay) return false;
        
        return true;
    }
    
    private String generateContactId() {
        if (contactCount == 0) {
            return "C0001";
        }
        String lastId = contacts[contactCount - 1].getContactId();
        int num = Integer.parseInt(lastId.substring(1));
        num++;
        return String.format("C%04d", num);
    }
    
    private int findContactIndex(String keyword) {
        for (int i = 0; i < contactCount; i++) {
            if (contacts[i].getName().equalsIgnoreCase(keyword) || 
                contacts[i].getPhoneNumber().equals(keyword)) {
                return i;
            }
        }
        return -1;
    }
    
    private void displayAllContacts() {
        if (contactCount == 0) {
            System.out.println("\n  No contacts to display.");
            return;
        }
        System.out.println("\n  --------------------------------------------------------------------------------------------------------");
        System.out.printf("  %-10s %-20s %-15s %-20s %-15s %-12s%n", 
                "ID", "Name", "Phone", "Company", "Salary", "Birthday");
        System.out.println("  --------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < contactCount; i++) {
            System.out.println("  " + contacts[i].toString());
        }
        System.out.println("  --------------------------------------------------------------------------------------------------------");
        System.out.println("  Total Contacts: " + contactCount);
    }
    
    public int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } else {
                scanner.nextLine();
                System.out.println("  Invalid input. Please enter a number.");
            }
        }
    }
    
    private void pressEnterToContinue() {
        System.out.print("\n  Press Enter to continue...");
        scanner.nextLine();
    }
    
    public void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }
}

class iFriendContactOrganizer {
    
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n");
        System.out.println("  ======================================================");
        System.out.println("  |      iFriend Contact Organizer - OOP Version       |");
        System.out.println("  ======================================================");
        
        while (true) {
            manager.clearConsole();
            displayHomePage();
            System.out.print("  Enter your choice: ");
            int choice = getIntInput(scanner);
            
            switch (choice) {
                case 1:
                    manager.addContacts();
                    break;
                case 2:
                    manager.updateContacts();
                    break;
                case 3:
                    manager.deleteContacts();
                    break;
                case 4:
                    manager.searchContacts();
                    break;
                case 5:
                    manager.listContacts();
                    break;
                case 6:
                    System.out.println("\n  Thank you for using iFriend Contact Organizer!");
                    System.out.println("  Goodbye! \n");
                    return;
                default:
                    System.out.println("  Invalid choice. Press Enter to continue...");
                    scanner.nextLine();
            }
        }
    }
    
    private static void displayHomePage() {
        System.out.println("");
        System.out.println("  ================================================================");
        System.out.println("  ||                                                             ||");
        System.out.println("  ||     /$$ /$$$$$$$$ /$$$$$$   /$$$$$$$ /$$$$$$$$ /$$   /$$    ||");
        System.out.println("  ||    |__/| $$_____/| $$__  $$|_   $$_/| $$_____/| $$$ | $$    ||");
        System.out.println("  ||     /$$| $$      | $$  \\ $$  | $$  | $$      | $$$$| $$    ||");
        System.out.println("  ||    | $$| $$$$$   | $$$$$$$/  | $$  | $$$$$   | $$ $$ $$     ||");
        System.out.println("  ||    | $$| $$__/   | $$__  $$  | $$  | $$__/   | $$  $$$$     ||");
        System.out.println("  ||    | $$| $$      | $$  \\ $$  | $$  | $$      | $$\\ $$$    ||");
        System.out.println("  ||    | $$| $$      | $$  | $$ /$$$$$$$| $$$$$$$$| $$ \\ $$    ||");
        System.out.println("  ||    |__/|__/      |__/  |__/|_______/|________/|___/ \\_/    ||");
        System.out.println("  ||                                                             ||");
        System.out.println("  =================================================================");
        System.out.println("\n");
        System.out.println("  ==============================================================");
        System.out.println("  ||                    MAIN MENU                              ||");
        System.out.println("  ||===========================================================||");
        System.out.println("  ||  [01]  ADD Contacts                                       ||");
        System.out.println("  ||  [02]  UPDATE Contacts                                    ||");
        System.out.println("  ||  [03]  DELETE Contacts                                    ||");
        System.out.println("  ||  [04]  SEARCH Contacts                                    ||");
        System.out.println("  ||  [05]  LIST Contacts                                      ||");
        System.out.println("  ||  [06]  Exit                                               ||");
        System.out.println("  ===============================================================");
        System.out.println("\n");
    }
    
    private static int getIntInput(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } else {
                scanner.nextLine();
                System.out.print("  Invalid input. Enter a number: ");
            }
        }
    }
}
