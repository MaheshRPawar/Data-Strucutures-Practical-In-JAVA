import java.util.Scanner;

class BinarySearchTree
{
    static class Node
    {
        int data;
        Node left,right;

        Node(int x)
        {
            data = x;
            left = right = null;
        }
    }

    static Scanner sc = new Scanner(System.in);

    static Node create()
    {
        int x;

        System.out.print("Enter value (-1 for no node): ");
        x = sc.nextInt();

        if(x == -1)
            return null;

        Node temp = new Node(x);

        System.out.println("Enter left of " + x);
        temp.left = create();

        System.out.println("Enter right of " + x);
        temp.right = create();

        return temp;
    }

    static Node insert(Node root,int x)
    {
        if(root == null)
            return new Node(x);

        if(x < root.data)
            root.left = insert(root.left,x);
        else if(x > root.data)
            root.right = insert(root.right,x);

        return root;
    }

    static Node findMin(Node root)
    {
        while(root.left != null)
            root = root.left;

        return root;
    }

    static Node delete(Node root,int x)
    {
        if(root == null)
            return null;

        if(x < root.data)
            root.left = delete(root.left,x);
        else if(x > root.data)
            root.right = delete(root.right,x);
        else
        {
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;

            Node temp = findMin(root.right);
            root.data = temp.data;
            root.right = delete(root.right,temp.data);
        }

        return root;
    }

    static boolean search(Node root,int key)
    {
        if(root == null)
            return false;

        if(root.data == key)
            return true;

        if(key < root.data)
            return search(root.left,key);
        else
            return search(root.right,key);
    }

    static void inorder(Node root)
    {
        if(root != null)
        {
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }

    static void preorder(Node root)
    {
        if(root != null)
        {
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void postorder(Node root)
    {
        if(root != null)
        {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
    }

    static int count(Node root)
    {
        if(root == null)
            return 0;

        return 1 + count(root.left) + count(root.right);
    }

    static void displayTree(Node root,int space)
    {
        if(root == null)
            return;

        space = space + 5;

        displayTree(root.right,space);

        for(int i=5;i<space;i++)
            System.out.print(" ");

        System.out.println(root.data);

        displayTree(root.left,space);
    }

    public static void main(String args[])
    {
        Node root;
        int ch,x;

        System.out.println("Create Tree:");
        root = create();

        do
        {
            System.out.println("\n1.Insert");
            System.out.println("2.Delete");
            System.out.println("3.Search");
            System.out.println("4.Inorder");
            System.out.println("5.Preorder");
            System.out.println("6.Postorder");
            System.out.println("7.Minimum");
            System.out.println("8.Maximum");
            System.out.println("9.Count Nodes");
            System.out.println("10.Display Tree");
            System.out.println("11.Exit");

            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch(ch)
            {
                case 1:
                    System.out.print("Enter element: ");
                    x = sc.nextInt();
                    root = insert(root,x);
                    break;

                case 2:
                    System.out.print("Enter element to delete: ");
                    x = sc.nextInt();
                    root = delete(root,x);
                    break;

                case 3:
                    System.out.print("Enter element to search: ");
                    x = sc.nextInt();
                    if(search(root,x))
                        System.out.println("Element Found");
                    else
                        System.out.println("Element Not Found");
                    break;

                case 4:
                    System.out.print("Inorder: ");
                    inorder(root);
                    break;

                case 5:
                    System.out.print("Preorder: ");
                    preorder(root);
                    break;

                case 6:
                    System.out.print("Postorder: ");
                    postorder(root);
                    break;

                case 7:
                    if(root == null)
                        System.out.println("Tree Empty");
                    else
                        System.out.println("Minimum: "+findMin(root).data);
                    break;

                case 8:
                    if(root == null)
                        System.out.println("Tree Empty");
                    else{
                        Node ptr = root;
                        while(ptr.right != null)
                            ptr = ptr.right;
                        System.out.println("Maximum: "+ptr.data);
                    }
                    break;

                case 9:
                    System.out.println("Total nodes: "+count(root));
                    break;

                case 10:
                    displayTree(root,0);
                    break;
            }

        }while(ch!=11);
    }
}