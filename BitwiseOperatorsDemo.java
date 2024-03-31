import java.util.*;

public class BitwiseOperatorsDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        int a = scanner.nextInt();

        System.out.print("Enter the value of b: ");
        int b = scanner.nextInt();

        int bitwiseAnd = a & b;
        System.out.println("Bitwise AND of " + a + " and " + b + ": " + bitwiseAnd);

        int bitwiseOr = a | b;
        System.out.println("Bitwise OR of " + a + " and " + b + ": " + bitwiseOr);

        int bitwiseXor = a ^ b;
        System.out.println("Bitwise XOR of " + a + " and " + b + ": " + bitwiseXor);

        int leftShiftResult = a << 1;
        System.out.println("Left shift of " + a + " by 1: " + leftShiftResult);

        int rightShiftResult = b >> 1;
        System.out.println("Right shift of " + b + " by 1: " + rightShiftResult);

        scanner.close();
    }
}
