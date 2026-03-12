import java.util.Scanner;

class SinglyLinkedList2
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

    static void insert_pos(int x,int pos)
    {
        Node temp = new Node();
        temp.data = x;

        Node ptr = head;

        for(int i=1;i<pos-1;i++)
        {
            ptr = ptr.next;
        }

        temp.next = ptr.next;
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

        System.out.println("Deleted: "+temp.data);
    }

    static void delete_end()
    {
        if(head == null)
        {
            System.out.println("List Empty");
            return;
        }

        Node ptr = head;
        Node prev = null;

        while(ptr.next != null)
        {
            prev = ptr;
            ptr = ptr.next;
        }

        if(prev != null)
            prev.next = null;
        else
            head = null;

        System.out.println("Deleted: "+ptr.data);
    }

    static void delete_pos(int pos)
    {
        Node ptr = head;
        Node temp;

        for(int i=1;i<pos-1;i++)
        {
            ptr = ptr.next;
        }

        temp = ptr.next;

        ptr.next = temp.next;

        System.out.println("Deleted: "+temp.data);
    }

    static void search(int key)
    {
        Node ptr = head;
        int pos = 1;

        while(ptr != null)
        {
            if(ptr.data == key)
            {
                System.out.println("Element found at position "+pos);
                return;
            }

            ptr = ptr.next;
            pos++;
        }

        System.out.println("Element not found");
    }

    static void display()
    {
        Node ptr = head;

        if(ptr == null)
        {
            System.out.println("List Empty");
            return;
        }

        while(ptr != null)
        {
            System.out.print(ptr.data+" -> ");
            ptr = ptr.next;
        }

        System.out.println("NULL");
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int ch,x,pos;

        do
        {
            System.out.println("\n1.Insert Beginning");
            System.out.println("2.Insert End");
            System.out.println("3.Insert Position");
            System.out.println("4.Delete Beginning");
            System.out.println("5.Delete End");
            System.out.println("6.Delete Position");
            System.out.println("7.Search");
            System.out.println("8.Display");
            System.out.println("9.Exit");

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
                    System.out.print("Enter element and position: ");
                    x = sc.nextInt();
                    pos = sc.nextInt();
                    insert_pos(x,pos);
                    break;

                case 4:
                    delete_begin();
                    break;

                case 5:
                    delete_end();
                    break;

                case 6:
                    System.out.print("Enter position: ");
                    pos = sc.nextInt();
                    delete_pos(pos);
                    break;

                case 7:
                    System.out.print("Enter element to search: ");
                    x = sc.nextInt();
                    search(x);
                    break;

                case 8:
                    display();
                    break;
            }

        }while(ch != 9);
    }
}