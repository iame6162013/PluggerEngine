package src.plugger.view;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageLoader {
	public static Image getImage(String path){
		Image tempImage=null;
		try{
			//tempImage = ImageIO.read(new File("D:/Users/Aron/Desktop/Savy Safe Map p/SavE/prog/PROJECTS/lilGame/lilGame/src/resources/"+path));
		}catch(Exception e){
			System.out.println("can't load image -"+ e.getMessage());
			
			System.out.println("THIS FILE ONLY WORKS WITH IAME I'M AWARE OF THIS");
		}
		return tempImage;
	}
}
/*
import java.io.IOException;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class ImageLoader {
	public static getImage(String path){
		private Texture texture;
		try{
			//Works
			//tempImage = ImageIO.read(new File("D:/Users/Aron/Desktop/Savy Safe Map p/SavE/prog/PROJECTS/lilGame/lilGame/src/resources/"+path));
			
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/image.png"));
		}catch(Exception e){
			System.out.println("can't load image -"+ e.getMessage());
			
			System.out.println("THIS FILE ONLY WORKS WITH IAME I'M AWARE OF THIS");
		}
		return tempImage;
	}
}
*/