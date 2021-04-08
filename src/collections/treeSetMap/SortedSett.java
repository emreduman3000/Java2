package collections.treeSetMap;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSett {
    //The SortedSet interface present in java.util package extends the Set interface present in the collection framework.
    // It is an interface that implements the mathematical set.
    //
    // This interface contains the methods inherited from the Set interface and adds a feature that stores all the elements in this interface to be stored in a sorted manner.

    public static void main(String[] args)
    {
        SortedSet<String> ts= new TreeSet<String>();

        // Adding elements into the TreeSet
        // using add()
        ts.add("India");
        ts.add("Australia");
        ts.add("South Africa");

        // Adding the duplicate
        // element
        ts.add("India");

        // Displaying the TreeSet
        System.out.println(ts);

        // Removing items from TreeSet
        // using remove()
        ts.remove("Australia");
        System.out.println("Set after removing "  + "Australia:" + ts);


        String check = "India";

        // Check if the above string exists in
        // the SortedSet or not
        System.out.println("Contains " + check
                + " " + ts.contains(check));

        // Print the first element in
        // the SortedSet
        System.out.println("First Value " + ts.first());

        // Print the last element in
        // the SortedSet
        System.out.println("Last Value " + ts.last());

        //Contains India true
        //First Value India
        //Last Value South Africa

        // Iterating over Tree set items
        System.out.println("Iterating over set:");
        Iterator<String> i = ts.iterator();
        while (i.hasNext())
            System.out.println(i.next());
    }


}
