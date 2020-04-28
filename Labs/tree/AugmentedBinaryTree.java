/**
 * A class that augments the LinkedBinaryTree from the course primary textbook. Instead of <i>directly</i> modifying the LinkedBinaryTree class, we can simply extend the class and
 * exploit the "is-a" relationship.
 * 
 * @author YourName
 */
public class AugmentedBinaryTree<E> extends LinkedBinaryTree<E> {

	/**
	 * Removes the entire subtree rooted at position p, making sure to maintain an accurate count of the size of the tree. <b>Hint</b>: Use recursion. Reference to the remove method
	 * to see how to remove a node but do not use the remove method.
	 * @param p
	 */
	public void pruneSubtree(Position<E> p) {
		Node<E> node = validate(p);
		if(p == null) {
			
		}
		
	}
	
	/**
	 * Restructures the tree so that the node referenced by p takes the place of the node referenced by q, and vice versa. Make sure to properly handle the case when the nodes are
	 * adjacent
	 * @param p
	 * @param q
	 */
	public void swap(Position<E> p, Position<E> q) {
		
		// Two positions are related if their corresponding nodes have a parent/child relationship (i.e., one node is the parent of the other)
		
	}
}


/* C++ Implementation of pruneSubtree
// Recursively deletes all nodes specified by a root
void pruneSubtree(Node* subtreeRoot) {
	if(!subtreeRoot) return;			// Base Case: If subtreeRoot is null, then terminate
	if(leftChild)    pruneSubtree(leftChild);	// If there is a leftChild, recursively delete the subtree where leftChild is its root
	if(rightChild)   pruneSubtree(rightChild);	// If there is a rightChild, recursively delete the subtree where rightChild is its root
	delete subtreeRoot;
}
*/