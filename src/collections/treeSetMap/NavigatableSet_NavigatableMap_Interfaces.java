package collections.treeSetMap;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class NavigatableSet_NavigatableMap_Interfaces {

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

        //NavigatableSet NavigatableMap methods
        System.out.println(treeSet.lower("3"));//2
        System.out.println(treeMap.lowerKey("3"));//2
        System.out.println(treeMap.lowerEntry("3"));//2=2

        System.out.println(treeSet.floor("5"));//4 yoksa en büyüğü verir
        System.out.println(treeSet.floor("3"));//3 yoksa en büyüğü verir
        System.out.println(treeMap.floorKey("5"));//4

        System.out.println(treeSet.ceiling("5"));//null yoksa 5ten büyük olanı verir
        System.out.println(treeSet.ceiling("0"));//1
        System.out.println(treeMap.ceilingKey("0"));//1

        System.out.println(treeSet.higher("2"));//3 büyüğünü verir
        System.out.println(treeMap.higherKey("2"));//3

        System.out.println(treeSet.pollFirst());//"1 ilk elemanı return edr and remove it
        System.out.println(treeSet);//[2, 3, 4]

        System.out.println(treeSet.pollLast());//"4 son elemanı return edr and remove it
        System.out.println(treeSet);//[2, 3]


        Iterator<String> iterator=treeSet.descendingIterator();//büyükten küçüğe yazar
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
            //3
            //2
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
        System.out.println();
        Iterator<String> iterator3=treeMap.descendingKeySet().descendingIterator();//
        while (iterator3.hasNext()){
            System.out.print(iterator3.next()+" ");
            //1
            //2
            //3
            //4
        }

        // Iterator<String> iterator3=treeMap.descendingKeySet().iterator();//büyükten küçüğe yazar
//        Iterator<String> iterator3=treeMap.navigableKeySet().iterator();//küçükten büyüğe
        //        Iterator<String> iterator3=treeMap.descendingMap().descendingKeySet().iterator();//küçükten byüğe


    }

}
