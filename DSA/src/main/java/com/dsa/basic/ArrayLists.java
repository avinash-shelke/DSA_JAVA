package com.dsa.basic;

import com.dsa.basic.utils.Car;

import java.util.*;
import java.util.stream.Stream;

public class ArrayLists {
    public static void main(String [] args){
        // Example 1: Convert primitive int[] to ArrayList<Integer>
        int[] primitiveArr = {1, 2, 3, 4, 5};
        System.out.println("Length of primitive array: " + primitiveArr.length);
        ArrayList<Integer> arrList = new ArrayList<>();
        Arrays.stream(primitiveArr).forEach(arrList::add);
        System.out.println("Converted ArrayList: " + arrList);

        // Example 2: Adding null elements to an ArrayList at specific indices
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(1, null);  // inserting null at index 1
        arr.add(3, null);  // inserting null at index 3
        System.out.println("ArrayList with nulls: " + arr);

        // Example 3: Removing element by index
        arr.remove(2);
        System.out.println("After removal at index 2: " + arr);

        // Example 4: Accessing element and size
        Integer at = arr.get(1);
        System.out.println("Size of ArrayList: " + arr.size());

        // Example 5: Iterating over ArrayList
        System.out.println("Iterating using for-each:");
        for (Integer i : arr) {
            System.out.println(i);
        }

        // Example 6: Copying an ArrayList
        List<Integer> duplicate = new ArrayList<>(arr);
        System.out.println("Duplicate List: " + duplicate);

        // Example 7: Finding index of null and checking existence
        System.out.println("First index of null: " + arr.indexOf(null));
        System.out.println("Last index of null: " + arr.lastIndexOf(null));
        System.out.println("Does ArrayList contain null? " + arr.contains(null));

        // Example 8: Comparing null safely
        Object o = null;
        Boolean a = o == null;
        System.out.println("Is object null? " + a);

        // Example 9: Clearing ArrayList
        duplicate.clear();
        System.out.println("Cleared duplicate: " + duplicate);

        // Example 10: retainAll() - intersection of two ArrayLists
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1); arr1.add(2); arr1.add(3);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1); arr2.add(3); arr2.add(4);
        System.out.println("Original arr1: " + arr1);
        arr1.retainAll(arr2);
        System.out.println("arr1 after retainAll: " + arr1);

        // Example 11: Creating sublist from ArrayList
        ArrayList<Integer> subList = new ArrayList<>(arr.subList(0, 2));
        System.out.println("SubList: " + subList);

        // Example 12: Convert to Set (removes duplicates)
        HashSet<Integer> st = new HashSet<>();
        st.addAll(arr);
        System.out.println("Set from ArrayList: " + st);

        // Example 13: Converting to Array
        Object[] objects = arr.toArray();
        Integer[] intObjects = arr.toArray(new Integer[0]);
        System.out.println("Object array: " + Arrays.toString(objects));

        // Example 14: Arrays.asList and sorting
        Integer[] val = new Integer[]{9, 8, 7, 6};
        List<Integer> list = Arrays.asList(val);  // fixed-size list
        System.out.println("Original list: " + list);
        Collections.sort(list);
        System.out.println("Sorted list: " + list);

        // Example 15: Custom sorting with Comparator
        List<Car> list1 = new ArrayList<>();
        list1.add(new Car("Volvo V40", "XYZ 201845", 5));
        list1.add(new Car("Citroen C1", "ABC 164521", 4));
        list1.add(new Car("Dodge Ram", "KLM 845990", 2));

        Comparator<Car> carBrandComparator = new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.brand.compareTo(o2.brand);
            }
        };
        Collections.sort(list1, carBrandComparator);
        System.out.println("Sorted cars by brand:");
        for (Car car : list1) {
            System.out.println(car);
        }

        // Example 16: Iterating using Iterator
        Iterator<Integer> iterator = list.iterator();
        System.out.print("Using Iterator: ");
        while (iterator.hasNext()) {
            System.out.printf("%d", iterator.next());
        }
        System.out.println();

        // Example 17: Iterating using for-each
        System.out.print("Using for-each: ");
        for (Integer element : list) {
            System.out.printf("%d", element);
        }
        System.out.println();

        // Example 18: Iterating using index-based for loop
        System.out.print("Using index-based loop: ");
        for (int i = 0; i < list.size(); i++) {
            Integer ele = list.get(i);
            System.out.printf("%d", ele);
        }
        System.out.println();

        // Example 19: Stream operations
        System.out.print("Using Stream (doubled values): ");
        Stream<Integer> stream = list.stream();
        stream.forEach(ele -> {
            Integer v = ele * 2;
            System.out.printf("%s ", v);
        });
        System.out.println();
    }
}
