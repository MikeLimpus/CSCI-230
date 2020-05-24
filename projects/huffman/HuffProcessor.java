/**
 * HuffProcessor - This method handles the actual Huffman Compression and Decompression <p>
 * This method is based on <a href=
 *         "https://www2.cs.duke.edu/csed/poop/huff/spring05/code/SimpleHuffProcessor.java">SimpleHuffProcessor.java</a>
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class HuffProcessor {

    private HuffViewer viewer;

    /**
     * This method gets everything ready for compression, calling all needs methods and data structures from 
     * <li> HuffTree 
     * <li> CharCounter
     * <li> HuffEncode
     * @param in
     * @return charCount from the input
     * @throws IOException
     */
    public int preprocessCompress(InputStream in) throws IOException {
        try {
            int charCount = CharCounter.countAll(in);                   // Count all of the characters in the file
            int count[] = CharCounter.copy();                           // Get our count array from CharCounter
            HuffTree tree = new HuffTree();                             // Create the huffman tree object
            tree.build(count);                                          // Now build the tree 
            HuffEncode.huffEncode(tree.getRoot());                      // Encode the tree
            return charCount;
        } catch(IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
    /**
     * perform the actual file compression 
     * @param in
     * @param out
     * @param force
     * @return 
     * @throws IOException
     */
    public int compress(InputStream in, OutputStream out, boolean force) throws IOException {
        int walk = 0;
        int count = 0;
        char codeCheck = ' ';
        String codeMap[] = HuffEncode.binaryString;                     // Our input, taken from HuffEncode
        String emptyString = "";
        String codeLength = "";
        BitInputStream  bIn = new BitInputStream(in);
        BitOutputStream bOut = new BitOutputStream(out);

        
        // At the top of the file, write the array codeMap[]
        out.write(32);                                                  // Write a space in the very beginning
        for(int i = 0; i < codeMap.length; i++) {
            // Set the initially empty string to be equal to the string at i
            emptyString = codeMap[i];
  
            if(emptyString == null)                                     // If the string is null, set it to the string "0"
                emptyString = "0";
            
            codeLength += emptyString.length();                         // get the length of the string 
            bOut.writeBits(8, Integer.valueOf(codeLength));             // write out the length of the string
            codeLength = "";                                            // re-initialize the length of the string to ""
            // Write the value of the character
            bOut.writeBits(emptyString.length(), Integer.parseInt(emptyString, 2));
            out.write(32);                                              // Write a space
        }
        out.write(10);

        boolean go = true;                                              // Loop toggle

        try {
            while(go == true) {
                walk = bIn.read();                                      // Read eight bits
                if (walk != -1) {                                    
                    codeCheck = (char) walk;                            // cast binary string to a char
                    
                    emptyString = codeMap[codeCheck];                   // check for the huffman code
                    // write out the code and flush the bitstream, as long as it is not a null pointer
                    if(!(emptyString == null)) {
                        // parseInt(String, 2) will parse a string as binary number
                        bOut.writeBits(emptyString.length(), Integer.parseInt(emptyString, 2));
                        count += 8;                                     // Increase the count by one byte
                    }
                }
                else go = false;
            }
            // Close our bit streams to prevent a memory leak
            bOut.close();
            bIn.close();
            return count;       
        } catch (IOException e) {                           
            // print the stack trace and return -1 if an error is found
            e.printStackTrace();      
            bOut.close();
            bIn.close();                               
            return -1; 
        }
        
    }
    /**
     * Uncompress a created hufmman (.hf) file
     * @param in
     * @param out
     * @return 0
     * @throws IOException
     */
    public int uncompress(InputStream in, OutputStream out) throws IOException {
        int count = 0;
        int code = 0;
        String decode[] = new String[256];
        BitInputStream bIn = new BitInputStream(in);
        StringBuilder coded = new StringBuilder(0);
        
        
        count = in.read();
        if(count != 32){
            bIn.close();
            return -1;
        }
        
        for (int i = 0; i < decode.length; i++) { 
            count = bIn.read();

            for (int j = 0; j < count ; j++) 
                coded.append(bIn.readBits(1));
            
            decode[i] = coded.toString();
            coded = new StringBuilder(0);
        }

        for (int i = 0; i < decode.length; i++) 
            if(decode[i].equals("00000000"))
                decode[i] = null;
            
        boolean go = true;

        try {
            coded = new StringBuilder(0);
            while (go == true) { 

                code = bIn.readBits(1);

                if(code != -1){
                    coded.append(String.valueOf(code));
                    for (int i = 0; i < decode.length; i++) {
                        if(decode[i] != null){
                            if(decode[i].equals(coded.toString())){
                                out.write(i);
                                System.out.print(coded.toString());
                                coded = new StringBuilder(0);
                            }
                        }
                    }
                }
                else go = false;        
            }
        } catch (IOException e){
            e.printStackTrace();
            bIn.close();
        }

        bIn.close();
        return 0;
    }
    
    /**
     * Prepare the viewer
     * @param viewer
     */
    public void setViewer(HuffViewer viewer) {
        this.viewer = viewer;
    }

    private void updateView(String s) {
        viewer.update(s);
    }
}