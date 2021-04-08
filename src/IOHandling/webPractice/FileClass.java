package IOHandling.webPractice;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


//if we create a file object using the path as “program.txt”,
// it points to the file present in the same directory where the executable program is kept
// (if you are using an IDE it will point to the file where you have saved the program ).
// Here the path of the file mentioned above is “program.txt” but this path is not absolute (i.e. not complete).
// The function getCanonicalPath() will return a path which will be an absolute and unique path from the root directories.
// The canonical form of an existing file may be different from the canonical form of a same non existing file and
// the canonical form of an existing file may be different from the canonical form of the same file when it is deleted.
public class FileClass {

    //Java File Class
    //The File class is an abstract representation of file and directory pathname.
    // A pathname can be either absolute or relative.
    //The File class have several methods for working with directories and
    // files such as creating new directories or files, deleting and renaming directories or files,
    // listing the contents of a directory etc.

    public static void main(String data[])
    {
        //createFile();
        //createFile2();
        readContentInDir();
        readContentInDir2();

    }

    static void createFile(){
        try {
            File file = new File("javaFile123.txt");
            if (file.createNewFile())//projelevelinde file create eder
            {
                System.out.println("New File is created!");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void createFile2()
    {

        String path = "";
        boolean bool = false;
        try {
            // createing  new files
            File file  = new File("testFile1.txt");
            if (!file.exists())//projelevelinde file create eder
            {
                System.out.println("New File is created!");
            } else {
                System.out.println("File already exists.");
            }
            System.out.println(file.createNewFile());//false
            //Atomically creates a new, empty file named by this abstract pathname if and only if a file with this name does not yet exist.
            System.out.println(file);//testFile1.txt


            // createing new canonical from file object
            File file2 = file.getCanonicalFile();

            // returns true if the file exists
            System.out.println(file2);
            //C:\Users\Emre Duman\IdeaProjects\Java2\testFile1.txt
            bool = file2.exists();//true

            // returns absolute pathname
            path = file2.getAbsolutePath();
            System.out.println(path);
            //C:\Users\Emre Duman\IdeaProjects\Java2\testFile1.txt

            // if file exists
            if (bool) {
                // prints
                System.out.print(path + " Exists? " + bool);
                //C:\Users\Emre Duman\IdeaProjects\Java2\testFile1.txt Exists? true
            }
        } catch (Exception e) {
            // if any error occurs
            e.printStackTrace();
        }
    }


    static void readContentInDir()
    {
        File f=new File("/Users/Emre Duman/eclipse");
        String filenames[]=f.list();
        for(String filename:filenames){
            System.out.println(filename);
        }
    }

    static void readContentInDir2()
    {
        File dir=new File("/Users/Emre Duman");
        File files[]=dir.listFiles();
        for(File file:files){
            System.out.println(file.getName()+" Can Write: "+file.canWrite()+
           " Is Hidden: "+file.isHidden()+" Length: "+file.length()+" bytes");
        }
    }
}
