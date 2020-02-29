/**
 * Jonathan Limpus
 * CSCI-230
 * Project 2 - Guitar
 * 
 * RingBuffer - models a ring buffer and the associated methods using a double array with cyclic wrap-around
 */

public class RingBuffer {
    // Global Variables 
    private int capacity; 
    private int size;
    private int first, last;
    public Double ringBufferArray[] = new Double[capacity];

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
        return ringBufferArray.length;
    }

    /**
     * isEmpty - return true if buffer is empty
     * @return boolean
     */
    public boolean isEmpty() {
        if (size() == 0)
            return true;
        else 
            return false;
    }

    /**
     * isFull - return true if buffer is full
     * @return boolean
     */
    public boolean isFull() {
        if (size() == capacity)
            return true;
        else 
            return false;
    }

    public void enqueue(Double x) {
        // add x to end or throw RingBufferException if full

    }

    public Double dequeue() {
        // Delete and reutrn item from front, throw RingBufferException
        // If empty
    }

    /**
     * peek - return the first element of the buffer without deleting it
     * @return 
     */
    public Double peek() {
        return ringBufferArray[first];
        // Returns front of list w/o deleting
    }

    /**
     * Class extending Exception used to handle full and empty Ring Buffer
     */
    private class RingBufferException extends Exception {
        public RingBufferException(String message) {
            super(message);
        }
    }
}