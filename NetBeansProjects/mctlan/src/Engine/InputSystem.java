/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author ezpadaz
 */
public class InputSystem implements KeyListener{

    private SceneLoader sl;
    
    public InputSystem(SceneLoader sl){
        this.sl = sl;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyChar()){
            case 'i':
                sl.getScene(0).startSorting();
                break;
            case 'r':
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
