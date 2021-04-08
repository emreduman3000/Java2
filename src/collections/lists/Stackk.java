package collections.lists;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

public class Stackk
{
    //public class Stack extends Vector

    public static void main(String[] args)
    {

        //Iterable>Collection>AbstractCollection>AbstractList
        //    //Iterable>Collection>List              >AbstractList>ArrayList
        //    //Iterable>Collection>List              >AbstractList>Vector>Stack
        //
        //    //Iterable>Collection>List              >AbstractList>AbstractSequencialList>LinkedList


        //public class Stack<E> extends Vector<E> {

        //public class Vector<E>
        //    extends AbstractList<E>
        //    implements List<E>, RandomAccess, Cloneable, java.io.Serializable

        //public interface List<E> extends Collection<E> {

        //public interface Collection<E> extends Iterable<E> {
        Stack<String> stack01=new Stack<>();
        stack01.push("A");
        stack01.push("B");//EN SONA ELEMAN EKLER
        stack01.add("D");
        stack01.push("C");
        System.out.println(stack01);//[A, B, D, C]

        System.out.println(stack01.peek());//C en sondaki elemanı returns
        System.out.println(stack01.pop());//C SONDAKINI CIKARIR VE RETURN EDER
        System.out.println(stack01.search("B"));//1 İNDEXİ VERİR
        System.out.println(stack01.empty());//false
        stack01.remove(0);


        //stack mantıgı bunda calısıyor
        LinkedList<Integer> linkedList=new LinkedList<>();
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);
        //Appends the specified element to the end of this list.
        //This method is equivalent to addLast
        linkedList.add(4);
        // linkedList.addFirst(4);
        // linkedList.addLast(4);

        linkedList.push(5);
        System.out.println(linkedList);//[5, 3, 2, 1, 4]
        //add() en sona ekler
        System.out.println(linkedList.pop());//5
        //son push olan enbasa yazılır ve ilk pop edilir

        ListIterator listIterator= stack01.listIterator();
        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
            //B
            //D
        }

        stack01.stream().forEach(t-> System.out.println(t));
        /*
        5
        B
        D
        B
        D

         */


    }
}

//Tanım
//Vektör sınıfından türetilmiştir, ilk giren son çıkar mantığı ile çalışır.
//empty() -> stack boş ise true döner
//peek() -> En son elemanı döner;
//pop() -> En son elemanı döner ve yığından cıkarır.
//push(eleman) -> yığının en sonuna parametredeki elemanı ekler
//search(eleman) -> parametredeki elemanın yığındaki yerini döner.
//LinkedList<Integer> stack = new LinkedList<Integer>();
//Stack sınıfı yerine Linkedlist sınıfı kullanılabilir.
