/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Back.sort;

import Engine.Config;
import Engine.HUD;
import Engine.Scene;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;

/**
 *
 * @author ezpadaz
 */
public class HeapSort implements Scene{

    private HUD hud;
    private int[] arr;
    private float[] dp = Config.getDrawPos();
    private GLUT glut;
    
    public void init(HUD hud) {
        this.hud = hud;       
        //autogen del array en otra clase? :v
        arr = Config.genArray();
        glut = new GLUT();
    }

    @Override
    public void render(GL2 gl) {
        drawGraph(gl);
        hud.render(gl);
        renderText(gl,glut);
    }
    
    private void drawGraph(GL2 gl){
        float base = 0f;
        gl.glPushMatrix();
        gl.glTranslatef(dp[0],dp[1],dp[2]);
        gl.glBegin(GL2.GL_QUADS);
        for(int i = 0; i<arr.length; i++){
            float height = ((float)arr[i]/100);
            float pos = ((float)i/10);

            gl.glPushMatrix();
            float[] color = colorGrading(arr[i]);
            gl.glColor3f(color[0],color[1],color[2]);
            // base           
            gl.glVertex3f(base+pos, base, 0);
            gl.glVertex3f(base+pos, height,0);
            // altura
            gl.glVertex3f(base+pos-0.1f, height, 0);
            gl.glVertex3f(base+pos-0.1f, base, 0);
            gl.glPopMatrix();
        }
        gl.glEnd();
        gl.glPopMatrix();
        gl.glFlush();
    }

    @Override
    public void startSorting() {
        //aaaaggggg el margggggg. - Memazo del 2019 para mi yo del año que sea que revise este codigo de nuevo.
        Thread sort = new Thread(){
            public void run(){
                sort(arr);
            }
        }; 
        
        sort.start();
    }
    
    public void sort(int arr[]) 
	{ 
		int n = arr.length; 

		for (int i = n / 2 - 1; i >= 0; i--) 
			heapify(arr, n, i); 

		for (int i=n-1; i>=0; i--) 
		{
			int temp = arr[0]; 
			arr[0] = arr[i]; 
			arr[i] = temp;
                        try{
                            
                                //t.toggleSelected(true);
                                Thread.sleep(Config.getDelay());
                                //t.toggleSelected(false);
                            
                        }catch(Exception e){
                        e.printStackTrace();
                        }
			heapify(arr, i, 0); 
		} 
	} 

	void heapify(int arr[], int n, int i) 
	{ 
		int largest = i; 
		int l = 2*i + 1; 
		int r = 2*i + 2; 

		
		if (l < n && arr[l] > arr[largest]) {
			largest = l;
                        try{
                            Thread.sleep(Config.getDelay());
                        }catch(Exception e){
                        
                        }
                }

		if (r < n && arr[r] > arr[largest]) {
			largest = r; 
                        try{
                            Thread.sleep(Config.getDelay());
                        }catch(Exception e){
                        
                        }
                }

		if (largest != i) 
		{ 
			int swap = arr[i];                      
			arr[i] = arr[largest]; 
			arr[largest] = swap;
                        
                        try{
                            Thread.sleep(Config.getDelay());
                        }catch(Exception e){
                        
                        }
			heapify(arr, n, largest); 
		} 
	} 
    
    public void renderText(GL2 gl, GLUT glut){        
        float base = 0f;
        gl.glPushMatrix();
        gl.glTranslatef(dp[0],dp[1],dp[2]);
        for(int i= 0; i<arr.length; i++){
            float height = ((float)arr[i]/100);
            float pos = ((float)i/10);
            float[] textpos = {((base+pos)-0.08f),height+0.07f,0};         
            gl.glColor3f(1,1,1);
            gl.glRasterPos3f(textpos[0],textpos[1],textpos[2]);
            glut.glutBitmapString(GLUT.BITMAP_HELVETICA_10, Integer.toString(arr[i]));         
        }
        gl.glPopMatrix();
    }

    @Override
    public float[] colorGrading(int a) {
        int n = a;
        float[] rgb = new float[3];
        if(n<=100){
            //RED FLAG
            if(n<50){
                rgb[0] = ((float)n/10);
            }else{
            rgb[0] = ((float)n/100);
            }
            rgb[1] = 0;
            rgb[2] = 0f;
            return rgb;
        }else if(n>=100 && n<=199){
            //naranja :v
            rgb[0] = 1;
            rgb[1] = ((float)n/100)-1;
            rgb[2] = 0;
            return rgb;
        }else if(n>=200 && n<=299){
            //verde
            rgb[0] = 0;
            rgb[1] = ((float)n/100)-2;
            rgb[2] = 0;
            return rgb;
            
        }else if(n>=299 && n<=399){
            // Morado
            rgb[0] = 1;
            rgb[1] = 0;
            rgb[2] = (((float)n/100)-3);
            return rgb;
        }else{
            rgb[0] = 1;
            rgb[1] = 1;
            rgb[2] = 1;
            return rgb;
        }
    }
}
