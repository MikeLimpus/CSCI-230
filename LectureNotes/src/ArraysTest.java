// 1/30/20
// Shows some methods of the Arrays class
import java.util.Arrays;
import java.util.ArrayList;
public class ArraysTest{
    public static void main(String args[]) {
        //Declares/Defines array
        int[] intArray = new int[] {9, 3, 77, 4, 2, 1 ,8, 3, 7, 10}; 
        int[] intArray2 = new int[] {9, 3, 77, 4, 2, 1 ,8, 3, 7, 10}; 
        System.out.println("Original " + Arrays.toString(intArray));
        System.out.println("Equals " + Arrays.equals(intArray, intArray2));
        Arrays.sort(intArray);
        System.out.println("Sorted " + Arrays.toString(intArray));

        int[] fillArray = new int[10];
        System.out.println(Arrays.toString(fillArray));
        Arrays.fill(fillArray, 10);
        System.out.println(Arrays.toString(fillArray));

        //ArrayList - Statically sized, for dynamic use ArrayList<T>

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.remove(0);           // Remove the item at index 0, shift to the left by one 
        stringList.remove("Hello");     // Remove the first instance of "Hello"

        stringList.clear();             // Remove all elements
        stringList.contains("Hello");   // Returns t/f


    }
}