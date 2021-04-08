package enums;

/*
A Java Enum is a special Java type used to define collections of constants.
More precisely, a Java enum type is a special kind of Java class.
An enum can contain constants, methods etc. Java enums were added in Java 5.

This Java enum tutorial explains how to create and use a Java enum.
If you prefer video, I have a video version of this tutorial here:
 */

import jdk.swing.interop.SwingInterOpUtils;

//enum cannot extends a class
//enum can implements interface
//enum cannot create an object
//enum used when you have constant values like months days colors deck of cards
public enum Level {
    HIGH,//public static final String HIGH="HIGH"; ILE AYNIDIR, OVERRIDE EDILEMEZ,UNCHANGEABLE'DIR
    MEDIUM,
    LOW,

    Level(){
    }
}
