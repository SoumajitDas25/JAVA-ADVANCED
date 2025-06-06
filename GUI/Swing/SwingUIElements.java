package GUI.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingUIElements
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setTitle("My Frame");
        frame.setSize(500,500);
        frame.setLayout(new FlowLayout()); //since, here we have applied FlowLayout so it will ignore setBounds() of any component and hence we won't be setting bounds of any component here.
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //JButton:
        //used to create a button
        //constructors:
        //1. JButton(): button with no text/icon
        //2. JButton(String text): button with a text value
        //3. JButton(Icon i): button with an icon
        JButton button = new JButton("Button");
        button.setText("My Button"); //sets the button text
        System.out.println(button.getText()); //returns the button text
        button.setEnabled(true); //sets the button to be enabled
        frame.add(button);

        //JRadioButton:
        //used to create a radiobutton which allows us to choose a single option from multiple options
        //constructors:
        //1. JRadioButton(): radiobutton with no text & is unselected
        //2. JRadioButton(String text): radiobutton with text & is unselected
        //3. JRadioButton(String text, boolean selected): radiobutton with text & is selected/unselected based on the selected status
        //creating radiobutton options
        JRadioButton radioButton1 = new JRadioButton("Option 1", false);
        JRadioButton radioButton2 = new JRadioButton("Option 2", true);
        //creating buttongroup to add the radiobuttons to it.
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        //adding radiobuttons to the frame
        frame.add(radioButton1);
        frame.add(radioButton2);

        //JTextArea:
        //used to create a multiline editor area
        //constructors:
        //1. JTextArea(): blank textarea
        //2. JTextArea(String text): textarea with a pre-given text
        //3. JTextArea(int row, int col): blank textarea with specified rows & columns
        //4. JTextArea(String text, int row, int col): textarea with pre-given text & with specified rows & columns
        JTextArea textArea = new JTextArea("My Text Area",4,20);
        frame.add(textArea);

        //JComboBox:
        //used to create combo box(drop-down list)
        //only one item can be selected at a time
        //constructors:
        //1. JComboBox(): blank combo box
        //2. JComboBox(Object[] items): combo box with specified items
        //3. JComboBox(Vector<?> items): combo box with specified items
        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Predator","Syrex","Rio"});
        comboBox.addItem("Toxin");
        frame.add(comboBox);

        //JTable:
        //used to display data on two-dimensional table of cells
        //constructors:
        //1. JTable(): empty table with no rows & columns
        //2. JTable(int rows,int cols): empty table with specified rows & columns
        //2. JTable(Object[][] rowData, Object[] colNames): table with data & their column names
        String rowData[][] = {{"1","Predator","SDE"},{"2","Syrex","Data Analyst"},{"3","Toxin","Accountant"}};
        String colNames[] = {"ID","NAME","ROLE"};
        JTable table = new JTable(rowData,colNames);
        frame.add(table); //table won't show the column headers and so we need a JScrollPane to show the table along with the column header

        //JColorChooser:
        //used to create color chooser dialog box
        //constructor:
        //1. JColorChooser(): creates a color chooser palette(doesn't include OK and cancel buttons like the color chooser dialog box)
        //2 JColorChooser(Color initialColor): creates a color chooser palette with initial color
        //if we add color chooser palette directly on our frame or any container, then we have to manually create buttons for Ok and cancel to pick the selected color after choosing upon clicking the button.
        //JColorChooser.showDialog(): creates a color chooser dialog box which includes Ok and cancel buttons.
        JButton colorbtn = new JButton("Choose Background Color");
        colorbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Opens the color chooser dialog & will return the selected color if Ok button is clicked else will return null if Cancel button is clicked.
                Color selectedColor = JColorChooser.showDialog(frame, "Choose a Color", frame.getContentPane().getBackground());

                if (selectedColor != null)
                    frame.getContentPane().setBackground(selectedColor);
            }
        });
        frame.add(colorbtn);

        //JMenuBar:
        //used to create a Menubar which contains a list of menus where each menu can contain a list of menu items.
        JMenuBar menuBar = new JMenuBar(); //creating menubar
        JMenu menu1 = new JMenu("Menu 1"); //creating menus
        JMenu menu2 = new JMenu("Menu 2");
        menu1.add(new JMenuItem("MenuItem 1")); //creating menuitems & adding them to the menu
        menu1.add(new JMenuItem("MenuItem 2"));
        menu2.add(new JMenuItem("MenuItem 1"));
        menu2.add(new JMenuItem("MenuItem 2"));
        menuBar.add(menu1); //adding menus to the menubar
        menuBar.add(menu2);
        frame.setJMenuBar(menuBar); //adding menubar to the frame

        frame.setVisible(true);
    }
}
