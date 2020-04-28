/**
 * @author Jonathan Limpus 
 * CSCI-230 
 * Lab: Hash Tables
 * Two independent hash functions are computed for each key, and an element is always stored in one of the two cells
 * indicated by those hash functions. When a new element is inserted, if either of those two cells is available, it is 
 * placed there. Otherwise, it is placed into one of its choice of locations, evicting another entry. The evicted entry 
 * is then placed in its alternate choice of cells, potentially evicting another entry. This continues until an open 
 * cell is found or an infinite loop is detected (in which case, two new hash functions are chosen and all entries are 
 * deleted and reinserted). Give a complete map implementation based on this strategy.
 */

import java.util.ArrayList;
public class CuckooHashMap<K,V> extends AbstractHashMap<K,V> {

    private UnsortedTableMap<K,V>[] table;

    /**
     * Constructors inhereit from AbstractHashMap
     */
    public CuckooHashMap() {
        super();
    }

    public CuckooHashMap(int cap) {
        super(cap);
    }

    public CuckooHashMap(int cap, int p) {
        super(cap, p);
    }

    public Iterable<Entry<K,V>> entrySet() {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                for (Entry<K,V> entry : table[i].entrySet()) {
                    buffer.add(entry);
                }
            } 
        }
        return buffer;
    }

    @Override
    protected void createTable() {
        table = (UnsortedTableMap<K,V>[]) new UnsortedTableMap[capacity];
    }

    @Override
    protected V bucketGet(int h, K k) {

        UnsortedTableMap<K,V> bucket = table[h];
        if (bucket == null) return null;
        else return bucket.get(k);

    }

    /**
     * @author Jonathan Limpus 
     * Recursive solution for Cuckoo hash map
     * If there is no value at h %  11, store it there 
     * If there is, try storing at (h / 11) % 11
     * If there is a value there too, try again until an empty spot if found
     * @param int h     Hash value
     * @param K k       Key 
     * @param V v       Value to be stored in the hash map
     * @return V 
     */
    @Override
    protected V bucketPut(int h, K k, V v) { 
        // Hash function 1 
        int hash = h % 11;
        System.out.println("hash = " + hash);
        UnsortedTableMap<K,V> bucket = table[hash];
        if (bucket == null) {
            bucket = table[hash] = new UnsortedTableMap<>();
            int oldSize = bucket.size();
            V answer = bucket.put(k, v);
            n += (bucket.size() - oldSize);
            System.out.println("answer = " + answer + "\nn = " + n);
            return answer;
        }
        else {
            // Hash function 2
            int hashPrime = (h/11) % 11;
            System.out.println("hashPrime = " + hashPrime);
            UnsortedTableMap<K,V> bucketPrime = table[hashPrime];
            if (bucketPrime == null) {
                bucketPrime = table[hashPrime] = new UnsortedTableMap<>();
                int oldSize = bucket.size();
                V answer = bucket.put(k, v);
                n += (bucket.size() - oldSize);
                System.out.println("answer = " + answer + "\nn = " + n);
                return answer;
            } 
            else
                return bucketPut(hashPrime, k, v);
        }
    }

    @Override
    protected V bucketRemove(int h, K k) {
        UnsortedTableMap<K,V> bucket = table[h];
        if (bucket == null) return null;
        int oldSize = bucket.size();
        V answer = bucket.remove(k);
        n -= (oldSize - bucket.size());   // size may have decreased
        return answer;
    }
}