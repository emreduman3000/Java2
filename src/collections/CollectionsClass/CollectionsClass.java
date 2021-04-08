package collections.CollectionsClass;

import collections.lists.ArrayLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsClass {
    public static void main(String[] args) {

        Student student=new Student(3,"Emre");
        Student student2=new Student(1,"Tubi");
        Student student3=new Student(2,"Emine");

        ArrayList<Student> studentArrayLists=new ArrayList<>();
        studentArrayLists.add(student);
        studentArrayLists.add(student2);
        studentArrayLists.add(student3);
        System.out.println(studentArrayLists);
        //[ImmutableStudent{id=3, name='Emre'}, ImmutableStudent{id=1, name='Tubi'}, ImmutableStudent{id=2, name='Emine'}]

        //Collections.max en büyük değeri döndürür. neye göre en büyük isme göre
        Student eldestStd= Collections.max(studentArrayLists, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2)
            {
                if(o1.name.compareTo(o2.name)<0){
                    return -1;
                }
                else if(o1.name.compareTo(o2.name)>0){
                    return 1;
                }
                else return 0;
            }
        });
        System.out.println(eldestStd);//ImmutableStudent{id=1, name='Tubi'}


        //Collections.min min  değeri döndürür. neye göre min isme göre
        Student youngestStd= Collections.min(studentArrayLists, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2)
            {
                if(o1.name.compareTo(o2.name)<0){
                    return -1;
                }
                else if(o1.name.compareTo(o2.name)>0){
                    return 1;
                }
                else return 0;
            }
        });
        System.out.println(youngestStd);//ImmutableStudent{id=2, name='Emine'}

        Collections.sort(studentArrayLists, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.id> o2.id){//büyükten küçüğe
                    return -1;
                }
                else if(o1.id<o2.id){
                    return 1;
                }
                else return 0;
            }
        });
        System.out.println(studentArrayLists);
        //[ImmutableStudent{id=3, name='Emre'}, ImmutableStudent{id=2, name='Emine'}, ImmutableStudent{id=1, name='Tubi'}]

        Collections.sort(studentArrayLists);
        System.out.println(studentArrayLists);
        //[ImmutableStudent{id=1, name='Tubi'}, ImmutableStudent{id=2, name='Emine'}, ImmutableStudent{id=3, name='Emre'}]

        Collections.reverse(studentArrayLists);
        System.out.println(studentArrayLists);
        //[ImmutableStudent{id=3, name='Emre'}, ImmutableStudent{id=2, name='Emine'}, ImmutableStudent{id=1, name='Tubi'}]

        Collections.shuffle(studentArrayLists);
        System.out.println(studentArrayLists);
        //[ImmutableStudent{id=2, name='Emine'}, ImmutableStudent{id=3, name='Emre'}, ImmutableStudent{id=1, name='Tubi'}]
        //herdefasında karıstırır

        //binarySearch() yaomadan önce sorting yapmamız gerekiyor!!!!
        int studentVarMı = Collections.binarySearch(studentArrayLists,student3);
        int studentVarMı2 = Collections.binarySearch(studentArrayLists,new Student(10,"azra"));
        System.out.println(studentVarMı);//2 indexinde var
        System.out.println(studentVarMı2);//-4 yok böyle bir std


        ArrayList spareList=new ArrayList(studentArrayLists);
        System.out.println(spareList);//[ImmutableStudent{id=1, name='Tubi'}, ImmutableStudent{id=2, name='Emine'}, ImmutableStudent{id=3, name='Emre'}]

    }
}

class Student implements Comparable<Student>
{
    int id;
    String name;

    public Student(int i,String s) {
        id=i;
        name=s;
    }

    @Override
    public String toString() {
        return "ImmutableStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if(this.id< o.id){
            return -1;
        }
        else if(this.id>o.id){
            return 1;
        }
        else return 0;
    }
}