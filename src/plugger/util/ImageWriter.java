package plugger.util;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;

import plugger.util.GifSequenceWriter;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ImageWriter {
	
	
	protected static int toRGB(int r, int g, int b, int a) {
		int rgb = a;
		rgb = (rgb << 8) + (r & 0xFF);
		rgb = (rgb << 8) + (g & 0xFF);
		rgb = (rgb << 8) + (b & 0xFF);
		return rgb;
	}
	
    public static void greyWritePng(short[][] noise, Integer Numb){
        BufferedImage image = new BufferedImage(noise.length, noise.length, BufferedImage.TYPE_INT_RGB);
        
        
        for(int x = 0; x < noise.length; x++){
            for(int y = 0; y < noise.length; y++){
            	
            	if (noise[x][y]/255>1){
                    noise[x][y]=255;
                }
                if (noise[x][y]<0){
                    noise[x][y]=0;
                }
                Color color = new Color((float)noise[x][y]/255, (float)noise[x][y]/255, (float)noise[x][y]/255);
                image.setRGB(x, y, color.getRGB());
            }
        }

        try{
            File file = new File("noise"+Numb+".png");
            file.createNewFile();

            ImageIO.write(image, "PNG", file);
        }catch(Exception e){
            throw new RuntimeException("Unable to write noise"+e);
        }
    }
    
    public static void greyWritePng(short[][][] noise, Integer Numb){
    	System.out.println("Converting."+noise.length);
		BufferedImage img = new BufferedImage(noise.length, noise.length, BufferedImage.TYPE_INT_RGB);
		
		
		byte[][] imageInByte=new byte[noise.length][noise.length];
		
		System.out.println(noise[0][10][10]/255f);
		for (int l = 0; l < noise.length; l++) {
			for (int x = 0; x < noise.length; x++) {
				for (int y = 0; y < noise.length; y++) {
					if (noise[l][x][y]/255>1){
	                    noise[l][x][y]=1;
	                }
	                if (noise[l][x][y]<0){
	                    noise[l][x][y]=0;
	                }
					Color color = new Color(noise[l][x][y]/255f, (float)noise[l][x][y]/255, (float)noise[l][x][y]/255);
					img.setRGB(x, y, color.getRGB());
				}
			}
			
			try {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(img, "png", baos);
				baos.flush();
				imageInByte[l] = baos.toByteArray();
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		String directory = "simplex_noise_3d";
		File dir = new File(directory);
		if (!dir.exists()) {
			dir.mkdir();
		}
		String filename = directory + "/" + "Bllob";
		String suffix = ".png";

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
			for (int j=0;j<imageInByte.length;j++) {
				InputStream in = new ByteArrayInputStream(imageInByte[j]);
				BufferedImage bImageFromConvert = ImageIO.read(in);
				
				
				writer.writeToSequence(bImageFromConvert);
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
    
    
    
    public static void greyWriteBigAPng(ByteBuffer noise, Integer Numb){
    	System.out.println("Converting."+noise.capacity());
    	int Cap=(int) Math.cbrt(noise.capacity());
		BufferedImage img = new BufferedImage(Cap, Cap, BufferedImage.TYPE_INT_RGB);
		
		
		byte[][] imageInByte=new byte[Cap][Cap];
		
		for (int l = 0; l < Cap; l++) {
			for (int x = 0; x < Cap; x++) {
				for (int y = 0; y < Cap; y++) {
					int i=((noise.get())& 0xFF);
					if (i>255){
						System.out.println(i);
	                    i=(byte)255;
	                    
	                }
	                if (i<0){
	                	System.out.println(i);
	                	i=(byte)0;
	                }
					Color color = new Color((float)i/255, (float)i/255, (float)i/255);
					img.setRGB(x, y, color.getRGB());
				}
			}
			
			try {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(img, "png", baos);
				baos.flush();
				imageInByte[l] = baos.toByteArray();
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		String directory = "simplex_noise_3d";
		File dir = new File(directory);
		if (!dir.exists()) {
			dir.mkdir();
		}
		String filename = directory + "/" + "Bllob";
		String suffix = ".png";

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
			for (int j=0;j<imageInByte.length;j++) {
				InputStream in = new ByteArrayInputStream(imageInByte[j]);
				BufferedImage bImageFromConvert = ImageIO.read(in);
				
				
				writer.writeToSequence(bImageFromConvert);
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