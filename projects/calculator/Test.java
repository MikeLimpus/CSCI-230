package projects.calculator;
// This is how you parse a string to create substrings between spaces
import java.util.Arrays;
public class Test{
    public static void main(String args[]) {
        String foo = "4 + 1";
        String bar[] = foo.split(" ");

        System.out.println(foo);
        System.out.println(Arrays.toString(bar));


    }
}
