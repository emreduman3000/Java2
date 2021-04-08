package threads;

public class GarbageCollector {

    public static void main(String[] args)
    {
        TestGarbage1 s1=new TestGarbage1();
        TestGarbage1 s2=new TestGarbage1();
        s1=s2;
        System.gc();

        TestGarbage1 s3=new TestGarbage1();
        s3=null;
        System.gc();

        new TestGarbage1();
        System.gc();


    }
}

class TestGarbage1{
    public void finalize()
    {
        System.out.println("object is garbage collected");
    }

}
