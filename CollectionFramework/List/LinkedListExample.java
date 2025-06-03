package CollectionFramework.List;

import java.util.Arrays;
import java.util.LinkedList;

//LinkedList class implements the List interface & is part of java.util package.
//It stores its elements as nodes in a doubly linked list(a linked list where each node has pointers to its previous and next node).

//Performance considerations:
//Insertions and deletions in the middle of the list are better performed in linkedlist since it doesn't require shifting elements unlike arraylist.
//It has slower random access compared to arraylist since it requires traversing the list from the beginning to reach the desired index.
//Linked list requires more memory than arraylist cause each node in the linkedlist requires additional memory to store the pointers to the next and previous node.

public class LinkedListExample
{
    public static void main(String[] args)
    {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(10); //adds a node with value 10 to the last(tail) O(1)
        list1.add(2);
        list1.addLast(23);
        list1.addFirst(45); //adds a node with value 45 to the first(head) O(1)
        list1.add(1,56); //adds a node with value 56 at 1st index
        System.out.println(list1); //O(n)
        System.out.println(list1.get(2)); //gets the value of node at specified index O(n)
        System.out.println(list1.getFirst()); //gets the value of first node O(1)
        System.out.println(list1.getLast()); //gets the value of last node O(1)
//        list1.remove(); //removes (& returns) the first node
        //list1.remove(1); //removes the node at the specified index
        //list1.remove(Integer.valueOf(10)); //removes the node with the specified value
        //list1.removeIf(x->x%2==0); //removes the node whose value satisfies the condition (here, we are passing a predicate object by implementing its test()).
        System.out.println(list1);

        LinkedList<String> list2 = new LinkedList<>(Arrays.asList("Predator","Syrex","Rio","Blaze")); //creating linkedlist from a list
        LinkedList<String> list3 = new LinkedList<>(Arrays.asList("Rio","Lethal"));
        list2.removeAll(list3); //removes all elements of list3 from list2 which are available in the list2
        System.out.println(list2);
    }
}
