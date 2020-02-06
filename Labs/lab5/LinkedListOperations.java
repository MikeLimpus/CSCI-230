/**
 * Jonathan Limpus
 * Implement 
 */
package lab5;
import SinglyLinkedList;

public class LinkedListOperations {
    public static <E> SinglyLinkedList reverse(SinglyLinkedList<E> list) {
        // List is an instance of a SinglyLinkedList with some other number of nodes
        // 1 -> 20 -> 3 -> 5
        // Return a new SinglyLinkedList with 5-> 3->10->1
        SinglyLinkedList<E> ret = new SinglyLinkedList<>();

        // add things to ret

        return ret; 


    }
    public static void main(String args[]) {
        SinglyLinkedList<Integer> oldList = new SinglyLinkedList<>();
        oldList.addFirst(1); oldList.addFirst(10); oldList.addFirst(3); oldList.addFirst(5);

        SinglyLinkedList<Integer> newList = LinkedListOperations.reverse(oldList);

        System.out.println("Original List: " + oldList.toString());
        System.out.println("Reversed List: " + newList.toString());
    }
}
