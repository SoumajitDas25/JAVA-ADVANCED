package GUI.Swing;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

//Java Swing is also used to create window based application just like awt.
//It is built on top of awt api
//Difference btw AWT & Swing:
//1. AWT Components are platform-dependent whereas Swing Component are platform independent.
//2. AWT Components are heavyweight whereas Swing Components are lightweight.
//3. AWT Components does not support pluggable look & feel(the look & feel is not consistent across different OS) whereas Swing Components supports pluggable look & feel(consistent look & feel across different OS).
//4. AWT has less no of components whereas Swing has more no of components.
//5. AWT doesn't follow MVC architecture whereas Swing follows it.

//Important methods of Component class
//1. public void add(Component c): inserts the specified Component into the Container.
//2. public void setSize(int width,int height): sets the size of the container or the component on which it is invoked.
//3. public void setLayout(LayoutManager m): sets the layout of the container or the component.
//4. public void setVisible(boolean status): sets the visibility of the component.

public class SwingBasics
{
    public SwingBasics()
    {
        //create the frame
        JFrame frame = new JFrame();
        frame.setTitle("My Frame");
        frame.setSize(500,500);
        frame.setLayout(null); //In Swing, frames have BorderLayout as the default layout manager, so if we don't want any layout manager then we have to pass null.
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //makes the frame to close & program to exit when user clicks on the close icon

        //creating a button
        JButton button = new JButton("Click");
        button.setBounds(30,50,90,30);
        frame.add(button);

        //set the frame to be visible
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        new SwingBasics();
    }
}