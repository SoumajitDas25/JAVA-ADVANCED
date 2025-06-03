package CollectionFramework.Map;

import java.util.HashMap;
import java.util.LinkedHashMap;

//LinkedHashMap is a subclass of HashMap & implements Map interface
//Unlike Hashmap, it maintains the insertion order.
//It internally uses a doubly linked list along with the internal array to store the insertion order.
//It is also not thread-safe like hashmap

public class LinkedHashMapExample
{
    public static void main(String[] args)
    {
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        map.put("Predator",12);
        map.put("Syrex",23);
        map.put("Toxin",10);
        System.out.println(map);

        LinkedHashMap<String,Integer> map2 = new LinkedHashMap<>(10,0.5f,true); //when accessOrder is passed as true, it will maintain access order instead of insertion order
        map2.put("Alice",12);
        map2.put("Thompson",23);
        map2.put("Bob",10);
        map2.get("Alice");
        map2.get("Thompson"); //so, here the most recently accessed element will be at the last position & the least recently accessed element will be at the first position.
        System.out.println(map2);

        //creating a linkedhashmap from an existing hashmap
        HashMap<String,Integer> hashMap= new HashMap<>();
        LinkedHashMap map3 = new LinkedHashMap(hashMap);
    }
}
