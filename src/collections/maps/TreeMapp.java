package collections.maps;

import com.sun.source.tree.IdentifierTree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapp {
    public static void main(String[] args) {

        //String Wrapper Classlarda compartor() metodu override edilmiştir.oyuzden sıralayabilir.
        java.util.TreeMap<Integer,String>treeMap01=new java.util.TreeMap<>();
        treeMap01.put(6,"ZAnkara");
        treeMap01.put(35,"Izmir");
        treeMap01.put(1,"Adana");
        treeMap01.put(34,"Istanbul");
        System.out.println(treeMap01);//{1=Adana, 6=ZAnkara, 34=Istanbul, 35=Izmir}

        for(Map.Entry i: treeMap01.entrySet()){
            System.out.println(i);
        }

        Iterator iterator01;

        iterator01=treeMap01.entrySet().iterator();
        while (iterator01.hasNext()){
            System.out.println(iterator01.next());
            //1=Adana
//            6=ZAnkara
//            34=Istanbul
//            35=Izmir
        }

        iterator01=treeMap01.keySet().iterator();
        while (iterator01.hasNext()){
            System.out.println(iterator01.next());
            //1
            //6
            //34
            //35
        }

        iterator01=treeMap01.values().iterator();//TRAVERSING YAPAR
        while (iterator01.hasNext()){
            System.out.println(iterator01.next());
            //Adana
            //ZAnkara
            //Istanbul
            //Izmir
        }


        TreeMap<Student,Integer> tree=new TreeMap<>();
        for(int i=0; i<4; i++)
            tree.put(new Student(i,"Emre"+i),i);

        for (Map.Entry i: tree.entrySet())
            System.out.println(i);

        ///sıralama her zaman key'lere göre olur
        //ImmutableStudent{studentID=3, studentName='Emre3'}=3
        //ImmutableStudent{studentID=2, studentName='Emre2'}=2
        //ImmutableStudent{studentID=1, studentName='Emre1'}=1
        //ImmutableStudent{studentID=0, studentName='Emre0'}=0








        java.util.TreeMap <Student,String> studentTreeMap=new java.util.TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Student s1=(Student)o1;
                Student s2=(Student)o2;

                if(s1.getStudentID()<s2.getStudentID())
                    return 1;//kıyasladıgının sagına yaz
                else if(s1.getStudentID()>s2.getStudentID())
                    return -1;////kıyasladıgının soluna yaz
                else
                    return 0;
            }
        });
        Student s1=new Student(1,"Emre");
        Student s2=new Student(2,"Emre2");
        Student s3=new Student(3,"Emre3");
        Student s4=new Student(4,"Emre4");

        studentTreeMap.put(s1,"Duman");
        studentTreeMap.put(s2,"Duman2");
        studentTreeMap.put(s3,"Duman3");
        studentTreeMap.put(s4,"Duman4");

        iterator01=studentTreeMap.entrySet().iterator();
        while(iterator01.hasNext()){
            System.out.println(iterator01.next());
            //ImmutableStudent{studentID=4, studentName='Emre4'}=Duman4
            //ImmutableStudent{studentID=3, studentName='Emre3'}=Duman3
            //ImmutableStudent{studentID=2, studentName='Emre2'}=Duman2
            //ImmutableStudent{studentID=1, studentName='Emre'}=Duman
        }



        java.util.TreeMap<Student,String> studentTreeMap02=new java.util.TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2)
            {
                return o1.getStudentName().compareTo(o2.getStudentName());
                //kucukten buyuge

                //return o2.getStudentName().compareTo(o1.getStudentName());
                //buyukten kucuge
            }
        });


        studentTreeMap02.put(s1,"Duman");
        studentTreeMap02.put(s2,"Duman2");
        studentTreeMap02.put(s3,"Duman3");
        studentTreeMap02.put(s4,"Duman4");

        iterator01=studentTreeMap02.entrySet().iterator();
        while(iterator01.hasNext()){
            System.out.println(iterator01.next());
            //ImmutableStudent{studentID=1, studentName='Emre'}=Duman
            //ImmutableStudent{studentID=2, studentName='Emre2'}=Duman2
            //ImmutableStudent{studentID=3, studentName='Emre3'}=Duman3
            //ImmutableStudent{studentID=4, studentName='Emre4'}=Duman4
        }
    }
}



class Student implements Comparable<Student>//jvjvjcjgcjgcjg
{
    private int studentID;
    private String studentName;

    public Student(Integer studentID,String studentName){
        this.studentID=studentID;
        this.studentName=studentName;
    }
    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "ImmutableStudent{" +
                "studentID=" + studentID +
                ", studentName='" + studentName + '\'' +
                '}';
    }


    @Override
    public int compareTo(Student o) {
        if(this.studentID>o.studentID)
            return -1;
        else if(this.studentID<o.studentID)
            return 1;
        else
            return 0;
    }
}
