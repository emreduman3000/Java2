package dataStructures_Algorithms.algorithms.bigOnotation;

public class FactorialTimeAlgorithms {
    public static void main(String[] args) {
        //In most cases, this is pretty much as bad as it'll get. This class of algorithms has a run time proportional to the factorial of the input size.

        //A classic example of this is solving the traveling salesman problem using a brute-force approach to solve it.
        //
        //An explanation of the solution to the traveling salesman problem is beyond the scope of this article.
        //
        //Instead, let's look at a simple O(n!) algorithm, as in the previous sections:

        //for (int i = 1; i <= factorial(n); i++){
        //    System.out.println("Hey - I'm busy looking at: " + i);
        //}
        //where factorial(n) simply calculates n!. If n is 8, this algorithm will run 8! = 40320 times.
    }
}
