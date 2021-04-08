package IOHandling.character;

import java.io.*;

public class FileReaderWriter {
    public static void main(String[] args)
    {
        String fileName="character.txt";

        //writeFile("character.txt");
        writeFileTryWithResources(fileName);
        readFileTryWithResources(fileName);

    }


    private static void writeFile(String s) {
        BufferedWriter writeAtOnce=null;
        try {
            writeAtOnce=new BufferedWriter(new FileWriter(s));
            writeAtOnce.write("merhaba");
            writeAtOnce.newLine();//to pass the line
            writeAtOnce.write("nasılsın\n");
            writeAtOnce.write("END");

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(writeAtOnce != null){
                try {
                    writeAtOnce.close();
                }catch (Exception e){

                }
            }
        }
    }

    private static void writeFileTryWithResources(String s) {
        try(BufferedWriter  writeAtOnce=new BufferedWriter(new FileWriter(s))) {
            writeAtOnce.write("merhaba");
            writeAtOnce.newLine();//to pass the line
            writeAtOnce.write("nasılsın\n");
            writeAtOnce.write("END");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static void readFileTryWithResources(String fileName) {

        try(BufferedReader readAtOnce= new BufferedReader(new FileReader(fileName))) {
            String readAll;

            while ( (readAll=readAtOnce.readLine()) != null){
                    System.out.println(readAll);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
