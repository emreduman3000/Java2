package dataStructures_Algorithms.algorithms.bigOnotation;

public class PolynomialTimeAlgorithms {
    public static void main(String[] args) {
        //7. Polynomial Time Algorithms – O(np)
        //Next up we've got polynomial time algorithms. These algorithms are even slower than n log n algorithms.

        //The term polynomial is a general term which contains quadratic (n2), cubic (n3), quartic (n4), etc. functions. What's important to know is that O(n2) is faster than O(n3) which is faster than O(n4), etc.
        //
        //Let's have a look at a simple example of a quadratic time algorithm:

        int n=5;
        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.println("Hey - I'm busy looking at: " + i + " and " + j);
            }
        }
        //This algorithm will run 82 = 64 times. Note, if we were to nest another for loop, this would become an O(n3) algorithm.
    }
}
