package Generics;

interface Container<T> //generic interface
{
    void add(T item);
    T get();
}
//a generic interface can be implemented by other class which will either pass the type or itself become a generic class.

class StringContainer implements Container<String> //a class that implements generic interface by passing type
{
    private String item;

    @Override
    public void add(String item)
    {
        this.item=item;
    }

    @Override
    public String get()
    {
        return item;
    }
}

class GenericContainer<T> implements Container<T> //a generic class that implements a generic interface
{
    private T item;

    @Override
    public void add(T item)
    {
        this.item=item;
    }

    @Override
    public T get()
    {
        return item;
    }
}

public class GenericInterface
{
    public static void main(String[] args)
    {
        StringContainer stringContainer = new StringContainer();
        stringContainer.add("Predator");
        System.out.println(stringContainer.get());

        GenericContainer<Integer> genericContainer = new GenericContainer<>(); //passing the type
        genericContainer.add(45);
        System.out.println(genericContainer.get());
    }
}
