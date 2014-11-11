package src.plugger.world;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;

import src.plugger.util.GifSequenceWriter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ImageWriter {
	
	
	protected static int toRGB(int r, int g, int b, int a) {
		int rgb = a;
		rgb = (rgb << 8) + (r & 0xFF);
		rgb = (rgb << 8) + (g & 0xFF);
		rgb = (rgb << 8) + (b & 0xFF);
		return rgb;
	}
	
    public static void greyWritePNG(short[][] noise, Integer Numb){
        BufferedImage image = new BufferedImage(noise.length, noise[0].length, BufferedImage.TYPE_INT_RGB);

        for(int x = 0; x < noise.length; x++){
            for(int y = 0; y < noise.length; y++){
            	
            	if (noise[x][y]>1){
                    noise[x][y]=1;
                }
                if (noise[x][y]<0){
                    noise[x][y]=0;
                }
                Color color = new Color((float)noise[x][y], (float)noise[x][y], (float)noise[x][y]);
                image.setRGB(x, y, color.getRGB());
            }
        }

        try{
            File file = new File("noise"+Numb+".png");
            file.createNewFile();

            ImageIO.write(image, "PNG", file);
        }catch(IOException e){
            throw new RuntimeException("Unable to write noise");
        }
    }
    /*public static void greyWriteGif(short[][][] noise, Integer Numb){
    	BufferedImage image = new BufferedImage(noise.length, noise[0].length, BufferedImage.TYPE_INT_RGB);

        for(int x = 0; x < noise.length; x++){
            for(int y = 0; y < noise.length; y++){
            	for(int z = 0; z < noise.length; z++){
            		
	            	
	            	if (noise[x][y][z]>1){
	                    noise[x][y][z]=1;
	                }
	                if (noise[x][y][z]<0){
	                    noise[x][y][z]=0;
	                }
	                Color color = new Color((float)noise[x][y][z], (float)noise[x][y][z], (float)noise[x][y][z]);
	                image.setRGB(x, y, color.getRGB());
            	}
            }
        }
        
        
        
        File file;
        while (file.exists()){
			file = new File("noise" + 10 + ".gif");
		}try {
			file.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
        ImageOutputStream stream = null;
        try{
        	stream = new FileImageOutputStream(image);
        	GifSequenceWriter writer = new GifSequenceWriter(stream, BufferedImage.TYPE_INT_RGB, 64, true);
        	
        	writer.writeToSequence(image);    
            for(int i=1; i<args.length-1; i++) 
            {      
              BufferedImage nextImage = ImageIO.read(new File(args[i]));      
              writer.writeToSequence(nextImage);    
            }    
            writer.close();    
        }catch(IOException e){
            throw new RuntimeException("Unable to write noise");
        }
    }*/
    
    
    public static void greyWriteGif(short[][][] noise, Integer Numb){
    	System.out.println("Converting.");
		BufferedImage[] imgs = new BufferedImage[noise.length];
		BufferedImage img = new BufferedImage(noise.length, noise.length, BufferedImage.TYPE_INT_ARGB);
		
		for (int l = 0; l < noise.length; l++) {
			for (int x = 0; x < noise.length; x++) {
				for (int y = 0; y < noise.length; y++) {
					if (noise[x][y][l]>1){
	                    noise[x][y][l]=1;
	                }
	                if (noise[x][y][l]<0){
	                    noise[x][y][l]=0;
	                }
					Color color = new Color((float)noise[x][y][l], (float)noise[x][y][l], (float)noise[x][y][l]);
					img.setRGB(x, y, color.getRGB());
				}
			}
			imgs[l] = img;
		}
		
		
		if(imgs[39]==imgs[0]){
			System.out.println("Failure!");
		}

		String directory = "simplex_noise_3d";
		File dir = new File(directory);
		if (!dir.exists()) {
			dir.mkdir();
		}
		String filename = directory + "/" + "noise";
		String suffix = ".gif";

		int i = 0;
		File file;
		do {
			i++;
			file = new File(filename + i + suffix);
		} while (file.exists());
		try {
			file.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("Writing to file.");
		ImageOutputStream stream = null;
		try {
			stream = new FileImageOutputStream(file);
			GifSequenceWriter writer = new GifSequenceWriter(stream, BufferedImage.TYPE_INT_RGB, 64, true);
			for (int j=0;j<imgs.length;j++) {
				writer.writeToSequence(imgs[j]);
				
				
				File file2 = new File("noise"+Numb+".png");
				Numb++;
	            file2.createNewFile();
				ImageIO.write(imgs[j], "PNG", file2);
			}
			
            
			
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Finished writing (to " + filename + i + suffix + ").");
    }
    
    
    
   
    
    
    

}