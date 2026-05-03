// Parent class
class Parent {

    int a = 10;

    Parent() {
        System.out.println("Parent default constructor");
    }

    Parent(int x) {
        System.out.println("Parent parameterized constructor: " + x);
    }
}


// Child class
public class ThisSuperExample extends Parent {

    int a = 20;

    // 3. Call constructor of current class using this()
    ThisSuperExample() {
        this(50);   // calling parameterized constructor
        System.out.println("Child default constructor");
    }

    // 4. Call argument constructor using this()
    ThisSuperExample(int x) {
        super(x);   // 5. calling parent constructor
        System.out.println("Child parameterized constructor: " + x);
    }

    // 1. Print current class variables using this
    void printCurrent() {
        System.out.println("Using this: " + this.a);
        System.out.println("Without this: " + a);
    }

    // 2. Print parent class variables using super
    void printParent() {
        System.out.println("Using super: " + super.a);
    }

    // 6. Using this() and super() in methods (indirect way)
    void callMethods() {
        this.printCurrent();   // calling using this
        this.printParent();

        // Note:
        // this() and super() cannot be directly used inside methods
        // They are only used in constructors
    }

    public static void main(String[] args) {

        System.out.println("---- Object Creation ----");
        ThisSuperExample obj = new ThisSuperExample();

        System.out.println("\n---- Current Class ----");
        obj.printCurrent();

        System.out.println("\n---- Parent Class ----");
        obj.printParent();

        System.out.println("\n---- Method Calls ----");
        obj.callMethods();
    }
}