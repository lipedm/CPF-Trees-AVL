package classes;

import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class AVLTree {
    private int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    public void searchByCpf(Node node, String cpf) {
        List<People> pList = new ArrayList<>();

        traverseInOrderCPF(node, cpf, pList);

        System.out.println("\ncaminhando pela árvore\n");

        for (People people : pList) {
            System.out.println(people);
        }
    }

    public void traverseInOrderCPF(Node node, String cpf, List<People> pList) {
        System.out.println(cpf);
        if (node != null) {
            if (node.people.getCpf().equals(cpf)) {
                
                pList.add(node.people);
            }
            traverseInOrderName(node.left, cpf, pList);
            System.out.print(" " + node.people);
            traverseInOrderName(node.right, cpf, pList);
        }

    }

    public void searchByName(Node node, String name) {
        List<People> pList = new ArrayList<>();

        traverseInOrderName(node, name, pList);

        System.out.println("\n\naminhando pela árvore\n\n");

        for (People people : pList) {
            System.out.println(people);
        }
    }

    public void traverseInOrderName(Node node, String name, List<People> pList) {
        if (node != null) {
            if (node.people.getName().contains(name)) {
                pList.add(node.people);
            }
            traverseInOrderName(node.left, name, pList);
            System.out.print(" " + node.people);
            traverseInOrderName(node.right, name, pList);
        }
    }

    public void searchByDates(Node node, String start, String end) {
        Date startdate = null;
        Date enddate  = null;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            startdate = sdf.parse(start);
            enddate = sdf.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        List<People> pList = new ArrayList<>();

        traverseInOrderDate(node, startdate, enddate, pList);

        System.out.println("\n\naminhando pela árvore\n\n");

        for (People people : pList) {
            System.out.println(people);
        }
    }

    public void traverseInOrderDate(Node node, Date start, Date end, List<People> pList) {
        if (node != null) {
            if (node.people.getBirthdate().after(start) && node.people.getBirthdate().before(end)) {
                pList.add(node.people);
            }
            traverseInOrderDate(node.left, start, end, pList);
            System.out.print(" " + node.people);
            traverseInOrderDate(node.right, start, end, pList);
        }
    }

    public Node insert(Node node, People people) {
        Long key = Long.parseLong(people.getCpf());

        if (node == null) {
            return (new Node(people, 0));
        }

        if (key < Long.parseLong(node.people.getCpf()))
            node.left = insert(node.left, people);
        else
            node.right = insert(node.right, people);

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);

        if (balance > 1 && key < Long.parseLong(node.left.people.getCpf()))
            return rightRotate(node);

        if (balance < -1 && key > Long.parseLong(node.right.people.getCpf()))
            return leftRotate(node);

        if (balance > 1 && key > Long.parseLong(node.left.people.getCpf())) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < Long.parseLong(node.right.people.getCpf())) {
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
            System.out.println("(XXXXXX)");
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
                    System.out.printf("(%s) (%s)", n.people.getName(), n.people.getCpf());
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
                        System.out.printf("%s                            %s", n.left == null ? " " : "/",
                                n.right == null ? " " : "\\");

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