package enums;

import jdk.swing.interop.SwingInterOpUtils;

import static enums.Level.HIGH;

public class Enumeration {

    static Level level = HIGH;
    //Level level2=new Level();//Enum types cannot be instantiated

    public static void main(String[] args) {
        ifStatement();
        switchStatement();
        forLoop();
    }

    static void ifStatement(){


        if(level == HIGH)
            System.out.println(HIGH);
        else if (level == level.MEDIUM)
            System.out.println(level.MEDIUM);
        else
            System.out.println(level.LOW);

    }

    static void switchStatement(){
        switch (level){
            case HIGH: System.out.println("high"); break;

            case MEDIUM: System.out.println("medium"); break;

            case LOW: System.out.println("low"); break;

            default:
                System.out.println("nothing");


        }
    }

    static void forLoop(){
        for(Level l: Level.values())//Level ismindeki enum'un sabitlerini array'a Level[] koyar value() methodu
            System.out.println(l);
        //HIGH
        //MEDIUM
        //LOW
    }
}
