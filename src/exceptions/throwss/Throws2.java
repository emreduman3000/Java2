package exceptions.throwss;

import java.sql.SQLDataException;

public class Throws2 {
    //throws keyword Vs. try...catch...finally
    //There might be several methods that can cause exceptions.
    // Writing try...catch for each method will be tedious and code becomes long and less-readable.
    // methodun basına koy throws u hata barındıranı try catch içine alırsın
    public static void main(String[] args) throws SQLDataException {//2
        Throws2.A nesne=new Throws2().new A();
        nesne.aMethod();//aMethod

        nesne.aMethod1();//java.lang.ArithmeticException: / by zero

        /*checked exception throws eden bir method cagrıldı, ya bunu try catch e al
        ya da methodun cagrıldıgı methodun signature ına throws that exception yaz
        try {
            nesne.aMethod2();//class A aMethod2
        } catch (SQLDataException throwables) {
            throwables.printStackTrace();
        }
         */

        nesne.aMethod2();//class A aMethod2 - throws exception eklendi main methoda

    }

    {//1
        A nesne= new A();
        nesne.aMethod();//class A aMethod
        System.out.println("initializng block");//initializng block
    }

    class A{

        void aMethod() throws ArithmeticException {
            System.out.println("aMethod");
        }

        void aMethod1(){
            try{
                int i =5/0;
            }catch (Exception E){
                System.out.println(E);
            }
        }

        void aMethod2() throws SQLDataException {
            System.out.println("class A aMethod2");
        }
    }
    class B extends A {
        @Override
        void aMethod(){
            System.out.println("class B aMethod");
        }

        @Override
        void aMethod1() {
            super.aMethod1();
        }

        @Override
        void aMethod2() throws SQLDataException {
            super.aMethod2();//burada A classındaki method2 calıscak oyuzden override edilmiş edilmiş
            //bu method throws SQLDataException yapmak zorunda ya da try catch yapmalı
        }
    }
    class C extends B {
        @Override
        void aMethod()  {
            //SQLDataException is checked exception and superClasses must throws this
            System.out.println("class C aMethod");
        }

        @Override
        void aMethod1() {
            System.out.println("eefefefe");
        }

        @Override
        void aMethod2() {
            try {
                super.aMethod2();//try catch koydum
            } catch (SQLDataException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}


