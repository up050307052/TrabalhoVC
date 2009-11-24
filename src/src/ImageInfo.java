package src;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.PixelGrabber;

/*
 *
 *  class para conter dado relativos a uma imagem
 *  permite a alteração da image pelo metodo modifyImage (Image img)
 *  permite recuperar a imagem original
 * 
 */
public class ImageInfo extends java.awt.Component {
    protected Image img, original_img;
    protected int sizex, sizey, matrix[];


    // construtor, carrega a image para matrix e o seu tamanho para sizex e sizey
    public ImageInfo (Image img) {
        this.img = original_img = img;
        loadMatrix();
    }

    // moifica a image para a image passada por argumento
    public void modifyImage (Image img) {
        this.img = img;
        loadMatrix();
        this.repaint();
    }

    // coloca a imagem numa matrix de pixeis
    // largura em sizex
    // altura em sizey
    private void loadMatrix() {
        sizex = img.getWidth(null);
		sizey = img.getHeight(null);
		matrix = new int[sizex*sizey];
		PixelGrabber pg = new PixelGrabber(img, 0, 0, sizex, sizey, matrix, 0, sizex);
        try {
            pg.grabPixels();
        } catch (InterruptedException ex) {System.out.println("Error load image " + ex.getMessage());}
    }


    // metodos reescritos da class Components
    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(img.getWidth(null), img.getHeight(null));
    }
}