import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.Collections;
/**
 * Jonathan Limpus
 * CSCI-230
 * Project 4: Plagiarism Detection
 * RedBlack: Create a red black tree using java's TreeMap class, adding some useful features specifically for 
 * reading files. 
 */
import java.util.TreeMap;
import java.util.Scanner;
import java.util.LinkedList;
import java.io.File;

public class RedBlack extends TreeMap<Integer, Document> {

    private File folder;

   /** 
    * RedBlack - The tree nodes should contain an integer key which represents the amount of hits for that file,
    * and the file itself 
    */
    public RedBlack() {
        super();
    }

    /**
     * print - print the contents of the tree
     */
    public void print() {
        Collection<Document> value = super.values();
        System.out.println(value.toString());
    }

    // public void generateTree(String dir) {
    //     long tStart = System.currentTimeMillis();
    //     File folder = new File("CS230-data/docs2000/");
    //     File listOfFilesArray[] = folder.listFiles();
    //     LinkedList<File> listOfFiles = new LinkedList<File>(Arrays.asList(listOfFilesArray));
    //     try {
    //         Integer i = Integer.valueOf(0);
    //         for(File f : listOfFiles) {
    //             //if (f.isFile()) {
    //                 Scanner fileRead = new Scanner(f);
    //                 //Integer i = Integer.valueOf(0);
    //                 System.out.println(f.getName());
    //                 put(i.intValue(), f);
    //                 // while(fileRead.hasNext()) {
                    
    //                 //     String read = fileRead.next();
    //                 //     treeMap.put(i.intValue(), read);
    //                 i++;
    //                 // }
    //                 fileRead.close();
    //             //}
    //         }   
    //     } catch (FileNotFoundException e) {
    //         e.printStackTrace();
    //     }
    // }

    public void readFile(String inputFile) /* throws FileNotFoundException  */{
        //try {
            

        /* } catch(FileNotFoundException e) {
            System.out.println("ERROR: File '" + inputFile + "' not found");
            e.printStackTrace();
        } */
    }
}