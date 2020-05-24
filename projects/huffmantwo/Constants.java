public class Constants {
    public byte alphabet[] = new byte[95];     // There are 95 representable ascii characters between 'tab' & '~'

    public Constants() {
        createArray();
    }

    public void createArray() {
        for(byte i = 0; i < alphabet.length; i++) {
            alphabet[i] = i;   
        }
    }
    
}

