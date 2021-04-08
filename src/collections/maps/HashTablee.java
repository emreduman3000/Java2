package collections.maps;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashTablee {

    //Features of Hashtable
    //
    //It is similar to HashMap, but is synchronized.
    //Hashtable stores key/value pair in hash table.
    //In Hashtable we specify an object that is used as a key, and the value we want to associate to that key.
    // The key is then hashed, and the resulting hash code is used as the index at which the value is stored within the table.
    //The initial default capacity of Hashtable class is 11 whereas loadFactor is 0.75.
    //HashMap doesn’t provide any Enumeration, while Hashtable provides not fail-fast Enumeration.


    //Hashmap vs Hashtable
    //1. HashMap is non synchronized. It is not-thread safe and can’t be shared between many threads without proper synchronization code whereas Hashtable is synchronized. It is thread-safe and can be shared with many threads.
    //2. HashMap allows one null key and multiple null values whereas Hashtable doesn’t allow any null key or value.
    //3. HashMap is generally preferred over HashTable if thread synchronization is not needed

    //Why HashTable doesn’t allow null and HashMap does?
    //To successfully store and retrieve objects from a HashTable, the objects used as keys must implement the hashCode method and the equals method. Since null is not an object, it can’t implement these methods. HashMap is an advanced version and improvement on the Hashtable. HashMap was created later.

    //public class Hashtable<K,V> extends Dictionary<K,V> implements Map<K,V>, Cloneable, Serializable



    public static void main(String args[])
    {
        method();
        method2();
        //Mappings of ht2 : {3=three, 2=two, 1=one}

        method3();
        //vaibhav 20
        //vishal 10
        //sachin 30

        method4();

    }


    static void method()
    {
        // No need to mention the
        // Generic type twice
        Hashtable<Integer, String> ht1 = new Hashtable<>();

        // Initialization of a Hashtable
        // using Generics

        Hashtable<Integer, String> ht2= new Hashtable<Integer, String>();

        // Inserting the Elements
        // using put() method
        ht1.put(1, "one");
        ht1.put(2, "two");
        ht1.put(3, "three");

        ht2.put(4, "four");
        ht2.put(5, "five");
        ht2.put(6, "six");

        // Print mappings to the console
        System.out.println("Mappings of ht1 : " + ht1);
        System.out.println("Mappings of ht2 : " + ht2);
    }

    static void method2()
    {
        // No need to mention the
        // Generic type twice
        Map<Integer, String> hm = new HashMap<>();

        // Inserting the Elements
        // using put() method
        hm.put(1, "one");
        hm.put(2, "two");
        hm.put(3, "three");

        // Initialization of a Hashtable
        // using Generics
        Hashtable<Integer, String> ht2 = new Hashtable<Integer, String>(hm);

        // Print mappings to the console

        System.out.println("Mappings of ht2 : " + ht2);
    }

    static void method3()
    {
        // Create an instance of Hashtable
        Hashtable<String, Integer> ht = new Hashtable<>();

        // Adding elements using put method
        ht.put("vishal", 10);
        ht.put("sachin", 30);
        ht.put("vaibhav", 20);

        // Iterating using enhanced for loop
        for (Map.Entry<String, Integer> e : ht.entrySet())
            System.out.println(e.getKey() + " "
                    + e.getValue());
    }

    static void method4()
    {
            //----------hashtable -------------------------
            Hashtable<Integer,String> ht=new Hashtable<Integer,String>();
            ht.put(101," ajay");
            ht.put(101,"Vijay");
            ht.put(102,"Ravi");
            ht.put(103,"Rahul");
            System.out.println("-------------Hash table--------------");
            for (Map.Entry m:ht.entrySet()) {
                System.out.println(m.getKey()+" "+m.getValue());
            }

            //----------------hashmap--------------------------------
            HashMap<Integer,String> hm=new HashMap<Integer,String>();
            hm.put(100,"Amit");
            hm.put(104,"Amit");
            hm.put(101,"Vijay");
            hm.put(102,"Rahul");
            System.out.println("-----------Hash map-----------");
            for (Map.Entry m:hm.entrySet()) {
                System.out.println(m.getKey()+" "+m.getValue());
            }

    }

}
