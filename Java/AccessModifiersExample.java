// All in one file for demonstration

class PrivateExample {

    private int a = 10;

    private void display() {
        System.out.println("Private method called");
    }

    void testPrivate() {
        System.out.println("Private variable: " + a);
        display();
    }
}


// Default access class
class DefaultExample {

    int x = 20;

    void show() {
        System.out.println("Default method called");
    }
}


// Protected class
class ProtectedExample {

    protected int y = 30;

    protected void display() {
        System.out.println("Protected method called");
    }
}


// Public class (main class must be public)
public class AccessModifiersExample {

    public int z = 40;

    public void print() {
        System.out.println("Public method called");
    }

    public static void main(String[] args) {

        System.out.println("---- PRIVATE ----");
        PrivateExample p = new PrivateExample();
        p.testPrivate();   // accessing via method

        System.out.println("\n---- DEFAULT ----");
        DefaultExample d = new DefaultExample();
        System.out.println("Default variable: " + d.x);
        d.show();

        System.out.println("\n---- PROTECTED ----");
        ProtectedExample pr = new ProtectedExample();
        System.out.println("Protected variable: " + pr.y);
        pr.display();

        System.out.println("\n---- PUBLIC ----");
        AccessModifiersExample obj = new AccessModifiersExample();
        System.out.println("Public variable: " + obj.z);
        obj.print();

        System.out.println("\n---- CHILD CLASS ACCESS (PROTECTED) ----");
        ChildProtected child = new ChildProtected();
        child.accessProtected();
    }
}


// Child class to show protected access
class ChildProtected extends ProtectedExample {

    void accessProtected() {
        System.out.println("Accessing protected variable from child: " + y);
        display();
    }
}