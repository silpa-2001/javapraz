import java.util.Scanner;
import java.util.StringTokenizer;

public class IntegerSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of integers separated by spaces: ");
        String input = scanner.nextLine();

        StringTokenizer tokenizer = new StringTokenizer(input);
        int sum = 0;

        System.out.println("Individual Integers:");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            try {
                int number = Integer.parseInt(token);
                System.out.println(number);
                sum += number;
            } catch (NumberFormatException e) {
                System.out.println("Error: \"" + token + "\" is not a valid integer.");
            }
        }

        System.out.println("Sum of all integers: " + sum);
    }
}
