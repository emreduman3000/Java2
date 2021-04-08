package threads.producerConsumerProblem;


import java.lang.Thread;


//Multi-Threading in Java:
// In computing, the producer-consumer problem (also known as the bounded-buffer problem) is a classic example of a multi-process synchronization problem.
// The problem describes two processes, the producer and the consumer, which share a common, fixed-size buffer used as a queue.
//
//The producer’s job is to generate data, put it into the buffer, and start again.
//At the same time, the consumer is consuming the data (i.e. removing it from the buffer), one piece at a time.
//In this problem, we need two threads, Thread t1 (produces the data) and Thread t2 (consumes the data). However, both the threads shouldn’t run simultaneously.
class Test2 {
    public static void main(String args[])
    {
        // Initially, there needs to be some data
        // in order to consume the data. So,
        // Producer object is created first
        Producer2 p = new Producer2();

        // Sending this producer object
        // into the consumer
        Consumer2 c = new Consumer2(p);

        // Since from the producer object,
        // we have already produced the data.
        // So, we start by consuming it.

        c.start();
        p.start();
        //Produced 0
        //Produced 1
        //Produced 2
        //Produced 3
        //Buffer is FUll
        //0 1 2 3
        //Buffer is Empty
    }
}

// Producer class which extends the
// thread
class Producer2 extends Thread {

    // Creating a string buffer
    StringBuffer buffer;


    // Initializing the string buffer
    Producer2()
    {
        buffer = new StringBuffer(4);
    }

    // Overriding the run method
    public void run()
    {
        synchronized (buffer)
        {

            // Adding the data into the
            // buffer
            for (int i = 0; i < 4; i++) {
                try {
                    buffer.append(i);
                    System.out.println("Produced " + i);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // Notifying the buffer
            System.out.println("Buffer is FUll");
            buffer.notify();
        }
    }
}

// Consumer class which extends
// the thread
class Consumer2 extends Thread {

    // Creating the object of the
    // producer class
    Producer2 p;

    // Assigning the object of the
    // producer class
    Consumer2(Producer2 temp)
    {
        p = temp;
    }

    // Overriding the run method
    public void run()
    {

        // Controlling the access of the
        // buffer to the shared producer
        synchronized (p.buffer)
        {
            try {
                p.buffer.wait();//producer waits
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            // Printing the values of the string buffer
            // and consuming the buffer
            for (int i = 0; i < 4; i++) {
                System.out.print(p.buffer.charAt(i) + " ");//readding
            }
            System.out.println("\nBuffer is Empty");
        }
    }
}
