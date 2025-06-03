package GUI.AWT;

//AWT(Abstract Window Toolkit) is used to develop GUI or Window based Applications.
//AWT Components are platform independent(their look and feel depends on the OS).
//AWT Components are present inside java.awt package.

//Hierarchy:
//At the root level, there is Component(abstract class)
//Under Component, there are various components(classes) like Button, Label, Container, etc.
//Under Container, there are Window & Panel
//Under Window, there are Frame & Dialog
//Under Panel, there is Applet
//Representation:
//Object <- Component <- Button, Label, Container
//Container <- Window & Panel
//Window <- Frame & Dialog
//Panel <- Applet

//Container:
//It is an awt component that can contain other components like Button, textfields, labels, etc.
//The classes that extends container class are known as container such as Frame, Dialog, Applet (it means that if we want to make a window based program, we can make it through either Frame, Dialog or Applet).
//Window: It is also a container with no border & no menubar.
//Panel: It is also a container with no title bar & no menubar but it can have other components like buttons, textfields, etc.
//Most Commonly used container is Frame which contains title bar, menubar, Buttons, textFields, etc.

//Important methods of component class
//1. public void add(Component c): inserts the specified Component into the Container.
//2. public void setSize(int width,int height): sets the size of the container or the component on which it is invoked.
//3. public void setLayout(LayoutManager m): sets the layout of the container or the component.
//4. public void setVisible(boolean status): sets the visibility of the component.

import java.awt.*;

class MyFrame extends Frame
{
    public MyFrame()
    {
        //whenever we want to create a component, we need to create its object
        Button button = new Button("Click Me");
        button.setBounds(30,100,80,30); //sets position of button in the container(frame) and also sets the width & height
        setSize(500,500); //sets the size of the frame
        setLayout(null); //sets the layout of the frame, it accepts a layout( by passing null, it uses default layout of awt)
        setVisible(true); //by default, its false, so we need to pass true to make it visible
        add(button); //adds the button to the frame

        //Note: for every frame, we must set its size, layout & visibility.
        //By default, the close icon on the frame doesn't responds, it needs to be attached with a WindowListener to handle the windowClosing event.
    }
}

public class AWTBasics
{
    public static void main(String[] args)
    {
        MyFrame frame = new MyFrame();
    }
}