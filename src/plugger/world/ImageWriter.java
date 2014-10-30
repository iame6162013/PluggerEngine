package src.plugger.world;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageWriter {

    public static void greyWriteImage(double[][] data){
        BufferedImage image = new BufferedImage(data.length, data[0].length, BufferedImage.TYPE_INT_RGB);

        for(int x = 0; x < data.length; x++){
            for(int y = 0; y < data[0].length; y++){
                Color color = new Color((float)data[x][y], (float)data[x][y], (float)data[x][y]);
                image.setRGB(x, y, color.getRGB());
            }
        }

        try{
            File file = new File("noise.png");
            file.createNewFile();

            ImageIO.write(image, "PNG", file);
        }catch(IOException e){
            throw new RuntimeException("Unable to write noise");
        }
    }

}