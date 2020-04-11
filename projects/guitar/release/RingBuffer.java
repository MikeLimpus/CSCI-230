import java.util.Arrays;    //TODO delete me before submit

/**
 * Jonathan Limpus CSCI-230 Project 2 - Guitar
 * 
 * RingBuffer - models a ring buffer and the associated methods using a double
 * array with cyclic wrap-around
 */
public class RingBuffer {
    // Global Variables 
    // Capacity will represent the maximum size of our ring buffer
    private int capacity = 0; 
    // Initialize the first and last pointers to zero
    private int first = 0, last = 0;
    // Array used as underlying data structure to be implemeted as a circular array
    private double ringBufferArray[]; 

    // Default Constructor - sets capacity to default value 100 
    public RingBuffer() {
        capacity = 100; 
        ringBufferArray = new double[capacity];
    }

    public RingBuffer(int cap) {
        capacity = cap;
        ringBufferArray = new double[capacity];
    }    


    /**
     * size - returns the number of items currently in the buffer
     * @return size
     */
    public int size() {
        int size = 0;
        for (int i = 0; i < capacity; i++) {
            if(ringBufferArray[i] != 0) 
                size++;
        }
        return size; 
    }
    // Accessor for capacity variable, used for incrementing through ring buffer
    public int getCapacity() {
        return capacity;
    }

    /**
     * isEmpty - return true if buffer is empty
     * @return boolean
     */
    public boolean isEmpty() {
        return (size() == 0);
    }

    /**
     * isFull - return true if buffer is full
     * @return boolean
     */
    public boolean isFull() {
        return (size() == capacity); 
    }

    /**
     * enqueue - add an item to the array and increment the last index
     * @return void
     */
    public void enqueue(double x) throws RingBufferException {
        // Add new element if the array is not full 
        if(!isFull()) {     
            ringBufferArray[last] = x;
            // Wrap around array if the the index reaches the end
            last = (last + 1) % capacity; 
        }                              
        // Throw RingBufferException if the buffer is full 
        else throw new RingBufferException("ERROR ADDING: RingBuffer is full, with capacity: " + capacity);
    }
    /**
     * dequeue - delete and return the item at the front of the buffer
     * @return double
     * @throws RingBufferException
     */
    public double dequeue() throws RingBufferException  {
        // Delete and return item from front, throw RingBufferException if empty 
        if (!isEmpty()) {
            double temp = ringBufferArray[first];   // Temp variable so we don't lose the deleted data before returning
            ringBufferArray[first] = 0.0;           
            // Wrap around array if the the index reaches the end
            first = (first + 1) % ringBufferArray.length;     
            return temp;
        }
        else throw new RingBufferException("ERROR REMOVING: RingBuffer is already empty");
    }
    /**
     * peek - return the first element of the buffer without deleting it
     * @return 
     */
    public double peek() {
        return ringBufferArray[first];
    }

    /**
     * clearAll - Helper method to remove all elements from a ring buffer if needed
     */
    protected void clearAll() throws RingBufferException {
        while(!isEmpty())
            dequeue();
    }

    /**
     * Class extending Exception used to handle full and empty Ring Buffer
     */
    public class RingBufferException extends Exception {
        public RingBufferException(String message) {
            super(message);
        }
    }
}