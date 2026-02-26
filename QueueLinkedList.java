import java.util.Scanner;

class QueueLinkedList
{
    static class Node
    {
        int data;
        Node next;
    }

    static Node front=null;
    static Node rear=null;

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int ch,x;
        Node temp;

        do{
            System.out.println("\n1.Enqueue 2.Dequeue 3.Front 4.isEmpty 5.Exit");
            System.out.print("Enter choice: ");
            ch=sc.nextInt();

            switch(ch)
            {
                case 1:
                    temp=new Node();
                    System.out.print("Enter value: ");
                    x=sc.nextInt();

                    temp.data=x;
                    temp.next=null;

                    if(front==null)
                    {
                        front=rear=temp;
                    }
                    else
                    {
                        rear.next=temp;
                        rear=temp;
                    }
                    break;

                case 2:
                    if(front==null)
                        System.out.println("Queue is Empty");
                    else{
                        temp=front;
                        System.out.println("Deleted: "+front.data);
                        front=front.next;
                    }
                    break;

                case 3:
                    if(front==null)
                        System.out.println("Queue Empty");
                    else
                        System.out.println("Front element: "+front.data);
                    break;

                case 4:
                    if(front==null)
                        System.out.println("Queue is Empty");
                    else
                        System.out.println("Queue not Empty");
                    break;
            }

        }while(ch!=5);
    }
}