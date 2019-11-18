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
public interface Scene {
    // Esta "escena" esta configurada especificamente para renderizar metodos de ordenamiento.
    public void render(GL2 gl);    
    public void startSorting();
    public float[] colorGrading(int a);
}
