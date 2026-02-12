import java.util.Scanner;

public class Array2D_Matrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a[][] = new int[10][10];
        int b[][] = new int[10][10];
        int result[][] = new int[10][10];

        int r1, c1, r2, c2, choice;

        System.out.println("Select Operation");
        System.out.println("1. Matrix Addition");
        System.out.println("2. Matrix Subtraction");
        System.out.println("3. Matrix Multiplication");
        System.out.println("4. Transpose of Matrix");
        System.out.println("5. Identity Matrix");
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();

        if (choice == 1 || choice == 2) {

            System.out.print("Enter rows and columns: ");
            r1 = sc.nextInt();
            c1 = sc.nextInt();

            System.out.println("Enter first matrix:");
            for (int i = 0; i < r1; i++)
                for (int j = 0; j < c1; j++)
                    a[i][j] = sc.nextInt();

            System.out.println("Enter second matrix:");
            for (int i = 0; i < r1; i++)
                for (int j = 0; j < c1; j++)
                    b[i][j] = sc.nextInt();

            for (int i = 0; i < r1; i++)
                for (int j = 0; j < c1; j++)
                    result[i][j] = (choice == 1) ? a[i][j] + b[i][j] : a[i][j] - b[i][j];

            System.out.println("Result:");
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++)
                    System.out.print(result[i][j] + " ");
                System.out.println();
            }
        }

        else if (choice == 3) {

            System.out.print("Enter rows and columns of first matrix: ");
            r1 = sc.nextInt();
            c1 = sc.nextInt();

            System.out.print("Enter rows and columns of second matrix: ");
            r2 = sc.nextInt();
            c2 = sc.nextInt();

            if (c1 != r2) {
                System.out.println("Multiplication not possible");
                return;
            }

            System.out.println("Enter first matrix:");
            for (int i = 0; i < r1; i++)
                for (int j = 0; j < c1; j++)
                    a[i][j] = sc.nextInt();

            System.out.println("Enter second matrix:");
            for (int i = 0; i < r2; i++)
                for (int j = 0; j < c2; j++)
                    b[i][j] = sc.nextInt();

            for (int i = 0; i < r1; i++)
                for (int j = 0; j < c2; j++) {
                    result[i][j] = 0;
                    for (int k = 0; k < c1; k++)
                        result[i][j] += a[i][k] * b[k][j];
                }

            System.out.println("Result:");
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++)
                    System.out.print(result[i][j] + " ");
                System.out.println();
            }
        }

        else if (choice == 4) {

            System.out.print("Enter rows and columns: ");
            r1 = sc.nextInt();
            c1 = sc.nextInt();

            System.out.println("Enter matrix:");
            for (int i = 0; i < r1; i++)
                for (int j = 0; j < c1; j++)
                    a[i][j] = sc.nextInt();

            System.out.println("Transpose:");
            for (int j = 0; j < c1; j++) {
                for (int i = 0; i < r1; i++)
                    System.out.print(a[i][j] + " ");
                System.out.println();
            }
        }

        else if (choice == 5) {

            System.out.print("Enter order of matrix: ");
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        System.out.print("1 ");
                    else
                        System.out.print("0 ");
                }
                System.out.println();
            }
        }

        else {
            System.out.println("Invalid Choice");
        }
    }
}
