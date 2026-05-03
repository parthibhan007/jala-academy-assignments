public class ArraysExample {

    // 1. Sum of array
    void sum(int arr[]) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total = total + arr[i];
        }
        System.out.println("Sum: " + total);
    }

    // 2. Average
    void average(int arr[]) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        System.out.println("Average: " + (total / arr.length));
    }

    // 3. Find index
    void findIndex(int arr[], int value) {
        int found = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                found = i;
                break;
            }
        }
        System.out.println("Index: " + found);
    }

    // 4. Check contains
    void contains(int arr[], int value) {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                flag = true;
                break;
            }
        }
        System.out.println("Contains: " + flag);
    }

    // 5. Remove element
    void removeElement(int arr[], int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                break;
            }
        }

        System.out.print("After Removal: ");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 6. Copy array
    void copyArray(int arr[]) {
        int newArr[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        System.out.print("Copied Array: ");
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
        System.out.println();
    }

    // 7. Insert element
    void insert(int arr[], int value, int pos) {
        int newArr[] = new int[arr.length + 1];

        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i == pos) {
                newArr[i] = value;
            } else {
                newArr[i] = arr[j++];
            }
        }

        System.out.print("After Insert: ");
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
        System.out.println();
    }

    // 8. Min and Max
    void minMax(int arr[]) {
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }

    // 9. Reverse array
    void reverse(int arr[]) {
        System.out.print("Reversed: ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 10. Duplicate values
    void duplicates(int arr[]) {
        System.out.print("Duplicates: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.print(arr[i] + " ");
                    break;
                }
            }
        }
        System.out.println();
    }

    // 11. Common values between two arrays
    void common(int arr1[], int arr2[]) {
        System.out.print("Common Elements: ");
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    System.out.print(arr1[i] + " ");
                    break;
                }
            }
        }
        System.out.println();
    }

    // 12. Remove duplicates
    void removeDuplicates(int arr[]) {
        System.out.print("After Removing Duplicates: ");
        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    // 13. Second largest
    void secondLargest(int arr[]) {
        int first = arr[0];
        int second = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }

        System.out.println("Second Largest: " + second);
    }

    // 15. Count even & odd
    void countEvenOdd(int arr[]) {
        int even = 0, odd = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) even++;
            else odd++;
        }

        System.out.println("Even count: " + even);
        System.out.println("Odd count: " + odd);
    }

    // 16. Difference of max & min
    void difference(int arr[]) {
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }

        System.out.println("Difference: " + (max - min));
    }

    // 17. Check two elements exist
    void checkTwo(int arr[], int x, int y) {
        boolean f1 = false, f2 = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) f1 = true;
            if (arr[i] == y) f2 = true;
        }

        if (f1 && f2)
            System.out.println("Both elements found");
        else
            System.out.println("Elements not found");
    }

    // 19. Missing number (1–100)
    void missingNumber(int arr[]) {
        int expectedSum = 5050; // sum of 1 to 100
        int actualSum = 0;

        for (int i = 0; i < arr.length; i++) {
            actualSum += arr[i];
        }

        System.out.println("Missing number: " + (expectedSum - actualSum));
    }

    // Main
    public static void main(String[] args) {

        ArraysExample obj = new ArraysExample();

        int arr[] = {1, 2, 3, 4, 5, 3, 2};
        int arr2[] = {3, 4, 6, 7};

        obj.sum(arr);
        obj.average(arr);
        obj.findIndex(arr, 3);
        obj.contains(arr, 5);
        obj.removeElement(arr, 3);
        obj.copyArray(arr);
        obj.insert(arr, 10, 2);
        obj.minMax(arr);
        obj.reverse(arr);
        obj.duplicates(arr);
        obj.common(arr, arr2);
        obj.removeDuplicates(arr);
        obj.secondLargest(arr);
        obj.countEvenOdd(arr);
        obj.difference(arr);
        obj.checkTwo(arr, 2, 5);
    }
}