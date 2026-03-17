import java.util.Scanner;

class DoublyLinkedList
{
    static class Node
    {
        int data;
        Node prev;
        Node next;
    }

    static Node head = null;

    static void insert_begin(int x)
    {
        Node temp = new Node();
        temp.data = x;
        temp.prev = null;
        temp.next = head;

        if(head != null)
            head.prev = temp;

        head = temp;
    }

    static void insert_end(int x)
    {
        Node temp = new Node();
        temp.data = x;
        temp.next = null;

        if(head == null)
        {
            temp.prev = null;
            head = temp;
            return;
        }

        Node ptr = head;
        while(ptr.next != null)
            ptr = ptr.next;

        ptr.next = temp;
        temp.prev = ptr;
    }

    static void insert_pos(int x,int pos)
    {
        Node temp = new Node();
        temp.data = x;

        Node ptr = head;

        for(int i=1;i<pos-1;i++)
            ptr = ptr.next;

        temp.next = ptr.next;
        temp.prev = ptr;

        if(ptr.next != null)
            ptr.next.prev = temp;

        ptr.next = temp;
    }

    static void delete_begin()
    {
        if(head == null)
        {
            System.out.println("List Empty");
            return;
        }

        Node temp = head;
        head = head.next;

        if(head != null)
            head.prev = null;

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

        while(ptr.next != null)
            ptr = ptr.next;

        if(ptr.prev != null)
            ptr.prev.next = null;
        else
            head = null;

        System.out.println("Deleted: "+ptr.data);
    }

    static void delete_pos(int pos)
    {
        Node ptr = head;

        for(int i=1;i<pos;i++)
            ptr = ptr.next;

        if(ptr.prev != null)
            ptr.prev.next = ptr.next;

        if(ptr.next != null)
            ptr.next.prev = ptr.prev;

        System.out.println("Deleted: "+ptr.data);
    }

    static void search(int key)
    {
        Node ptr = head;
        int pos = 1;

        while(ptr != null)
        {
            if(ptr.data == key)
            {
                System.out.println("Found at position "+pos);
                return;
            }
            ptr = ptr.next;
            pos++;
        }

        System.out.println("Not found");
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
            System.out.print(ptr.data+" <-> ");
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

        }while(ch!=9);
    }
}