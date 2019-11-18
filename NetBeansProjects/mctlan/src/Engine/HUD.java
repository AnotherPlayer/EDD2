/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Engine.Renderer;
import Engine.Scene;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;

/**
 *
 * @author ezpadaz
 */
public class HUD implements Scene {

    private GLUT glut = new GLUT();
    private String orderMethod = "";
    private String delayInfo ="";
    private String arrayAccesses = "";

    public HUD(String o){
        this.orderMethod = o;
        this.delayInfo = Integer.toString(Config.getDelay());
        //this.arrayAccesses = aa; not implemented yet.
        System.out.println("HUD OK, Ready to Render");
    }

    @Override
    public void render(GL2 gl) {
        gl.glPushMatrix();
        gl.glTranslatef(-2.900002f,-1.4000002f,-3.3999987f);
        genText("Metodo de Ordenamiento: "+orderMethod,gl,glut,-0.05f,2.6f,0);
        genText("Delay: "+delayInfo,gl,glut,-0.05f,2.48f,0);   
        genText("Accesos al Arreglo: "+arrayAccesses,gl,glut,-0.05f,2.36f,0);
        genText("- HOTKEYS -",gl,glut,4.8f,2.6f,0);
        genText("E - Cambia de Metodo de Ordenamiento",gl,glut,4.3f,2.5f,0);
        genText("R - Reinicia el Arreglo",gl,glut,4.3f,2.4f,0);
        genText("O - Inicia el Ordenamiento",gl,glut,4.3f,2.3f,0);
        genText("T - Cambia el Delay",gl,glut,4.3f,2.2f,0);
        gl.glPopMatrix();
    }
    //objeto 2
    
    
    private void genText(String texto, GL2 gl, GLUT glut, float x, float y, float z){
        gl.glColor3f(1,1,1);
        gl.glRasterPos3f(x,y,z);
        glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, texto);  
    }

    @Override
    public void startSorting() {
        throw new UnsupportedOperationException("Not used on HUD."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float[] colorGrading(int a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
