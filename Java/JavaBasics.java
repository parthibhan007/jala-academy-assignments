// Program for Java Basics

/**
 * This class demonstrates basic Java concepts
 */
public class JavaBasics {

    // Global (instance) variable
    int num = 100;

    // Method to print name
    void printName() {
        System.out.println("My Name is Parthibhan");
    }

    public static void main(String[] args) {

        // Creating object
        JavaBasics obj = new JavaBasics();

        // 1. Print Name
        System.out.println("---- Printing Name ----");
        System.out.println("My Name is Parthibhan");

        // 2. Comments Example
        // This is single line comment

        /*
         This is multi-line comment
         Java Basics Program
        */

        /**
         * This is documentation comment
         */

        // 3. Data Types
        int a = 10;
        boolean b = true;
        char c = 'P';
        float d = 10.5f;
        double e = 20.99;

        System.out.println("---- Data Types ----");
        System.out.println("Integer: " + a);
        System.out.println("Boolean: " + b);
        System.out.println("Char: " + c);
        System.out.println("Float: " + d);
        System.out.println("Double: " + e);

        // 4. Local vs Global Variable
        int num = 50; // local variable

        System.out.println("---- Variable Scope ----");
        System.out.println("Local variable: " + num);
        System.out.println("Global variable: " + obj.num);

        // 5. Calling Method
        System.out.println("---- Method Call ----");
        obj.printName();
    }
}