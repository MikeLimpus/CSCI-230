import java.io.IOException;
import java.io.InputStream;

public class CharCounter implements ICharCounter {
    // Instance variables 
    private static int charIndices[] = new int[256];
    @Override
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
    @Override
    public int countAll(InputStream stream) throws IOException {
        int walk = 0;
        int count = 0;

        try {
            while(walk != -1) {     
                walk = stream.read();
                charIndices[walk]++;
                count++;
            }
            return count;
        }
        catch(IOException e) {
            System.out.println(e);
            return -1;              // return -1 if it didn't work
        }
        
    }
    
    /**
     * add - Update state to record an occurance of specified char/chunk
     * @param chunk 
     */
    @Override
    public void add(int chunk) {
        if((chunk > 0) && (chunk <= 255))
            charIndices[chunk]++;
    }
    /**
     * Set the value/count associated with a specific character/chunk.
     * @param chunk is the chunk/character whose count is specified
     * @param value is # occurrences of specified chunk
     */
    @Override
    public void set(int chunk, int value) {
        if((chunk >= 0) && (chunk <= 255))  //Check to make sure the chunk param is in range
            charIndices[chunk] = value;
    }

    /**
     * empty out the array charIndices
     */
    @Override
    public void clear() {
        for(int i: charIndices) {
            charIndices[i] = 0;
        }
    }

    /**
     * clone - invoke Objects.clone() on the array charIndices
     * @return an identical array to charIndices, which is the underlying data structure
     */
    public int[] clone() {
        return charIndices.clone();
    }

}