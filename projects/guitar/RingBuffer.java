import java.util.Arrays;    //TODO delete me before submit

/**
 * Jonathan Limpus CSCI-230 Project 2 - Guitar
 * 
 * RingBuffer - models a ring buffer and the associated methods using a double
 * array with cyclic wrap-around
 */
public class RingBuffer {
    // Global Variables 
    private int capacity = 0; 
    
    private int first = 0, last = 1;
    private double ringBufferArray[]; 

    // Default Constructor - sets capacity to default value 100 
    public RingBuffer() {
        int capacity = 100; 
        ringBufferArray = new double[capacity];
        size();
    }

    public RingBuffer(int cap) {
        capacity = cap;
        ringBufferArray = new double[capacity];
        size();
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
    // TODO Accessor for capacity variable, used for debug purposes only
    public int getCapacity() {
        return capacity;
    }

    /**
     * isEmpty - return true if buffer is empty
     * @return boolean
     */
    public boolean isEmpty() {
        if (size() == 0) return true;
        else return false;
        //return size == 0;
    }

    /**
     * isFull - return true if buffer is full
     * @return boolean
     */
    public boolean isFull() {
        return size() == capacity;
    }

    /**
     * enqueue - add an item to the array and increment the last index
     * @return void
     */
    public void enqueue(double x) throws RingBufferException {
        // Add new element if the array is not full 
        if(!this.isFull()) {     
            ringBufferArray[last] = x;
            if (last == (capacity + 1))
                last = 1;                           // Wrap around array if the the index reaches the end
            last = (last + 1) % ringBufferArray.length;     // last++
            size();                          // Recalculate size
        }
                                    
        // Throw RingBufferException if the buffer is full 
        else throw new RingBufferException("ERROR ADDING: RingBuffer is full, with capacity: " + capacity);
    }

    public double dequeue() throws RingBufferException  {
        // Delete and reutrn item from front, throw RingBufferException
        // If empty 
        if (!this.isEmpty()) {
            double temp = ringBufferArray[first];   // Temp variable so we don't lose the deleted data before returning
            ringBufferArray[first] = 0;
            first = (first + 1) % ringBufferArray.length;     //first++;
            if (first == capacity)                  // Wrap-around 
                first = 0; 
            size();                          // Recalculate size
            return temp;
        }
        else throw new RingBufferException("ERROR REMOVING: RingBuffer is already empty");
    }
    /**
     * peek - return the first element of the buffer without deleting it
     * @return 
     */
    public double peek() throws RingBufferException {
        System.out.println("DELETE ME: first = " + first);
        System.out.println("DELETE ME: rBA[first] = " + ringBufferArray[first]);
        if (!this.isEmpty())
            return ringBufferArray[first];
        else throw new RingBufferException("Error in method peek: RingBuffer is empty");
        // Returns front of list w/o deleting
    }

    /**
     * Class extending Exception used to handle full and empty Ring Buffer
     */
    public class RingBufferException extends Exception {
        //private static final long serialVersionUID = 1L;

        public RingBufferException(String message) {
            super(message);
        }
    }
    // TODO kill me
    public void print() {
        System.out.println("DELETE ME: RingBuffer = " + Arrays.toString(ringBufferArray));
        System.out.println("DELETE ME: Capacity = " + capacity);
    }
    public static void main(String args[]) {
        System.out.println("RingBuffer");
    }
}