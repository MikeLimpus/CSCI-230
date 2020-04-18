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
	private Comparator<Object> c = new DefaultComparator<>();
	private ArrayList<K> heap = new ArrayList<>();
	// // ADD AND/OVERRIDE METHODS AS NEEDED
	@Override 
	protected void upheap(int j) {
		super.upheap(j);
	}
	
	@Override
	protected void downheap(int j) {
		// TODO Auto-generated method stub
		super.downheap(j);
	}

	protected int comparing(K a, K b) {
		return c.compare(a, b);
	}

	
	/** perform heap-sort in place **/
	public void sortInPlace(PositionalList<K> S) {
	//public void sortInPlace(PositionalList<K> S, PriorityQueue<K, ?> sortpQ) {
		// COMPLETE THIS METHOD
		int n = S.size();
		// // // Create an arrayList with the elements of the heap
		// ArrayList<K> sortArray = new ArrayList<K>();
		for(int i = 0; i < n; i++) {
			//PQEntry<K,V> temp = new PQEntry<K,V>(S.remove(S.first()),null);
			
			heap.add(S.remove(S.first()));
		}
		// Use the Java list sort method
		heap.sort(c);
		for(int i = 0; i < heap.size(); i++) {
			S.addFirst(heap.get(i));
		}
		
	}
	  
}
