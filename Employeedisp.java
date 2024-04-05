class Employee1 {
    void display() {
        System.out.println("Name of class is Employee");
    }

    void calcSalary() {
        System.out.println("Salary of employee is 10000");
    }
}

class Engineer extends Employee1 {

    void display() {
        System.out.println("Name of class is Engineer");
    }
    void calcSalary() {
        System.out.println("Salary of employee is 20000");
    }
}

public class Employeedisp {
    public static void main(String[] args) {
        Employee1 e = new Engineer();
        e.display();
        e.calcSalary();
    }
}
