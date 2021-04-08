package requiredClasses;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.Set;

import static java.lang.System.*;

public class SystemClass
{

    public static void main(String args[]) throws IOException {
        //arraycopy();
        //        getSetProperty();
        //        time();
        //        exit();
        //garbageCollector();
        //getProperties();
        setIn_setOut_setErr();
    }

    static void arraycopy() {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {6, 7, 8, 9, 10};

        //Copies an array
        System.arraycopy(a, 0, b, 2, 2);

        // array b after arraycopy operation
        System.out.println(Arrays.toString(b));
        //[6, 7, 1, 2, 10]
    }

    public static void getSetProperty() {
        // checking specific property
        System.out.println(System.getProperty("user.home"));
        //C:\Users\Emre Duman

        // clearing this property
        clearProperty("user.home");

        System.out.println(System.getProperty("user.home"));
        //null

        // setting specific property
        setProperty("user.home", "home");
        System.out.println(System.getProperty("user.home"));
        //home

        // checking property
        System.out.println(System.getProperty("user.country"));
        //CA

        // checking property other than system property
        // illustrating getProperty(String key, String def)
        System.out.println(System.getProperty("user.password",
                "none of your business"));
        //none of your business

        System.out.println(System.getProperty("user.password"));
        //null
    }

    static void time(){
        System.out.println("difference between the "
                + "current time and midnight,"
                + " January 1, 1970 UTC is: " +
                System.currentTimeMillis());//1613422089648

        System.out.println("cuurent time in "
                + "nano sec: " +
                System.nanoTime());//14407577277000
    }

    static void exit() {
        //static void exit(int status):
        // Terminates the currently running Java Virtual Machine.

        System.gc();
        System.out.println("Garbage collector executed ");

        System.out.println(System.getProperty("os.name"));//Windows 10

        System.exit(1);

        // this line will not execute as JVM terminated
        System.out.println("JVM terminated");

        //The call System.exit(n) is effectively equivalent to the call:
        //Runtime.getRuntime().exit(n)

    }

    static  void garbageCollector() {
        Runtime gfg = Runtime.getRuntime();

        long memory1, memory2;
        Integer integer[] = new Integer[1000];

        // checking the total memeory
        System.out.println("Total memory is: " + gfg.totalMemory());
        //Total memory is: 58720256

        // checking free memory
        memory1 = gfg.freeMemory();
        System.out.println("Initial free memory: " + memory1);
        //Initial free memory: 56623104

        // calling the garbage collector on demand
        System.gc();

        memory1 = gfg.freeMemory();

        System.out.println("Free memory after garbage "
                + "collection: " + memory1);
        //Free memory after garbage collection: 7457624

        // allocating integers
        for (int i = 0; i < 1000; i++)
            integer[i] = new Integer(i);

        memory2 = gfg.freeMemory();
        System.out.println("Free memory after allocation: "
                + memory2);
        //Free memory after allocation: 7373704

        System.out.println("Memeory used by allocation: " +
                (memory1 - memory2));
        //Memeory used by allocation: 83920

        // discard integers
        for (int i = 0; i < 1000; i++)
            integer[i] = null;

        System.gc();//kullanılmayan nesneleri siler

        memory2 = gfg.freeMemory();
        System.out.println("Free memeory after  "
                + "collecting discarded Integers: " + memory2);
        //Free memeory after  collecting discarded Integers: 7417208



    }

    public static void getProperties() {
        //static Properties getProperties(): Determines the current system properties.
        Properties gfg = System.getProperties();
        Set<Object> keySet = gfg.keySet();
        for(Object key : keySet)
        {
            System.out.println("key= " + key);
        }
    }

    public static void setIn_setOut_setErr() throws IOException, FileNotFoundException {
        FileInputStream IN = new FileInputStream("input.txt");
        FileOutputStream OUT = new FileOutputStream("system.txt");

        // set input stream
        System.setIn(IN);
        char c = (char) System.in.read();
        System.out.print(c);

        // set output stream
        System.setOut(new PrintStream(OUT));
        System.out.write("Hi Abhishek\n".getBytes());

        // set error stream
        System.setErr(new PrintStream(OUT));
        System.err.write("Exception message\n".getBytes());
    }
}
