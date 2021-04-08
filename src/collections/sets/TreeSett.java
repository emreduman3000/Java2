package collections.sets;

import java.util.TreeSet;

public class TreeSett {
    public static void main(String[] args) {

        TreeSet<String> treeSet=new TreeSet<>();
        //TreeSet<String> treeSet=new TreeSet<>();//sıralam yapacagı icin aynı türde olmlaı
        treeSet.add("2");
        treeSet.add("2");//setlerde tekrarlama olmz
        treeSet.add("1");
        treeSet.add("0");
        treeSet.add("C");
        treeSet.add("B");
        treeSet.add("A");
        //treeSet.add(null);//sıralayamaz tree de
        System.out.println(treeSet);//[0, 1, 2, A, B, C]
        //ASCII DEGERLENEE GORE



    }
}
