// Jonathan Limpus Lab 6 02/06/20

public class AlgorithmAnalysis {
    /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
    public static double[] prefixAverage1(double[] x) {
        long startTime = System.nanoTime();
        int n = x.length;
        double[] a = new double[n]; // filled with zeros by default
        for (int j=0; j < n; j++) {
        double total = 0; // begin computing x[0] + ... + x[j]
        for (int i=0; i <= j; i++)
        total += x[i];
        a[j] = total / (j+1); // record the average
        }
        long endTime = System.nanoTime(); // record end time
        long elapsed = endTime - startTime; // compute elapsed time
        System.out.println("TOTAL TIME ELAPSED: " + elapsed);
        return a;
    }
    
    /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
    public static double[] prefixAverage2(double[] x) {
        long startTime = System.nanoTime(); // record start time
        int n = x.length;
        double[] a = new double[n]; // filled with zeros by default
        double total = 0; // compute prefix sum as x[0] + x[1] + ...
        for (int j=0; j < n; j++) {
        total += x[j]; // update prefix sum to include x[j]
        a[j] = total / (j+1); // compute average based on current sum
        }
        long endTime = System.nanoTime(); // record end time
        long elapsed = endTime - startTime; // compute elapsed time
        System.out.println("TOTAL TIME ELAPSED: " + elapsed);
        return a;
    }

    public static void main(String args[]) {
        // Test arrays
        double array1[] = new double[170];
        double array2[] = new double[1700];
        double array3[] = new double[170000];
        double array4[] = new double[340000];
        // Test cases
        System.out.println("Case 1");
        prefixAverage1(array1);
        prefixAverage2(array1);
        System.out.println("Case 2");
        prefixAverage1(array2);
        prefixAverage2(array2);
        System.out.println("Case 3");
        prefixAverage1(array3);
        prefixAverage2(array3);
        System.out.println("Case 4");
        prefixAverage1(array4);
        prefixAverage2(array4);
    }
}