import java.util.*;

public class CollectionsExample {

    public static void main(String[] args) {

        // ===================== 1. ARRAYLIST =====================
        System.out.println("---- ARRAYLIST ----");

        ArrayList<String> list = new ArrayList<>();

        // Add 10 elements
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");
        list.add("Seven");
        list.add("Eight");
        list.add("Nine");
        list.add("Ten");

        // Add element
        list.add("Eleven");

        // Iterate using Iterator
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Add at specific index
        list.add(2, "NewElement");

        // Remove element
        list.remove("Five");

        // Remove at index
        list.remove(3);

        // Update element
        list.set(1, "Updated");

        // Check element at index
        System.out.println("Element at index 2: " + list.get(2));

        // Size
        System.out.println("Size: " + list.size());

        // Contains
        System.out.println("Contains 'One': " + list.contains("One"));

        // Clear all
        list.clear();
        System.out.println("List cleared. Size: " + list.size());


        // ===================== 2. HASHMAP =====================
        System.out.println("\n---- HASHMAP ----");

        HashMap<Integer, String> map = new HashMap<>();

        // Add 10 key-value pairs
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        map.put(5, "E");
        map.put(6, "F");
        map.put(7, "G");
        map.put(8, "H");
        map.put(9, "I");
        map.put(10, "J");

        // Insert new pair
        map.put(11, "K");

        // Fetch value
        System.out.println("Value for key 3: " + map.get(3));

        // Clone map
        HashMap<Integer, String> mapCopy = new HashMap<>(map);

        // Check key
        System.out.println("Contains key 5: " + map.containsKey(5));

        // Check value
        System.out.println("Contains value 'A': " + map.containsValue("A"));

        // Check empty
        System.out.println("Is empty: " + map.isEmpty());

        // Size
        System.out.println("Size: " + map.size());

        // Print keys
        System.out.println("Keys:");
        for (Integer key : map.keySet()) {
            System.out.println(key);
        }

        // Print values
        System.out.println("Values:");
        for (String value : map.values()) {
            System.out.println(value);
        }

        // Remove key-value
        map.remove(2);

        // Copy to another map
        HashMap<Integer, String> map2 = new HashMap<>();
        map2.putAll(map);

        System.out.println("Copied Map: " + map2);


        // ===================== 3. HASHSET =====================
        System.out.println("\n---- HASHSET ----");

        HashSet<String> set = new HashSet<>();

        // Add 10 elements
        set.add("Apple");
        set.add("Banana");
        set.add("Mango");
        set.add("Orange");
        set.add("Grapes");
        set.add("Pineapple");
        set.add("Cherry");
        set.add("Peach");
        set.add("Lemon");
        set.add("Guava");

        // Add duplicate (will not be added)
        set.add("Apple");

        // Iterate
        for (String s : set) {
            System.out.println(s);
        }

        // Check contains
        System.out.println("Contains Mango: " + set.contains("Mango"));

        // Remove element
        set.remove("Banana");

        // Size
        System.out.println("Size: " + set.size());

        // Check empty
        System.out.println("Is empty: " + set.isEmpty());

        // Clear set
        set.clear();
        System.out.println("Set cleared. Size: " + set.size());
    }
}