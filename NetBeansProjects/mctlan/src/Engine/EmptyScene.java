/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import com.jogamp.opengl.GL2;

/**
 *
 * @author ezpadaz
 */
public class EmptyScene implements Scene{

    @Override
    public void render(GL2 gl) {
        //nada.
    }

    @Override
    public void startSorting() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float[] colorGrading(int a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
