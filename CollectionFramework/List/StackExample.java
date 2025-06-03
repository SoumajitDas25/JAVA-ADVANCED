package CollectionFramework.List;

import java.util.Stack;

//Stack extends Vector class making it thread-safe
//It follows the LIFO principle
//Since it is a subclass of Vector, so it inherits all the features of a dynamic array but is constrained by the stack's LIFO nature

public class StackExample
{
    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(3); //adds element to the top
        stack.push(6);
        stack.push(34);
        stack.push(16);
        stack.pop(); //removes & returns the top element
        System.out.println(stack.peek()); //returns the top element without removing it
        System.out.println(stack.isEmpty()); //checks if the stack is empty
        System.out.println(stack.size()); //returns the no. of elements in the stack.

        //Since it extends vector, so we can even apply vector methods on it
        stack.add(2,23);

        //Since stack extends vector so it also includes synchronization performance overheads
    }
}
