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
        //preprocessCompress(in);
        int walk = 0;
        int count = 0;
        char codeCheck = ' ';
        String codeMap[] = HuffEncode.binaryString;
        String emptyString = "";
        String codeLength = "";
        BitInputStream  bIn = new BitInputStream(in);
        BitOutputStream bOut = new BitOutputStream(out);

        
        // Write the code array at the top of the file (Decode, read length of code from 8-bit chunk, use that length to read the code)
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
            //if(!emptyString.equals(""))
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
                    System.out.print(codeCheck);    

                    emptyString = codeMap[codeCheck];                   // check for the huffman code
                    // write out the code and flush the bitstream
                    if(!(emptyString == null)) {
                        bOut.writeBits(emptyString.length(), Integer.parseInt(emptyString, 2));
                        bOut.flush();
                        count += 8;
                    }
                    //System.out.println("Compressing...");
                }
                else go = false;
            }
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

    public int uncompress(InputStream in, OutputStream out) throws IOException {
        // TODO Auto-generated method stub
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