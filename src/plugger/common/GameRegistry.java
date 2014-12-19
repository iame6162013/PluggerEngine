package plugger.common;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GameRegistry {
	private static List<Byte> update = new LinkedList<Byte>();
	public static List<String> hudMesh= new LinkedList<String>();
	private static List<String> HudMessBase= new LinkedList<String>();
	//Last thing
	private static List<Class<?>> ClassPath=new LinkedList<Class<?>>();
	private static List<String> ClassPathOBJECT=new LinkedList<String>();
	
	
	
	public static int amountHudMesh = 0;
	
	/**
	 * to update the hudmessage's
	 */
	public static void UpdateHudMess(){
		int nonUpdators=0;
		for(int i=0;i<amountHudMesh;i++){
			try {
				switch (update.get(i)){
				case 0:nonUpdators++;
					break;
				case 1:hudMesh.add(i,HudMessBase.get(i-nonUpdators)+ClassPath.get(i-nonUpdators).getField(ClassPathOBJECT.get(i-nonUpdators)).toString());
					break;
				case 2:
					String j;
					Class<?> c = j.getClass();
					Method m = ClassPath.get(i-nonUpdators).getDeclaredMethod(ClassPathOBJECT.get(i-nonUpdators));
					Object obj = GameLoop.world.player;//ClassPath.get(i-nonUpdators).newInstance();
					Integer out=(Integer) m.invoke(obj);
					hudMesh.add(i,HudMessBase.get(i-nonUpdators)+out);
					break;
				default :System.err.print("wrong update number in hudmesh"+i);
					break;
				}
			}catch (Exception e) {System.err.print("wrong update number in hudmesh"+i);e.printStackTrace();}
		}
	}
	/**
	 * add item to the hud
	 * (for version,etc)
	 */
	public static void addHudMess(String mess) {
		if(mess!= null){
			hudMesh.add(mess);
			update.add((byte) 0);
			amountHudMesh++;
		}else{
			System.out.println("someone is trying to add a null hud Mess");
		}
	}
	/**
	 * add updating FIELD to the hud
	 *(for fps,position,etc)
	 */
	public static void addHudMess(String mess,Class<?>  Classpath,String ClassPathobj){
		if(mess!= null){
			try {
				ClassPath.add(Classpath);
				ClassPathOBJECT.add(ClassPathobj.toString());
				hudMesh.add(" ");
				HudMessBase.add(mess);
				update.add((byte) 1);
				amountHudMesh++;
			} catch (Exception e) {
				System.out.println(ClassPath.get(amountHudMesh)+"_"+ClassPathOBJECT.get(amountHudMesh)+"_"+amountHudMesh);
				e.printStackTrace();
			}
		}else{
			System.out.println("someone is trying to add a null hud Mess");
		}
	}
	/**
	 * add updating METHOD to the hud
	 *(for fps,position,etc)
	 */
	public static void addHudMess2(String mess,Class<?>  Classpath, String ClassPathobj){
		if(mess!= null){
			try {
				ClassPath.add(Classpath);
				ClassPathOBJECT.add(ClassPathobj);
				hudMesh.add(" ");
				HudMessBase.add(mess);
				update.add((byte) 2);
				amountHudMesh++;
			} catch (Exception e) {
				//System.out.println(ClassPath.get(amountHudMesh)+"_"+ClassPathOBJECT.get(amountHudMesh)+"_"+amountHudMesh);
				e.printStackTrace();
			}
		}else{
			System.out.println("someone is trying to add a null hud Mess");
		}
	}
}
