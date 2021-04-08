package requiredClasses;

import java.io.IOException;

//Java Runtime class
//Java Runtime class is used to interact with java runtime environment.
// Java Runtime class provides methods to execute a process, invoke GC, get total and free memory etc.
// There is only one instance of java.lang.Runtime class is available for one java application.
public class RunTimeClass {
    public static void main(String[] args) {
       //openNotePad();
       //shotDownSystem();
       // restartSystem();


        memoryTest();
        //Total Memory: 58720256
        //Free Memory: 56348312
        //After creating 10000 instance, Free Memory: 56075672
        //After gc(), Free Memory: 7391224



    }

    private static void restartSystem() {
        try {
            Runtime.getRuntime().exec("shutdown -r -t 0");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void memoryTest() {
        Runtime r=Runtime.getRuntime();
        System.out.println("Total Memory: "+r.totalMemory());
        System.out.println("Free Memory: "+r.freeMemory());

        for(int i=0;i<10000;i++){
            new Integer(1);
        }
        System.out.println("After creating 10000 instance, Free Memory: "+r.freeMemory());
        System.gc();
        System.out.println("After gc(), Free Memory: "+r.freeMemory());
    }

    private static void shotDownSystem() {
        try {
            Runtime.getRuntime().exec("c:\\Windows\\System32\\shutdown -s -t 0");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void openNotePad() {
        try {
            Runtime.getRuntime().exec("notepad");//will open a new notepad
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
