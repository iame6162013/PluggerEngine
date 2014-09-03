package src.plugger.common;

import java.lang.reflect.Field;

public class GameRegistery {
	/**
	 * add item to the hud
	 */
	public static int HudMessMaxID=64;
	public static String[] HudMessBase= new String[HudMessMaxID];
	public static Field[] Location=new Field[HudMessMaxID];
	public static String[] HudMess= new String[HudMessMaxID];
	public static int HudMessID =-1;
	public static void rebuildHudMessNum(){
		HudMessID=0;
		for (int i=0;HudMess[i]!=null; i++){
			HudMessID++;
		}
	}
	public static void repaintHudMess(){
		for(int i=0;i<HudMessMaxID;i++){
			if(HudMessBase[i]!=null){
				HudMess[i]=HudMessBase[i]+Location[i];
				System.out.println("OuT");
			}
			//System.out.println(HudMessBase+""+i);
		}
	}
	public static void addHudMess(String mess) {
		if(mess!= null){
			System.out.println("adding Mess to hud:"+mess+" id:"+HudMessID);
			HudMessID++;
			HudMess[HudMessID]=mess;
		}else{
			System.out.println("someone is trying to add a null hud Mess");
		}
	}
	public static void addHudMess(String mess, String mess2) {
		if(mess!= null){
			System.out.println("adding Mess to hud:"+mess+" id:"+HudMessID);
			HudMessID++;
			HudMess[HudMessID]=mess+mess2;
			HudMessBase[HudMessID]=mess;
		}else{
			System.out.println("someone is trying to add a null hud Mess");
		}
	}
	public static void addHudMess(String mess, Class  location) {
		int mess2 = 5;
		try {
			Field f=location.getDeclaredField("fps");
			try {
				mess2=f.getInt(f);
				Location[HudMessID+1]=f;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		mess+=mess2;
		addHudMess(mess);
	}
	public static void addHudBar(String mess) {
		if(mess!= null){
			System.out.println("adding Bar to hud:"+mess+" id:"+HudMessID);
			HudMessID++;
			HudMess[HudMessID]=mess;
		}else{
			System.out.println("someone is trying to add a null hud Bar");
		}
	}
	public static void addHudBar(String mess,String mess2) {
		if(mess!= null){
			System.out.println("adding Bar to hud:"+mess+" id:"+HudMessID);
			HudMessID++;
			HudMess[HudMessID]=mess;
			HudMessBase[HudMessID]=mess;
		}else{
			System.out.println("someone is trying to add a null hud Bar");
		}
	}
}
