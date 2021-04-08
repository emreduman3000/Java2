package exceptions.checked_compileTime_exc;

public class InterruptedException01 {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1000);
        //public static native void sleep(long millis) throws InterruptedException;
        System.out.println("emre");
    }
}
