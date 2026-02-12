import java.util.Scanner;

public class Searching {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int arr[] = new int[100];
        int n, choice, key;

        System.out.print("Enter number of elements: ");
        n = sc.nextInt();

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\nSelect Searching Method");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();

        System.out.print("Enter element to search: ");
        key = sc.nextInt();

        if (choice == 1) {

            boolean found = false;

            for (int i = 0; i < n; i++) {
                if (arr[i] == key) {
                    System.out.println("Element found at position " + (i + 1));
                    found = true;
                    break;
                }
            }

            if (!found)
                System.out.println("Element not found");
        }

        else if (choice == 2) {

            // sorting before binary search
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (arr[i] > arr[j]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }

            int low = 0;
            int high = n - 1;
            boolean found = false;

            while (low <= high) {

                int mid = (low + high) / 2;

                if (arr[mid] == key) {
                    System.out.println("Element found at position " + (mid + 1));
                    found = true;
                    break;
                } else if (arr[mid] < key) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if (!found)
                System.out.println("Element not found");
        }

        else {
            System.out.println("Invalid Choice");
        }
    }
}
