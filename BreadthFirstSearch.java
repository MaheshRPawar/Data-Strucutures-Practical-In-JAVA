import java.util.Scanner;

class BreadthFirstSearch
{
    static int graph[][] = new int[10][10];
    static int visited[] = new int[10];
    static int queue[] = new int[10];
    static int n;

    static void bfs(int start)
    {
        int front = 0;
        int rear = 0;

        queue[rear] = start;
        rear++;

        visited[start] = 1;

        while(front < rear)
        {
            int current = queue[front];
            front++;

            System.out.print(current + " ");

            for(int i=0;i<n;i++)
            {
                if(graph[current][i] == 1 && visited[i] == 0)
                {
                    queue[rear] = i;
                    rear++;

                    visited[i] = 1;
                }
            }
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int start;

        System.out.print("Enter number of vertices: ");
        n = sc.nextInt();

        System.out.println("Enter adjacency matrix:");

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter starting vertex: ");
        start = sc.nextInt();

        System.out.print("BFS Traversal: ");

        bfs(start);
    }
}