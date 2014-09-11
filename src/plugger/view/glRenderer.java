package src.plugger.view;

import static org.lwjgl.opengl.GL11.GL_QUADS;

import org.lwjgl.opengl.GL11;

public class glRenderer {
	
	/** Draws vertices to the screen
	 * @param vertices vertices to draw, each 3 floats define 1 point in space 
	 * @author Leander*/
	public static void drawVertices(float[] vertices){
		
	}

	/** Setup an OpenGL context with API version 3.2 */
	public void setupOpenGL() {
		
		// Setup an XNA like background color
		GL11.glClearColor(0.4f, 0.6f, 0.9f, 0f);
		
		// Map the internal OpenGL coordinate system to the entire screen
		GL11.glViewport(0, 0, 800, 600);
		
		this.exitOnGLError("Error in glRenderer.setupOpenGL");
	}
	
	/** Cleans up the memory! */
	public void cleanUp() {
		
	}
	
	/** Exits on GL error 
	 * @param errorMessage the error message to display */
	public void exitOnGLError(String errorMessage) {
		int errorValue = GL11.glGetError();
		
		if (errorValue != GL11.GL_NO_ERROR) {
			String errorString = GLU.gluErrorString(errorValue);
			System.err.println("ERROR - " + errorMessage + ": " + errorString);
			
			if (Display.isCreated()) Display.destroy();
			System.exit(-1);
		}
	}
	/*
	 * while (!Display.isCloseRequested()){
			glClear(GL_COLOR_BUFFER_BIT);
			glLoadIdentity();
			
			glRenderer.drawRect(0, 0, 64, 64, 0);
			glRenderer.drawRect(80, 80, 86, 86, 0);
			
			
			
			Display.update();
		}
	 */
}
