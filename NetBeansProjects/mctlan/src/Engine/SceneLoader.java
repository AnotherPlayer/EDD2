/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import com.jogamp.opengl.GL2;
import java.util.ArrayList;


/**
 *
 * @author ezpadaz
 */
public class SceneLoader{
    private ArrayList<Scene> escenas = new ArrayList<Scene>();
    
    public SceneLoader(){
        System.out.println("Cargador de Escenas Listo");
    }
    
    public Scene getScene(int i){
        return this.escenas.get(i);
    }
    
    public synchronized void renderAll(GL2 gl){
        for(int i=0; i<escenas.size(); i++){
            escenas.get(i).render(gl);
            System.out.println("Called.");
        }
    }
    
    public void addScene(Scene e){
        this.escenas.add(e);
        System.out.println("Agregad@ escena al renderizador.");
    }
    
    public void flushAll(){
        //Posiblemente no sea lo mejor.
        escenas.clear();
    }
    
    public void switchFor(Scene a){
        escenas.set(0, a);
    }
    
}
