package collections.maps;

import java.util.*;

public class HashMapp {
    public static void main(String[] args) {
        //public class HashMap<K,V> extends AbstractMap<K,V>
        //    implements Map<K,V>, Cloneable, Serializable {

        //HashMap is implemented as a hash table, and there is no ordering on keys or values.
        // TreeMap is implemented based on red-black tree structure, and it is ordered by the key.
        // LinkedHashMap preserves the insertion order.
        // Hashtable is synchronized, in contrast to HashMap.



        HashMap<Integer,String> hashMap01=new HashMap<>();
        hashMap01.put(1,"Adana");//1=Adana
        hashMap01.put(34,"Istanbul");
        hashMap01.put(6,"Ankara");//6=Ankara
        hashMap01.put(34,"Istanbull");//the value of 34 key is renewed.
        hashMap01.put(16,"Bursa");
        hashMap01.put(7,"Antalya");
        hashMap01.put(7,"Antalya2");
        hashMap01.put(null,"Antalya");//null=Antalya
        System.out.println(hashMap01);
        //{16=Bursa, null=Antalya, 1=Adana, 34=Istanbull, 6=Ankara, 7=Antalya2}
        //by no order


        System.out.println(hashMap01.get(7));//Antalya2 - get(key) returns value
        System.out.println(hashMap01.isEmpty());//false - Map Interface'inden overried edilir
        System.out.println(hashMap01.size());//6 - Map'ten
        System.out.println(hashMap01.containsKey(16));//true
        System.out.println(hashMap01.containsValue("Bursa"));//true
        System.out.println(hashMap01.remove(null));//Antalya



        HashMap<Integer,String>hashMapSpare=new HashMap<>();
        hashMapSpare.putAll(hashMap01);
        System.out.println(hashMapSpare);//{16=Bursa, 1=Adana, 34=Istanbull, 6=Ankara, 7=Antalya2}

        System.out.println(hashMap01.hashCode()==hashMapSpare.hashCode());//true
        System.out.println(hashMap01==hashMapSpare);//false
        //hashCode() Map Interface'ınden geliyor

        HashMap creatHashmap=new HashMap(hashMap01);
        System.out.println("creatHashmap"+creatHashmap);

        for (Integer key: hashMap01.keySet()) {
            System.out.print(key+" ");//16 1 34 6 7
        }
        System.out.println();

        for (String value: hashMap01.values()) {
            System.out.print(value+" ");//Bursa Adana Istanbull Ankara Antalya
        }
        System.out.println();


        //HashMap'i gezmek icin Entry Interface'i kullanılır
        //ListIterator kullanamaz çünkü
        //List Interface'ini implement etmez

        LinkedHashMap treeMap=new LinkedHashMap();
        for(Map.Entry<Integer,String> entry : hashMap01.entrySet())
        {

            //Entry is an inner Interface of Map Inteface
            System.out.println("KEY:"+entry.getKey()+" VALUE:"+entry.getValue());
            System.out.println("hashCode:"+ entry.hashCode());
            treeMap.put(entry.getValue(),entry.hashCode());
            //KEY:16 VALUE:Bursa
            //KEY:1 VALUE:Adana
            //KEY:34 VALUE:Istanbull
            //KEY:6 VALUE:Ankara
            //KEY:7 VALUE:Antalya
        }

        System.out.println("tree map of hashcodes of hashmap elements"+treeMap);
        Iterator iterator01=hashMap01.keySet().iterator();
        while(iterator01.hasNext())
        {
            System.out.println(iterator01.next());
            //16
            //1
            //34
            //6
            //7
        }

        Iterator iterator02=hashMap01.entrySet().iterator();
        while(iterator02.hasNext())
        {
            System.out.println(iterator02.next());
            //16=Bursa
            //1=Adana
            //34=Istanbull
            //6=Ankara
            //7=Antalya
        }

        Iterator iterator03=hashMap01.values().iterator();
        while(iterator03.hasNext())
        {
            System.out.println(iterator03.next());
            //Bursa
            //Adana
            //Istanbull
            //Ankara
            //Antalya
        }


    }
}


//Tanım
//List, Set ve Queue interfaceleri gibi Collections interfacesinden
//türememiştir. Üst interfacesi yoktur, elemanlarını key-value; anahtar-değer
//ilişkisinde tutar.
//Haspmap, LinkedHashMap ve Treemap gibi somut sınıflar bu interfaceden
//türemiştir.
//Map yapısında keyler tekildir yani tekrarlanmaz, aldıkları değerler tekrar
//edebilir.
//Her anahtar-değer ikilisine bir entry denir. Map.Entry aslında map
//interfacesinin içinde tanımlı olan bir interfacedir.

//Hashmap de elemanların sırası önemli değildir,
// linkedhashmap de elemanlar eklendikleri sırada tutulur
// ve son olarak treemap de ise elemanlar sıralı olarak saklanır.

//keySet metotu ile anahtarları, values metotu ile değerleri ve entrySet ile de
//anahtar-deger ikililerini elde edebiliriz.