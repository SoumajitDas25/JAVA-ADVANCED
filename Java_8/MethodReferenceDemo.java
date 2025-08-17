package Java_8;

import java.util.Arrays;
import java.util.List;

//Method Reference refers to a method without invoking it
//used in place of lambda expressions which just simply calls an existing method
//used for passing methods as a parameter
//for static method reference, we use className::methodName
//for non-static method reference, we use objectName::methodName
//for constructor reference, we use className::new

public class MethodReferenceDemo
{
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(1,2,3,4);
        list.forEach(System.out::println); //method reference of println() is passed so that forEach runs this method for each element.
    }
}
