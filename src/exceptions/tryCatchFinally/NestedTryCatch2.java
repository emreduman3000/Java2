package exceptions.tryCatchFinally;

public class NestedTryCatch2 {
    public static void main(String[] args)
    {
        String[] array={"abc","123",null,"a"};
        for(int i=0;i< array.length+2;i++) {

            try
            {
                int number = array[i].length();
                //there are more than 1 exception

                try
                {
                    number= Integer.parseInt(array[i]);

                    try {
                        array[8]="1";
                    }
                     catch (ArrayIndexOutOfBoundsException e){
                        System.out.println(e);
                    }
                }
                catch (NumberFormatException e){//burada cıkacak hata budur
                    System.out.println(e);
                }
            }
            catch (NullPointerException | ArrayIndexOutOfBoundsException e){
                System.out.println(e);
            }

        }
    }
}
