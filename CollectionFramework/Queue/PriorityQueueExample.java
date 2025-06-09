package CollectionFramework.Queue;

//It an implementation class of Queue
//It orders elements based on their natural ordering (for primitives lowest first, Eg- for integers, lowest will be first , for strings, lexicographic order)
//Custom Comparator is used for custom ordering.
//It does not allow null elements.

//Internal Working:
//It internally uses a min-heap(binary-tree like structure) by default where every parent node <= child node, so the smallest element will automatically be at the root node.
//So, for peek() -> O(1), for add()/remove() -> O(n) cause after every add/remove there will be some re-arrangement to restore the heap property again causing the min element to be at the root again.

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample
{
    public static void main(String[] args)
    {
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        queue1.add(15);
        queue1.add(10);
        queue1.add(30);
        queue1.add(5);
        System.out.println(queue1); //while printing, it may or may not appear as in sorted order cause only the highest priority element(least element by default) will be guaranteed to be at the first & rest all elements will be arranged in such a way to satisfy the heap property.
        //So, to print them in order of their priority, we need to remove() one by one until the queue is empty.
        while(!queue1.isEmpty())
        {
            System.out.print(queue1.remove()+" "); //remove() and peek() returns the element at the head(which is the highest priority element here)
        }
        System.out.println();

        //for reverse ordering
        PriorityQueue<Integer> queue2 = new PriorityQueue<>(Comparator.reverseOrder());
        queue2.add(20);
        queue2.add(2);
        queue2.add(45);
        queue2.add(10);
        while(!queue2.isEmpty())
        {
            System.out.print(queue2.remove()+" ");
        }
        System.out.println();

        //for custom ordering, we can pass the object of comparator by overriding its compare() which will define how two elements are compared with each other.
    }
}
