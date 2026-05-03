import java.io.*;
import java.sql.*;

public class ExceptionExample {

    // 3. Method that throws exception
    static void methodThrows() throws ArithmeticException {
        int a = 10 / 0;
    }

    // 6. Custom Exception
    static class MyException extends Exception {
        MyException(String msg) {
            super(msg);
        }
    }

    public static void main(String[] args) {

        // 1. Arithmetic Exception (without handling)
        System.out.println("1. Arithmetic Exception (no handling)");
        try {
            int a = 10 / 0;
        } catch (Exception e) {
            System.out.println("Handled to avoid crash");
        }

        // 2. Arithmetic Exception with try-catch
        System.out.println("\n2. Arithmetic Exception with try-catch");
        try {
            int a = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }

        // 3. Calling method without try (handled here)
        System.out.println("\n3. Method throws exception");
        try {
            methodThrows();
        } catch (Exception e) {
            System.out.println("Exception from method");
        }

        // 4. Multiple catch blocks
        System.out.println("\n4. Multiple catch");
        try {
            int arr[] = new int[2];
            arr[5] = 10;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index error");
        }

        // 5. Throw exception with message
        System.out.println("\n5. Throw custom message");
        try {
            throw new Exception("My custom error");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 6. Custom exception
        System.out.println("\n6. Custom exception");
        try {
            throw new MyException("This is my exception");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

        // 7. Finally block
        System.out.println("\n7. Finally block");
        try {
            int a = 5 / 1;
        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            System.out.println("Finally always runs");
        }

        // 8. Arithmetic Exception
        try {
            int a = 10 / 0;
        } catch (Exception e) {
            System.out.println("Arithmetic Exception");
        }

        // 9. ArrayIndexOutOfBoundsException
        try {
            int arr[] = new int[2];
            arr[3] = 5;
        } catch (Exception e) {
            System.out.println("ArrayIndexOutOfBoundsException");
        }

        // 10. ClassNotFoundException
        try {
            Class.forName("TestClass");
        } catch (Exception e) {
            System.out.println("ClassNotFoundException");
        }

        // 11. FileNotFoundException
        try {
            FileReader f = new FileReader("abc.txt");
        } catch (Exception e) {
            System.out.println("FileNotFoundException");
        }

        // 12. IOException
        try {
            FileReader f = new FileReader("abc.txt");
            f.read();
        } catch (Exception e) {
            System.out.println("IOException");
        }

        // 13. NoSuchFieldException
        try {
            Class cls = String.class;
            cls.getField("abc");
        } catch (Exception e) {
            System.out.println("NoSuchFieldException");
        }

        // 14. NoSuchMethodException
        try {
            Class cls = String.class;
            cls.getMethod("abc");
        } catch (Exception e) {
            System.out.println("NoSuchMethodException");
        }

        // 15. NullPointerException
        try {
            String s = null;
            s.length();
        } catch (Exception e) {
            System.out.println("NullPointerException");
        }

        // 16. NumberFormatException
        try {
            int num = Integer.parseInt("abc");
        } catch (Exception e) {
            System.out.println("NumberFormatException");
        }

        // 17. StringIndexOutOfBoundsException
        try {
            String s = "Hello";
            s.charAt(10);
        } catch (Exception e) {
            System.out.println("StringIndexOutOfBoundsException");
        }

        // 18. SQLException (simulation)
        try {
            throw new SQLException("Database error");
        } catch (Exception e) {
            System.out.println("SQLException");
        }
    }
}