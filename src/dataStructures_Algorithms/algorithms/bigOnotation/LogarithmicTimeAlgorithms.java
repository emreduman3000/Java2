package dataStructures_Algorithms.algorithms.bigOnotation;

public class LogarithmicTimeAlgorithms {
    public static void main(String[] args) {

        //4. Logarithmic Time Algorithms – O(log n)
        //Constant time algorithms are (asymptotically) the quickest. Logarithmic time is the next quickest. Unfortunately, they're a bit trickier to imagine.

        //One common example of a logarithmic time algorithm is the binary search algorithm. To see how to implement binary search in Java, click here.

        //What is important here is that the running time grows in proportion to the logarithm of the input (in this case, log to the base 2):
        int n=8;
        for (int i = 1; i < n; i = i * 2){
            System.out.println("Hey - I'm busy looking at: " + i);
        }
        //If n is 8, the output will be the following:

        //Hey - I'm busy looking at: 1
        //Hey - I'm busy looking at: 2
        //Hey - I'm busy looking at: 4
        //Our simple algorithm ran log(8) = 3 times.
    }
}
