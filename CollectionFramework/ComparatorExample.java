package CollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student
{
    private String name;
    private double gpa;

    Student(String name, double gpa)
    {
        this.name=name;
        this.gpa=gpa;
    }
    public String getName()
    {
        return name;
    }
    public double getGpa()
    {
        return gpa;
    }
}

class MyComparator implements Comparator<Integer>
{
    @Override
    public int compare(Integer o1, Integer o2)
    {
        //Rules for ordering:
        //1. return a negative no if o1 should come before o2
        //2. return a 0 if o1 and o2 are considered equal
        //3. return a positive no if o1 should come after o2

        //Thought process:
        //1. Determine what order of sorting is be done.
        //2. Determine the relative order of elements required for the sorting(for ascending, smaller elements be should appear first & vice versa for descending
        //3. For ascending, when o1<o2, we must return negative value to place o1 before o2 & when o1>o2, we must return postive value to place o2 before o1.
        //4. For descending, when o1<o2, we must return positive value to place o2 before o1 & when o1>o2, we must return negative value to place o1 before o2.
        //5. Then, deduce it using compare() of wrapper classes(for avoiding errors and edge cases), (the compare(a,b) returns -1 when a<b and 1 when a>b and 0 when a=b).

        return Integer.compare(o1,o2); //for ascending
    }
}
public class ComparatorExample
{
    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>();
        list.add(30);
        list.add(3);
        list.add(50);
        list.add(5);
        //sort() receives a Comparator object which provides the implementation of compare() which tells the sort() how to order the elements
        //list.sort(null); //passing comparator as null will make sorting in ascending order.
        list.sort(new MyComparator()); //sort in ascending order
        System.out.println(list);

        List<String> list2 = new ArrayList<>();
        list2.add("Predator");
        list2.add("Syrex");
        list2.add("RoseMerry");
        list2.sort((o1,o2)->Integer.compare(o2.length(),o1.length())); //sort in descending order

        List<Student> list3 = new ArrayList<>();
        list3.add(new Student("Predator",4.0));
        list3.add(new Student("Syrex",3.5));
        list3.add(new Student("Rio",3.67));
        list3.add(new Student("Lethal",3.2));
        list3.add(new Student("Toxin",3.6));
        list3.sort((o1, o2) -> Double.compare(o2.getGpa(),o1.getGpa())); //sorting the Custom type list based on its Gpa in descending order
        for (Student e:list3)
        {
            System.out.println(e.getName()+" "+e.getGpa());
        }
        Collections.sort(list3,(o1,o2)->o2.getName().compareTo(o1.getName())); //sorting the list based on its name in descending lexicographic order
        for (Student e:list3)
        {
            System.out.println(e.getName()+" "+e.getGpa());
        }
    }
}