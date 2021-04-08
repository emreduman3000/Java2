package threads.synchronization;


public class Un_Synchronization
{
    public static void main(String args[]){
        Table obj = new Table();//only one object
        MyThread1 t1=new MyThread1(obj);
        MyThread2 t2=new MyThread2(obj);
        t1.start();
        t2.start();

    }
}


class MyThread1 extends Thread{
    Table t;
    MyThread1(Table t){
        this.t=t;
    }
    @Override
    public void run(){
        //t.unsynchronizedTable(5);
        //t.synchronizedTable(5);
        //t.synchronizedBlockTable(5);
        Table.staticSynchronizedTable(5);
    }

}
class MyThread2 extends Thread{
    Table t;
    MyThread2(Table t){
        this.t=t;
    }
    @Override
    public void run(){
        //t.unsynchronizedTable(100);
        //t.synchronizedTable(100);
        //t.synchronizedBlockTable(100);
        Table.staticSynchronizedTable(100);
    }
}