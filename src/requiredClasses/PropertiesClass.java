package requiredClasses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class PropertiesClass {

    public static void main(String args[]) {

        //Properties() - It creates an empty property list with no default values.
        Properties capitals = new Properties();

        Set states;
        String str;

        capitals.put("Illinois", "Springfield");
        capitals.put("Missouri", "Jefferson City");
        capitals.put("Washington", "Olympia");
        capitals.put("California", "Sacramento");
        capitals.put("Indiana", "Indianapolis");

        capitals.setProperty("Illinois","Springfield2");

        // Show all states and capitals in hashtable.
        states = capitals.keySet();   // get set-view of keys
        Iterator itr = states.iterator();

        while(itr.hasNext()) {
            str = (String) itr.next();
            System.out.println("The capital of " + str + " is " +
                    capitals.getProperty(str) + ".");
        }
        //The capital of Indiana is Indianapolis.
        //The capital of Illinois is Springfield2.
        //The capital of Missouri is Jefferson City.
        //The capital of California is Sacramento.
        //The capital of Washington is Olympia.
        System.out.println();

        // look for state not in list -- specify default
        str = capitals.getProperty("Florida", "Not Found");
        System.out.println("The capital of Florida is " + str + ".");

        str = capitals.getProperty("Florida");
        System.out.println("The capital of Florida is " + str + ".");
        //The capital of Florida is Not Found.
        //The capital of Florida is null.

    }

}


class PropertiesDemo {
    public static void main(String[] args) {
        Properties prop = new Properties();
        String s = "Height=200";
        String s2 = "Width=15";

        System.out.println("Arrays.toString(s.getBytes())"+Arrays.toString(s.getBytes()));
        ///Arrays.toString(s.getBytes())[72, 101, 105, 103, 104, 116, 61, 50, 48, 48]
        //10 karakter ıcın bırer ascıı kodu olusturdu


        try {

            // create a new input and output stream
            FileOutputStream fos = new FileOutputStream("properties.txt");//app'ten file'a yazma
            FileInputStream fis = new FileInputStream("properties.txt");//file'dan app'e alma

            //The getBytes() method encodes a given String into a sequence of bytes
            // and returns an array of bytes. The method can be used in below two ways:

            // write the first property in the output stream file
            fos.write(s.getBytes());//app'ten file'a yazdı

            // change the line between the two properties
            fos.write("\n".getBytes());////app'ten file'a yazdı

            // write next property
            fos.write(s2.getBytes());////app'ten file'a yazdı

            // load from input stream
            prop.load(fis);//Properties nesnesi olan prop'a FileInputStream nesnesini yukledik

            // print the properties list from System.out
            prop.list(System.out);
            //-- listing properties --
            //Height=200
            //Width=15


        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}