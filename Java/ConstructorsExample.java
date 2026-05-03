// Super class
class Parent {

    // Default constructor
    Parent() {
        System.out.println("Parent Default Constructor");
    }

    // One argument constructor
    Parent(int a) {
        System.out.println("Parent One-Arg Constructor: " + a);
    }
}


// Child class
public class ConstructorsExample extends Parent {

    // 3. Different access modifiers

    public ConstructorsExample() {
        System.out.println("Public Default Constructor");
    }

    protected ConstructorsExample(int a) {
        super(a);   // calling parent constructor
        System.out.println("Protected Constructor: " + a);
    }

    ConstructorsExample(int a, int b) {   // default access
        super();   // calling parent default constructor
        System.out.println("Default Constructor (2 args): " + a + ", " + b);
    }

    private ConstructorsExample(String s) {
        System.out.println("Private Constructor: " + s);
    }

    // Method to call private constructor
    static void callPrivate() {
        ConstructorsExample obj = new ConstructorsExample("Private Call");
    }

    public static void main(String[] args) {

        System.out.println("---- Creating Objects ----");

        // 1. Calling different constructors
        ConstructorsExample obj1 = new ConstructorsExample();
        ConstructorsExample obj2 = new ConstructorsExample(10);
        ConstructorsExample obj3 = new ConstructorsExample(10, 20);

        // 2. Super class constructors are already called using super()

        // 3. Calling private constructor
        callPrivate();

        // 5. Calling constructor multiple times
        System.out.println("\n---- Multiple Object Creation ----");
        ConstructorsExample obj4 = new ConstructorsExample();
        ConstructorsExample obj5 = new ConstructorsExample();

        // NOTE:
        // Same object cannot call constructor again
        // Constructor is called only at object creation
    }
}