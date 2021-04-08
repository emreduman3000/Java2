package enums;

public class Enum02 {

    //enum declaration inside a class
    enum Color{
        //first line of enum must contain constant
        //and then methods and constructor

        RED,   //public static final RED    = new Color();
        GREEN, //public static final GREEN  = new Color();
        BLUE,  //public static final BLUE   = new Color();
        YELLOW //public static final YELLOW = new Color();

        //EVERY ENUM CONSTANT represent an object of type enum
    }

    //driver method-main method
    public static void main(String[] args)
    {
        Color c1=Color.BLUE;
        System.out.println(c1);//BLUE
        System.out.println(c1.describeConstable());//Optional[EnumDesc[Enum02$Color.BLUE]]
        System.out.println(c1.getDeclaringClass());//class enums.Enum02$Color
        System.out.println(c1.getClass());//class enums.Enum02$Color

    }

}
