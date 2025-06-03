package CollectionFramework.List;

import java.util.Vector;

//Vector class is part of java.util package & is one of the legacy classes that implements the List interface.
//Introduced in JDK 1.0 before collection framework & now a part of collection framework.
//It is Synchronized, making it thread-safe
//Used in multithreaded environments where thread safety is our concern

//Key features:
//Dynamic Array: Like arraylist, it is also a dynamic array
//Synchronized: All the methods in Vector class are synchronized, which makes it thread safe (which means multiple threads can work on a vector without the risk of corrupting the data). However, it introduces performance overhead in single threaded environments. In single thread environments, if we don't want thread safety then, then it's recommended to use ArrayList over it.
//Legacy class: It was a part of Java original release and is considered a legacy class.
//Resizing mechanism: when its current capacity is exceeded, it doubles its size by default.
//Random access: Similar to arrays and arraylist, it allows random access to elements, making it efficient for accessing elements using an index.

public class VectorExample
{
    public static void main(String[] args) throws InterruptedException
    {
        Vector<Integer> vector = new Vector<>(); //creates a vector with an initial capacity of 10
        //Vector<Integer> vector2 = new Vector<>(15); //creates a vector with specified initial capacity
        //Vector<Integer> vector3 = new Vector<>(15,5); //passing initial capacity & capacity increment
        //Vector<String> vector4 = new Vector<>(Arrays.asList("Predator","Syrex","Rio")); //creates a vector from a collection

        vector.add(4);//adds an element to the end
        vector.add(0,2); // adds an element at the specified index
        System.out.println(vector.get(1)); //returns the element at the specified index
        vector.set(1,45); //replaces the element at the specified index
        //vector.remove(1); // removes the element at the specified index
        vector.remove(Integer.valueOf(4)); //removes the first occurrence of the specified element
        System.out.println(vector.size()); //returns the no of elements in the vector
        System.out.println(vector.isEmpty()); //checks if the vector is empty
        System.out.println(vector.contains(Integer.valueOf(45))); //checks if the vector contains the specified element
        vector.clear(); //removes all element from the vector
        System.out.println(vector.capacity()); //returns the capacity of the vector

        //Internal Working: Similar to ArrayList, it also uses an internal array, which is resized to double by default when it exceeds its capacity.

        //Since vector methods are synchronized, so it is thread-safe which means only one thread can access it at a time.
        Thread t1 = new Thread(()->{
            for(int i =0;i<1000;i++)
            {
                vector.add(i);
            }
        });
        Thread t2 = new Thread(()->{
            for(int i =0;i<1000;i++)
            {
                vector.add(i);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(vector.size()); //it will always give 2000
    }
}
