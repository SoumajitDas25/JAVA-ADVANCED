package Generics;

public class GenericConstructor
{
    public<T> GenericConstructor(T number) //generic constructor
    { //T can only be used in this scope
        System.out.println("Number: "+number);
    }

    public static void main(String[] args)
    {
        GenericConstructor ob=new GenericConstructor(6);
    }
}