package threads.synchronization;

//Synchronization in Java
    //Synchronization in java is the capability to control the access of multiple threads to any shared resource.
    //
    //Java Synchronization is better option where we want to allow only one thread to access the shared resource.

//Why use Synchronization
    //The synchronization is mainly used to
    //
    //To prevent thread interference.
    //To prevent consistency problem.

//Types of Synchronization
    //There are two types of synchronization
    //
    //Process Synchronization
    //Thread Synchronization
    //Here, we will discuss only thread synchronization.

//Thread Synchronization
//There are 2 types of thread synchronization mutual exclusive and inter-thread communication.
//
    //Mutual Exclusive:Mutual Exclusive helps keep threads from interfering with one another while sharing data. This can be done by three ways in java:
        //Synchronized method.
        //Synchronized block.
        //static synchronization.

    //Cooperation (Inter-thread communication in java)

import threads.intro.Thread02;

//her Thread'in kendi Stack memory'si vardır,Processs'in heap alanını orak kullanırlar
public class SynchronizationThread
{
    public static void main(String[] args) {
        Printer printer=new Printer(6);

        Thread emre= new Person(printer);
        emre.setName("emre");
        Thread beyza= new Person(printer);
        beyza.setName("beyza");

        emre.start();
        beyza.start();

    }



}

class Printer
{
    private int documentAmount;
    private int i;//process'in heap alanında degisken atadım. her thread gıdıp ortak i yi kullanıcak print2()'de

    public Printer(int documentAmount){
        this.documentAmount=documentAmount;
    }

    public void print(){
        for(int i=documentAmount; i>0 ; i--){//burada i diye bir degişken atanıyor
            // herseferinde i kutucuguna stackte yeni bir value atanıyor.
            if(Thread.currentThread().getName().equals("emre"))
                System.out.println(Thread02.Blue + "Document no: "+ i + "Thread name: "+Thread.currentThread().getName());
            else
                System.out.println(Thread02.Yellow + "Document no: "+ i + "Thread name: "+Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public  void print2(){
        for( i=documentAmount; i>0 ; i--){
            if(Thread.currentThread().getName().equals("emre"))
                System.out.println(Thread02.Blue + "Document no: "+ i + " - Thread name: "+Thread.currentThread().getName());
            else
                System.out.println(Thread02.Yellow + "Document no: "+ i + " - Thread name: "+Thread.currentThread().getName());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public  synchronized void print3(){//bu methoda ilk ulasan thread işlem yapsın
        //o sırada diger threadler beklesin
        for( i=documentAmount; i>0 ; i--){//burada i diye bir degişken atanıyor
            // herseferinde i kutucuguna stackte yeni bir value atanıyor.
            if(Thread.currentThread().getName().equals("emre"))
                System.out.println(Thread02.Blue + "Document no: "+ i + "Thread name: "+Thread.currentThread().getName());
            else
                System.out.println(Thread02.Yellow + "Document no: "+ i + "Thread name: "+Thread.currentThread().getName());
        }
    }

    public void print4()
    {
        //methodun hepsinin değilde sadece belli bir bölümünü synchronized yapmak ıcın  kullanılır
        synchronized (this)
        {
            for( i=documentAmount; i>0 ; i--){
                if(Thread.currentThread().getName().equals("emre"))
                    System.out.println(Thread02.Blue + "Document no: "+ i + "Thread name: "+Thread.currentThread().getName());
                else
                    System.out.println(Thread02.Yellow + "Document no: "+ i + "Thread name: "+Thread.currentThread().getName());
            }
        }
    }
}

class Person extends Thread{

    private Printer printer;

    public Person(Printer printer){
        this.printer=printer;
    }


    @Override
    public void run() {
        //printer.print();
        // Document no: 6Thread name: beyza
        // Document no: 6Thread name: emre
        // Document no: 5Thread name: beyza
        // Document no: 5Thread name: emre
        // Document no: 4Thread name: beyza
        // Document no: 4Thread name: emre
        // Document no: 3Thread name: beyza
        // Document no: 3Thread name: emre
        // Document no: 2Thread name: emre
        // Document no: 2Thread name: beyza
        // Document no: 1Thread name: emre
        // Document no: 1Thread name: beyza

        //printer.print2();
        //Document no: 6 - Thread name: beyza
        // Document no: 6 - Thread name: emre
        // Document no: 5 - Thread name: beyza
        // Document no: 4 - Thread name: emre
        // Document no: 3 - Thread name: beyza
        // Document no: 2 - Thread name: emre
        // Document no: 1 - Thread name: beyza

        //printer.print3();
        // Document no: 6Thread name: beyza
        //        // Document no: 5Thread name: beyza
        //        // Document no: 4Thread name: beyza
        //        // Document no: 3Thread name: beyza
        //        // Document no: 2Thread name: beyza
        //        // Document no: 1Thread name: beyza
        //        // Document no: 6Thread name: emre
        //        // Document no: 5Thread name: emre
        //        // Document no: 4Thread name: emre
        //        // Document no: 3Thread name: emre
        //        // Document no: 2Thread name: emre
        //        // Document no: 1Thread name: emre

        printer.print4();
        // Document no: 6Thread name: emre
        // Document no: 5Thread name: emre
        // Document no: 4Thread name: emre
        // Document no: 3Thread name: emre
        // Document no: 2Thread name: emre
        // Document no: 1Thread name: emre
        // Document no: 6Thread name: beyza
        // Document no: 5Thread name: beyza
        // Document no: 4Thread name: beyza
        // Document no: 3Thread name: beyza
        // Document no: 2Thread name: beyza
        // Document no: 1Thread name: beyza
    }
}

