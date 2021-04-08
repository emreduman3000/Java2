package threads.producerConsumerProblem;


   // Producer Consumer’s Problem without Synchronization:
//        The above code is inefficient because the CPU resources are not being utilized in an efficient way.
//        The threads are waiting for the buffer in the waiting state. Instead of this, we can utilize these threads in an efficient way by terminating them and creating them again. That is:
//
//        We create a thread to produce the data.
//        Once the buffer is full we will terminate that thread.
//        Create another thread to consume the data(at this point producer thread is dead).
//        Once the buffer is empty, consumer thread terminates and producer thread gets created and produces the data (at this point consumer thread is dead).


// Main class to implement the
// Producer Consumer problem
public class Test3
{
    public static void main(String args[])
    {
        // Producer object is created and
        // passed into the thread.
        Producer3 p = new Producer3();

        // Here, instead of the same
        // thread waiting, a new thread
        // is created in the constructor
        // of the consumer class
        p.start();
    }
}

// Java program to implement the
// producer consumer's problem
// without using synchronization


// Producer class which extends the
// thread
class Producer3 extends Thread {

    // Creating a string buffer
    StringBuffer buffer;

    // Initializing the string buffer
    Producer3()
    {
        buffer = new StringBuffer(4);
    }

    // Overriding the run method
    public void run()
    {
        currentThread().setName("Producer Thread");
        System.out.println(currentThread().getName()+" is working");

        // Loop to add data into the
        // buffer
        for (int i = 0; i < 4; i++) {
            try {
                buffer.append(i);
                System.out.println("Produced " + i);
            }
            catch (Exception e) {

                // Exception is returned when
                // the buffer is not accessible
                e.printStackTrace();
            }
        }
        System.out.println("Buffer is FUll");

        // Creating a consumer object after
        // execution of the above method.
        // Here, this keyword refers to
        // the current object of the
        // producer. This object is passed
        // into the consumer to access the
        // created buffer
        Consumer3 c = new Consumer3(this);

        //main'de böyle yazmak yerine
        //Consumer3 c = new Consumer3(p);
    }
}

// Consumer class which extends
// the thread
class Consumer3 extends Thread {
    Producer3 p;
    Thread t2;

    // Constructor to get the
    // producer object
    Consumer3(Producer3 temp)
    {
        p = temp;

        // Creating a new thread for
        // the object
        t2 = new Thread(this);
        t2.start();
    }

    // Overriding the run method
    public void run()
    {
        currentThread().setName("Consumer" +
                " Thread");
        System.out.println(currentThread().getName()+" is working");
        try {

            // Printing the string buffer and
            // consuming it
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
