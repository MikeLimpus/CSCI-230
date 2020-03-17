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
    private Double ringBufferArray[] = new Double[capacity];

    // Default Constructor - sets capacity to default value 100 
    public RingBuffer() {
        capacity = 100; 
        //ringBufferArray = new Double[capacity];
    }

    public RingBuffer(int capacity) {
        this.capacity = capacity;
        //ringBufferArray = new Double[capacity];
    }


    /**
     * size - returns the number of items currently in the buffer
     * @return size
     */
    public int size() {
        for (int i = 0; i < ringBufferArray.length; i++) {
            if(ringBufferArray[i] != 0) 
                size++;
        }
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * isEmpty - return true if buffer is empty
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * isFull - return true if buffer is full
     * @return boolean
     */
    public boolean isFull() {
        return size == capacity;
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
            size = size();                          // Recalculate size
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
            first++;
            if (first == capacity)                  // Wrap-around 
                first = 0; 
            size = size();                          // Recalculate size
            return temp;
        }
        else throw new RingBufferException("ERROR REMOVING: RingBuffer is already empty");
    }
    /**
     * peek - return the first element of the buffer without deleting it
     * @return 
     */
    public Double peek() {
        System.out.println("DELETE ME: first = " + first);
        System.out.println("DELETE ME: rBA[first] = " + ringBufferArray[first]);
        return ringBufferArray[first];
        // Returns front of list w/o deleting
    }

    /**
     * Class extending Exception used to handle full and empty Ring Buffer
     */
    public class RingBufferException extends Exception {
        private static final long serialVersionUID = 1L;

        public RingBufferException(String message) {
            super(message);
        }
    }

    public static void main(String args[]) {
        System.out.println("RingBuffer");
    }
}