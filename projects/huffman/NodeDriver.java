
public class NodeDriver {

// TODO Delete this: Node driver
// 4/28 8:03 PM this works
    public static void main(String args[]) {
        Node node1 = new Node();
        node1.print();
        System.out.println("Node 1 gibberish " + node1);
        Node node2 = new Node(1, 3);
        node2.print();
        System.out.println("Node 2 gibberish " + node2);
        Node node3 = new Node(1, 3);
        node3.print();
        System.out.println("Node 3 gibberish " + node3);
        Node node4 = new Node(0, 1, node2, node3);
        node4.print();
        System.out.println("Node 4 gibberish " + node4);

        if (node2.compareTo(node3) == 0) {
            System.out.println("2 = 3");
        }

    }
}