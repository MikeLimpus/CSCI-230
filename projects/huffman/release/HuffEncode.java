/**
 * @author Jonathan Limpus 
 * This class handles the encoding of the HuffTree to prepare it for compression
 */

import java.util.LinkedList;

public class HuffEncode {
    
    private static LinkedList<String> encodedString = new LinkedList<>();
    public static String binaryString[] = new String[256];
    private static StringBuilder encoding;
    /**
     * huffEncode - recursively create an encoded tree full of string-valued 0s and 1s
     * @param node
     */
    public static void huffEncode(Node node) {
        if(node.left != null) {
            // Add a zero to the back and remove 
            encodedString.add("0");
            huffEncode(node.left);
            encodedString.remove(encodedString.size() - 1);
        }
        if(node.right != null) {
            // Add a onr to the back and remove
            encodedString.add("1");
            huffEncode(node.right);
            encodedString.remove(encodedString.size() - 1);
        }

        encoding = new StringBuilder();

        for (int i = 0; i < encodedString.size(); i++) {
            encoding.append(encodedString.get(i));
        }
        

        if(node.getValue() == 257) 
            return; 

        binaryString[node.getValue()] = encoding.toString();
    }
}   