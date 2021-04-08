package threads.synchronization;


public class SynchronizationByAnonymousClass
{
    public static void main(String args[])
    {
        final Table obj = new Table();//only one object

        Thread t1=new Thread(){
            public void run(){
               // obj.unsynchronizedTable(5);
               // obj.synchronizedTable(5);
                //obj.synchronizedBlockTable(5);
                Table.staticSynchronizedTable(5);
            }
        };
        Thread t2=new Thread(){
            public void run(){
               // obj.unsynchronizedTable(100);
               // obj.synchronizedTable(100);
                //obj.synchronizedBlockTable(100);
                Table.staticSynchronizedTable(100);

            }
        };

        t1.start();
        t2.start();
        //5
        //10
        //15
        //20
        //25
        //100
        //200
        //300
        //400
        //500
    }
}