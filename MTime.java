import java.util.Scanner;

class Time {
    private int hours;
    private int minutes;
    
    public Time() {
        this.hours = 0;
        this.minutes = 0;
    }
    
    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }
    
    public Time sum(Time other) {
        int totalHours = this.hours + other.hours;
        int totalMinutes = this.minutes + other.minutes;
        if (totalMinutes >= 60) {
            totalHours += totalMinutes / 60;
            totalMinutes %= 60;
        }
        return new Time(totalHours, totalMinutes);
    }
    public void display() {
        System.out.println("Time: " + this.hours + " hours " + this.minutes + " minutes");
    }
    public void setHours(int hours) {
        this.hours = hours;
    }
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}

public class MTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Time time1 = new Time();
        Time time2 = new Time();
        Time time3;
        
        System.out.println("Enter hours and minutes for first time:");
        int hours1 = scanner.nextInt();
        int minutes1 = scanner.nextInt();
        System.out.println("Enter hours and minutes for second time:");
        int hours2 = scanner.nextInt();
        int minutes2 = scanner.nextInt();
        time1.setHours(hours1);
        time1.setMinutes(minutes1);
        time2.setHours(hours2);
        time2.setMinutes(minutes2);
        time3 = time1.sum(time2);
        System.out.println("First time:");
        time1.display();
        System.out.println("Second time:");
        time2.display();
        System.out.println("Sum of the two times:");
        time3.display();
    }
}
