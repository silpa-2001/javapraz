import java.util.*;

public class SecondSmallestElement {
    public static int findSecondSmallest(int[] arr) {
        Arrays.sort(arr);
        return arr[1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        int secondSmallest = findSecondSmallest(arr);
        System.out.println("Second smallest element in the array: " + secondSmallest);
        
        scanner.close();
    }
}

