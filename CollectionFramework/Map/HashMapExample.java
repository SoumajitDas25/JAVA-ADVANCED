package CollectionFramework.Map;

import java.util.*;

//A Map is an object that map keys to values.
//It cannot contain duplicate keys & each key can map to at most one value.
//It does not extend the collection interface though being a part of collection framework.
//Key characteristics:
//1. Key-value pairs: Each entry in a map consists of a key & a value.
//2. Unique keys: No two entries can have the same key.
//3. One value per key: Each key maps to a single value.
//4. Order: Some implementation classes maintain insertion order(LinkedHashMap), natural order(TreeMap), or no order(HashMap).

//HashMap:
//It is an implementation class of Map interface
//Characteristics:
//1. Unordered: Does not maintain any order of its element.
//2. Allows null keys and values: can have only one null key and multiple null values.
//3. Not Synchronized: Not thread-safe, requires external synchronization if used in a multithreaded context.
//4. Performance: Offers constant-time performance(O(1)) for basic operations like get and put and contains

//Internal Components of a hashmap:
//1. Key: The identifier used to retrieve the value.
//2. Value: The data associated with the key.
//3. Bucket: A place where key-value pairs are stored.
//4. Array: An array to store the nodes(containing key & value).
//5. Hash function: Converts a key into a hashcode which is then used to calculate the index(bucket location) in the array where the node will be stored. (Each bucket can store multiple nodes handled by linkedList or red-black tree after java 8)

//The Hash function is an algorithm that takes key as an input & returns a fixed-size string of bytes, typically a numerical value which is known as hash code, hash value or simply hash. Its primary purpose is to map data of arbitrary size to data of fixed size.
//Internally it first converts the key to its raw hash using key.hasCode() which is then done bit-spreading to produce the processed hash which is returned by it.
//Index is then calculated using this hashcode by methods like get(),put(),etc (int index = hashcode % arraySize or hashcode & arraySize).
//If the index comes out to be the same for two diff keys(whose hashcode comes out to be the same) then its called Collision which is handled by a LinkedList( or balanced tree(Red-black tree) after java 8) by storing the new node to the next pointer of existing node).
//1. key.hashCode() -> returns raw hash
//2. HashMap.hash(key) -> returns processed hash
//3. put()/get() -> takes the hash and compute index

//Node structure:
//1. hash: hashcode of the key
//2. key: key itself
//3. value: the value associated with the key
//4. next: pointer to the next node is case of a collision

//Key characteristics of Hash function:
//1. Deterministic: The same input will always produce the same output.
//2. Fixed Output Size: Regardless of the input size, the hash code has a consistent size(eg- 32-bit, 64-bit).
//3. Efficient Computation: It should compute the hash quickly

//Important thing bout hashcode:
//1. When two keys are equal(using equals()) then their corresponding hashcodes must also be equal.
//2. Two different keys can also have a same hashcode (hash collision)
//3. Two same hashcodes(using equals()) doesnt necessarily means that their keys are also equal.

//Operations:
//When data is added:
//1. hashcode generation: key is passed into the hash() which returns the hashcode
//2. Index calculation: index is calculated from hashcode
//3. Storing the new node: new node is stored in that index or appended to a linkedlist (in case of collision) and if the size of the linkedList exceeds its threshold capacity (default threshold is 8) then the linkedlist will be converted to a red-black tree.
//When data is retrieved:
//1. hashcode generation: key is passed into the hash() which returns the hashcode
//2. Index calculation: index is calculated from hashcode
//3. Searching the node by its key: the whole linkedlist or tree is traversed until the node containing that key is found

//HashMap Resizing(Rehashing): Hashmap has an internal array of default size 16, so when the no. of elements exceeds a certain load factor( default is 0.75), the array will be resized to double(default) & all the existing elements are rehashed(their position are recalculated) & placed into the new array.

//Hashmap internally uses hashcode() for generating the key hashcodes & equals() for checking the equality of keys, so if we use a custom type object for keys, then we have to override these methods in the class whose objects are used as keys.

//Time Complexity:
//1. put(key,value): O(1) for best-case, O(log n) for worst case
//2. get(key): O(1) for best-case, O(log n) for worst case
//3. remove(key): O(1) for best-case, O(log n) for worst case
//4. containsKey(key): O(1) for best-case, O(log n) for wort-case
//5. containsValue(value): O(n) for all cases
//6. size(): O(1) for all cases

public class HashMapExample
{
    public static void main(String[] args)
    {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"Predator"); //adds a key-value pair
        map.put(2,"Syrex");
        map.put(3,"Lethal");
        System.out.println(map);
        map.remove(3); //removes the value for the key
        //map.put(null,"Blaze"); //allows only one null key

        System.out.println(map.get(2)); // returns the value for the key (if key not found then returns null)
        System.out.println(map.containsKey(4)); //checks if the key exists in the map or not (unlike arraylist where contains() requires traversing the list from its start resulting in O(n) complexity, here map contains() has O(1) complexity).
        System.out.println(map.containsValue("Predator")); //checks if value exists in the map or not O(1)

        //Traversing over the map:
        //1. by using keySet()
        Set<Integer> keys = map.keySet(); //keySet() returns a set of the map keys
        for(int i:keys) //since Hashmap doesn't maintain the insertion order so the keyset can be of any order
        {
            System.out.println(map.get(i));
        }
        //2. by using entrySet()
        Set<Map.Entry<Integer, String>> entries = map.entrySet(); //entrySet() returns a set of the map entries
        for(Map.Entry<Integer, String> entry:entries)
        {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        //Creating a hashmap with custom type as key
        HashMap<Employee,String> hashMap2 = new HashMap<>();
        Employee e1 = new Employee(1,"Predator");
        Employee e2 = new Employee(2,"Syrex");
        Employee e3 = new Employee(1,"Predator");
        hashMap2.put(e1,"SDE");
        hashMap2.put(e2,"Data Scientist");
        hashMap2.put(e3,"Database Admin"); //here, e1 & e3 will have same hashcodes acc to its class definition, so they will be considered equal due to which e1 value will be replaced with e3 value.

        for(Map.Entry<Employee, String> entry:hashMap2.entrySet())
        {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}

class Employee
{
    private int id;
    private String name;

    public Employee(int id,String name)
    {
        this.id=id;
        this.name=name;
    }

    @Override
    public String toString() //to define how an object of this class should be printed
    {
        return name;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id,name);
    }

    @Override
    public boolean equals(Object another) //to define how two objects of this class will be equal to this each other
    {
        if(this == another)
            return true;
        if(another == null)
            return false;
        if(getClass() != another.getClass())
            return false;
        Employee e = (Employee) another;
        return (this.id == e.id && Objects.equals(this.name,e.name));
    }
}