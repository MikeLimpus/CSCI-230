/**
 * currently creates a red black tree of all files
 */

//import java.util.TreeMap;
// import java.util.Scanner;
import java.util.LinkedList;
// import java.util.Arrays;
import java.util.Collections;
import java.io.File;
// import java.io.FileNotFoundException;
import java.io.IOException;
// import java.nio.file.Files;
public class PlagiarismDetect {
    //static RedBlack<Integer, String> treeMap = new RedBlack<>();
    static RedBlack fileMap = new RedBlack();
    static LinkedList<Document> documents = new LinkedList<>();
    static LinkedList<Document> suspectDocs = new LinkedList<>();
    

    public static void main(String args[]) {
        if (args.length < 2 ) {
            System.out.println("Please specify a directory, number of n-word sequences, and number of sequences");
            return;
        }
        long tStart = System.currentTimeMillis();                   // Start the timer
        File folder = new File(args[0]);
        int nGrams = Integer.parseInt(args[1]);
        int numberOfSequences = Integer.parseInt(args[2]);
        File listOfFiles[] = folder.listFiles();
        // LinkedList<File> listOfFiles = new LinkedList<File>(Arrays.asList(listOfFilesArray));
        try {
            //Integer i = Integer.valueOf(0);
            System.out.println("Loading files...");
            for(File f : listOfFiles) {
                if (f.isFile()) {
                    //Scanner fileRead = new Scanner(f);
                    //Integer i = Integer.valueOf(0);
                    
                    //fileMap.put(i.intValue(), f);
                    documents.add(new Document(Document.fileToString(f), 0, f.toString()));
                    //i++;
                    //}
                    //fileRead.close();
                }
            }   
        } catch (IOException e) {
            e.printStackTrace();
        }
        LinkedList<String> hits = new LinkedList<>();
        //int j = 0;
        //int check = 0;
        System.out.println("Comparing...");
        //try {
            
            
            // String key = new String();
            for (int j = 0; j < documents.size(); j+= nGrams) {
            //for(Document documents.get(j) : documents) {
                // StringBuilder sb = new StringBuilder(documents.get(j).getString().length());
                String temp = documents.getFirst().getString().substring(j, j + nGrams);
                //String temp[] = documents.get(j).parseWords(nGrams);
                //System.out.println("temp[].length " + temp.length + "\n" + documents.get(j).getString().length());    //TODO
                // for (String t : temp) {
                //     sb.append(t);
                //     key = sb.toString();
                //     System.out.println(key);    //TODO
                // }
                for(int i = 0; i < documents.size(); i++) {
                    if(documents.get(i).getString().contains(temp)) {
                        documents.getFirst().hit();
                    }
                    
                }
                if(documents.getFirst().getHits() >= numberOfSequences) {     
                    documents.getFirst().isSuspect();
                    suspectDocs.add(documents.getFirst());
                }
                //j++;
                //temp = null;
                documents.removeFirst();
            }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        
        Collections.sort(suspectDocs);
        Collections.reverse(suspectDocs);

        //fileMap.print();
/*         for(int i = 0; i < documents.size(); i++)
            documents.get(i).print();
         */
        if(suspectDocs.isEmpty()) {
            System.out.println("No suspicious documents found: plagiarism unlikely.");
            System.out.println("Run again with smaller values to narrow potential results.");
        }
        else {
            System.out.println(suspectDocs.size() + " suspicious documents found with " + numberOfSequences + 
            " or more " + nGrams + "-word combinations. See: ");
            // for(Document d : suspectDocs) {
            //     System.out.println(d.getHits() + " Hits: " + d.getFileName());
            //     System.out.println(hits.toString());
            // }
        }

/*         for(int i = 0; i < fileMap.size(); i++) {
            File temp = fileMap.get(i);
            
        } */


        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;
        System.out.println("It took " + elapsedSeconds + 
            " seconds to read and compare " + listOfFiles.length + " files.");
        System.out.println("At an average rate of " + (tDelta /(long) listOfFiles.length) + "ms per file");
        System.out.println("Sus files " + suspectDocs.size());
        
    }

    // /**
    //  * fileToString - take an input file and convert it to a single string
    //  * @param file
    //  * @return The input file as a single string
    //  * @throws IOException
    //  */
    // public static String fileToString(File file) throws IOException {
    //     return new String(Files.readAllBytes(file.toPath()));
    // }
}



/* File folder = new File("/Users/you/folder/");
File[] listOfFiles = folder.listFiles();

for (File file : listOfFiles) {
    if (file.isFile()) {
        System.out.println(file.getName());
    }
}
 */
