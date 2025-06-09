package CollectionFramework.Queue;

//Deque is a double-ended queue which allows insertion & deletion from both ends.
//It is more versatile than regular stacks & queues cause it supports all the operations of both(when insertion & deletion is done from the rear, then it acts like a regular stack & when insertion is done from the rear & deletion from the front, then it acts like a regular queue).
//It is an Interface in java which extends the Queue Interface.
//Its implementation classes are: LinkedList, ArrayDeque

//Insertion methods:
//1. addFirst(E e): Inserts the specified element at the front else throws Exception
//2. addLast(E e): Inserts the specified element at the end/rear else throws Exception
//3. offerFirst(E e): Inserts the specified element at the front if possible else returns null
//4. offerLast(E e): Inserts the specified element at the end/rear if possible else returns null

//Removal methods:
//1. removeFirst(): Retrieves & removes the first element else throws Exception if empty
//2. removeLast(): Retrieves & removes the last element else throws Exception if empty
//3. pollFirst(): Retrieves & removes the first element else returns null if empty
//4. pollLast(): Retrieves & removes the last element else returns null if empty

//Examination methods:
//1. getFirst(): Retrieves but does not remove the first element else throws Exception if empty
//2. getLast(): Retrieves but does not remove the last element else throws Exception if empty
//3. peekFirst(): Retrieves but does not remove the first element else returns null if empty
//4. peekLast(): Retrieves but does not remove the last element else returns null if empty

//Stack methods:
//1. push(E e): Adds an element to the front(equivalent to addFirst(E e))
//2. pop(E e): Removes & returns the first element(equivalent to removeFirst(E e))

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeExample
{
    public static void main(String[] args)
    {
        Deque deque = new ArrayDeque(); //requires less-memory as it uses a circular array which updates its head & tail pointers when insertion/deletion at either end is done but requires shifting of elements when insertion/deletion is done at the middle.
        deque.addFirst(10);
        deque.addLast(34);
        deque.offerFirst(23);
        System.out.println(deque);
        deque.removeLast();

        Deque deque2 = new LinkedList(); //requires no shifting of elements at insertion/deletion but requires more memory to store its pointers to next/previous node.
        deque2.addFirst(45);
        deque2.offerFirst(34);
        deque2.offerLast(69);
        System.out.println(deque2);
        deque2.removeLast();
    }
}
