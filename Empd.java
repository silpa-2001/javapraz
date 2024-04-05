import java.util.Scanner;

class Employee{
    String name;
    int age;
    String phoneNumber;
    String address;
    double salary;

    Employee(String name, int age, String phoneNumber, String address, double salary) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
    }

    void printSalary(){
        System.out.println("Salary: " + salary);
    }
}

class Officer extends Employee{
    String specialization;

    Officer(String name, int age, String phoneNumber, String address, double salary, String specialization) {
        super(name, age, phoneNumber, address, salary);
        this.specialization = specialization;
    }

    void printDetails(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Salary: " + salary);
        System.out.println("Specialization: " + specialization);
    }
}

class Manager extends Employee{
    String department;

    Manager(String name, int age, String phoneNumber, String address, double salary, String department) {
        super(name, age, phoneNumber, address, salary);
        this.department = department;
    }

    void printDetails(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Salary: " + salary);
        System.out.println("Department: " + department);
    }
}

public class Empd{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of employees (Officer/Manager): ");
        int n = scanner.nextInt();
        scanner.nextLine();
        Employee[] empArr = new Employee[n];
        for (int i = 0; i < n; i++){
            System.out.println("\n Choose 1.Manager or 2.officer");
            int j=scanner.nextInt();
            boolean isOfficer = (j % 2 == 0);
            System.out.println("\nEmployee Details");
            System.out.print("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
 // consume newline character
            System.out.print("Phone Number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            if (isOfficer) {
                System.out.print("Specialization: ");
                String specialization = scanner.nextLine();
                Officer officer = new Officer(name, age, phoneNumber, address, 50000, specialization);
                officer.printDetails();
                empArr[i] = officer;
            } else {
                System.out.print("Department: ");
                String department = scanner.nextLine();
                Manager manager = new Manager(name, age, phoneNumber, address, 70000, department);
                manager.printDetails();
                empArr[i] = manager;
            }
        }
    }
}
