/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import com.jogamp.opengl.awt.GLJPanel;
import javax.swing.JFrame;

/**
 *
 * @author ezpadaz
 */
public class Window extends JFrame{
    //aqui va el motor :v    
    private Engine motor;
    private Window self;
    public static int x = 1280;
    public static int y = 600;
    
    public Window(String toRender){
        this.setTitle("Ventana de Renderizado");
        this.setSize(x,y);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.self = this;
        //Basura.
        
        
        //Hilo del motor.
        Thread engineThread = new Thread(){
            public void run(){
                motor = new Engine(toRender, self);
            }
        };       
        engineThread.start();
    }
    
    public void setGLPanel(GLJPanel panel){
        this.add(panel);
        this.revalidate();
        this.repaint();
    }
}
