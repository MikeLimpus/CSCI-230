/**
 * Jonathan Limpus
 * CSCI-230
 * Lab: Priority Queue
 * 04/12/2020
 * 
 * Problem Statement: provide an implementation of a MaxPriorityQueue class that adapts to 
 * provide a maximum-oriented abstraction with methods insert, max, and removeMax
 */

// Note: Only edit this file

package LabPriorityQueue;

import javax.swing.text.Position;

public class MaxPriorityQueue<K,V> extends MinPriorityQueue {

	/*
	 * Finish me
	 */
	K k;
	V val;
	private UnsortedPriorityQueue<K,V> priQueue = new UnsortedPriorityQueue<>();
	 // Default constructor which calls the parent class's constructor
	public MaxPriorityQueue(){
		super();
	}	

	public MaxPriorityQueue(K key, V value) {
		k = key;
		val = value;
	}

	@Override
	public Entry<K,V> insert(Object key, Object value) {
		super.insert(key, value);
	}

	public Entry<K,V> findMax() {
		Position<Entry<K,V>> max = priQueue.first();
		for(Position<Entry<K,V>> it : priQueue.positions) {
			if (compare(it.getElement(), max.getElement()) > 0)
				max = it;
			return max;
		}
	}

	public Entry<K,V> max() {
		if(isEmpty())
			return null;
		else
			return findMax().getElement();
	}

	public Entry<K,V> removeMax() {
		if (priQueue.isEmpty())
			return null; 
		return priQueue.remove(findMax()); 	// remove defined in parent
	}



	public static void main(String[] args) {

		MinPriorityQueue<Integer, String> pq = new MinPriorityQueue<>();

		pq.insert(1, "Apple");
		pq.insert(2, "Banana");

		/*
		 * This should print "Banana" "Apple"
		 */
		while (!pq.isEmpty())
			System.out.println(pq.removeMin().getValue());

	}
}
