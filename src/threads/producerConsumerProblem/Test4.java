package threads.producerConsumerProblem;

import java.lang.Thread;


// Modified Producer Consumer’s Problem:
// The above approach can further be improved because the same buffer is being used by the producer and the consumer. So, instead of using multiple threads, use one thread such that initially, the buffer is empty and thread that was created acts as a producer. Once the buffer is full, this thread acts as a consumer and consumes the data. However, we need to avoid deadlock.
//
//        Recommended: Please try your approach on {IDE} first, before moving on to the solution.
//        Below is the implementation of the above approach:

// Main class to implement the
// Producer Consumer problem
public class Test4 {
    public static void main(String args[])
    {

        // Creating the object of the
        // producer
        Producer4 p = new Producer4();
    }
}

// Java program to implement the
// producer consumer's problem
// using single thread

// Producer class which extends the
// thread
class Producer4 extends Thread {

    // Creating a string buffer
    StringBuffer buffer;

    // Variable to avoid the deadlock
    boolean dp = false;
    Thread t1;
    Producer4()
    {
        // Initializing the buffer
        buffer = new StringBuffer(4);

        // Creating a new thread with
        // the current object
        t1 = new Thread(this);
        t1.start();
    }

    // Overriding the run method
    public void run()
    {

        // Loop to produce the
        // data and add it to
        // the buffer
        for (int i = 0; i < 4; i++) {
            try {
                buffer.append(i);
                System.out.println("Produced " + i);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Buffer is FUll");

        // Creating a consumer object
        // by passing the current
        // producer object
        Consumer4 c = new Consumer4(this);

        // Reinitializing the thread
        // with the new value of the
        // consumer object
        t1 = new Thread(c);
        t1.start();
    }
}

// Consumer class which extends
// the thread
class Consumer4 extends Thread {
    Producer4 p;

    // Constructor to initialize
    // with the producer object
    Consumer4(Producer4 temp)
    {
        p = temp;
    }

    // Overriding the run method
    public void run()
    {
        try {

            // Loop to print the buffer and
            // consume the values
            for (int i = 0; i < 4; i++) {
                System.out.print(p.buffer.charAt(i) + " ");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\nBuffer is Empty");
    }
}

