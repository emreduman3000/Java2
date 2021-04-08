package collections.sets;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSett
{
    public static void main(String[] args) {
        LinkedHashSet<String> letter = new LinkedHashSet<>();
        letter.add("a");
        letter.add("d");
        letter.add("c");
        letter.add("b");
        letter.add("b");//set oldugu icin tekrarlama olmaz
        letter.add(null);
        Iterator iterator=letter.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" - ");//adcbnull ekleme sırasına göre
        }
        System.out.println();

        letter.stream().spliterator().forEachRemaining(t-> System.out.println(t));
         //a
        //d
        //c
        //b
        //null

        String[] array=letter.toArray(new String[0]);
        System.out.println(array[1]);//d
        System.out.println(Arrays.toString(array));//[a, d, c, b,null]
        System.out.println(array.toString());//[Ljava.lang.String;@2d98a335


    }
}

