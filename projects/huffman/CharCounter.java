import java.io.IOException;
import java.io.InputStream;

public class CharCounter {
    // Instance variables 
    private static int charIndices[] = new int[256];

    public int getCount(int ch) {
        // TODO rewrite to be more legible 
        return ((ch > 0) && (ch < 255)) ? charIndices[ch] : -1;
    }
    /**
     * countAll - count all the chars in an input stream
     * @param InputStream 
     * @return integer value of all characters, or -1 if exception is thrown
     * @throws IOException
     */
    public static int countAll(InputStream stream) throws IOException {
        BitInputStream bits = new BitInputStream(stream);
        int walk = 0;
        int count = 0;
        boolean stop = false;

        try {
            while(stop == false) {     
                walk = bits.read();
                if(walk==-1) break;
                charIndices[walk]++;
                count++;
            }
            bits.close();           // Close the input streams
            stream.close();
            return count;
        }
        catch(IOException e) {
            e.printStackTrace();
            bits.close();           // Close the input streams
            stream.close();
            return -1;               // return -1 if it didn't work
        }
        
    }
    


    /**
     * add - Update state to record an occurance of specified char/chunk
     * @param chunk 
     */
    public static void add(int chunk) {
        if((chunk > 0) && (chunk <= 255))
            charIndices[chunk]++;
    }
    /**
     * Set the value/count associated with a specific character/chunk.
     * @param chunk is the chunk/character whose count is specified
     * @param value is # occurrences of specified chunk
     */
    public static void set(int chunk, int value) {
        if((chunk >= 0) && (chunk <= 255))  //Check to make sure the chunk param is in range
            charIndices[chunk] = value;
    }

    /**
     * empty out the array charIndices
     */
    public static void clear() {
        for(int i: charIndices) {
            charIndices[i] = 0;
        }
    }

    /**
     * clone - return an identical array to charIndices <p>
     * <b> NOTE </b> this should be called <i>after</i> countAll()
     * @return an identical array to charIndices, which is the underlying data structure
     */
    // TODO this might be broken
    public static int[] copy() {
        return charIndices.clone();
        // int clonedArray[] = new int[charIndices.length];
        // for(int i : charIndices)
        //     clonedArray[i] = charIndices[i];
        // return clonedArray;
    }

}