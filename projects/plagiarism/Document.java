import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

/**
 * @author Jonathan Limpus 
 * CSCI-230 Project: Plagiarism 
 * Document - An abstract data type that represents a potentially suspicious document,
 * including the contents being held as a single string, the file name,
 * and whether or not it is deemed 'suspicious'
 */

public class Document implements Comparable<Document> {
    private String internalString;
    private String fileName;
    private Integer hits = 0;
    private boolean suspicious = false;
    
    public Document() {
        internalString = null;
        hits = 0;
        fileName = null;
    }

    public Document(String internalString, Integer hits, String fileName) {
        this.internalString = internalString;
        this.hits = hits;
        this.fileName = fileName;
    }

    // Accessors 
    public String getString() {return internalString;}
    public Integer getHits() {return hits;}
    public String getFileName() {return fileName;}
    
    // Modifiers
    public void hit() {
        hits++;
    }

    public void isSuspect() {
        suspicious = !suspicious;
    }

    /**
     * fileToString - take an input file and convert it to a single string 
     * @param file
     * @return The input file as a single string
     * @throws IOException
     */
    public static String fileToString(File file) throws IOException {
        return new String(Files.readAllBytes(file.toPath()));
    }

    /**
     * parseWords - return an array of strings separated by the given range, inputted by the user at runtime
     * @return
     * @throws IOException
     */
    public String[] parseWords(int range) throws IOException {
        String strings[] = internalString.split(" -/.,:;()_+");   // Get rid of common symbols
        String parsedString[] = new String[internalString.length() /range];/* [internalString.length() /range];
        String parsedString[] = new String[internalString.length() / range]; */
        for (int i = 0; i < strings.length; i+=range) {
            parsedString[i] = Arrays.copyOfRange(strings, i, i + range).toString().replaceAll(" ,", "");
        }
        
        // for (int i = 0; i < parsedString.length; i++){
        //     parsedString[i] = parsedString[i].toString().replaceAll(" ,", "");
        // }

        return parsedString;
    }

/*     public int compare(Document doc1, Document doc2) {
        if (doc1.hits < doc2.hits)
            return -1;
        else if (doc1.hits == doc2.hits)
            return 0;
        else 
            return 1;
    } */

    public void print() {
        System.out.println("Name: " + fileName);
        System.out.println("Hits:" + hits);
    }

    public void printWithDetail() {
        System.out.println("Name: " + fileName);
        System.out.println("Contents: " + internalString);
        System.out.println("Hits:" + hits);
    }

    @Override
    public int compareTo(Document doc2) {
        return Integer.compare(this.hits, doc2.hits);
    }
}