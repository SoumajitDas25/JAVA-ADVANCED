package CollectionFramework.Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

//A set is a collection that cannot contain duplicate elements
//It internally uses hashmap to store the elements as keys while mapping them to some dummy values so it also has constant time access for inserting or searching elements like that of map.
//Since it uses map so all its implementation classes will work the same as map implementation classes
//But unlike to map which doesn't come under the collection hierarchy, it comes under the collection hierarchy(it implements collection interface)
//Implementation classes of Set: HashSet, LinkedHashSet, TreeSet, EnumSet
public class SetBasics
{
    public static void main(String[] args)
    {
        Set<String> set = new HashSet<>();
        set.add("Predator"); //adding element
        set.add("Syrex");
        set.add("Lethal");
        System.out.println(set); //since it's a hashSet(similar behaviour like hashmap) so its insertion order won't be maintained.

        //for maintaining insertion order, we need LinkedHashSet
        Set<String> set2 = new LinkedHashSet<>();
        set2.add("Predator");
        set2.add("Syrex");
        set2.add("Lethal");
        System.out.println(set2);

        System.out.println(set.contains("Predator")); //checking the existence of element
        set.remove("Lethal"); //removing element
        set.clear(); //empties the set

        //for thread-safety, we can use ConcurrentSkipListSet
        Set<String> set3 = new ConcurrentSkipListSet<>();

        //for unmodifiable set
        Set<Integer> set4 = Set.of(4,5,2,1);
        System.out.println(set4);
    }
}
