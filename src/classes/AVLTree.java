package classes;

import java.util.*;

public class AVLTree {
    private String searchPath = "";

    private int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    public String getSearchPath() {
        return searchPath;
    }

    public Node search(Node node, People people) {
        
        if (people == node.people) {
            System.out.println("\nNodo Encontrado: " + node.people);
            searchPath += node.people;
            return node;
        } else if (people < node.people) {
            searchPath += node.people + " > ";
            search(node.left, people);
        } else if (people > node.people) {
            searchPath += node.people + " > ";
            search(node.right, people);
        }
        System.out.println(searchPath);
        searchPath = "";
        return node;
    }

    public Node insert(Node node, People people) {
        if (node == null) {
            return (new Node(people));
        }

        if (people < node.people)
            node.left = insert(node.left, people);
        else
            node.right = insert(node.right, people);

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);

        if (balance > 1 && people < node.left.people)
            return rightRotate(node);

        if (balance < -1 && people > node.right.people)
            return leftRotate(node);

        if (balance > 1 && people > node.left.people) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && people < node.right.people) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    public void preOrder(Node root) {
        if (root != null) {
            preOrder(root.left);
            System.out.printf("%d ", root.people);
            preOrder(root.right);
        }
    }

   
    public void print(Node root) {
        if (root == null) {
            // System.out.println("(XXXXXX)");
            return;
        }

        int height = root.height, width = (int) Math.pow(2, height - 1);

        List<Node> current = new ArrayList<Node>(1), next = new ArrayList<Node>(2);
        current.add(root);

        final int maxHalfLength = 4;
        int elements = 1;

        StringBuilder sb = new StringBuilder(maxHalfLength * width);
        for (int i = 0; i < maxHalfLength * width; i++)
            sb.append(' ');
        String textBuffer;

        for (int i = 0; i < height; i++) {
            sb.setLength(maxHalfLength * ((int) Math.pow(2, height - 1 - i) - 1));
            textBuffer = sb.toString();
            for (Node n : current) {
                System.out.print(textBuffer);

                if (n == null) {
                    System.out.print("        ");
                    next.add(null);
                    next.add(null);

                } else {
                    System.out.printf("(%6d)", n.people);
                    next.add(n.left);
                    next.add(n.right);

                }

                System.out.print(textBuffer);

            }

            System.out.println();
            if (i < height - 1) {
                for (Node n : current) {
                    System.out.print(textBuffer);
                    if (n == null)
                        System.out.print("        ");
                    else
                        System.out.printf("%s      %s", n.left == null ? " " : "/", n.right == null ? " " : "\\");

                    System.out.print(textBuffer);

                }

                System.out.println();

            }

            elements *= 2;
            current = next;
            next = new ArrayList<Node>(elements);

        }

    }

}