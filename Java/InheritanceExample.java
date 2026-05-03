// Super class A
class A {

    int value = 10;

    void methodA1() {
        System.out.println("Method A1 (specific to A)");
    }

    void methodA2() {
        System.out.println("Method A2 (specific to A)");
    }

    // Overridden method
    void commonMethod() {
        System.out.println("Common method in class A");
    }
}


// Subclass B extends A
class B extends A {

    int value = 20;

    void methodB1() {
        System.out.println("Method B1 (specific to B)");
    }

    void methodB2() {
        System.out.println("Method B2 (specific to B)");
    }

    // Overriding method
    void commonMethod() {
        System.out.println("Common method in class B");
    }
}


// Subclass C extends B
class C extends B {

    int value = 30;

    void methodC1() {
        System.out.println("Method C1 (specific to C)");
    }

    void methodC2() {
        System.out.println("Method C2 (specific to C)");
    }

    // Overriding method
    void commonMethod() {
        System.out.println("Common method in class C");
    }
}


// Main class
public class InheritanceExample {

    public static void main(String[] args) {

        // Creating objects
        A objA = new A();
        B objB = new B();
        C objC = new C();

        System.out.println("---- Calling methods of A ----");
        objA.methodA1();
        objA.methodA2();
        objA.commonMethod();

        System.out.println("\n---- Calling methods of B ----");
        objB.methodA1();   // inherited
        objB.methodB1();
        objB.methodB2();
        objB.commonMethod();

        System.out.println("\n---- Calling methods of C ----");
        objC.methodA1();   // inherited
        objC.methodB1();   // inherited
        objC.methodC1();
        objC.methodC2();
        objC.commonMethod();

        // Runtime Polymorphism (method overriding)
        System.out.println("\n---- Runtime Polymorphism (Methods) ----");

        A ref;

        ref = new B();
        ref.commonMethod();   // calls B version

        ref = new C();
        ref.commonMethod();   // calls C version


        // Data Members (Instance Variables)
        System.out.println("\n---- Data Members ----");

        System.out.println("A value: " + objA.value);
        System.out.println("B value: " + objB.value);
        System.out.println("C value: " + objC.value);

        // Using superclass reference
        System.out.println("\n---- Polymorphism with Data Members ----");

        ref = new B();
        System.out.println("Value using A ref to B object: " + ref.value);

        ref = new C();
        System.out.println("Value using A ref to C object: " + ref.value);
    }
}