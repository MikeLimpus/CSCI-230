/**
 * @author Jonathan Limpus
 * CSCI-230
 * Lab: Maps
 * 
 * Driver program for UnsortedTableMap
 */

package net.datastructures;

public class UnsortedTableMapDriver {
    public static void main(String args[]) {
        UnsortedTableMap<Integer, String> map = new UnsortedTableMap<>();
        // Add some stuff
        map.put(0, "The");
        map.put(1, "Quick");
        map.put(2, "Brown");
        map.put(3, "Fox");
        
        map.putIfAbsent(4, "Jumps Over");   // Should add just fine
        map.putIfAbsent(2, "The Lazy Dog"); // Should not add
    }
}