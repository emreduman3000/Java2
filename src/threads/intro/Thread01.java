package threads.intro;

public class Thread01
{
    //uzun süre zaman alacak kodlarda sadece main thread imiz varsa, uygulama cok kasar.
    //alternatif threadlere ihtiyacımız var.

    //Thread( iş parçacığı)
    //“Thread”ler de “Processler gibi”  işlem birimleridir ve  hafifsiklet processler (“lightweight processes”) olarak adlandırılırlar.
    // Threadler daha az kaynağa ihtiyaç duymaktadırlar.
    // “Thread”ler bir “process” içinde yer almaktadır.
    // Her thread mutlaka bir procecesse sahiptir ve onun kaynaklarından faydalanabilir.

    //

    public static void main(String[] args)
    {
        //public class Thread implements Runnable
        System.out.println("Program started and thread name:"+ Thread.currentThread().getName());//Program started and thread name:main

        try {
            Thread.sleep(3000);//3 seconds - threadı 3 saniye durur
            //It sleeps a thread for the specified amount of time.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //kontrollü istisna-try catch bloğuna al or use throws

        System.out.println(Thread.currentThread().getState());//RUNNABLE

        //class Employee extends Thread
        Employee employee =new Employee();
        System.out.println(employee.getState());//New
        employee.setName("Thread of Employee Class");

        //main thread üzerinde calsıır
        employee.run();//It is used to do an action for a thread.
        //Calls to 'run()' should probably be replaced with 'start()'
        //thread olusmaz
        //Employee Class kicked off : Thread Name:main
        //Employee Class ended up : Thread Name:main

        System.out.println(Thread.currentThread().getState());//RUNNABLE


        //thread ousturma-  Tread'i extends etmiş run()'ı override etmiş
        employee.start();//It is used to start the execution of the thread.

        //Employee Class kicked off : Thread Name:Thread of Employee Class
        //Employee Class ended up : Thread Name:Thread of Employee Class
        System.out.println(Thread.currentThread().getState());//RUNNABLE





        //2.YOL THREAD OLUSTURMA
        EmployeeRunnable e = new EmployeeRunnable();
        //class EmployeeRunnable extends Employee02 implements Runnable
        //e.start(); //compile time errror
        Thread emp = new Thread(e);//public Thread(Runnable target)
        //EmployeeRunnable CLASSINA AIT thread olusturudm
        emp.setName("EmployeeRunnable Threadi:");//adını koydum

        emp.run();
        //EmployeeRunnable Class kicked off : Thread Name:main
        //EmployeeRunnable Class ended up : Thread Name:main

        //2. thread olusturma anı
        emp.start();//calıstırdım - /Thread Claasından gelen run() methofunu tetikler

        //3.YOL
        //constructor(par1).method();
         Thread thread =  new Thread(new Runnable() {
            @Override
            public void run() {
                try
                {
                    System.out.println("Runnable Anonymous Inner Class kicked off : Thread Name:" + Thread.currentThread().getName());
                    Thread.sleep(5000);
                    System.out.println("Runnable Anonymous Inner Class ended up : Thread Name:" + Thread.currentThread().getName());
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
         thread.start();//Thread Claasından gelen run() methofunu tetikler


        //4.YOL
        new Thread(){
            @Override
            public void run() {
                try
                {
                    System.out.println("Thread Anonymous Inner Class kicked off : Thread Name:" + Thread.currentThread().getName());
                    Thread.sleep(5000);
                    System.out.println("Thread Anonymous Inner Class ended up : Thread Name:" + Thread.currentThread().getName());
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();//Thread Claasından gelen run() methofunu tetikler




       //EmployeeRunnable Class kicked off : Thread Name:EmployeeRunnable Threadi:
        //Runnable Anonymous Inner Class kicked off : Thread Name:Thread-2
        //Thread Anonymous Inner Class kicked off : Thread Name:Thread-3

        //EmployeeRunnable Class ended up : Thread Name:EmployeeRunnable Threadi:
        //Runnable Anonymous Inner Class ended up : Thread Name:Thread-2
        //Thread Anonymous Inner Class ended up : Thread Name:Thread-3



    }
}
class Employee extends Thread
{


    @Override
    public void run() //Thread classından geliyor
    {
        try
        {
            System.out.println("Employee Class kicked off : Thread Name:" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("Employee Class ended up : Thread Name:" + Thread.currentThread().getName());
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

class Employee01
{

}

class EmployeeRunnable extends Employee01 implements Runnable{//extends Thread diyemeyiz

    //subclass oldugu ıcın Thread class'ını extends edemez
    //oyuzdn Runnnable ınt. ini impllement etti
    //  public abstract void run(); rom Runnable Interface
    @Override
    public void run()
    {
        try
        {
            System.out.println("EmployeeRunnable Class kicked off : Thread Name:" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("EmployeeRunnable Class ended up : Thread Name:" + Thread.currentThread().getName());
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
