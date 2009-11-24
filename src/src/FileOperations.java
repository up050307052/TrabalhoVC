package src;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileOperations {
    private JFileChooser jfc;

    public FileOperations () {
        jfc   = new JFileChooser();
    }


    public Image LoadImage () {
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                return ImageIO.read(jfc.getSelectedFile());
            } catch (IOException e) {
                System.out.println("Error open file " + e.getMessage());
                return null;
            }
        }
        JOptionPane.showMessageDialog(null, "You must select a background image!!", "Warning", JOptionPane.WARNING_MESSAGE);
        return LoadImage();
    }

    public void SaveImage (Image img) {
        if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            BufferedImage bi = new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_INT_RGB);
            Graphics bg = bi.getGraphics();
            bg.drawImage(img, 0, 0, null);
            bg.dispose();

            try {
                ImageIO.write(bi, "jpg", jfc.getSelectedFile());
            } catch (IOException e) {
                System.err.println("Couldn't write output file! "+e.getMessage());
                return;
            }
        }
    }
}
