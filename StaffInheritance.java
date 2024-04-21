class Staff {
    int code;
    String name;
}

class Faculty extends Staff {
    String department;
    String subjectTaken;
    String researchArea;
}

class Officer1 extends Staff {
    int rank;
    char grade;
}

class Typist extends Staff {
    String office;
    int speed;
}

class Permanent extends Typist {
    double salary;
}

class Casual extends Typist {
    double dailyWages;
} 

public class StaffInheritance{
    public static void main(String[] args) {
        Faculty faculty = new Faculty();
        faculty.code = 234567890;
        faculty.name = "John Doe";
        faculty.department = "Computer Science and Engineering";
        faculty.subjectTaken = "Data Structures";
        faculty.researchArea = "Artificial Intelligence";

        Officer1 officer = new Officer1();
        officer.rank = 1;
        officer.grade = 'A';
        officer.code = 123456789;
        officer.name = "Officer Smith";

        Permanent permanentTypist = new Permanent();
        permanentTypist.office = "Room 101";
        permanentTypist.speed = 50;
        permanentTypist.salary = 5000.00;

        Casual casualTypist = new Casual();
        casualTypist.office = "Room 102";
        casualTypist.speed = 60;
        casualTypist.dailyWages = 100.00;

        System.out.println("Faculty Name: " + faculty.name);
        System.out.println("Officer Name: " + officer.name);
        System.out.println("Permanent Typist Salary: " + permanentTypist.salary);
        System.out.println("Casual Typist Daily Wages: " + casualTypist.dailyWages);
    }
}
