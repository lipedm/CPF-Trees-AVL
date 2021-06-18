package classes;

public class Node {
    public Node left, right, parent;
    public int height = 1;
    public People people;

    public Node(People val) {
        this.people = val;
    }
}
