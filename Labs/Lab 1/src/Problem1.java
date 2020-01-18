import java.util.Scanner;
public class Problem1 {
	/*
	 *  Given an integer number n, return the  difference
	 *  between  the  product  of  its  digits  and  
	 *  the  sum  of  its  digits.   Write  both  an 
	 *  iterative  and  a recursive solution
	 */
		private static int digitsIterative() { 
		int foo = 0;
		int bar = 1; 	//Don't wanna multi by 0
		int fee = 0;
		Scanner input = new Scanner(System.in);
		String n = input.nextLine(); //Input the "integer as a string"
		int[] digits = new int[n.length()]; //create an array of ints for each digit
		for (int i = 0; i < n.length(); i++) { //Cast each "digit" as an integer
			digits[i] = Character.getNumericValue(n.charAt(i)); //Grab char from string, convert char to in
		}	//We now have an array of digits corresponding to our string
		for (int i = 0; i < digits.length; i++) 
			foo = foo * digits[i];
		for (int i = 0; i < digits.length; i++)
			bar = bar + digits[i];
		fee = foo - bar; 
		return foo;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please input an integer: ");
		System.out.println(digitsIterative()); 
		
	}

}
