package IOHandling.character;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


//System.out.println(readAtOnce.readLine());
//Reads a line of text.
// A line is considered to be terminated by any one of a line feed ('\n'),
// a carriage return ('\r'), a carriage return followed immediately by a line feed,
// or by reaching the end-of-file (EOF).

public class Practice01
{
    private static final  String FILENAME="istiklal.txt";
    private static String mostRepeatedWord;
    private static int repeatTime;

    private static int totalCharAmount;
    private static int totalWordAmount;
    private static int totalLineAmount;

    public static void main(String[] args) {

        readFile(FILENAME);

    }


    private static void readFile(String filename) {

        String currentLine;
        String [] allWordsInThheLine = new String[0];
        HashMap <String,Integer> wordRepeating=new HashMap<>();

        try(BufferedReader readAtOnce= new BufferedReader(new FileReader("istiklal.txt"))) {
            //line bitince autoclose() calısır

            while ((currentLine=readAtOnce.readLine()) != null){
                //her defasında yeni bir line getirir

                //for total line
                totalLineAmount++;

                //for total word
                allWordsInThheLine= currentLine.replaceAll("[.!,;?\"']", "").split(" ");//exp. -> [MEHMET, AKİF, ERSOY]
                totalWordAmount+=allWordsInThheLine.length;



                //for total char
                for (String word: allWordsInThheLine) {
                    totalCharAmount+=word.length();

                    //for repeated words
                    if(wordRepeating.containsKey(word))
                        wordRepeating.put(word,wordRepeating.get(word)+1);
                    else
                        wordRepeating.put(word,1);
                }



                for(Map.Entry<String,Integer> repeatTimes : wordRepeating.entrySet())
                {

                    if(repeatTimes.getValue() > repeatTime && !repeatTimes.getKey().equals(""))
                    {
                        mostRepeatedWord=repeatTimes.getKey();
                        repeatTime=repeatTimes.getValue();
                    }

                }

                System.out.println(currentLine);
                System.out.println(Arrays.toString(allWordsInThheLine));

            }

        }catch (IOException e){
            System.out.println(e);
        }
        finally {
            System.out.println("-----------------------------------");
            System.out.println("Total Line Amount:"+totalLineAmount);
            System.out.println("Total Word Amount:"+totalWordAmount);
            System.out.println("Total Char Amount:"+totalCharAmount);
            System.out.println("Total Char Amount:"+mostRepeatedWord +" : "+ repeatTime);
        }
    }




}
