// An example of the class StdDraw

public class TestStdDraw {
    public static void main(String[] args) {
        double baseX = 0.0;
        double baseY = 0.5;
        for(;;) {

            //double randomX = Math.random();
            //double randomY = Math.random();
            StdDraw.setPenRadius(0.005);
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.point(baseX, baseY);
            baseX += 0.0001;
        }
           //StdDraw.setPenColor(StdDraw.MAGENTA);
           //StdDraw.line(0.2, 0.2, 0.8, 0.2);
       }
   }