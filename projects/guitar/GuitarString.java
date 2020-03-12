/**
 * Jonathan Limpus
 * Project 2 - Guitar
 * CSCI-230
 * 
 * GuitarString - Models a vibrating guitar string 
 */

public class GuitarString {
    // Instance Variables 
    private int samplingRate;
    private int baseSamplingRate = 44100;

    /** 
     * Create a guitar string of the argument frequency, using a sampling rate of 
     * 44,000 by creating a <b>RingBuffer</b> instance of the desired capacity
     * <i>N</i>, Where <i>N</i> = ceiling((sampling rate 44100) / frequency) 
     * @param Double frequency
     */

    public GuitarString(Double frequency) {
        int N = (int)Math.ceil((baseSamplingRate / frequency));
        RingBuffer guitarString = new RingBuffer(N);
    }

    /**
     * Creates a guitar string whose size and initial values are given
     * by the array by creating a <b>RingBuffer</b> of capacity equal to the size of the array, and initializes
     * the contents of the buffer to the values in the array.
     * 
     * @param Double[] init
     */
    public GuitarString(Double[] init) {
        RingBuffer guitarString = new RingBuffer(init.length);
        try {
            for(int i = 0; i < init.length; i++) {
                guitarString.enqueue(init[i]);
            }
        } catch (RingBufferException e) {

        }
    }

}