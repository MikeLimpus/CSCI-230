import net.datastructures.Deque;
import net.datastructures.ArrayList; 
// throws IllegalStateException \ IllegalArgumentException

public class StackDeque<E> implements Deque<E> {
// Declare two private member variables frontStack and endStack with
// reference type ArrayStack
    ArrayStack<E> frontStack = new ArrayStack<E>;
    ArrayStack<E> endStack = new ArrayStack<E>;

    int size() {
        // return number of elements
    }

    boolean isEmpty() {
        // if empty \
            // return true
    }

    E first() {
        // return first element without removing
    }
    E last() {
        // return last element without removing 
    }

    void addFirst() {
        // Inserts at front
    }

    void addLast() {
        // Inserts at back
    }

    E removeFirst() {
        // Remove and return first element
    }

    E removeLast() {
        // Remove and return last element
    }
	
	// Utilize these two member variables and their respective methods to
	// implement each function in the Deque interface
	
	public static void main(String[] args) {
		// Write your driver here as a part of problem 2
	}
}