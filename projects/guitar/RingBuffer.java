/**
 * Jonathan Limpus
 * CSCI-230
 * Project 2 - Guitar
 * 
 * RingBuffer - models a ring buffer and the associated methods
 */

public class RingBuffer {
    // Global Variables 
    private int capacity; 
    private int size;
    private int first, last;

    // Default Constructor - sets capacity to default value 100 
    public RingBuffer() {
        capacity = 100; 
    }

    public RingBuffer(int capacity) {
        capacity = this.capacity;
    }


    /**
     * size - returns the number of items currently in the buffer
     * @return size
     */
    public int size() {
        // TODO STUFF
    }

    public boolean isEmpty() {
        // if empty
        //      return true 
        // else 
        //      return false
    }

    public boolean isFull() {
        // if full 
        //      return true
        // else
        // Return false
    }

    public void enqueue(double x) {
        // add x to end or throw RingBufferException if full
    }

    public double dequeue() {
        // Delete and reutrn item from front, throw RingBufferException
        // If empty
    }

    public double peek() {
        // Returns front of list w/o deleting
    }
}