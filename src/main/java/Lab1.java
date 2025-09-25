import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        // conditional
        if (num % 2 == 0) {
            System.out.println(num + " is even.");
        } else {
            System.out.println(num + " is odd.");
        }

        // loop with array
        int[] nums = {1, 2, 3, 4, 5};
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
