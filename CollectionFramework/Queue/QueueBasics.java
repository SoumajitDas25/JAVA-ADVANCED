package CollectionFramework.Queue;

import java.util.LinkedList;
import java.util.Queue;

//A Queue is a linear data structure that is based on the FIFO principle where the first element inserted will be first element to be removed.
//A queue has 2 ends: front & rear
//Elements are inserted at the rear end known as Enqueue Operation ( done through add() or offer() ).
//Elements are removed from the front end known as Dequeue Operation ( done through remove() or poll() ).
//Element is returned from the front end known as Peek Operation ( done through peek() or element() ).
//It is an Interface in java
//Its implementation classes include: LinkedList, PriorityQueue,

public class QueueBasics
{
    public static void main(String[] args)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(34); //enqueue
        queue.offer(45); //add() throws exception if unable to add( in case of adding in a fixed-queue when its already full ) whereas offer() only returns false.
        System.out.println(queue.remove()); //dequeue
        System.out.println(queue.poll()); //remove() throws exception if empty whereas poll() returns null
        System.out.println(queue.peek()); //peek
        //System.out.println(queue.element()); //element() throws exception if empty whereas peek() returns null
    }
}
