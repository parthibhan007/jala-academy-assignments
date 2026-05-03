public class StringsExample {

    public static void main(String[] args) {

        // 1. Different ways of creating strings
        String str1 = "Hello";                  // using literal
        String str2 = new String("World");      // using new keyword

        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);

        // 2. Concatenation using +
        String result = str1 + " " + str2;
        System.out.println("Concatenation: " + result);

        // 3. Length of string
        System.out.println("Length of str1: " + str1.length());

        // 4. Substring
        String sub = str1.substring(1, 4);  // from index 1 to 3
        System.out.println("Substring: " + sub);

        // 5. indexOf()
        int index = str1.indexOf('l');
        System.out.println("Index of 'l': " + index);

        // 6. matches()
        boolean match = str1.matches("Hello");
        System.out.println("Matches 'Hello': " + match);

        // 7 & 8. Comparing strings
        String str3 = "hello";

        System.out.println("equals: " + str1.equals(str3));
        System.out.println("equalsIgnoreCase: " + str1.equalsIgnoreCase(str3));
        System.out.println("startsWith: " + str1.startsWith("He"));
        System.out.println("endsWith: " + str1.endsWith("lo"));
        System.out.println("compareTo: " + str1.compareTo(str3));

        // 9. trim()
        String str4 = "  Java Programming  ";
        System.out.println("Before trim: " + str4);
        System.out.println("After trim: " + str4.trim());

        // 10. replace()
        String replaced = str1.replace('l', 'x');
        System.out.println("After replace: " + replaced);

        // 11. split()
        String str5 = "Apple,Banana,Mango";
        String fruits[] = str5.split(",");

        System.out.println("After split:");
        for (int i = 0; i < fruits.length; i++) {
            System.out.println(fruits[i]);
        }

        // 12. Number to String using valueOf()
        int num = 100;
        String numStr = String.valueOf(num);
        System.out.println("Number to String: " + numStr);

        // 13. Integer object to String
        Integer obj = 200;
        String objStr = obj.toString();
        System.out.println("Integer object to String: " + objStr);

        // 14. Uppercase and Lowercase
        System.out.println("Uppercase: " + str1.toUpperCase());
        System.out.println("Lowercase: " + str1.toLowerCase());
    }
}