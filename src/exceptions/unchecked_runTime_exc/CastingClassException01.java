package exceptions.unchecked_runTime_exc;



public class CastingClassException01 {
    public static void main(String[] args) {



        //ClassCastException
       Test test=new Test();
       Test test1=new SubTest();
       SubTest subTest= (SubTest) test1;
        try{
            SubTest subTest1= (SubTest) test;
            Test subTest2= (SubTest) test;
        }catch (Exception e){
            System.out.println(e);
        //java.lang.ClassCastException: class exceptions.unchecked_runTime_exc.Test cannot be cast to class exceptions.unchecked_runTime_exc.SubTest (exceptions.unchecked_runTime_exc.Test and exceptions.unchecked_runTime_exc.SubTest are in unnamed module of loader 'app')
        }
    }
}
