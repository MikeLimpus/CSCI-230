import java.util.Scanner;
public class Example_1 {
	static Scanner input = new Scanner(System.in);
	
	private static String promptString(String prompt) {
		System.out.print(prompt);
		return input.nextLine();
	}
	
	public static void main(String args[]) {		
		System.out.println("Hello, " + promptString("Enter your name"));
		input.close();
		}
	}
