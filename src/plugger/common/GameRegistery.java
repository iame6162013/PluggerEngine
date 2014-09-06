package src.plugger.common;

import java.lang.reflect.Field;


// TODO GameRegistery is spelled incorrect, it should be GameRegistry
public class GameRegistery {
	/**
	 * add item to the hud
	 */
	public static int HudMessMaxID=64;
	public static String[] HudMessBase= new String[HudMessMaxID];
	public static Field[] ClassPath=new Field[HudMessMaxID];
	public static String[] ClassPathOBJECT=new String[HudMessMaxID];
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
				HudMess[i]=HudMessBase[i]+ClassPath[i];
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
	public static void addHudMess(String mess, Class  Classpath,String ClassPathobj) throws NoSuchFieldException {
		int mess2 = 0;
		if(mess!= null){
			HudMessID++;
			if(ClassPath[HudMessID]!=null){
				try {
					Field f=Classpath.getDeclaredField(ClassPathOBJECT[HudMessID]);//.getDeclaredField(ClassPath[HudMessID][1]);
					try {
						mess2=f.getInt(f);
						ClassPath[HudMessID+1]=f;
						ClassPathOBJECT[HudMessID]= ClassPathobj;
					} catch (Exception e) {
						e.printStackTrace();
					}
				} catch (SecurityException e) {
					e.printStackTrace();
				}
				System.out.println("adding Mess to hud:"+mess+" id:"+HudMessID);
				HudMess[HudMessID]=mess;
			}else{
				HudMess[HudMessID]=mess;
			}
		}else{
			System.out.println("someone is trying to add a null hud Mess");
		}
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
}
