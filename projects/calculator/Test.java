package projects.calculator;
public class Test{
    public static void main(String args[]) {
        String numbers = "10 + 2.0";
        Double array[] = new Double[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            //array[i] = Double.parseDouble(numbers.charAt());
        } 
        //System.out.println(array);
        System.out.println(Double.parseDouble(numbers));
    } 
}