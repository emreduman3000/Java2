package IOHandling.Stream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class DataInputOutputStream {
    public static void main(String[] args) {
        //veriler byte olarak stream uzerınden aktarılır

        dosyaYaz();
        dosyaOku();
    }


    private static void dosyaYaz()
    {
        DataOutputStream dataOutputStream=null;
        Student std=new Student(1,"Emre",true);


        try
        {
            //student.dat'a veri atıcam, dosya old.ıcın FileOutputStream kullanıcam
            //byte byte tek tek atmak yerine verileri bufferlayıp tek seferde atıcam dosyaya
            dataOutputStream=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("student.dat")));
            //bu dosya proje levelinde olusturulacak

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
        finally
        {
            if(dataOutputStream != null)
            {
                try
                {
                    dataOutputStream.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void dosyaOku() {
        DataInputStream dataInputStream=null;
        boolean dosyaSonu=false;
        List<Student> stdList=new ArrayList<>();

        try{
            dataInputStream=new DataInputStream(new BufferedInputStream(new FileInputStream("student.dat")));


           while (!dosyaSonu)
           {
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

                   dosyaSonu=true;//loop'u bitirr yoksa hep exception alırız
               }
           }

        }
        catch (IOException e)
        {
            System.out.println(e);
        }

        finally {
            if(dataInputStream != null) {
                try {
                    dataInputStream.close();//dataStream'i kapadım
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            //nesneler icerir
            ListIterator<Student> listIterator=stdList.listIterator();
            while (listIterator.hasNext()){
                System.out.println(listIterator.next());
                //ImmutableStudent{id=1, name='Emre', active=true}
            }
        }


    }
}

