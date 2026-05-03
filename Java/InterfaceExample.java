// 1. Interface with one method
interface OneMethod {
    void show();
}

class OneClass implements OneMethod {
    public void show() {
        System.out.println("1. Single method implemented");
    }
}


// 2. Interface with two methods
interface TwoMethods {
    void method1();
    void method2();
}

class PartialClass implements TwoMethods {
    public void method1() {
        System.out.println("2. Only method1 implemented");
    }

    public void method2() {
        System.out.println("method2 also implemented (mandatory in Java)");
    }
}


// 4. Two interfaces, one method each
interface A1 {
    void methodA();
}

interface B1 {
    void methodB();
}

class MultiClass implements A1, B1 {
    public void methodA() {
        System.out.println("4. Method A");
    }

    public void methodB() {
        System.out.println("4. Method B");
    }
}


// 5. Same method in two interfaces
interface X {
    void display();
}

interface Y {
    void display();
}

class SameMethodClass implements X, Y {
    public void display() {
        System.out.println("5. Same method implemented once");
    }
}


// 6. Default method
interface DefaultInterface {
    default void defaultMethod() {
        System.out.println("6. Default method in interface");
    }
}

class DefaultClass implements DefaultInterface {
    // no override needed
}


// 7. Interface inheritance
interface ParentInterface {
    void parentMethod();
}

interface ChildInterface extends ParentInterface {
    void childMethod();
}

class InheritInterfaceClass implements ChildInterface {
    public void parentMethod() {
        System.out.println("7. Parent method");
    }

    public void childMethod() {
        System.out.println("7. Child method");
    }
}


// 8. Public interface with fields
interface PublicInterface {
    int value = 100;   // automatically public static final

    void print();
}

class PublicImpl implements PublicInterface {
    public void print() {
        System.out.println("8. Interface value: " + value);
    }
}


// 10 & 11. Interface with variables
interface VariableInterface {
    int a = 10;   // public static final by default
    int b = 20;
}

public class InterfaceExample {

    public static void main(String[] args) {

        System.out.println("---- 1 ----");
        OneClass o = new OneClass();
        o.show();

        System.out.println("\n---- 2 ----");
        PartialClass p = new PartialClass();
        p.method1();

        System.out.println("\n---- 3 (Interface reference) ----");
        OneMethod ref = new OneClass();
        ref.show();

        System.out.println("\n---- 4 ----");
        MultiClass m = new MultiClass();
        m.methodA();
        m.methodB();

        System.out.println("\n---- 5 ----");
        SameMethodClass s = new SameMethodClass();
        s.display();

        System.out.println("\n---- 6 ----");
        DefaultClass d = new DefaultClass();
        d.defaultMethod();

        System.out.println("\n---- 7 ----");
        InheritInterfaceClass i = new InheritInterfaceClass();
        i.parentMethod();
        i.childMethod();

        System.out.println("\n---- 8 ----");
        PublicImpl pub = new PublicImpl();
        pub.print();

        System.out.println("\n---- 10 & 11 ----");
        System.out.println("a: " + VariableInterface.a);
        System.out.println("b: " + VariableInterface.b);
    }
}