package threads.intro;

public class Priority {

    public static void main(String[] args) {

        //suan priority yok
        OddNumber t1=new OddNumber("1", Thread02.Blue);//run methodu override edildiği icin Thread olustu
        OddNumber t2=new OddNumber("2",Thread02.Red);
        OddNumber t3=new OddNumber("3",Thread02.Yellow);//thread olustu

        //setPriority() demesem VM sırayla yazdırmazz
        t1.setPriority(Thread.MIN_PRIORITY);//ilk olusan son calıscak
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();//run methodunu tetikler thread calısır
        t2.start();
        t3.start();
        // 1 Thread-2 10
        // 1 Thread-1 5
        // 1 Thread-0 1
        // 3 Thread-2 10
        // 3 Thread-1 5
        // 3 Thread-0 1
    }
}

class OddNumber extends Thread{

    String threadName,color;

    public OddNumber(String name, String color) {
        threadName=name;
        this.color = color;
    }

    @Override
    public void run() {
        for(int i=0; i<100 ; i++){
            if(i % 2 == 1) {
                System.out.println(color + i+" "+OddNumber.currentThread().getName()+" "+Thread.currentThread().getPriority());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
