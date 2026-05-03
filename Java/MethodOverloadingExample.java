public class MethodOverloadingExample {

    // 1. Same name, different number of parameters (same type)
    void add(int a) {
        System.out.println("One parameter: " + a);
    }

    void add(int a, int b) {
        System.out.println("Two parameters: " + (a + b));
    }


    // 2. Same name, different number of parameters (different type)
    void show(int a) {
        System.out.println("Integer value: " + a);
    }

    void show(int a, double b) {
        System.out.println("Int and Double: " + a + ", " + b);
    }


    // 4. Same name, same number of parameters, different type
    void display(int a) {
        System.out.println("Display int: " + a);
    }

    void display(String a) {
        System.out.println("Display String: " + a);
    }


    // 5. Different return type (NOT VALID for overloading alone)
    int test(int a) {
        return a;
    }

    // ❌ This is NOT allowed (same parameters, different return type)
    /*
    double test(int a) {
        return a;
    }
    */

    public static void main(String[] args) {

        MethodOverloadingExample obj = new MethodOverloadingExample();

        System.out.println("---- 1 ----");
        obj.add(5);
        obj.add(5, 10);

        System.out.println("\n---- 2 ----");
        obj.show(10);
        obj.show(10, 20.5);

        System.out.println("\n---- 4 ----");
        obj.display(100);
        obj.display("Hello");

        System.out.println("\n---- Return Type Example ----");
        System.out.println("Returned value: " + obj.test(50));
    }
}