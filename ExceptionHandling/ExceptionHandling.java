package ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionHandling
{
    static void divide()
    {
        try
        {
            //any statement(s) which can cause exception is wrapped inside try block.
            System.out.println(5/0); //this will throw an ArithmeticException
        }
        catch (Exception e)
        {   //this catch block executes whenever there is an exception in the try block
            // Often we don't know which type of exception object will be thrown, so its better to use an Exception type reference which is superclass for all different exception classes.
            //here, since we know that ArithmeticException will be thrown, so we can also specifically use ArithmeticException type reference.

            System.out.println("Exception caught");
            System.out.println(e); // println() calls the toString() of this Exception object whose class(Exception class) has overrided the method to display exception information (Unlike to this, println() will print hashcode for a regular object whose class hasn't overrided the toString() which is inherited from the Object class).

        }
        finally
        {   // this finally block is always executed irrespective of whether exception has occurred or not.
            //this block executes even if try or catch block returns something(in that case, the block is executed before returning to its caller).
            System.out.println("Finally block executed");
        }
    }
    static void method1() throws IOException
    {   //when a method is declared to throw Exception using throws keyword        then it should be handled by its caller method using try-catch or        the caller can declare itself to throw that exception which must be      further handled by its caller.
        //For checked exceptions, it is necessary to handle or declare those Exceptions using throws clause by the method or else it will cause a compilation error.

        throw new IOException(); // it is a Checked Exception(checking will be done in compile time and the program won't compile if is not handled or declared to be thrown by the method)
        // throw keyword is used to explicitly throw an Exception.
    }
    static void method2()
    {
        try(BufferedReader reader = new BufferedReader(new FileReader("File1.txt"))) //known as try-with-resources
        { //this try-with-resources automatically closes the resource object if its class have implemented the AutoClosable Interface
            String line;
            while((line = reader.readLine())!=null)
            {
                System.out.println(line);
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception: "+e.getMessage());
        }
    }
    public static void main(String[] args) throws Exception
    {
        //An Exception is a case which disrupts the normal flow of our application/program.
        //All the remaining statements after the exception causing statement won't be executed and the program will terminate from there.
        //It is an object which is thrown during run-time.
        //Exceptions can be checked or unchecked
        //Checked Exceptions are those which are checked at compile-time and compilation fails if they are not handled or declared to be thrown by the method.
        //Unchecked Exceptions are those which are not checked at compile-time and compilation succeeds irrespective of whether they are handled or not.
        //Both checked and unchecked must be handled to avoid disruption of the program during run-time.
        //Whenever an Exception is thrown and is not handled, it prints the Exception message and the stack trace on the terminal.
//        divide();
//        method1();
//        method2();
    }
}
