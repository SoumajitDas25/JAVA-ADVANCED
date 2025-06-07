package EventHandling;

//Adapter classes are used to simplify the process of event handling.
//It provides empty implementation of all methods in an event listener interface due to which we only need to override only those methods which we want.
//It can be used either by extending an adapter class or by using anonymous inner class to override the methods which we want.

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class AdapterClasses
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("My Frame");
        frame.setSize(500,500);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Mouse Pointer Coordinates: ");
        JLabel coordinates = new JLabel("( 0 , 0 )");
        frame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) //we are overriding only this method which we need
            {
                coordinates.setText(" ( "+e.getX()+" , "+ e.getY() +" ) "); //set the coordinates of the mouse pointer position
            }
        });
        frame.add(label);
        frame.add(coordinates);

        frame.setVisible(true);
    }
}
