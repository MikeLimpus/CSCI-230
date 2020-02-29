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

    /**
     * enqueue - add an item to the array and increment the last index
     * @return void
     */
    public void enqueue(Double x) throws RingBufferException {
        // Add new element if the array is not full 
        if(!isFull()) {     
            ringBufferArray[last] = x;
            if (last == capacity)
                last = 0;                            // Wrap around array if the the index reaches the end
            last++;
        }
        // Throw RingBufferException if the buffer is full 
        else throw new RingBufferException("ERROR ADDING: RingBuffer is full, with capacity: " + capacity);
    }

    public Double dequeue() throws RingBufferException  {
        // Delete and reutrn item from front, throw RingBufferException
        // If empty
        if (!isEmpty()) {
            Double temp = ringBufferArray[first];   // Temp variable so we don't lose the deleted data before returning
            ringBufferArray[first] = null;
            if (first == capacity)                  // Wrap-around 
                first = 0; 
            return temp;
        }
        else throw new RingBufferException("ERROR REMOVING: RingBuffer is already empty");
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