import java.util.Scanner;

class QueueArray
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

        int q[]=new int[100];
        int front=-1,rear=-1;
        int size,ch,x;

        System.out.print("Enter size of queue: ");
        size=sc.nextInt();

        do{
            System.out.println("\n1.Enqueue 2.Dequeue 3.Front 4.isEmpty 5.isFull 6.Exit");
            System.out.print("Enter choice: ");
            ch=sc.nextInt();

            switch(ch)
            {
                case 1:
                    if(rear==size-1)
                        System.out.println("Queue is Full");
                    else{
                        System.out.print("Enter value: ");
                        x=sc.nextInt();
                        if(front==-1) front=0;
                        rear++;
                        q[rear]=x;
                    }
                    break;

                case 2:
                    if(front==-1 || front>rear)
                        System.out.println("Queue is Empty");
                    else{
                        System.out.println("Deleted: "+q[front]);
                        front++;
                    }
                    break;

                case 3:
                    if(front==-1 || front>rear)
                        System.out.println("Queue Empty");
                    else
                        System.out.println("Front element: "+q[front]);
                    break;

                case 4:
                    if(front==-1 || front>rear)
                        System.out.println("Queue is Empty");
                    else
                        System.out.println("Queue not Empty");
                    break;

                case 5:
                    if(rear==size-1)
                        System.out.println("Queue is Full");
                    else
                        System.out.println("Queue not Full");
                    break;
            }

        }while(ch!=6);
    }
}