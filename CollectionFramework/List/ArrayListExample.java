package CollectionFramework.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// List Interface:
// Present in java.util package & a sub-interface of collection interface.
// Stores ordered collection of elements(known as a sequence)
// Allows for more precise control over where elements are inserted and can contain duplicate elements
// Features are Order preservation, Index-based access, Allows duplicates
// Implementation classes are ArrayList, LinkedList, Vector, Stack, etc.

// ArrayList Class:
// It is a re-sizable array implementation of the List interface.
// Unlike arrays which have a fixed size, it can change its size dynamically as elements are added or removed.

public class ArrayListExample
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<>(); //creates an arraylist of integer type element
        list.add(4); //adds element to 0th index
        list.add(45); //adds element to 1st index
        list.add(9); //adds element to 2nd index
        list.add(1,10); //adds the element to the 1st index and shifts other elements
        System.out.println(list.get(1)); //returns the element at 1st index
        System.out.println(list.size()); //returns the current size of the list
        System.out.println(list); // prints the list cause list has provided its own toString() implementation for printing
        list.contains(4); //checks the existence of given element & returns true/false.
        list.remove(3); //removes the element at the given index
        list.set(1,34); //replaces the element at the given index with the provided element
        //Internal Working of ArrayList:
        //It uses an internal array(whose default initial size/capacity is 10) in which the elements gets inserted one by one & when the array is full, then it creates a new array(with a larger capacity(usually 1.5 times the current capacity)) & copies all the elements from the old array to this new array & then adds the new element.
        //size() returns the index till which the elements have been filled in the internal array.
        //creating ArrayList with a specified initial capacity:
        //ArrayList<Integer> list = new ArrayList<>(20);
        //creating ArrayList from another collection:
        //List<String> anotherList = Arrays.asList("Predator","Syrex","Blaze"); //Arrays.asList() returns a fixed-size list constructed from the specified array i.e.,addition or removal of elements can't be done in this List
        //ArrayList<String> listFromCollection = new ArrayList<>(anotherList);
        //Another modern way of creating List
        List<Integer> list2 = List.of(1,2,3); //List.of() returns an unmodifiable list containing specified elements
        list.addAll(list2); //appends all the elements of the list2 to list1
        //Integer[] array = list.toArray(new Integer[0]); //converting list to array
        Collections.sort(list); //sorts the given list
    }
}
