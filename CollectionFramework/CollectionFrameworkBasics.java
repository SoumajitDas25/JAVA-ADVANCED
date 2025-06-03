package CollectionFramework;

// A collection is an object that represents a group of objects, known as its elements.
// It provides a set of interfaces and classes that help in managing groups of elements.

// The Collection Framework is primarily built around a set of Interfaces, key interfaces are as follows:
//1. Collection: The root interface for all the other collection types.
//2. List: An ordered collection that can contain duplicate elements(Ex- Arraylist, LinkedList).
//3. Set: An unordered collection that can contain duplicate elements(Ex- HashSet, TreeSet).
//4. Queue: A collection designed for holding elements prior to processing, based on FIFO principle(Ex- PriorityQueue, LinkedList when used as a queue).
//5. Deque: A double-ended queue that allows insertion & deletion from both ends(Ex- ArrayDeque).
//6. Map: An interface that represents a collection of key-value pairs(Ex- HashMap, TreeMap).

//Collection Hierarchy:
//On the root of the hierarchy, there is Iterable interface(we can apply foreach loop to any object of a class which implements this interface).
//Then comes the Collection interface(present in java.util package) which extends the Iterable interface(present in java.lang package)
//Below it are 3 interfaces: List, Set, Queue (which extends the Collection interface)
//Below them are their specific implementations either in form of classes or interfaces.
//Map, though being a part of the Collection Framework, doesn't inherit Collection or Iterable interface( It has its own hierarchy tree).

// Collection Interface:
// Present in java.util package
// It provides a blueprint for the basic operations that are common to all collections.
// It defines a set of core methods(that are implemented by all its implementation class) which allows for basic operations such as adding, removing, and checking the existence of elements in a collection.

public class CollectionFrameworkBasics
{
    public static void main(String[] args)
    {

    }
}
