package threads.producerConsumerProblem;

import threads.intro.Thread02;

public class Test {
    public static void main(String[] args) {
        CommonArea commonArea = new CommonArea();
        Producer producer = new Producer(commonArea);
        Consumer consumer= new Consumer(commonArea);

        producer.setPriority(Thread.MAX_PRIORITY);
        consumer.setPriority(Thread.MIN_PRIORITY);

        producer.start();
        consumer.start();

        //  data which was put by Producer 0
        //  consumer thread reads data 0
        //  data which was put by Producer 1
        //  consumer thread reads data 1
        //  data which was put by Producer 2
        //  consumer thread reads data 2
        //  data which was put by Producer 3
        //  consumer thread reads data 3
        //  data which was put by Producer 4
        //  consumer thread reads data 4
        //  data which was put by Producer 5
        //  consumer thread reads data 5
        //  data which was put by Producer 6
        //  consumer thread reads data 6
        //  data which was put by Producer 7
        //  consumer thread reads data 7
        //  data which was put by Producer 8
        //  consumer thread reads data 8
        //  data which was put by Producer 9
        //  consumer thread reads data 9


    }
}

class CommonArea{
    private int data;
    private boolean isThereData =false;


    public synchronized int readData(){
        while (isThereData ==false){//data var oyuzden loop'a girmez
            try {
                wait();//consumer thread'i bekleyenler havuzuna at
                //wait diyerek synchronized methoda koyudugumuz lock'ı kaldırmıs oluruz

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        isThereData=false;
        notifyAll();
        return data;


    }

    public synchronized void writeData(int data){//0,1,2,3,4,5,6,7,8,9
        while (isThereData ==true){//data varsa
            try {

                wait();//producer threadini wait saloon'a al, loop ends
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.data=data;//veri heap'teki alana yazıldı
        isThereData =true;//veri yazıldı
        notifyAll();//ben veriyi yazdım bekleme havuzndaki veriAlma threadini uyar calıssın dedim


    }
}

class Producer extends Thread{
    //this class put data in commmonArea

    private CommonArea commonArea;

    public Producer(CommonArea c){
        commonArea=c;
    }


    @Override
    public void run() {
        for(int i=0; i<10 ; i++){
            commonArea.writeData(i);//producer sadece writeData() icin calısır
            System.out.println(Thread02.Cyan+" data which was put by Producer " + i);
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread{
    //this class put data in commmonArea

    private CommonArea commonArea;

    public Consumer(CommonArea c){
        commonArea=c;
    }


    @Override
    public void run() {
        int readData;
        for(int i=0; i<10 ; i++){
            readData=commonArea.readData();
            System.out.println(Thread02.Yellow+" consumer thread reads data " + readData);
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
