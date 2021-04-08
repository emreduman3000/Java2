package exceptions.unchecked_runTime_exc;

import java.util.Scanner;

public class InputMismatchException01 {

    public static void main(String[] args) {
        // Reading user input
        Scanner input_dev = new Scanner(System.in);//a yaz
        System.out.print("Enter your age in Numbers: ");

        try{
            int age1 = input_dev.nextInt();

            if (age1>20) {
                System.out.println("You can view the page");
            } else {
                System.out.println("You cannot view the page");
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
