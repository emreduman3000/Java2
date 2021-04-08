package IOHandling.character;


import java.io.*;
import java.util.*;


public class Practice02 {

    public static void main(String[] args) {

        ArrayList<Employee> employees= new ArrayList<>();

        readFile(employees);
        System.out.println(employees);
        writeFile(employees);


    }

    private static void readFile(ArrayList<Employee> employees) {

        try(BufferedReader readAtOnce =new BufferedReader(new FileReader("salary.txt"))) {

            String currentLine = readAtOnce.readLine();//sırayla gezer, null return ederse stop dicez


            while (currentLine != null){

                String[] line = currentLine.split(" ");
                Employee emp=new Employee(line[0],Integer.parseInt(line[1]));
                employees.add(emp);
            }

            System.out.println(employees);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if( o1.salary< o2.salary)
                    return 1;
                else if(o1.salary< o2.salary)
                    return -1;
                else
                    return 0;
            }
        });

    }

    private static void writeFile(ArrayList<Employee> employees) {

        try(BufferedWriter writeAtOnce =new BufferedWriter(new FileWriter("orderedSalaries.txt"))) {
            for (Employee e: employees){
                writeAtOnce.write(e.name+ " "+ e.salary);
                writeAtOnce.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class Employee{

    String name;
    int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary.txt=" + salary +
                '}';
    }
}