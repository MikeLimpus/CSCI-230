import java.util.Scanner;
import java.util.Vector;
//import stdlib.StdDraw;

public class Multithreading {

	public static void main(String[] args) {
		
		StdDraw.setXscale(0,100);
		StdDraw.setYscale(0,10);
		StdDraw.enableDoubleBuffering();
		
		Vector<Double> values = new Vector<Double>(100);
		for(int i = 0; i < 100; ++i)
			values.add(5.0);
		
		Thread t = null;
		
		t = new Thread(
				new Runnable() {
					@Override
					public void run() {
						
						int counter = 0;
						
						while(true) {
							StdDraw.clear();
							for(int i = 0; i < values.size() - 1; ++i)
								StdDraw.line(i, values.get(i), i+1, values.get(i+1));
							StdDraw.show();
						
							if(counter == 0) {
								values.remove(0);
								values.add(0.0);
						}
						counter++;
						counter %= 5;
				}
			}
		});
		
		t.start();
		
		Scanner in = new Scanner(System.in);
		double x;
		while(true) {
			System.out.print("Enter value: ");
			x = in.nextDouble();
			values.remove(0);
			values.add(x);
		}
	}
}
