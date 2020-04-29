/**
 * @author Jonathan Limpus 
 * CSCI-230 
 * Project: Huffman Encoding
 * 
 */

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class HuffModel implements IHuffModel {
    // Global variables
    String WINDOW_TITLE = "Huffman Compression";
    HuffViewer viewer = new HuffViewer(WINDOW_TITLE);

    /**
     * @author Jonathan Limpus
     * @param 
     * initialize 
     */
    @Override
    public void initialize(InputStream stream) {
       
    }

    @Override
    public void showCodings() {
        // TODO Auto-generated method stub

    }

    @Override
    public void showCounts() {
        // TODO Auto-generated method stub

    }



    @Override
    public void write(InputStream stream, File file, boolean force) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setViewer(HuffViewer viewer) {
        // TODO Auto-generated method stub

    }

    @Override
    public void uncompress(InputStream in, OutputStream out) {
        // TODO Auto-generated method stub

    }


}