package Generics;

//In java, adding generics to Exception is not directly allowed cause Exceptions are thrown at the runtime during which they don't have the type information due to type eraser.
//So to achieve this, we use generic constructor
class MyException extends Exception
{
    public <T> MyException (T value) //generic constructor
    {
        super("Exception related to value: "+value.toString()+" of type: "+value.getClass().getName());
    }
}
public class GenericException
{
    public static void main(String[] args)
    {
        try{
            throw new MyException(123);
        } catch (MyException e){
            System.out.println("Caught exception: "+e.getMessage());
        }
        try{
            throw new MyException("Predator");
        } catch (MyException e){
            System.out.println("Caught exception: "+e.getMessage());
        }
    }
}
