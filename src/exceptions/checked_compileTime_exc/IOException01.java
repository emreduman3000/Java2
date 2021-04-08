package exceptions.checked_compileTime_exc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;


//IOException
//This type of exception occurs while using file I/O stream operations.
// For example, consider the following code snippet:
public class IOException01 {

//IOException found :D:\User\guest\Desktop\File2.txt (The system cannot find the path specified)
    private static String filepath = "D:\\User\\guest\\Desktop\\File2.txt";

    public static void main(String[] args) {
        BufferedReader br1 = null;
        String curline;

        try {
            br1 = new BufferedReader(new FileReader(filepath));

            while ((curline = br1.readLine()) != null) {
                System.out.println(curline);
            }
        } catch (IOException e) {
            System.err.println("IOException found :" + e.getMessage());
        } finally {
            try {
                if (br1 != null)
                    br1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}