import java.util.Scanner;

class SinglyLinkedList
{
    static class Node
    {
        int data;
        Node next;
    }

    static Node head = null;

    static void insert_begin(int x)
    {
        Node temp = new Node();

        temp.data = x;
        temp.next = head;

        head = temp;
    }

    static void insert_end(int x)
    {
        Node temp = new Node();

        temp.data = x;
        temp.next = null;

        if(head == null)
        {
            head = temp;
            return;
        }

        Node ptr = head;

        while(ptr.next != null)
        {
            ptr = ptr.next;
        }

        ptr.next = temp;
    }

    static void delete_begin()
    {
        if(head == null)
        {
            System.out.println("List is Empty");
            return;
        }

        Node temp = head;

        head = head.next;

        System.out.println("Deleted element: " + temp.data);
    }

    static void display()
    {
        Node ptr = head;

        if(ptr == null)
        {
            System.out.println("List is Empty");
            return;
        }

        System.out.print("Linked List: ");

        while(ptr != null)
        {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }

        System.out.println("NULL");
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int ch,x;

        do
        {
            System.out.println("\n1.Insert at Beginning");
            System.out.println("2.Insert at End");
            System.out.println("3.Delete from Beginning");
            System.out.println("4.Display");
            System.out.println("5.Exit");

            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch(ch)
            {
                case 1:
                    System.out.print("Enter element: ");
                    x = sc.nextInt();
                    insert_begin(x);
                    break;

                case 2:
                    System.out.print("Enter element: ");
                    x = sc.nextInt();
                    insert_end(x);
                    break;

                case 3:
                    delete_begin();
                    break;

                case 4:
                    display();
                    break;
            }

        }while(ch != 5);
    }
}