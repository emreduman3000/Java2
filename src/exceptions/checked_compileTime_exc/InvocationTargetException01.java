package exceptions.checked_compileTime_exc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SuppressWarnings("unused")
public class InvocationTargetException01 {

//InvocationTargetException
//        This type of exception wraps an exception thrown by an invoked method or a constructor.
//        The thrown exception can be accessed with the help of the getTargetException method.
//        For example, consider the following code snippet:


    //	at exceptions.checked_compileTime_exc.InvocationTargetException01.main(InvocationTargetException01.java:24)
    private int test_sample(String s1) {
        if (s1.length() == 0)
            throw new IllegalArgumentException("The string should have at least one character!");
        System.out.println("Inside test_sample: argument's value equals to:  s1 " );
        return 0;
    }

    public static void main(String... args) {
        try {
            Class<?> c1 = Class.forName("main.samplejava. Example");
            Object t1 = c1.newInstance();
            Method[] declared_Methods = c1.getDeclaredMethods();
            for (Method method : declared_Methods) {
                String methodName = method.getName();
                if (methodName.contains("main"))
                    continue;

                System.out.format("Invoking %s()%n", methodName);

                try {
                    method.setAccessible(true);
                    Object returnValue = method.invoke(t1, "");
                    System.out.format("%s() returned: %d%n", methodName, returnValue);
                } catch (InvocationTargetException ex) {
                    System.err.println("An InvocationTargetException was caught!");
                    Throwable cause = ex.getCause();
                    System.out.format("Invocation of %s failed because of: %s%n",
                            methodName, cause.getMessage());
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.err.println("The following exception was thrown:");
            ex.printStackTrace();
        }
    }
}