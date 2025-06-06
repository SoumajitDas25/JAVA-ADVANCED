package GUI.Swing;

import javax.swing.*;
import java.awt.*;

class Painter extends JPanel
{
    Image image;

    Painter(String path)
    {
        image = new ImageIcon(path).getImage();
    }
    @Override
    public void paintComponent(Graphics g) //this method(present inside JComponent class) will be invoked automatically by the Swing painting system to paint the component whenever it needs to render the component
    {
        g.drawImage(image,0,0,getWidth(),getHeight(),this); //this will draw the image inside this component
    }
}

public class ImagePainter
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Image Painter 1");
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //using ImageIcon and JLabel
        ImageIcon originalIcon = new ImageIcon("src/assets/doctor.png");
        Image scaledImg = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH); //resizing image
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        JLabel label = new JLabel(scaledIcon);
        label.setBounds(30,30,200, 200);
        frame.add(label);

        //drawing image using paintComponent() in a JPanel
        //this method is better cause it gives us more control over the image painting(we don't need to resize the image here cause the image is being painted based on the container size which we define
        Painter painter = new Painter("src/assets/doctor.png");
        painter.setBounds(30,250,200,200);
        frame.add(painter);

        frame.setVisible(true);
    }
}