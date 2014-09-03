package src.plugger.view;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageLoader {
	public static Image getImage(String path){
		Image tempImage=null;
		try{
			//String imageURL = ("D:\\Users\\Aron2\\Desktop\\something.png");
			tempImage = ImageIO.read(new File("D:/Users/Aron/Desktop/Savy Safe Map p/SavE/prog/PROJECTS/lilGame/lilGame/src/resources/"+path));
			//tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		}catch(Exception e){
			System.out.println("can't load image -"+ e.getMessage());
		}
		return tempImage;
	}
}
