package threads.intro;


public class Interrupt_Join
{
    public static void main(String[] args)
    {
        Test testThread=new Test("1", Thread02.Cyan);
        testThread.start();

        // 1 Thread-0 5
        // 3 Thread-0 5
        // 5 Thread-0 5
        //java.lang.InterruptedException: sleep interrupted
        //
        //Process finished with exit code 0

        Thread t2=new Thread() {//default priority is 5
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {

                    if(i==11) {
                        try {
                            //testThread.join();//testThread önceliği aldı
                            //testThread bitene kadar diğer threadler beklesin

                            //Cyan olan devam edicek
                            //eger Cyan olan biterse Magenta olan deva eder

                            testThread.join(5000);//meganta cyanı 5 saniye beklicek sadece
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (i % 2 == 1) {
                        System.out.println(Thread02.Magenta + i + " " + OddNumber.currentThread().getName() + " " + Thread.currentThread().getPriority());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.getStackTrace();
                        }
                    }
                }
            }
        };
        t2.setPriority(6);//magenta firstly start, but sometimes VM DOESNT
        t2.start();

    }
}

class Test extends Thread{
    String threadName,color;

    public Test(String name, String color) {
        threadName=name;
        this.color = color;
    }

    @Override
    public void run() {
        for(int i=0; i<100 ; i++){

            if(i==51)
                interrupt();//if ==51 throw InterruptedException
            //bu thread interrupt edildi

            if(i % 2 == 1) {
                System.out.println(color + i+" "+OddNumber.currentThread().getName()+" "+Thread.currentThread().getPriority());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                    return;//methodfdan ckmak icin yazdım
                }
            }


        }
    }
}