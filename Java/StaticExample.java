public class StaticExample {

    // 1. Static variables
    static int a = 10;
    static int b = 20;

    // Instance variables
    int x = 100;
    int y = 200;

    // 2. Static methods
    static void staticMethod1() {
        System.out.println("Static Method 1");
    }

    static void staticMethod2() {
        System.out.println("Static Method 2");
    }

    // Instance methods
    void instanceMethod1() {
        System.out.println("Instance Method 1");
    }

    void instanceMethod2() {
        System.out.println("Instance Method 2");
    }

    // 3. Print instance variables in static method
    static void printInstanceVariables() {
        StaticExample obj = new StaticExample();
        System.out.println("Instance x: " + obj.x);
        System.out.println("Instance y: " + obj.y);
    }

    // 4. Print static variables in instance method
    void printStaticVariables() {
        System.out.println("Static a: " + a);
        System.out.println("Static b: " + b);
    }

    // 5. Call instance methods in static method
    static void callInstanceMethods() {
        StaticExample obj = new StaticExample();
        obj.instanceMethod1();
        obj.instanceMethod2();
    }

    // 6. Call static methods in instance method
    void callStaticMethods() {
        staticMethod1();
        staticMethod2();
    }

    // Main method
    public static void main(String[] args) {

        StaticExample obj = new StaticExample();

        // Print all variables
        System.out.println("---- Variables ----");
        System.out.println("Static a: " + a);
        System.out.println("Static b: " + b);
        System.out.println("Instance x: " + obj.x);
        System.out.println("Instance y: " + obj.y);

        // Call static methods
        System.out.println("\n---- Static Methods ----");
        staticMethod1();
        staticMethod2();

        // Call instance methods
        System.out.println("\n---- Instance Methods ----");
        obj.instanceMethod1();
        obj.instanceMethod2();

        // Print instance variables in static method
        System.out.println("\n---- Instance in Static ----");
        printInstanceVariables();

        // Print static variables in instance method
        System.out.println("\n---- Static in Instance ----");
        obj.printStaticVariables();

        // Call instance methods in static
        System.out.println("\n---- Call Instance in Static ----");
        callInstanceMethods();

        // Call static methods in instance
        System.out.println("\n---- Call Static in Instance ----");
        obj.callStaticMethods();
    }
}