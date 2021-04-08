package enums;

import java.util.Arrays;

//all enums implicitly extends java.lang.Enum Class.
//as a class can only extends a parent class in java, So an enum cannot extends anything else.
enum Day
{
    MONDAY,TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY,SUNDAY;

    //it is possible to declare main method in enum
    public static void main(String[] args) {

        String str="Monday";

        Enum03 enum03=new Enum03(Day.valueOf(str.toUpperCase()));
        enum03.dayIsLıke();

        System.out.println(Enum03.day);//MONDAY
        System.out.println(Day.valueOf("sunday".toUpperCase()));//SUNDAY
        System.out.println(Day.valueOf("sunday"));//illegalArgumentStatement exception

        Day[] dayArray=Day.values();
        for(Day d: dayArray){
            System.out.println(d+" at index "+d.ordinal());
            //MONDAY at index 0
            //TUESDAY at index 1
            //WEDNESDAY at index 2
            //THURSDAY at index 3
            //FRIDAY at index 4
            //SATURDAY at index 5
            //SUNDAY at index 6
        }

    }
}

public class Enum03 {

    static Day day;

    public Enum03(Day day)
    {
        this.day=day;
    }

    public static void dayIsLıke(){

        switch (day){

            case MONDAY:
                System.out.println("mondays are bad"); break;
            case FRIDAY:
                System.out.println("Fridays are better"); break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are best"); break;
            default:
                System.out.println("Midweek days are so-so.");break;
        }
    }


}
