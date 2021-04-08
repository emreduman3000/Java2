package requiredInterfaces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharSequencee {

    //Simply put, CharSequence and String are two different fundamental concepts in Java.

    {

        // CharSequence is an interface that represents a sequence of characters.
        // Mutability is not enforced by this interface.
        // Therefore, both mutable and immutable classes implement this interface.

        //Of course, an interface can't be instantiated directly; it needs an implementation to instantiate a variable:

        CharSequence charSequence1 = "baeldung";
        //Here, charSequence is instantiated with a String. Instantiating other implementations:

        CharSequence charSequence2 = new StringBuffer("baeldung");
        CharSequence charSequence3 = new StringBuilder("baeldung");
    }

    @Test
    public void givenUsingString_whenInstantiatingString_thenWrong() {
        CharSequence firstString = "baeldung";
        String secondString = "baeldung";

        assertEquals(firstString, secondString);
        System.out.println(firstString.equals(secondString));//true
    }


    //Let's compare the differences and commonalities of CharSequence and String.
    // They both reside in the same package named java.lang.,
    // but the former is an interface and latter is a concrete class.
    // Moreover, the String class is immutable.

    //In the following example, each sum operation creates another instance,
    // increases the amount of data stored and returns the most recently created String:

    @Test
    public void givenString_whenAppended_thenUnmodified() {
        String test = "a";
        int firstAddressOfTest = System.identityHashCode(test);
        System.out.println(firstAddressOfTest);//161960012

        test += "b";
        int secondAddressOfTest = System.identityHashCode(test);
        System.out.println(secondAddressOfTest);//738433734

        assertNotEquals(firstAddressOfTest, secondAddressOfTest);
    }

    //On the other hand, StringBuilder updates the already created String to hold the new value:
    @Test
    public void givenStringBuilder_whenAppended_thenModified() {
        StringBuilder test = new StringBuilder();
        test.append("a");
        int firstAddressOfTest = System.identityHashCode(test);
        System.out.println(firstAddressOfTest);//1484594489

        test.append("b");
        int secondAddressOfTest = System.identityHashCode(test);
        System.out.println(secondAddressOfTest);//1484594489

        assertEquals(firstAddressOfTest, secondAddressOfTest);
    }


    //Another difference is that the interface does not imply a built-in comparison strategy,
    // whereas the String class implements the Comparable<String> interface.

    //To compare two CharSequences, we can cast them to Strings then subsequently compare them:

    @Test
    public void givenIdenticalCharSequences_whenCastToString_thenEqual() {
        CharSequence charSeq1 = "baeldung_1";
        CharSequence charSeq2 = "baeldung_2";

        assertTrue(charSeq1.toString().compareTo(charSeq2.toString()) < 0);
    }
}
