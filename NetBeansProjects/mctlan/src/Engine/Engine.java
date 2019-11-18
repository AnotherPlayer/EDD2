package Engine;

//Extracto basico del Titan Engine - Sin Shaders ni Rendering Inteligente.

import Back.sort.*;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.FPSAnimator;

public class Engine {   
    private Renderer render;
    private SceneLoader sl;
    private FPSAnimator fps;
    private GLProfile perfil;
    private GLCapabilities capabilities;
    private GLJPanel panel;
    private Window window;
    
    public Engine(String toLoad, Window window){
        this.window = window;
        sysInit();
        preLoader(toLoad);
    }
    
    private void sysInit(){
        sl = new SceneLoader();       
        render = new Renderer(sl);
        perfil = GLProfile.get(GLProfile.GL2);
        capabilities = new GLCapabilities(perfil);        
        panel = new GLJPanel(capabilities);
        panel.addGLEventListener(render); 
        panel.addKeyListener(new InputSystem(sl));
        window.setGLPanel(panel);
        panel.requestFocus();
        fps = new FPSAnimator(panel,300,true);
        fps.start();
    }
    
    private void flushScreen(){
        //limpia la pantalla
        //System.out.println("screen is clear.");
        sl.flushAll();
    }
      
    private void preLoader(String tl){
        switch(tl){
            case "insert":
                flushScreen();
                InsertSort is = new InsertSort();
                HUD insert_hud = new HUD("Insercion");
                //Llama al metodo init para poder inicializar el metodo a usar.
                is.init(insert_hud);
                //sl.addScene(insert_hud);
                sl.addScene(is);
                break;
            case "merge":
                flushScreen();
                MergeSort ms = new MergeSort();
                HUD ms_hud = new HUD("Mezcla");
                ms.init(ms_hud);
                //sl.addScene(ms_hud);
                sl.addScene(ms);
                break;
            case "heap":
                flushScreen();
                HeapSort hs = new HeapSort();
                HUD hs_hud = new HUD("Heapsort");
                hs.init(hs_hud);
                sl.addScene(hs);
                break;
            case "radix":
                flushScreen();
                RadixSort rx = new RadixSort();
                HUD rx_hud = new HUD("Radix");
                rx.init(rx_hud);
                sl.addScene(rx);
                break;
            case "shell":
                flushScreen();
                ShellSort ss = new ShellSort();
                HUD ss_hud = new HUD("Shell");
                ss.init(ss_hud);
                sl.addScene(ss);
                break;
            case "quick":
                flushScreen();
                QuickSort qs = new QuickSort();
                HUD qs_hud = new HUD("QuickSort");
                qs.init(qs_hud);
                sl.addScene(qs);
                break;

            default:
                System.out.println("Nada fue seleccionado.");
                break;
        }
    }
    
}
