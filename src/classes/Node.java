package classes;

public class Node {
    public Node left, right, parent;
    public int height = 1;
    public People people;
    public int key;

    public Node(People val, int key) {
        this.people = val;
        this.key = key;
    }
}
