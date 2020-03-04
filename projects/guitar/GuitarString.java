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
     * 44,000 by creating a RingBuffer instance of the desired capacity N
     * Where N = ceiling((sampling rate 44100) / frequency) 
     */
    public GuitarString(Double frequency) {
        int N = (int)Math.ceil((baseSamplingRate / frequency));
        RingBuffer guitarString = new RingBuffer(N);
    }
}