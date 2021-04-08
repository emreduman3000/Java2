package IOHandling.Stream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


//Support for try-with-resources – introduced in Java 7 –
// allows us to declare resources to be used in a try block with the assurance that the resources will be closed when after the execution of that block.
//The resources declared must implement the AutoCloseable interface.
public class TryWithResources
{
    public static void main(String[] args) {
        //veriler byte olarak stream uzerınden aktarılır

        dosyaYaz();
        dosyaOku();
    }


    private static void dosyaYaz()
    {
        Student std=new Student(1,"Emre",true);


        try(DataOutputStream dataOutputStream=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("student.dat"))))
        {
            //dataOutputStream will be closed Automatically
            dataOutputStream.writeInt(std.id);
            dataOutputStream.writeUTF(std.name);
            dataOutputStream.writeBoolean(std.active);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    private static void dosyaOku() {
        boolean dosyaSonu=false;
        List<Student> stdList=new ArrayList<>();

        try(DataInputStream  dataInputStream=new DataInputStream(new BufferedInputStream(new FileInputStream("student.dat"))))
        {
            while (!dosyaSonu) {
                try//bir daha data okumaya calısıcak ama data yok ve exception atıcak
                {
                    //bu method dataInputStream'den gelir, System bagımsızdır dataInputStream
                    int id = dataInputStream.readInt();
                    String name = dataInputStream.readUTF();
                    Boolean active = dataInputStream.readBoolean();
                    stdList.add(new Student(id, name, active));
                }
                catch (EOFException e)//EndOfFileException
                {//dosya biterse
                    System.out.println("Dosya sonuna gelindi!!!");

                    //nesneler icerir
                    ListIterator<Student> listIterator = stdList.listIterator();
                    while (listIterator.hasNext()) {
                        System.out.println(listIterator.next());
                        //ImmutableStudent{id=1, name='Emre', active=true}

                        dosyaSonu = true;//loop'u bitirr yoksa hep exception alırız
                    }
                }
            }
        }
        catch (IOException e)
        {
            System.out.println(e);
        }




    }
}
