package GUI.AWT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//LayoutManager is used to arrange components in a particular manner
//It is an interface that is implemented by all classes of layout managers.

//Types of Layout Managers:

//1. BorderLayout:
//entire region is divided into 5 regions: North region(top), South region(bottom), West region(left), East region(right) & Center region(center).
//Each region can contain only one component.
//A component can be added to any region by specifying its constraint name like North for north region.

//2. Card Layout:
//Arranges each component in the container as card on top of each other.
//Only one card is visible at a time and the container acts as a stack of cards.
//It ignores the setSize() of its cards and instead sizes cards on its own.

//3. FlowLayout:
//Used to arrange components in a line, one after the another.
//it is the default layout manager in java

//4. GridLayout:
//Whole Container is divided into a grid of cells.
//Each cell can accommodate only one component.
//Components are filled in cells in row-wise manner from left to right.

class BorderLayoutExample
{
    Frame frame;
    Button button1,button2;
    public BorderLayoutExample()
    {
        //create the frame
        frame = new Frame("My Border Layout Frame");
        frame.setSize(500,500);

        //add border layout to the frame
        frame.setLayout(new BorderLayout());

        //add the components to the frame
        button1 = new Button("Button 1");
        button2 = new Button("Button 2");
        frame.add(button1,"North"); //adding a button to north region
        frame.add(button2,"South"); //adding a button to south region

        //set the frame to be visible
        frame.setVisible(true);
    }
}

class CardLayoutExample implements ActionListener
{
    Frame frame;
    Panel panel;
    CardLayout card;
    Button button1,button2;
    public CardLayoutExample()
    {
        //create the frame
        frame = new Frame("My Card Layout Frame");
        frame.setSize(500,500);

        //create a panel with cardLayout
        //here, we can also add cardLayout directly to the frame, but it's a better practice to add it to a panel which is attached to the frame
        panel = new Panel();
        card = new CardLayout(100,100);
        panel.setLayout(card);

        //add components as cards to the panel
        button1 = new Button("Button 1");
        button2 = new Button("Button 2");
        panel.add("card1",button1);
        panel.add("card2",button2);
        //here, since buttons are added as cards so they will have the full size of the card.
        //if we want custom sizing of each buttons then we have to wrap each button inside a panel with a different layout like nullLayout or flowLayout.

        //attach event handler to the buttons to switch to the next card when clicked
        button1.addActionListener(this);
        button2.addActionListener(this);

        //add the panel to the frame
        frame.add(panel);

        //set frame to be visible
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        card.next(panel); //here, we have to pass the parent container which has cardLayout
    }
}

class FlowLayoutExample
{
    Frame frame;
    Button button1,button2;

    public FlowLayoutExample()
    {
        //create the frame
        frame = new Frame("My Flow Layout Frame");
        frame.setSize(500,400);

        //set flowLayout to the frame
        frame.setLayout(new FlowLayout());

        //add components to the frame
        button1 = new Button("Button 1");
        button1.setSize(40,30);
        button2 = new Button("Button 2");
        button2.setSize(50,20);
        frame.add(button1);
        frame.add(button2);

        //set the frame to be visible
        frame.setVisible(true);
    }
}

class GridLayoutExample
{
    Frame frame;
    Button button1,button2,button3,button4;
    public GridLayoutExample()
    {
        //create the frame
        frame = new Frame("My Grid Layout Example");
        frame.setSize(500,300);

        //set gridLayout to the frame
        frame.setLayout(new GridLayout(3,2)); //2 rows & 3 cols here
        //if we are not sure about how many rows should be there, then we can add 0 rows(dynamic rows) with some cols which will let gridlayout to calculate the rows dynamically.

        //add components to the frame
        button1 = new Button("Button 1");
        button2 = new Button("Button 2");
        button3 = new Button("Button 3");
        button4 = new Button("Button 4");
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);

        //set the frame to be visible
        frame.setVisible(true);
    }
}

public class LayoutManagerExample
{
    public static void main(String[] args)
    {
//        BorderLayoutExample frame1 = new BorderLayoutExample();
//        CardLayoutExample frame2 = new CardLayoutExample();
//        FlowLayoutExample frame3 = new FlowLayoutExample();
        GridLayoutExample frame4 = new GridLayoutExample();
    }
}