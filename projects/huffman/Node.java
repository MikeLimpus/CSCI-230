/**
 * @author Jonathan Limpus 
 * Node class for elements of a huffman tree
 * Based on <a href="TreeNode.java">https://www2.cs.duke.edu/csed/poop/huff/spring05/code/TreeNode.java</a>
 */
public class Node implements Comparable<Node> {
    // Instance Variables 
    public int value; 
    public int weight;
    public Node left, right;

    // Constructors

    /**
     * default constructor: create an empty node with no value or weight
     */

    public Node() {
        value = 0;
        weight = 0;
    } 

    /**
     * Leaf Node constructor
     * @param value (the item stored in the node) 
     * @param weight (the number used for comparison)
     * 
     * No children will be created 
     */

    public Node(int value, int weight) {
        // TODO make sure this isn't backwards
        this.value = value;
        this.weight = weight;
    }

    /**
     * Internal node constructor: 
     * @param value (the item stored in the node)
     * @param weight (the number used for comparison)
     * @param left (the left subtree)
     * @param right (the right subtree)
     */

    public Node(int value, int weight, Node left, Node right) {
        this.value = value;
        this.weight = weight;
        this.left = left;
        this.right = right;

    }

    // Accessors 
    
    /** 
     * @return this value
     */
    public int getValue() {
        return value;
    }

    /**
     * print all the elements of a node
     */
    public void print() {
        System.out.println("Value " + value);
        System.out.println("Weight " + weight);
        System.out.println("Left (Should print Node@somevalue or null)" + left);
        System.out.println("Right (Should print Node@somevalue or null)" + right);
    }

    /**
     * compareTo - implemented from java's Comparable
     * @param Node n (the node that will be compared with this one's weight)
     * @return -1 if < n.weight, 0 if == n.weight, or 1 if > n.weight
     */

    public int compareTo(Node n) {
        return weight - n.weight;
    }
}