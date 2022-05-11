public class Node1 {
    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        node1.next=node2;
    }
}
class Node{
    public int data;
    public Node next;
}

