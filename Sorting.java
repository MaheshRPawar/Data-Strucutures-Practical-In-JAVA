import java.util.Scanner;

public class Sorting {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int arr[] = new int[100];
        int n, choice;

        System.out.print("Enter number of elements: ");
        n = sc.nextInt();

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\nSelect Sorting Method");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Counting Sort");
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();

        if (choice == 1) {

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }

        else if (choice == 2) {

            for (int i = 0; i < n - 1; i++) {
                int min = i;

                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[min])
                        min = j;
                }

                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }

        else if (choice == 3) {

            for (int i = 1; i < n; i++) {
                int key = arr[i];
                int j = i - 1;

                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }

                arr[j + 1] = key;
            }
        }

        else if (choice == 4) {

            int max = arr[0];

            for (int i = 1; i < n; i++) {
                if (arr[i] > max)
                    max = arr[i];
            }

            int count[] = new int[100];

            for (int i = 0; i < n; i++) {
                count[arr[i]]++;
            }

            int index = 0;

            for (int i = 0; i <= max; i++) {
                while (count[i] > 0) {
                    arr[index] = i;
                    index++;
                    count[i]--;
                }
            }
        }

        else {
            System.out.println("Invalid Choice");
            return;
        }

        System.out.println("Sorted Array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
