package wildCardsInJava;

import java.util.Arrays;
import java.util.List;

public class UnBounded {

    //Unbounded Wildcard:
    // This wildcard type is specified using the wildcard character (?), for example, List.
    // This is called a list of unknown type.
    // These are useful in the following cases
    //When writing a method which can be employed using functionality provided in Object class.
    //When the code is using methods in the generic class that don’t depend on the type parameter

    public static void main(String[] args)
    {

        //Integer List
        List<Integer> list1= Arrays.asList(1,2,3);

        //Double list
        List<Double> list2=Arrays.asList(1.1,2.2,3.3);

        printlist(list1);
        printList2(list1);

        printlist(list2);
        printList2(list2);
    }

    private static void printlist(List<?> list)
    {
        System.out.println(list);
    }

    private static <R> void printList2(List<R> list){
        System.out.println(list);
    }
}
