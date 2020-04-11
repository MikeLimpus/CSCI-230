/**
 * Jonathan Limpus
 * Project 2 - Guitar
 * CSCI-230
 * 
 * GuitarHero -
 * Driver for the Karplus-Strong algorithm
 * Play 37 notes from the chromatic scale between 110Hz to 440hz in real time, 
 * and draw the soundwaves 
 */

public class GuitarHero {
    static double SCALE_MIN = 0.00, SCALE_MAX = 100.0;
    static double BASE_X = 0.0, BASE_Y = 0.5;
    public static void main(String args[]) throws RingBuffer.RingBufferException {
        double BASE_FREQUENCY = 440.0, BASE_MULTIPLIER = 1.05956, BASE_OFFSET = 24.0;     // Constants to calculate freq
        double sample = 0.0, lastSample = 0.0;
        double xPos = BASE_X;
        double counter = 0.0;
        int sampleIndex = 0;
        double delay = 0.0;
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,;/' ";
        char keystroke = 'q';
        GuitarString frequencies[] = new GuitarString[37];  // Create an array of 37 GuitarString objects for each freq
        for(int i = 0; i < frequencies.length; i++) {
            // Create a new GuitarString instance of the frequency defined in the project outline
            frequencies[i] = new GuitarString(BASE_FREQUENCY * (Math.pow(BASE_MULTIPLIER, (i - BASE_OFFSET))));
        }

        initializeDraw();   // Initialize StdDraw as defined below
       

        /*
         * Main Program Loop is as follows:
         * Check if user has typed key > Process it > compute superpostition of samples > play sample > advance tic
         */

        while(true) {
            // Check if user has typed key
            if(StdDraw.hasNextKeyTyped()) {
                keystroke = StdDraw.nextKeyTyped();
                // Process it 
                int index = keyboard.indexOf(keystroke);
                if (index > -1) {// indexOf returns -1 if the char is not found
                    // Pluck the input "string"
                    sampleIndex = index;
                    frequencies[sampleIndex].pluck();
                }
            }
                // Create the sample 
                sample = frequencies[sampleIndex].sample();
            
                // Compute the superpostition of samples 
                for(int i = 0; i < frequencies.length; i++) {
                    sample += frequencies[i].sample();
                }
            
                // Play the sample
                StdAudio.play(sample);
                
                

            if(delay % 5 == 0){ 

                StdDraw.line((xPos), (50 + (lastSample)), (xPos + 1), (50 + (sample * 10)));
                
                if(xPos == 99){
                    StdDraw.show();
                    StdDraw.clear();
                }
                xPos = (xPos + 1) % 100;
                lastSample = sample; 
            }
            
            for(int i = 0; i < frequencies.length; i++) {
                frequencies[i].tic();
            }
            delay++;
        }
    }

    /**
     * initializeDraw - set all values for the needed StdDraw members
     */
    public static void initializeDraw() {
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.setScale(SCALE_MIN, SCALE_MAX);
        StdDraw.enableDoubleBuffering();
    }
    
}