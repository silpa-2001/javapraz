import java.io.*;
import java.util.*;
class Employee
{
	String name, address;
	int age, salary;
	long phoneNo; 
	Scanner s= new Scanner(System.in);
	public void read()
	{
		System.out.println("Enter the name, address,age,phone no and salary: ");
		name=s.nextLine();
		address=s.nextLine();
		age=s.nextInt();
		phoneNo=s.nextLong();
		salary= s.nextInt();
	}
	public void print()
	{
		System.out.println("Name: "+name+"\nAddress: "+address+"\nAge: "+age+"\nPhone No.: "+phoneNo);
	}
	public void printSalary()
	{
		System.out.println("Salary: "+salary);
	}
}
class Officer extends Employee
{
	String specialization;
	Scanner s= new Scanner(System.in);
	public void read()
	{
		super.read();
		System.out.println("Enter the Specialization: ");
		specialization=s.nextLine();
	}
	public void print()
	{
		super.print();
		System.out.println("Specialization: "+specialization);
	}
	public void printSalary()
	{
		super.printSalary();
	}
}
class Manager extends Employee
{
	String department;
	Scanner s= new Scanner(System.in);
	public void read()
	{
		super.read();
		System.out.println("Enter the department: ");
		department=s.nextLine();
	} 
	public void print()
	{
		super.print();
		System.out.println("Departmnet: "+department);
	}
	public void printSalary()
	{
		super.printSalary();
	}
}
class MEmp
{
	public static void main(String args[])
	{
		Officer f= new Officer();
		f.read();
		System.out.println("----Officer Details----");
		f.print();
		f.printSalary();
		Manager m= new Manager();
		m.read();
		System.out.println("----Manager Details----");
		m.print();
		m.printSalary();
	}
}