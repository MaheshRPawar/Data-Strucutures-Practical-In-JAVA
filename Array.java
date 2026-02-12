import java.util.Scanner;

public class Array {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int arr[] = new int[5];
        int choice;
        boolean arrayCreated = false;

        while (true) {

            System.out.println("\n=== Array Menu ===");
            System.out.println("1) Create array of 5 elements");
            System.out.println("2) Display elements");
            System.out.println("3) Max value in array");
            System.out.println("4) Smallest value in array");
            System.out.println("5) Addition of all elements");
            System.out.println("6) Update array element");
            System.out.println("7) Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter 5 array elements:");
                    for (int i = 0; i < 5; i++) {
                        System.out.print("Element " + (i + 1) + ": ");
                        arr[i] = sc.nextInt();
                    }
                    arrayCreated = true;
                    System.out.println("Array created successfully!");
                    break;

                case 2:
                    if (!arrayCreated) {
                        System.out.println("Create array first!");
                        break;
                    }
                    System.out.print("Array elements: ");
                    for (int i = 0; i < 5; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    break;

                case 3:
                    if (!arrayCreated) {
                        System.out.println("Create array first!");
                        break;
                    }
                    int max = arr[0];
                    for (int i = 1; i < 5; i++) {
                        if (arr[i] > max)
                            max = arr[i];
                    }
                    System.out.println("Maximum value: " + max);
                    break;

                case 4:
                    if (!arrayCreated) {
                        System.out.println("Create array first!");
                        break;
                    }
                    int min = arr[0];
                    for (int i = 1; i < 5; i++) {
                        if (arr[i] < min)
                            min = arr[i];
                    }
                    System.out.println("Minimum value: " + min);
                    break;

                case 5:
                    if (!arrayCreated) {
                        System.out.println("Create array first!");
                        break;
                    }
                    int sum = 0;
                    for (int i = 0; i < 5; i++) {
                        sum += arr[i];
                    }
                    System.out.println("Sum of all elements: " + sum);
                    break;

                case 6:
                    if (!arrayCreated) {
                        System.out.println("Create array first!");
                        break;
                    }
                    System.out.print("Enter index (0-4): ");
                    int index = sc.nextInt();
                    if (index >= 0 && index < 5) {
                        System.out.print("Enter new value: ");
                        int value = sc.nextInt();
                        arr[index] = value;
                        System.out.println("Element updated!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 7:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
