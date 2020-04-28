/**
 * Jonathan Limpus
 * Lab: Heaps
 * 04/17/2020
 */

import java.util.ArrayList;
import java.util.Comparator;

public class MaxHeapPriorityQueue<K,V> extends HeapPriorityQueue<K,V> {

	int size = 0;
	
	public int size() { return size; }
	private Comparator<K> c = new DefaultComparator<>();
	private ArrayList<K> heap = new ArrayList<>();
	// // ADD AND/OVERRIDE METHODS AS NEEDED
	@Override
	protected boolean hasLeft(int j) { return left(j) < heap.size(); }

	@Override
  	protected boolean hasRight(int j) { return right(j) < heap.size(); }

	@Override 
	protected void upheap(int j) {
		while (j > 0) {            // continue until reaching root (or break statement)
		int p = parent(j);
		if (compare(heap.get(j), heap.get(p)) >= 0) break; // heap property verified
		swap(j, p);
		j = p;                                // continue from the parent's location
		}
	}
	
	protected void downheap(int j) {
		while (hasLeft(j)) {               // continue to bottom (or break statement)
			int leftIndex = left(j);
			int smallChildIndex = leftIndex;     // although right may be smaller
			if (hasRight(j)) {
				int rightIndex = right(j);
				if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0)
				  smallChildIndex = rightIndex;  // right child is smaller
			}
			if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0)
			  break;                             // heap property has been restored
			swap(j, smallChildIndex);
			j = smallChildIndex;                 // continue at position of the child
		  }
	}

	protected int compare(K a, K b){
		return c.compare(a, b);
	}
	@Override
	protected void swap(int i, int j) {
		K temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	
	/** perform heap-sort in place **/
	public void sortInPlace(PositionalList<K> S) {
		// COMPLETE THIS METHOD
		int n = S.size();
		// // // Create an arrayList with the elements of the heap
		// ArrayList<K> sortArray = new ArrayList<K>();
		for(int i = 0; i < n; i++) {
			//PQEntry<K,V> temp = new PQEntry<K,V>(S.remove(S.first()),null);
			
			heap.add(S.remove(S.first()));
		}

		int index = 1; 
		while(index != heap.size() - 1) {
			upheap(index);
			index++;
		}
		printKeys();
		
	}

	private void printKeys() {
		while((heap.size() - 1) != 0){
			
			//print out the top, then downheap
			System.out.print(heap.get(0) + " "); // print smallest
			heap.set(0, heap.get(heap.size() -1)); // set root as end
			heap.remove(heap.size() - 1); // removes the smallest that is now the root
			// need to now downheap
			downheap(0);	
		}		
	}

}
	  