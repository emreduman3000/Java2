package threads.intro;

public class Thread02
{
    public static final String Black  =" \u001b[30m";
    public static final String Red    =" \u001b[31m";
    public static final String Green  =" \u001b[32m";
    public static final String Yellow =" \u001b[33m";
    public static final String Blue   =" \u001b[34m";
    public static final String Magenta=" \u001b[35m";
    public static final String Cyan   =" \u001b[36m";
    public static final String White  =" \u001b[37m";
    public static final String Reset  =" \u001b[0m ";

    public static void main(String[] args)
    {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getId());
        Thread.currentThread().setName("main thread");
        System.out.println(Thread.currentThread().getName());

        //Thread.currentThread().start();//Exception in thread "main" java.lang.IllegalThreadStateException

        // main thread is started automatically by JAVA VM
        //and a THREAD CAN BE ONLY STARTED ONCE.

        MyThread myThread = new MyThread();
        myThread.setName("MY user THREAD");
        myThread.start();
        System.out.println(myThread.getId());


        MyThread02 myThread02 = new MyThread02("MY THREAD022",Thread02.Blue,4);
        myThread02.setName("user thread");
        System.out.println(myThread02.isDaemon());//false
        myThread02.start();
        System.out.println(myThread02.getId());


        //Daemon thread is a low priority thread that runs in background to perform tasks such as garbage collection.
        //Properties:
        //They can not prevent the JVM from exiting when all the user threads finish their execution.
        //JVM terminates itself when all user threads finish their execution
        //If JVM finds running daemon thread, it terminates the thread and after that shutdown itself. JVM does not care whether Daemon thread is running or not.
        //It is an utmost low priority thread.
        MyThread02 myThread03= new MyThread02("THREAD03", Thread02.Cyan,8);
        //I CHANGED VALUES BY TAKEN AS A PARAMETER
        myThread03.setColor(Thread02.Magenta);
        myThread03.setName("Diomand thread");
        myThread03.setDaemon(true);//start() dan önce execute etmeliyiz
        System.out.println(myThread03.isDaemon());//true
        myThread03.start();
        System.out.println(myThread03.getId());

        //main
        //5 Seconds executing starts -  Thread Name:MY THREAD
        //5 Seconds executing starts -  Thread Name:MY THREAD02
        //5 Seconds executing starts -  Thread Name:MY THREAD03
        //5 Seconds executing ends -  Thread Name:MY THREAD
        //5 Seconds executing ends -  Thread Name:MY THREAD02
        //my thread03 un bitmesini beklemedi VM
    }
}

//JAVA VM executes all threads and then finish the program
//JAVA VM MAY NOT WAIT FOR DIOMAND THREAD (EXP: JAVA GARBAGE COLLECTOR THREAD)

class MyThread extends Thread
{
    @Override
    public long getId() {
        return super.getId()+1; //threadin id si ile oynadım
    }

    @Override
    public void run() {
        System.out.println(Thread02.Yellow+ "5 Seconds executing starts - Thread Name:"+currentThread().getName());// Thread.sleep(5000) YELLOW

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread02.Yellow + "5 Seconds executing ends - Thread Name:"+ Thread.currentThread().getName());// Thread.sleep(5000) YELLOW
    }
}

class MyThread02 extends Thread{

    private String color;
    private int sleep;

    public void setColor(String color) {
        this.color = color;
    }

    public MyThread02() {
    }
    public MyThread02(String name, String color,int sleep) {

        super(name);
        this.color = color;
        this.sleep=sleep;
    }

    @Override
    public void run() {
        try {
            System.out.println(color + sleep+" Seconds executing starts - Thread Name:"+currentThread().getName());// Thread.sleep(5000) YELLOW
            setName("user thread - 2");//thread calısırken ismi can be changed

            Thread.sleep(sleep*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(color + sleep+" Seconds executing ends - Thread Name:"+ Thread.currentThread().getName());// Thread.sleep(5000) YELLOW

    }
}
