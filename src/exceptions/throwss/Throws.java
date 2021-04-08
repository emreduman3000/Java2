package exceptions.throwss;

import java.io.IOException;
import java.sql.SQLDataException;

public class Throws {
    //We use the throws keyword in the method declaration
    // to declare the type of exceptions that might occur within it.
    //we can use throws to declare multiple exceptions.

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        try{
            method();
        }catch (Exception e){
            System.out.println(e);//java.lang.NumberFormatException: For input string: "INTEGER"
        }

        try {
            method2();//kullanırken diyorki bu method compiletime exception THROWS ediyor dikkatli ol
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            e.printStackTrace();//bu kırmızı error verir, ama runnning devam eder
         }
        //ya main methoda THROWS ekle ya da TRY-CATCH kullan


         method3();//unchecked exception throw edicek
        //main methoda signature ekledim compile time error'u engelledim
        // , ama exception üretildi ve catch edilmediği için error aldm

        Throws.C c=new Throws.C();
        try {
            c.aMethod();
        } catch (Throwable throwables) {
            System.out.println(throwables);
        }


        Throws.A b= new Throws.B();//polimorphism
        b.aMethod2();//B Classındaki methodtur
        //signature'ında throws vardır - void aMethod2() throws ClassNotFoundException{
        //main() methoda signature ekledim throws ile hata vermeyeceği compile time error almayacagım

    }

    private static void method() throws NumberFormatException,ArrayIndexOutOfBoundsException{
        //unchecked exceptionlar (runtime) iiçn throws  exception and catch block catches it
        //method olarak exception throws edilebilir, catch edilmesi gerekebilir demek
        //eger compile time exception THROWS edebilme ihtimali varsa try-catch  kullanmak zorundulur

        Integer integer=new Integer("INTEGER");//EXCEPTION var burda catch edilmesi gerekiyor
        //burada try-catch yapabilirm
        //ya da main methodta try-catch yapabilirim

        //checked, compiletime exception atıcak olan methodu kullanırken bana try catch ya da throws kullan der IDE
    }

    private static void method2() throws ClassNotFoundException {
        throw new ClassNotFoundException("throw ile ben attım, methoda da throws ekledim");
    //checked-compile time exception old. icin throws koymak zorundayım signature'da
    }

    private static void method3() throws IOException {
        throw new IOException("throw ile ben attım, methoda da throws ekledim");
    }

    static class A{//inner static class
        void aMethod() throws ArrayIndexOutOfBoundsException,SQLDataException{
            System.out.println("class A aMethod");
        }

        void aMethod2() throws ClassNotFoundException{
            System.out.println("class A aMethod");
        }

        void aMethod3() throws ClassNotFoundException{
            System.out.println("class A aMethod");
        }
    }
    static class B extends A{
        @Override
        void aMethod() throws SQLDataException{
            //CHECKED Exception throws eden method override edilirken
            // throws edilen exceptionı silemeyiz

            //unchecked exception THROWS edebilir diyen methodu override ederken zorunluluk yoktur
            System.out.println("class B aMethod");
        }

        @Override
        void aMethod2() throws ClassNotFoundException {
            super.aMethod2(); //eger diğer superclasstan overrride ettiğim methodun içinşi
            //super ile kullanıyorsam  throws ClassNotFoundException  ifadesi olmak zorunda
        }

        @Override
        void aMethod3() {
            System.out.println("sdfsfouse");//bu sefer throws ClassNotFoundException
            //kullanmak zorunda degılım
        }
    }
    static class C extends B{
        @Override
        void aMethod() throws NumberFormatException,NullPointerException, SQLDataException {
            //SQLDataException is checked exception and superClasses must throws this
            System.out.println("class C aMethod");
            throw new NumberFormatException();

        }
    }

}
