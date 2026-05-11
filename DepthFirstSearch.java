import java.util.Scanner;

class DepthFirstSearch
{
    static int graph[][] = new int[10][10];
    static int visited[] = new int[10];
    static int n;

    static void dfs(int start)
    {
        System.out.print(start + " ");

        visited[start] = 1;

        for(int i=0;i<n;i++)
        {
            if(graph[start][i] == 1 && visited[i] == 0)
            {
                dfs(i);
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

        System.out.print("DFS Traversal: ");

        dfs(start);
    }
}