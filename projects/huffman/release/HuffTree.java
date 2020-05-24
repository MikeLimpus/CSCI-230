
/**
 * @author Jonathan Limpus
 * CSCI-230 Project: Huffman
 * Class ArrayListTree
 * Create a Huffman tree using a Linked List as the underlying data structure, 
 * and methods to handle huffman compression
 */

import java.util.LinkedList;
import java.util.Collections;

public class HuffTree {
    // Instance variables

    // Our tree will live in this linked list
    private LinkedList<Node> tree = new LinkedList<Node>(); 
    // Temporary linked list will hold the nodes for insertion
    private LinkedList<Node> tempTree = new LinkedList<Node>(); 
    // Root node of the tree, initially empty
    private Node root = new Node(); 
    String binaryString[] = new String[256];
    private Node temp;

    HuffTree() {
    }

    /**
     * build - this creates a huffman tree
     * 
     * @param count
     */
    public void build(int count[])  {

        for(int i = 0; i <= 255; i++) 
            if(count[i] != 0) 
                tree.add(new Node(i, count[i]));

        for(int i = 0; i < tree.size(); i++) 
            tempTree.add(new Node(tree.get(i).getValue(), tree.get(i).getWeight()));    
                                                
        while(tempTree.size() > 1) {
                // Calculate weight on first two nodes and create new parent node, then add this to the real tree
               
                temp = new Node(257, calculateWeight(tempTree), tree.get(getIndex(tempTree.getFirst())),    
                    tree.get(getIndex(tempTree.get(1))));
                tree.addLast(temp);
               
                // Add the new value to our temporary tree's end, and remove the two first ones, and finally sort
                tempTree.addLast(temp);
                Collections.sort(tempTree); 
                tempTree.removeFirst();
                tempTree.removeFirst();
                temp = null;                                    // Clear out some memory
        }
        tempTree.clear();                                       // Empty out the temporary tree
    }
    
    /**
     * calcWeight - small helper function to improve readability in build, adds weight of first two nodes and 
     * removes those nodes from the tree
     * @param tree
     * @return first + second weight values
     */
    public int calculateWeight(LinkedList<Node> list) {
        return list.get(0).getWeight() + list.get(1).getWeight();
    }

    /**
     * getIndex - retrieve the index of a given node
     * @param Node toBeChecked
     * @return index we are looking for, or -1 if it doesn't exist
     */
    public int getIndex(Node toBeChecked) {
        for (int index = 0; index < tree.size(); index++) {
            if(toBeChecked.isEqual(tree.get(index))) 
                return index;
        }
        return -1;                                              // Doesn't exist :(
    }

    /**
     * getRoot - find the root of the tree by iterating through the tree and verifying the root is the 'heaviest' node
     * @return root of the tree
     */

    public Node getRoot() {
        for (int i = 0; i < tree.size(); i++) {
            if(tree.get(i).getWeight() > root.getWeight())
                root = tree.get(i);
        }
        return root;
    }





    // Accessors 

    public Node get(int i) {
        return tree.get(i);
    }

    public int size() {
        return tree.size();
    }

}