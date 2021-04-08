package collections.treeSetMap;

import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigatableSett {
    public static void main(String[] args)
    {
        NavigableSet<Integer> ns = new TreeSet<>();
        ns.add(0);
        ns.add(1);
        ns.add(2);
        ns.add(3);
        ns.add(4);
        ns.add(5);
        ns.add(6);

        // Get a reverse view of the navigable set
        NavigableSet<Integer> reverseNs = ns.descendingSet();

        // Print the normal and reverse views
        System.out.println("Normal order: " + ns);
        System.out.println("Reverse order: " + reverseNs);
        //Normal order: [0, 1, 2, 3, 4, 5, 6]
        //Reverse order: [6, 5, 4, 3, 2, 1, 0]

        // Print the first element in
        // the NavigableSet
        System.out.println("First Value " + ns.first());

        // Print the last element in
        // the NavigableSet
        System.out.println("Last Value " + ns.last());
        //First Value 0
        //Last Value 6

        NavigableSet<Integer> threeOrMore = ns.tailSet(3, true);
        System.out.println("3 or  more:  " + threeOrMore);
        System.out.println("lower(3): " + ns.lower(3));
        System.out.println("floor(3): " + ns.floor(3));
        System.out.println("higher(3): " + ns.higher(3));
        System.out.println("ceiling(3): " + ns.ceiling(3));
        //3 or  more:  [3, 4, 5, 6]
        //lower(3): 2
        //floor(3): 3
        //higher(3): 4
        //ceiling(3): 3

        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);
        //pollFirst(): 0
        //Navigable Set:  [1, 2, 3, 4, 5, 6]

        System.out.println("pollLast(): " + ns.pollLast());
        System.out.println("Navigable Set:  " + ns);
        //pollLast(): 6
        //Navigable Set:  [1, 2, 3, 4, 5]

        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);

        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);

        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);

        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("pollLast(): " + ns.pollLast());
        //pollFirst(): 1
        //Navigable Set:  [2, 3, 4, 5]
        //pollFirst(): 2
        //Navigable Set:  [3, 4, 5]
        //pollFirst(): 3
        //Navigable Set:  [4, 5]
        //pollFirst(): 4
        //pollLast(): 5
    }

}
