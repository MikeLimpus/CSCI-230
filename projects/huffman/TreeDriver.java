import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
public class TreeDriver {
    
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException,
    IllegalAccessException, UnsupportedLookAndFeelException  {
        HuffViewer view = new HuffViewer("Huffman Encoding");
        view.setLookAndFeel();


        HuffProcessor process = new HuffProcessor();
        view.setModel(process);

        
    }
}
    
