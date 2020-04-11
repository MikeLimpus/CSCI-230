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
        capacity = 100; 
        ringBufferArray = new double[capacity];
        // TODO Put me back size();
    }

    public RingBuffer(int cap) {
        capacity = cap;
        ringBufferArray = new double[capacity];
        // TODO Put me back size();
    }    


    /**
     * size - returns the number of items currently in the buffer
     * @return size
     */
    public int size() {
        // TODO Comment
        // if(last >= first)
        //     return last - first + 1;
        // else 
        //     return (ringBufferArray.length - first + 1) + (last + 1);
        //TODO Put me back 
        int size = 0;
        for (int i = 0; i < capacity; i++) {
            if(ringBufferArray[i] != 0) 
                size++;
        }
        return size;
        //return Math.abs(last - first);
 
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
        // TODO Put me back or kill me if (size() == 0) return true;
        // else return false;
        return (size() == 0);
    }

    /**
     * isFull - return true if buffer is full
     * @return boolean
     */
    public boolean isFull() {
        //if(capacity != 0)       // Due to a specific edge case, a ring buffer of capacity zero will crash the program 
            return (size() == ringBufferArray.length); // or capacity
        //else return true;       // If a ring buffer has a capacity of 0, it is inherently full at all times
    }

    /**
     * enqueue - add an item to the array and increment the last index
     * @return void
     */
    public void enqueue(double x) throws RingBufferException {
        // Add new element if the array is not full 
        if(!isFull()) {     
            ringBufferArray[last] = x;
/*             if (last == (capacity + 1))
                last = 1;      */                      // Wrap around array if the the index reaches the end
            last = (last + 1) % ringBufferArray.length;     // 
            //size();                          // Recalculate size
        }
                                    
        // Throw RingBufferException if the buffer is full 
        else throw new RingBufferException("ERROR ADDING: RingBuffer is full, with capacity: " + capacity);
    }

    public double dequeue() throws RingBufferException  {
        // Delete and return item from front, throw RingBufferException
        // If empty 
        if (!isEmpty()) {
            double temp = ringBufferArray[first];   // Temp variable so we don't lose the deleted data before returning
            ringBufferArray[first] = 0.0;
            first = (first + 1) % ringBufferArray.length;     //
            //size();                          // Recalculate size
            return temp;
        }
        else throw new RingBufferException("ERROR REMOVING: RingBuffer is already empty");
    }
    /**
     * peek - return the first element of the buffer without deleting it
     * @return 
     */
    public double peek() {
        //System.out.println("DELETE ME: first = " + first);
        //System.out.println("DELETE ME: rBA[first] = " + ringBufferArray[first]);
        //if (!isEmpty())
            return ringBufferArray[first];
        //else throw new RingBufferException("Error in method peek: RingBuffer is empty");
        // Returns front of list w/o deleting
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
    // TODO kill me
    public void print() {
        System.out.println("DELETE ME: RingBuffer = " + Arrays.toString(ringBufferArray));
        System.out.println("DELETE ME: Capacity = " + capacity);
    }
    public static void main(String args[]) {
        System.out.println("RingBuffer");
    }
}