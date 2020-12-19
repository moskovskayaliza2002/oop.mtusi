package laba4;
import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.Graphics;

public class JImageDisplay extends JComponent{
    private BufferedImage img;
    public JImageDisplay (int w, int h)
    {
        img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        setPreferredSize(new Dimension(w, h));
    }
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(),null);
    }
    public void drawPixel (int x, int y, int rgbColor)
    {
        img.setRGB(x,y,rgbColor);
    }
    public  void clearImage()
    {
        for (int i=0; i<img.getWidth(); i++)
        {
            for (int j = 0; j < img.getHeight(); j++)
            {
                drawPixel(i, j, 0);
            }
        }
    }
    public BufferedImage getImage() {
        return img;
    }
}
