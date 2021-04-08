package collections.treeSetMap;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class SortedMap_SortedSet_Interfaces {
    public static void main(String[] args) {

        TreeSet<String> treeSet=new TreeSet<>();
        treeSet.add("1");
        treeSet.add("2");
        treeSet.add("3");
        treeSet.add("4");
        System.out.println(treeSet);//[1, 2, 3, 4]

        TreeMap<String,Integer> treeMap=new TreeMap<>();
        treeMap.put("1",1);
        treeMap.put("2",2);
        treeMap.put("3",3);
        treeMap.put("4",4);
        System.out.println(treeMap); //{1=1, 2=2, 3=3, 4=4}

        //SortedSet, SortedMap
        TreeSet<String> subSet=(TreeSet<String>)treeSet.subSet("1","3");
        System.out.println(subSet);//[1, 2]

        System.out.println(treeMap.subMap("1","4"));//{1=1, 2=2, 3=3}

        try{
            TreeMap subMap2= (TreeMap) treeMap.subMap("1","2");
            System.out.println(subMap2);//{1=1}
        }catch (Exception e){
            System.out.println(e);
            //java.lang.ClassCastException: class java.util.TreeMap$AscendingSubMap cannot be cast to class java.util.TreeMap (java.util.TreeMap$AscendingSubMap and java.util.TreeMap are in module java.base of loader 'bootstrap')
        }

        System.out.println(treeMap.headMap("3"));//{1=1, 2=2}
        System.out.println(treeSet.headSet("3"));//[1, 2]
        System.out.println(treeMap.tailMap("3"));//{3=3, 4=4}
        System.out.println(treeSet.tailSet("3"));//[3, 4]

        System.out.println(treeMap.firstEntry());//1=1
        System.out.println(treeMap.firstKey());//1

        System.out.println(treeMap.lastEntry());//4=4
        System.out.println(treeMap.lastKey());//4

        System.out.println(treeSet.first());//1
        System.out.println(treeSet.last());//4


        Iterator<String> iterator=treeSet.descendingIterator();//büyükten küçüğe yazar
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
            //4
            //3
            //2
            //1
        }

        System.out.println();
        Iterator<String> iterator2=treeMap.descendingKeySet().iterator();//büyükten küçüğe yazar
        while (iterator2.hasNext()){
            System.out.print(iterator2.next()+" ");
            //4
            //3
            //2
            //1
        }

    }
}
