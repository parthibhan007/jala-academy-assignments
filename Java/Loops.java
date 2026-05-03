public class Loops {

    // 1. Print "Bright IT Career" 10 times
    void printMessage() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Bright IT Career");
        }
    }

    // 2. Print 1 to 20 using while
    void printNumbersWhile() {
        int i = 1;
        while (i <= 20) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();
    }

    // 3. Equal and Not Equal
    void checkEqual(int a, int b) {
        if (a == b) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }

    // 4. Odd and Even numbers (1 to 20)
    void printOddEven() {
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " is Even");
            } else {
                System.out.println(i + " is Odd");
            }
        }
    }

    // 5. Largest among three numbers
    void largestOfThree(int a, int b, int c) {
        if (a > b && a > c) {
            System.out.println("Largest: " + a);
        } else if (b > c) {
            System.out.println("Largest: " + b);
        } else {
            System.out.println("Largest: " + c);
        }
    }

    // 6. Even numbers between 10 and 100 using while
    void evenBetween() {
        int i = 10;
        while (i <= 100) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
            i++;
        }
        System.out.println();
    }

    // 7. Print 1 to 10 using do-while
    void doWhileExample() {
        int i = 1;
        do {
            System.out.print(i + " ");
            i++;
        } while (i <= 10);
        System.out.println();
    }

    // 8. Armstrong Number
    void armstrong(int num) {
        int temp = num;
        int sum = 0;

        while (num > 0) {
            int digit = num % 10;
            sum = sum + (digit * digit * digit);
            num = num / 10;
        }

        if (sum == temp) {
            System.out.println(temp + " is Armstrong");
        } else {
            System.out.println(temp + " is NOT Armstrong");
        }
    }

    // 9. Prime Number
    void prime(int num) {
        int count = 0;

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }

        if (count == 2) {
            System.out.println(num + " is Prime");
        } else {
            System.out.println(num + " is NOT Prime");
        }
    }

    // 10. Palindrome
    void palindrome(int num) {
        int temp = num;
        int reverse = 0;

        while (num > 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num = num / 10;
        }

        if (reverse == temp) {
            System.out.println(temp + " is Palindrome");
        } else {
            System.out.println(temp + " is NOT Palindrome");
        }
    }

    // 11. Even/Odd using switch
    void evenOddSwitch(int num) {
        switch (num % 2) {
            case 0:
                System.out.println("Even Number");
                break;
            case 1:
                System.out.println("Odd Number");
                break;
        }
    }

    // 12. Gender using switch
    void gender(char ch) {
        switch (ch) {
            case 'M':
                System.out.println("Male");
                break;
            case 'F':
                System.out.println("Female");
                break;
            default:
                System.out.println("Invalid Input");
        }
    }

    // 13. Largest using multiple if-else
    void largestUsingIfElse() {
        int a = 10, b = 20, c = 30;

        if (a > b && a > c) {
            System.out.println("Largest: " + a);
        } else if (b > c) {
            System.out.println("Largest: " + b);
        } else {
            System.out.println("Largest: " + c);
        }
    }

    // Main Method
    public static void main(String[] args) {

        Loops obj = new Loops();

        System.out.println("---- Print Message ----");
        obj.printMessage();

        System.out.println("\n---- While Loop ----");
        obj.printNumbersWhile();

        System.out.println("\n---- Equal Check ----");
        obj.checkEqual(10, 10);

        System.out.println("\n---- Odd/Even ----");
        obj.printOddEven();

        System.out.println("\n---- Largest of Three ----");
        obj.largestOfThree(10, 25, 15);

        System.out.println("\n---- Even Between 10-100 ----");
        obj.evenBetween();

        System.out.println("\n---- Do While ----");
        obj.doWhileExample();

        System.out.println("\n---- Armstrong ----");
        obj.armstrong(153);

        System.out.println("\n---- Prime ----");
        obj.prime(7);

        System.out.println("\n---- Palindrome ----");
        obj.palindrome(121);

        System.out.println("\n---- Switch Even/Odd ----");
        obj.evenOddSwitch(5);

        System.out.println("\n---- Gender ----");
        obj.gender('M');

        System.out.println("\n---- Largest (if-else) ----");
        obj.largestUsingIfElse();
    }
}