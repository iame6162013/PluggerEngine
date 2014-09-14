package src.plugger.view;

import static org.lwjgl.opengl.GL11.GL_QUADS;

import org.lwjgl.opengl.GL11;

public class glRenderer throws InvalidArgumentException {
	
	private int[] vboIds; /** VBO ids are integers*/
	private int[] vaoIds; /** VAO ids are integers*/
	
	/** Draws vertices to the screen
	 * @param vertices vertices to draw, each 3 floats define 1 point in space 
	 * @author Leander*/
	public static void drawVertices(float[] vertices){
		int vertexcount = vertices.length / 3;
		if (vertexcount % 1 != 0) {throw InvalidArgumentException("The amount of vertices should be divisble by three!");}
		
		// Sending data to OpenGL requires the usage of (flipped) byte buffers
		FloatBuffer verticesBuffer = BufferUtils.createFloatBuffer(vertices.length);
		verticesBuffer.put(vertices);
		verticesBuffer.flip();
		
		// Create a new Vertex Array Object in memory and select it (bind)
		// A VAO can have up to 16 attributes (VBO's) assigned to it by default
		vaoId = GL30.glGenVertexArrays();
		GL30.glBindVertexArray(vaoId);
		
		// Create a new Vertex Buffer Object in memory and select it (bind)
		// A VBO is a collection of Vectors which in this case resemble the location of each vertex.
		vboId = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboId);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, verticesBuffer, GL15.GL_STATIC_DRAW);
		// Put the VBO in the attributes list at index 0
		GL20.glVertexAttribPointer(, 3, GL11.GL_FLOAT, false, 0, 0);
		// Deselect (bind to 0) the VBO
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);

		// Deselect (bind to 0) the VAO
		GL30.glBindVertexArray(0);

		this.exitOnGLError("Error in setupQuad");
	}

	/** Setup an OpenGL context with API version 3.2 */
	public void setupOpenGL() {
		
		// Setup an XNA like background color
		GL11.glClearColor(0.4f, 0.6f, 0.9f, 0f);
		
		// Map the internal OpenGL coordinate system to the entire screen
		GL11.glViewport(0, 0, 800, 600);
		
		this.exitOnGLError("Error in glRenderer.setupOpenGL");
	}
	
	/* Cleans up the memory!
	 * @param vboIds array of vbo id integers 
	 * @param vaoIds array of vao id integers */
	public void cleanUp(int[] vboIds, int[] vaoIds) {
		/*// Disable the VBO index from the VAO attributes list
		GL20.glDisableVertexAttribArray(0);

		// Delete the VBOs
		for (i=0;i++;i < vboIds) {
			killVBO(vboIds[i]);
		}

		// Delete the VAOs
		GL30.glBindVertexArray(0);
		GL30.glDeleteVertexArrays(vaoId);

		Display.destroy();*/
	}
	
	/**removes a vbo from memory 
	 * @param vboId the id of the vbo to remove*/
	public void killVBO(vboId) {
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		GL15.glDeleteBuffers(vboId);
	}
	
	/** removes a vao from memory
	 * @param vboId the id of the vbo to remove*/
	public void killVAO(vaoId) {
		GL30.glBindVertexArray(0);
		GL30.glDeleteVertexArrays(vaoId);
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
