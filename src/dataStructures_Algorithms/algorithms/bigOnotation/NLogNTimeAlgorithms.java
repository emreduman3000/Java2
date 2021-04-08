package dataStructures_Algorithms.algorithms.bigOnotation;

public class NLogNTimeAlgorithms {
    public static void main(String[] args) {
        //6. N Log N Time Algorithms – O(n log n)
        //n log n is the next class of algorithms. The running time grows in proportion to n log n of the input:

        int n=8;
        for (int i = 1; i <= n; i++){
            for(int j = 1; j < n; j = j * 2) {
                System.out.println("Hey - I'm busy looking at: " + i + " and " + j);
            }
        }
        //For example, if the n is 8, then this algorithm will run 8 * log(8) = 8 * 3 = 24 times. Whether we have strict inequality or not in the for loop is irrelevant for the sake of a Big O Notation.
    }
}
