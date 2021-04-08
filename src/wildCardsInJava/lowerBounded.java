package wildCardsInJava;

import java.util.Arrays;
import java.util.List;

public class lowerBounded {

    //Lower Bounded Wildcards:
    // It is expressed using the wildcard character (‘?’), followed by the super keyword, followed by its lower bound: <? super A>.
    // Syntax: Collectiontype <? super A>

    //Here arguments can be Integer or superclass of Integer(which is Number).
    // The method printOnlyIntegerClassorSuperClass will only take Integer or its superclass objects.
    // However if we pass list of type Double then we will get compilation error.
    // It is because only the Integer field or its superclass can be passed .
    // Double is not the superclass of Integer.

    public static void main(String[] args)
    {
        //Lower Bounded Integer List
        List<Integer> list1= Arrays.asList(4,5,6,7);

        //Integer list object is being passed
        printOnlyIntegerClassorSuperClass(list1);

        //Number list
        List<Number> list2= Arrays.asList(4,5,6,7);

        //Integer list object is being passed
        printOnlyIntegerClassorSuperClass(list2);
    }

    public static void printOnlyIntegerClassorSuperClass(List<? super Integer> list)
    {
        System.out.println(list);
    }
}
