package classes;

public class Node {
    public Node left, right, parent;
    public int height = 1;
    public int value;

    public Node(int val) {
        this.value = val;
    }
}
