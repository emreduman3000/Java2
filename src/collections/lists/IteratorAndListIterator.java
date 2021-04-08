package collections.lists;

import java.util.*;

public class IteratorAndListIterator
{
    public static void main(String[] args)
    {
        List<Integer> numbers01=new ArrayList<>();
        numbers01.add(1);
        numbers01.add(2);
        numbers01.add(3);
        numbers01.add(4);
        System.out.println(numbers01);//[1, 2, 3, 4]

        //note: String[] SArrayf =list2.toArray( new String[]{"1","2","3","4"} );
        //ise yaramaz

        //burda yararr
        //List<Integer> numbers02=new ArrayList<>(Arrays.asList(new Integer[]{1,2,5,6}));
        List<Integer> numbers02=new ArrayList<>(Arrays.asList(1,2,5,6));
        System.out.println(numbers02);



/*
            //ıf the same element exists in, delete it form first ArrayList
            for (int i=0;i<numbers02.size();i++) {
                if(numbers01.contains(numbers02.get(i)));
                    numbers01.remove(i);
            }
            System.out.println(numbers01);//[8, 9] olmali ama
            //Exception in thread "main" java.util.ConcurrentModificationException
            //eleman cıkarınca size azalıyor aranan index yok oluyor excaptiion alıyoruz

*/

        //Iterator generic Interface - iterator() generic method /listleri setleri queue leri gezebilirz
        System.out.println("THANKS TO Iterator Interface and iterator() method, A LIST CAN BE STEPPED OVER");

        Iterator<Integer> iterator01=numbers01.iterator();

        System.out.println(iterator01.hashCode());//1072408673
        System.out.println(numbers01.hashCode());//955331

        while (iterator01.hasNext())//okun sagında eleman varsa true
        {
            if(numbers02.contains(iterator01.next()))//oku bir saga kaydırır ve üzerinden gectiği elemanı yazdırır
            {
                System.out.println("iterator01.toString():"+iterator01.toString());
                //iterator01.toString():java.util.ArrayList$Itr@b4c966a
                iterator01.remove();
            }
        }
        System.out.println(numbers01);//[3, 4]


        //public interface ListIterator<E> extends Iterator<E> {

        //Iterator<Integer> listIterator03=numbers02.listIterator(numbers02.size());
        // yazarsam ListIterator methodlarını kullanamam

        //listIterator ile hasNext() hasPrevious() listIterator(index) gibi özellikler de vardır
        ListIterator<Integer> listIterator01=numbers02.listIterator();
        while(listIterator01.hasNext())
        {
            System.out.print(listIterator01.next()+" ");//1 2 5 6
            if (listIterator01.hasNext()==false)
            {
                System.out.println();
                while (listIterator01.hasPrevious())
                {
                    System.out.print(listIterator01.previous()+" ");//6 5 2 1
                }
                System.out.println();
                break;
            }
        }

        //OR

        ListIterator<Integer> listIterator02=numbers02.listIterator(1);
        while(listIterator02.hasNext()) {
            System.out.println(listIterator02.nextIndex()+". index:"+listIterator02.next());
            //1. index:2
            //2. index:5
            //3. index:6
        }

        while(listIterator02.hasPrevious()) {
            System.out.println(listIterator02.previousIndex()+". index:"+listIterator02.previous());
            //3. index:6
            //2. index:5
            //1. index:2
            //0. index:1
        }

        ListIterator<Integer> listIterator03=numbers02.listIterator(numbers02.size());//5 eleman varsa 4 aralık vardır,yani 4 kez kayması gerekecek
        while (listIterator03.hasPrevious()){
            System.out.println(listIterator03.previous());
        }


        //Iterator<Integer> listIterator04=new ListIterator<Integer>();
        //olamaz cünkü 2 si de interface'dir



        //    //Iterable>Collection>AbstractCollection>AbstractList
        //    //Iterable>Collection>List              >AbstractList>ArrayList
        //    //Iterable>Collection>List              >AbstractList>Vector>Stack
        //
        //    //Iterable>Collection>List              >AbstractList>AbstractSequencialList>LinkedList

        ArrayList<String>nameArrayList=new ArrayList<>();
        nameArrayList.add("emre");

        ArrayList<String> nameArrayList2=nameArrayList;
        System.out.println("\n"+nameArrayList2);//[emre]
        System.out.println(nameArrayList2==nameArrayList);//true
        System.out.println(nameArrayList2.hashCode()==nameArrayList.hashCode());//true

        AbstractList<String> nameAbstractList=nameArrayList2;
        System.out.println(nameAbstractList);//[emre]
        System.out.println(nameAbstractList==nameArrayList);//true


        AbstractCollection<String> abstractCollectionList=nameArrayList2;
        System.out.println(abstractCollectionList);//[emre]
        System.out.println(abstractCollectionList==nameArrayList);//true


        List<String> nameList=nameAbstractList;
        System.out.println(nameList);//[emre]
        System.out.println(nameList==nameArrayList);//true

        Collection<String> nameCollection=nameList;
        System.out.println(nameCollection);//[emre]
        System.out.println(nameCollection==nameArrayList);//true


        //Iterator<String> nameIterator=  nameCollection;//compiler error
        //Iterator<String> nameIterator= (Iterator<String>) nameCollection;
        //Exception in thread "main" java.lang.ClassCastException: class java.util.ArrayList cannot be cast to class java.util.Iterator (java.util.ArrayList and java.util.Iterator are in module java.base of loader 'bootstrap')

        nameCollection.add("duman");
        Iterator<String> nameIterator=nameArrayList.iterator();
        System.out.println(nameIterator.toString());//java.util.ArrayList$Itr@3feba861
        while(nameIterator.hasNext())
        {
            System.out.println(nameIterator.next());//emre duman
        }
    }
}

//List iterator interfacesi Iterator interfacesinden türetilmiştir. Iterator ile
//listeler,setler ve queueler gezilebilir(sadece bastan sona dogru)
//Oysaki listiterator ile baştan sonra sonra basa gezilebilir. O yüzden eğer
//amacımız liste yapılarını gezmekse bu daha mantıklıdır.
//Iterator metotları
//hasNext, next ve remove
//ListIterator metotları
//hasNext, hasPrevious, next , previous, nextIndex, previousIndex,
//remove,set,add ..
//Görüldüğü gibi listeler için çok daha fazla metot barındırıyor. Ayrıca listeyi
//gezerken bir önceki ve bir sonraki elemanın index değerlerini de elde
//edebileceğimiz metotlar var. O yüzden listiterator kullanmak daha mantıklı.
//Ayrıca listiterator ile ekleme yerdeğiştirme ve silme yapabilirken iterator
//ile sadece silme yapılabilir.
//Listiterator ile belli bir indexten başlayıp listemizi gezebilirken iterator
//ile bunu yapamayız.