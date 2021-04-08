package exceptions.checked_compileTime_exc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLException02 {
    public static void main(String[] args) {


        //SQLException
        Connection com = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "username";
        String password = "password";
        //checked exceptiondır ve try catch block ister ya da main methodun
        ///signature ına throws ister ama bu sadece uyarıdır exception olusursa yine try catch gerekiyor
        try {
            com = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e);
            //java.sql.SQLException: No suitable driver found for jdbc:oracle:thin:@localhost:1521:XE
        }

    }
}
