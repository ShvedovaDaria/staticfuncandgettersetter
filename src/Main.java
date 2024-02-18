import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public static int countBooks(Library library) {
        return library.books.size();
    }
}

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private boolean isBlocked;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.isBlocked = false;
    }

    public void deposit(double amount) {
        if (!isBlocked) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Account is blocked. Deposit unsuccessful.");
        }
    }

    public void withdraw(double amount) {
        if (!isBlocked && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else if (isBlocked) {
            System.out.println("Account is blocked. Withdrawal unsuccessful.");
        } else {
            System.out.println("Insufficient funds. Withdrawal unsuccessful.");
        }
    }

    public void transfer(BankAccount recipient, double amount) {
        if (!isBlocked && balance >= amount) {
            balance -= amount;
            recipient.deposit(amount);
            System.out.println("Transfer successful. New balance: " + balance);
        } else if (isBlocked) {
            System.out.println("Account is blocked. Transfer unsuccessful.");
        } else {
            System.out.println("Insufficient funds. Transfer unsuccessful.");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void blockAccount() {
        isBlocked = true;
        System.out.println("Account is blocked.");
    }

    public void unblockAccount() {
        isBlocked = false;
        System.out.println("Account is unblocked.");
    }
}

class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public BankAccount createAccount(String accountHolder, double initialBalance) {
        String accountNumber = generateAccountNumber();
        BankAccount newAccount = new BankAccount(accountNumber, accountHolder, initialBalance);
        accounts.add(newAccount);
        return newAccount;
    }

    public BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    private String generateAccountNumber() {
        return "ACC" + System.currentTimeMillis();
    }
}

class Employee {
    private String name;
    private double salary;
    private String department;

    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Salary: " + salary + ", Department: " + department;
    }
}

class Manager extends Employee {
    private int teamSize;

    public Manager(String name, double salary, String department, int teamSize) {
        super(name, salary, department);
        this.teamSize = teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    @Override
    public String toString() {
        return super.toString() + ", Team Size: " + teamSize;
    }
}

class Engineer extends Employee {
    private String specialization;

    public Engineer(String name, double salary, String department, String specialization) {
        super(name, salary, department);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return super.toString() + ", Specialization: " + specialization;
    }
}

class EmployeeManagementSystem {
    private List<Employee> employees;

    public EmployeeManagementSystem() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added: " + employee.getName());
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        System.out.println("Employee removed: " + employee.getName());
    }

    public double calculateTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }

    public static double calculateAverageSalary(EmployeeManagementSystem ems) {
        List<Employee> employees = ems.employees;
        if (employees.size() == 0) {
            return 0;
        }

        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }

        return totalSalary / employees.size();
    }
}

public class Main {
    public static void main(String[] args) {
        Library myLibrary = new Library();

        myLibrary.addBook(new Book("Book1", "Author1", 2020));
        myLibrary.addBook(new Book("Book2", "Author2", 2018));
        myLibrary.addBook(new Book("Book3", "Author1", 2022));

        Book bookToRemove = new Book("Book2", "Author2", 2018);
        myLibrary.removeBook(bookToRemove);

        List<Book> booksByAuthor = myLibrary.searchByAuthor("Author1");
        System.out.println("Books by Author1: " + booksByAuthor.size());

        List<Book> booksByTitle = myLibrary.searchByTitle("Book1");
        System.out.println("Books with title Book1: " + booksByTitle.size());

        int numberOfBooks = Library.countBooks(myLibrary);
        System.out.println("Number of books in the library: " + numberOfBooks);

        Bank myBank = new Bank();

        BankAccount account1 = myBank.createAccount("Account Holder 1", 1000.0);

        account1.deposit(500.0);

        account1.withdraw(200.0);

        BankAccount account2 = myBank.createAccount("Account Holder 2", 500.0);
        account1.transfer(account2, 300.0);

        account1.blockAccount();
        account1.withdraw(100.0);
        account1.unblockAccount();
        account1.withdraw(100.0);

        List<BankAccount> allAccounts = myBank.getAccounts();
        System.out.println("All Accounts in the Bank:");
        for (BankAccount account : allAccounts) {
            System.out.println("Account Number: " + account.getAccountNumber() +
                    ", Account Holder: " + account.getAccountHolder() +
                    ", Balance: " + account.getBalance() +
                    ", Blocked: " + account.isBlocked());
        }

        EmployeeManagementSystem hrSystem = new EmployeeManagementSystem();

        hrSystem.addEmployee(new Manager("Manager1", 5000.0, "Management", 10));
        hrSystem.addEmployee(new Engineer("Engineer1", 4000.0, "Engineering", "Software Development"));
        hrSystem.addEmployee(new Engineer("Engineer2", 4500.0, "Engineering", "Hardware Design"));

        double totalSalary = hrSystem.calculateTotalSalary();
        System.out.println("Total salary of the company: " + totalSalary);

        Employee newEmployee = new Engineer("NewEngineer", 4200.0, "Engineering", "Quality Assurance");
        hrSystem.addEmployee(newEmployee);
        hrSystem.removeEmployee(newEmployee);

        double averageSalary = EmployeeManagementSystem.calculateAverageSalary(hrSystem);
        System.out.println("Average salary of the company: " + averageSalary);
    }
}
