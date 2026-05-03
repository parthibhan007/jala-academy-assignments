public class Operators {

    // 1. Arithmetic Operators
    void arithmetic(int a, int b) {
        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));

        if (b != 0) {
            System.out.println("Division: " + (a / b));
        } else {
            System.out.println("Division not possible");
        }
    }

    // 2. Increment and Decrement
    void incrementDecrement(int x) {
        System.out.println("Original value: " + x);

        x++;
        System.out.println("After Increment: " + x);

        x--;
        System.out.println("After Decrement: " + x);
    }

    // 3 & 4. Equal and Not Equal
    void checkEqual(int a, int b) {
        if (a == b) {
            System.out.println("Both numbers are equal");
        } else {
            System.out.println("Numbers are NOT equal");
        }

        if (a != b) {
            System.out.println("Confirmed: Numbers are different");
        }
    }

    // 5. Logical Operators
    void logicalOperators(int a, int b) {
        if (a > 0 && b > 0) {
            System.out.println("Both numbers are positive (AND)");
        }

        if (a > 0 || b > 0) {
            System.out.println("At least one number is positive (OR)");
        }

        if (!(a > b)) {
            System.out.println("a is NOT greater than b (NOT)");
        }
    }

    // 6. Relational Operators
    void relational(int a, int b) {
        System.out.println("a < b : " + (a < b));
        System.out.println("a <= b : " + (a <= b));
        System.out.println("a > b : " + (a > b));
        System.out.println("a >= b : " + (a >= b));
    }

    // 7. Smaller and Larger Number
    void findMinMax(int a, int b) {
        if (a > b) {
            System.out.println("Larger number: " + a);
            System.out.println("Smaller number: " + b);
        } else if (b > a) {
            System.out.println("Larger number: " + b);
            System.out.println("Smaller number: " + a);
        } else {
            System.out.println("Both numbers are equal");
        }
    }

    // Main Method
    public static void main(String[] args) {

        Operators obj = new Operators();

        int a = 10;
        int b = 5;

        System.out.println("---- Arithmetic ----");
        obj.arithmetic(a, b);

        System.out.println("\n---- Increment/Decrement ----");
        obj.incrementDecrement(a);

        System.out.println("\n---- Equality Check ----");
        obj.checkEqual(a, b);

        System.out.println("\n---- Logical Operators ----");
        obj.logicalOperators(a, b);

        System.out.println("\n---- Relational Operators ----");
        obj.relational(a, b);

        System.out.println("\n---- Min and Max ----");
        obj.findMinMax(a, b);
    }
}