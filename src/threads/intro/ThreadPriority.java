package threads.intro;


//In a Multi threading environment,
// thread scheduler assigns processor to a thread based on priority of thread.
// Whenever we create a thread in Java, it always has some priority assigned to it. Priority can either be given by JVM while creating the thread or it can be given by programmer explicitly.
//Accepted value of priority for a thread is in range of 1 to 10. There are 3 static variables defined in Thread class for priority.

//public static int MIN_PRIORITY: This is minimum priority that a thread can have. Value for this is 1.
//public static int NORM_PRIORITY: This is default priority of a thread if do not explicitly define it. Value for this is 5.
//public static int MAX_PRIORITY: This is maximum priority of a thread. Value for this is 10.
//Get and Set Thread Priority:
//
//public final int getPriority(): java.lang.Thread.getPriority() method returns priority of given thread.
//public final void setPriority(int newPriority): java.lang.Thread.setPriority() method changes the priority of thread to the value newPriority. This method throws IllegalArgumentException if value of parameter newPriority goes beyond minimum(1) and maximum(10) limit.

public class ThreadPriority extends Thread {
    @Override
    public void run() {
        System.out.println(ThreadPriority.currentThread().getName());
    }

    public static void main(String[] args)
    {
        ThreadPriority t1 = new ThreadPriority();
        ThreadPriority t2 = new ThreadPriority();
        ThreadPriority t3 = new ThreadPriority();

        // Default 5
        System.out.println("t1 thread priority : "+ t1.getPriority());

        // Default 5
        System.out.println("t2 thread priority : "+ t2.getPriority());

        // Default 5
        System.out.println("t3 thread priority : "+ t3.getPriority());

        ///burda priority yok
        //t1.start();
        //        t2.start();
        //        t3.start();

        t1.setPriority(2);//son calısacak
        t2.setPriority(5);
        t3.setPriority(8);//ilk calısacak

        // t3.setPriority(21); will throw
        // IllegalArgumentException

        // 2
        System.out.println("t1 thread priority : "+ t1.getPriority());

        // 5
        System.out.println("t2 thread priority : "+ t2.getPriority());

        // 8
        System.out.println("t3 thread priority : "+ t3.getPriority());


        t1.start();
        t2.start();
        t3.start();
        // Main thread

        // Displays the name of
        // currently executing Thread
        System.out.println("Currently Executing Thread : "+ Thread.currentThread().getName());

        System.out.println("Main thread priority : "+ Thread.currentThread().getPriority());

        // Main thread priority is set to 10
        Thread.currentThread().setPriority(10);

        System.out.println( "Main thread priority : "+ Thread.currentThread().getPriority());
    }
}
