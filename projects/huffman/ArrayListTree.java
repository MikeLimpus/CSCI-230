/**
 * @author Jonathan Limpus
 * CSCI-230 Project: Huffman
 * Class ArrayListTree
 * Create a Huffman tree using an ArrayList as the underlying data structure
 */
import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTree {
    // Instance variables
    private ArrayList<Node> tree = new ArrayList<Node>();       // Our tree will live in this array list
    private ArrayList<Node> tempTree;                           // Temporary array list will hold the nodes for insertion
    private Node root = new Node();                             // Root node of the tree, initially empty

                  
    ArrayListTree() {}

    /**
     * build - this creates a huffman tree b
     * @param count
     */
    public void build(int count[]) {

        for(int i = 0; i <= 255; i++) {
            if(count[i] != 0) {
                Node temp = new Node(i, count[i]);
                tree.add(temp);
            }
        }

        Collections.sort(tree);                                 // sort the tree
        tempTree = tree;                                        // Make a copy of the tree 
        while(tempTree.size() > 1) {
                // Calculate weight on first two nodes and create new parent node, then add this to the real tree
                Node temp = new Node(0, calculateWeight(tempTree), tree.get(getIndex(tempTree.get(0))),
                    tree.get(getIndex(tempTree.get(1))));

                tree.add(temp);
                // Add the new value to our temporary tree's end, and remove the two first ones, and finally sort
                tempTree.add(temp);
                tempTree.remove(0);
                tempTree.remove(0);
                Collections.sort(tempTree); 
        }
        tempTree.clear();                                       // Empty out the temporary tree
    }
    
    /**
     * calcWeight - small helper function to improve readability in build, adds weight of first two nodes
     * in the tree
     * @param tree
     * @return first + second weight values
     */
    public int calculateWeight(ArrayList<Node> tree) {
        return tree.get(0).getWeight() + tree.get(1).getWeight(); 
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

    /** TODO please delet this this is a very dumb thing that should not be in the final release */
    public void addTenRandomNodes() {
        int ass[] = {0, 1, 2, 3, 5, 8, 20, 420, 10};        //idk if this is even 10 number didnt count lmao
        build(ass);                                         // I came here to build ass and chew bubble gum and Im all outta ass
    }

    /*
    public void insert(int value, int weight) {
        Node newNode = new Node(value, weight);
        if (root == null) { // If there is no root, set the new node to be the root 
            root = newNode; 
        }
        else {              // If there is a root, procede as normal
            // Temp node for insertion
            Node temp = new Node(); 
            tempTree = tree;
            // Add the root to the front temporary tree
            tempTree.add(root);
            // Iterate until the temp tree is empty
            while(!tempTree.isEmpty()) {
                temp = tempTree.get(tempTree.size());   // 'Pop' the last element from the temporary tree
                if(temp.left == null) {
                    
                }
            }

        }
    } */




}