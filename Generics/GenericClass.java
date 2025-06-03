package Generics;

//Generic types allows us to define a class,interface or method with placeholders(type parameters) for the data types they will work with.

//Problems without generics:
//1. No type safety: any type of data can be added or fetched dynamically making it type unsafe.
//2. Manual casting: data needs to be explicitly cast while fetching(cause we don't know whether the data previously is our intended data type and moreover it can also cause casting errors if the data isn't of a greater type).
//3. No Compile time checking: checking is done in run-time which makes it prone to run-time errors.

class Box<T> //generic class
{
    //we specify the type parameter name inside the diamond operator <>.
    //type parameter naming conventions:
    //T: Type
    //E: Element(used in collections)
    //K: Key(used in maps)
    //V: Value(used in maps)
    //N: Number

    private T value;

    public T getValue()
    {
        return value;
    }

    public void setValue(T value)
    {
        this.value = value;
    }
}

public class GenericClass
{
    public static void main(String[] args)
    {
        Box<Integer> box=new Box<>(); //the type is passed from here(Wrapper classes are passed for primitive data types).

        box.setValue(34);
        //box.setValue("Hello"); //it will give a compile-time error which is better than run-time error due to compile-time checking making it type-safe.

        int value = box.getValue();
        //String value = box.getValue(); //it will give a compile-time error making it type-safe.
        System.out.println(value);
    }
}
