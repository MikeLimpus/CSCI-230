import java.util.ArrayList;

/**
 * @author Jonathan Limpus Node class for elements of a huffman tree Based on
 *         <a href=
 *         "https://www2.cs.duke.edu/csed/poop/huff/spring05/code/TreeNode.java">TreeNode.java</a>, 
 * modified for specific use with binary trees implemented using the Java LinkedList ADT
 */
public class Node implements Comparable<Node> {
    // Instance Variables 
    private int value; 
    private int weight;
    public Node left, right;

    

    // Constructors

    /**
     * default constructor: create an empty node with no value or weight
     */

    public Node() {
        value = 0;
        weight = 0;
        left = null; 
        right = null;
    } 

    /**
     * Leaf Node constructor
     * @param value (the item stored in the node) 
     * @param weight (the number used for comparison)<p>
     * 
     * No children will be created 
     */

    public Node(int value, int weight) {
        // TODO make sure this isn't backwards
        this.value = value;
        this.weight = weight;
        left = null;
        right = null;
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
     * @return The node's value
     */
    public int getValue() {
        return value;
    }

    /**
     * @return The node's weight
     */
    public int getWeight() { 
        return weight;
    }


    /**
     * Print all the elements of a node for debugging
     */
    public void print() {
        System.out.println("Value " + value);
        System.out.println("Weight " + weight);
        System.out.println("Left (Should print Node@somevalue or null)" + left);
        System.out.println("Right (Should print Node@somevalue or null)" + right);
    }

    /**
     * compareTo - implemented from java's Comparable
     * @param Node n (the node that will be compared with this comp's weight)
     * @return -1 if < n.weight, 0 if == n.weight, or 1 if > n.weight
     */

    public int compareTo(Node n) {
        return weight - n.weight;
    }

    /**
     * isEqual: check each member variable of two nodes to see if they are all equal
     * @param comp
     * @return true if all members are equal
     */
    public boolean isEqual(Node comp) {
        return (comp.value == value && comp.weight == weight && comp.left == left && comp.right == right);
    }
}