/**
 * Jonathan Limpus 
 * Project 2 - Guitar 
 * CSCI-230
 * 
 * GuitarString - Models a vibrating guitar string using the <b>RingBuffer</b> data structure
 */

public class GuitarString extends RingBuffer{
    // Instance Variables
    private int samplingRate;
    private int size;
    static private int timesCalled = 0; // Store the amount of times the method <b>tic</b> was called  
    // Constants defined in Karplus-Strong Algorithm
    private int BASE_SAMPLING_RATE = 44100;
    private Double ENERGY_DECAY_RATE = 0.994;
    // RingBuffer object
    private RingBuffer guitarString = new RingBuffer(size);
    /**
     * Create a guitar string of the argument frequency, using a sampling rate of
     * 44,000 by creating a <b>RingBuffer</b> instance of the desired capacity
     * <i>N</i>, Where <i>N</i> = ceiling((sampling rate 44100) / frequency)
     * 
     * @param Double frequency
     */

    public GuitarString(Double frequency) {
        int N = (int) Math.ceil((BASE_SAMPLING_RATE / frequency));
        System.out.println("DELETE ME: int N = " + N);
        size = N;
    }

    /**
     * Creates a guitar string whose size and initial values are given by the array
     * by creating a <b>RingBuffer</b> of capacity equal to the size of the array,
     * and initializes the contents of the buffer to the values in the array.
     * 
     * @param Double[] init
     * @throws RingBufferException
     */
    public GuitarString(Double[] init) throws RingBufferException {
        size = init.length;
        //guitarString = new RingBuffer(init.length);
        for (int i = 0; i < init.length; i++) {
            if (!guitarString.isFull())
                guitarString.enqueue(init[i]);
            else throw new RingBufferException("Error: Buffer Full");
        }
    }
    
    /**
     * pluck - fill the <b>RingBuffer</b> with random values between +-0.5
     * @param none
     * @return void
     * @throws RingBufferException
     */
    public void pluck() throws RingBufferException {
        for(int i = 0; i < guitarString.getCapacity(); i++) {
            if (!guitarString.isFull()) 
                // Math.random generates a random double between 0.0 & 1,0, so we must offset this by 0.5 by subtracting
                guitarString.enqueue((Math.random() - .05));    
            else throw new RingBufferException("Error: Buffer full");
        }
    }

    /**
     * tic - advances the simulation one time step by applying the Karplus-Strong update:
     * delete the sample at the front of the ring buffer and add to the end of the ring buffer the average
     * of the first two samples, multiplied by the energy decay factor of 0.994.
     * @param none
     * @return void
     */
    public void tic() throws RingBufferException {
        if (!guitarString.isEmpty()) { // Remove the first item if the buffer is not empty
            // Remove the first element, multiply it by 0.994, and add it to the back
            guitarString.enqueue((guitarString.dequeue() * ENERGY_DECAY_RATE));
            timesCalled++; // Update the time
        }
     
        else throw new RingBufferException("Error: Buffer empty");
    }

    /**
     * sample - returns the current sample by returning the value of the item at the front of
     * the ring buffer.
     * @param none
     * @return Double
     */
    public Double sample() {
        return guitarString.peek();
    }

    /**
     * time - return number of tics by returning the total number of times tic() was called.
     * @return int
     */
    public int time() {
        return timesCalled;
    }

    public static void main(String[] args) {
        System.out.println("GuitarString");
    }

}

