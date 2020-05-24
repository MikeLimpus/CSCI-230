/**
 * @author Jonathan Limpus
 * The main entry point for our application, this creates the HuffViewer window and initializes the huffman processor
 */

import javax.swing.*;
public class HuffDriver {
    
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException,
    IllegalAccessException, UnsupportedLookAndFeelException  {
        HuffViewer view = new HuffViewer("Huffman Encoding");
        view.setLookAndFeel();
        HuffProcessor process = new HuffProcessor();
        view.setModel(process);
    }
}
    
