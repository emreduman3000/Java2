package dataStructures_Algorithms.algorithms.bigOnotation;

public class ConstantTimeAlgorithms {

    public static void main(String[] args) {

        //3. Constant Time Algorithms – O(1)
        //How does this input size of an algorithm affect its running time? Key to understanding Big O is understanding the rates at which things can grow. The rate in question here is time taken per input size.

        //Consider this simple piece of code:

        int n = 1000;
        System.out.println("Hey - your input is: " + n);
        //Clearly, it doesn't matter what n is, above. This piece of code takes a constant amount of time to run. It's not dependent on the size of n.

        //Similarly:

        n = 1000;
        System.out.println("Hey - your input is: " + n);
        System.out.println("Hmm.. I'm doing more stuff with: " + n);
        System.out.println("And more: " + n);
        //The above example is also constant time. Even if it takes 3 times as long to run, it doesn't depend on the size of the input, n. We denote constant time algorithms as follows: O(1). Note that O(2), O(3) or even O(1000) would mean the same thing.
    }
}
