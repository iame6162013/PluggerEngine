package plugger.shaders;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;


import plugger.entities.Camera;
import plugger.entities.Light;
import plugger.util.Maths;

public class TerrainShader extends ShaderProgram{
	
	private static final String VERTEX_FILE = "src/plugger/shaders/terrainVertexShader.txt";
	private static final String FRAGMENT_FILE = "src/plugger/shaders/terrainFragmentShader.txt";
	
	private int location_transformationMatrix;
	private int location_projectionMatrix;
	private int location_viewMatrix;
	private int location_lightPosition;
	private int location_lightColor;
	private int location_shineDamper;
	private int location_reflectivity;
	private int location_skyColor;
	
	public TerrainShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);
	}
	@Override
	protected void bindAttributes() {
			super.bindAttribute(0, "position");
			super.bindAttribute(1, "textureCoords");
			super.bindAttribute(2, "normal");
		
	}
	@Override
	protected void getAllUinformLocation() {
		location_transformationMatrix=super.getUinformLocation("transformationMatrix");
		location_projectionMatrix=super.getUinformLocation("projectionMatrix");
		location_viewMatrix=super.getUinformLocation("viewMatrix");
		location_lightPosition=super.getUinformLocation("lightPosition");
		location_lightColor=super.getUinformLocation("lightColor");
		location_shineDamper=super.getUinformLocation("shineDamper");
		location_reflectivity=super.getUinformLocation("reflectivity");
		location_skyColor=super.getUinformLocation("skyColor");
	}
	
	public void loadSkyColor(float r, float g, float b){super.loadVector(location_skyColor, new Vector3f(r,g,b));}
	public void loadSkyColor(Vector3f skyColor){super.loadVector(location_skyColor, skyColor);}
	
	public void loadShineVariable(float damper, float reflectivity){
		super.loadFloat(location_shineDamper, damper);
		super.loadFloat(location_reflectivity, reflectivity);
	}
	
	public void loadTransformationMatrix(Matrix4f matrix){
		super.loadMatrix(location_transformationMatrix, matrix);
	}
	
	public void loadLight(Light light){
		super.loadVector(location_lightPosition, light.getPosition());
		super.loadVector(location_lightColor, light.getColour());
	} 
	
	public void loadViewMatrix(Camera camera){
		Matrix4f viewMatrix = Maths.createViewMatrix(camera);
		super.loadMatrix(location_viewMatrix, viewMatrix);
	}
	
	public void loadProjectionMatrix(Matrix4f projection){
		super.loadMatrix(location_projectionMatrix, projection);
	}
	
}
