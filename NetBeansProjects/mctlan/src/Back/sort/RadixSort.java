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
import java.util.Arrays;

/**
 *
 * @author ezpadaz
 */
public class RadixSort implements Scene {
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
                radixsort(arr, arr.length);
            }
        }; 
        
        sort.start();
    }
    
    static int getMax(int arr[], int n) 
    { 
        int mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) {
                mx = arr[i];
            }
        return mx; 
    } 
  
    // A function to do counting sort of arr[] according to 
    // the digit represented by exp. 
    static void countSort(int arr[], int n, int exp) 
    { 
        int output[] = new int[n]; // output array 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
  
        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) {
            count[ (arr[i]/exp)%10 ]++;
        }
  
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1]; 
        }
  
        // Build the output array 
        for (i = n - 1; i >= 0; i--) 
        { 
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
            count[ (arr[i]/exp)%10 ]--; 
        } 
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++) {
            arr[i] = output[i]; 
            try{
                Thread.sleep(Config.getDelay());
            }catch(Exception e){

            }
        }
    } 
  
    // The main function to that sorts arr[] of size n using 
    // Radix Sort 
    static void radixsort(int arr[], int n) 
    { 
        // Find the maximum number to know number of digits 
        int m = getMax(arr, n); 
  
        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        for (int exp = 1; m/exp > 0; exp *= 10) 
            countSort(arr, n, exp); 
        
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
