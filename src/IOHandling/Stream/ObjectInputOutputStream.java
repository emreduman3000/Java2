package IOHandling.Stream;

import java.io.*;
import java.util.ArrayList;

//By using ObjectInputOutputStream  the class must implement serializable interface
// while using the object of this class
public class ObjectInputOutputStream {

    static ArrayList<Student> stdList =null;

    public static void main(String[] args) {

        dosyayaNesneYazdır();
        dosyadanNesneOku();
    }

    private static void dosyayaNesneYazdır()
    {
        stdList=new ArrayList<>();
        stdList.add(new Student(1,"emre",true));
        stdList.add(new Student(2,"tuba",true));

        try(ObjectOutputStream objectOutputStream=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("StudentObjects.txt")))) {
            int limit=0;
            while (limit<stdList.size())
            {
                objectOutputStream.writeObject(stdList.get(limit));
                limit++;
            }

        }catch (Exception e){
            System.out.println(e);
        }
        finally {
            stdList=null;
        }

    }

    private static void dosyadanNesneOku()
    {

        try(ObjectInputStream objectInputStream=new ObjectInputStream(new BufferedInputStream(new FileInputStream("StudentObjects.txt"))))
        {
            boolean dosyaSonu=false;
            stdList=new ArrayList<>();

            while (!dosyaSonu)
            {
                try {
                    stdList.add((Student)objectInputStream.readObject());
                }catch (EOFException e){
                    dosyaSonu=true;
                    System.out.println(stdList);
                    System.out.println(e);
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
