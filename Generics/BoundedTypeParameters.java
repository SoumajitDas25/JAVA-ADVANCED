package Generics;

interface Printable
{
    void print();
}

class MyNumber extends Number implements Printable
{
    private final int value;

    public MyNumber(int value)
    {
        this.value=value;
    }

    @Override
    public void print() //from printable interface
    {
        System.out.println("My Number: "+value);
    }

    @Override
    public int intValue() //from Number class
    {
        return value;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }
}

class Boxx<T extends Number & Printable> //T is a bounded type parameter which should be necessarily a type which lies in this bound(here, a type which extends Number and implements Printable)
    //here, a class can be there after extends keyword followed by multiple interfaces separated by & operator(if any) or directly an interface followed by other interfaces separated by &(if any), but there can't be an interface/interfaces followed by a class.
{
    private T item;
    public void setItem(T item)
    {
        this.item=item;
    }
    public void displayItem()
    {
        item.print();
    }
}

public class BoundedTypeParameters
{
    public static void main(String[] args)
    {
        Boxx<MyNumber> box = new Boxx<>(); //passing the type which lies in its defined bound
        box.setItem(new MyNumber(6));
        box.displayItem();
    }
}