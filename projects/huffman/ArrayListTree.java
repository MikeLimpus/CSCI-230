/**
 * @author Jonathan Limpus
 * CSCI-230 Project: Huffman
 * Class ArrayListTree
 * Create a tree using an ArrayList as the underlying data structure
 */
import java.util.ArrayList;

public class ArrayListTree {
    // Instance variables
    private ArrayList<Node> tree = new ArrayList<Node>();       // Our tree will live in this array list
    private ArrayList<Node> tempTree = new ArrayList<Node>();   // Temporary array list will hold the nodes for insertion
    private Node root;                                          // Root node of the tree

    public void insert(int value, int weight) {
        Node newNode = new Node(value, weight)
        if (root == null) { // If there is no root, set the new node to be the root 
            root = newNode; 
        }
        else {              // If there is a root, procede as normal
            // Temp node for insertion
            Node temp = new Node(); 

        }
        
        
        
    }
}