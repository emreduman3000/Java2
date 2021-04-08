package enums;

interface Clr{
    abstract void printColor();//Modifier 'abstract' is redundant for interface methods

}
enum Color implements Clr{
    BLACK,WHITE;

    //enum constructor called seperately for each constant
    Color(){//Modifier 'private' is redundant for enum constructors
            //Modifier 'public' not allowed here
        System.out.println("Constructor called for: "+ this.toString());
    }

    public void colorInfo(){
        System.out.println("Universal Color");
    }

    @Override
    public void printColor() {
        System.out.println(this);
    }
}

public class Enum04
{
    public static void main(String[] args) {
        Color c1=Color.BLACK;//constructor'ı calıstırır
        //Constructor called for: BLACK
        //Constructor called for: WHITE

        System.out.println(c1);//BLACK
        c1.colorInfo();//Universal Color

        c1.printColor();//BLACK
    }
}
