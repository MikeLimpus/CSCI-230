

public class GuitarHeroLite {
    public static void main(String[] args) throws RingBuffer.RingBufferException {
    // create two guitar strings, for concert A and C
    double CONCERT_A = 440.0;
    double CONCERT_C = CONCERT_A * Math.pow(1.05956, 3.0);
    GuitarString stringA = new GuitarString(CONCERT_A);
    GuitarString stringC = new GuitarString(CONCERT_C);
    stringA.pluck();
    stringC.pluck();
    stringA.print();
    stringC.print();
    while (true) {

    // check if the user has typed a key; if so, process it
    if (StdDraw.hasNextKeyTyped()) {
    char key = StdDraw.nextKeyTyped();
    if
    (key == 'a') { stringA.pluck(); }
    else if (key == 'c') { stringC.pluck(); }
    }
    // compute the superposition of samples
    double a = stringA.sample();    // Is it you?
    double c = stringC.sample();    // Or you?
    double sample = a + c;
    // play the sample on standard audio
    StdAudio.play(sample);
    // advance the simulation of each guitar string by one step
    stringA.tic();
    stringC.tic();
    //stringA.print();
    //SstringC.print();
    }
    }
    }