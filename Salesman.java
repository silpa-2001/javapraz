import java.util.Scanner;

class Salesman {
    private String name;
    private int salesmanCode;
    private double salesAmount;

    public Salesman(String name, int salesmanCode, double salesAmount) {
        this.name = name;
        this.salesmanCode = salesmanCode;
        this.salesAmount = salesAmount;
    }

    public double calculateCommission() {
        if (salesAmount < 0) {
            throw new IllegalArgumentException("Sales amount cannot be negative.");
        } else if (salesAmount < 2000) {
            return salesAmount * 0.08;
        } else if (salesAmount >= 2000 && salesAmount <= 5000) {
            return salesAmount * 0.10;
        } else {
            return salesAmount * 0.12;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter salesman name: ");
        String name = scanner.nextLine();
        System.out.print("Enter salesman code: ");
        int code = scanner.nextInt();
        System.out.print("Enter sales amount: ");
        double salesAmount = scanner.nextDouble();

        try {
            Salesman salesman = new Salesman(name, code, salesAmount);
            double commission = salesman.calculateCommission();
            System.out.println("Commission for salesman " + name + " with code " + code + " is: " + commission);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
