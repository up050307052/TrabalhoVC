package src;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

/**
 * This class demonstrates how to load an Image from an external file
 */
public class LoadImage extends Component {
    protected BufferedImage img;


    public LoadImage(File file) {
       try {
           img = ImageIO.read(file);
       } catch (IOException e) {System.out.println("Error open file " + e.getMessage());}
    }


    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    
    @Override
    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(img.getWidth(null), img.getHeight(null));
       }
    }
}
