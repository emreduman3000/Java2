package collections.sets;

import java.util.HashSet;
import java.util.Iterator;

public class HashSett {
    public static void main(String[] args) {

        //public class HashSet<E>
        //    extends AbstractSet<E>
        //    implements Set<E>, Cloneable, java.io.Serializable


        //public interface Set<E> extends Collection<E> {


        //hashmap'te sıralama hashcodu kücük olan büyüge dogrudur

        //SET YAPILARINDA TEKRARLAMA OLMAZ
        HashSet<String> letter = new HashSet<>();
        letter.add("a");
        letter.add("a");//tekrarlama var dıyor IDE
        letter.add(null);
        letter.add("d");
        letter.add("c");
        letter.add("b");
        Iterator iterator=letter.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+ " - ");//hashcodelarına göre yazar
            System.out.println(iterator.hashCode());
            //null81628611
            //a81628611
            //b81628611
            //c81628611
            //d81628611
        }
    }
}
