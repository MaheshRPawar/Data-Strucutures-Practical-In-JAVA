import java.util.Scanner;

class StackLinkedList
{
    static class Node
    {
        int data;
        Node next;
    }

    static Node top = null;

    static void push(int x)
    {
        Node temp = new Node();

        temp.data = x;
        temp.next = top;

        top = temp;
    }

    static void pop()
    {
        if(top == null)
        {
            System.out.println("Stack Empty");
            return;
        }

        System.out.println("Deleted element: " + top.data);

        top = top.next;
    }

    static void top_element()
    {
        if(top == null)
            System.out.println("Stack Empty");
        else
            System.out.println("Top element: " + top.data);
    }

    static void isEmpty()
    {
        if(top == null)
            System.out.println("Stack is Empty");
        else
            System.out.println("Stack is Not Empty");
    }

    static void display()
    {
        Node ptr = top;

        if(ptr == null)
        {
            System.out.println("Stack Empty");
            return;
        }

        System.out.println("Stack elements:");

        while(ptr != null)
        {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int ch,x;

        do
        {
            System.out.println("\n1.Push");
            System.out.println("2.Pop");
            System.out.println("3.Top");
            System.out.println("4.isEmpty");
            System.out.println("5.Display");
            System.out.println("6.Exit");

            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch(ch)
            {
                case 1:
                    System.out.print("Enter element: ");
                    x = sc.nextInt();
                    push(x);
                    break;

                case 2:
                    pop();
                    break;

                case 3:
                    top_element();
                    break;

                case 4:
                    isEmpty();
                    break;

                case 5:
                    display();
                    break;
            }

        }while(ch != 6);
    }
}