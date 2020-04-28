package LabPriorityQueue;
public class MaxPriorityQueueDriver {
    public static void main(String args[]) {
        MaxPriorityQueue<Integer, String> maxPQ = new MaxPriorityQueue<>();

        maxPQ.insert(4, "Fox");
        maxPQ.insert(2, "The");
        maxPQ.insert(3, "Quick");
        maxPQ.insert(1, "I Don't Belong Here");

        maxPQ.removeMax();

        System.out.println("The max is: " + maxPQ.max().getValue());
    }
}