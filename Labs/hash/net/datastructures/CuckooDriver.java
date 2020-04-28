/**
 * @author Jonathan Limpus
 * CSCI-230
 * Lab Hash Map driver program
 * 
 * @param <K>
 * @param <V>
 */
public class CuckooDriver<K,V> extends CuckooHashMap<K,V> {
    public static void main(String args[]) {
        CuckooHashMap<Integer, String> map = new CuckooHashMap<>();
        CuckooHashMap<Integer, String> map2 = new CuckooHashMap<>(30);
        CuckooHashMap<Integer, String> map3 = new CuckooHashMap<>(40, 97);

        map.bucketPut(30, 10, "One");
        map.bucketPut(30, 10, "Two");

        map2.bucketPut(30, 10, "One");
        map2.bucketPut(30, 10, "Two");

        map3.bucketPut(30, 10, "One");
        map3.bucketPut(30, 10, "Two");

    }
}