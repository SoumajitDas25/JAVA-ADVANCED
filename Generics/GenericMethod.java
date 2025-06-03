package Generics;

public class GenericMethod
{
    public static <T> void printArray(T[] array) //generic method
    {
        for(T element: array)
        {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        printArray(new Integer[]{3,4,5});
        printArray(new String[]{"Predator","Syrex"});
    }
}
