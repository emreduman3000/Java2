package dataStructures_Algorithms.algorithms.bigOnotation;

public class ExponentialTimeAlgorithms {
    public static void main(String[] args) {
        //8. Exponential Time Algorithms – O(kn)
        //Now we are getting into dangerous territory; these algorithms grow in proportion to some factor exponentiated by the input size.
        //
        //For example, O(2n) algorithms double with every additional input. So, if n = 2, these algorithms will run four times; if n = 3, they will run eight times (kind of like the opposite of logarithmic time algorithms).
        //
        //O(3n) algorithms triple with every additional input, O(kn) algorithms will get k times bigger with every additional input.
        //
        //Let's have a look at a simple example of an O(2n) time algorithm:
        //
        int n=5;
        for (int i = 1; i <= Math.pow(2, n); i++){
            System.out.println("Hey - I'm busy looking at: " + i);
        }
        //This algorithm will run 28 = 256 times.

    }
}
