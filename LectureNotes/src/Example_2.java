
public class Example_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "Hello"; 
		
		StringBuilder sb = new StringBuilder();
		sb.append('P');
		for(int i = 1; i < str1.length(); i++) {
			sb.append(str1.charAt(i));
		}
		System.out.println("New String: " + sb.toString());
		
	}

}
