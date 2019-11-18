/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.util.Random;

/**
 *
 * @author ezpadaz
 */
public class Config {
    //Retorna el delay de la animacion nadamas :v
    
    private static int delay = 100;
    private static int array_size = 60;
    private static int[] arreglo;
    private static float[] drawPos = {-2.900002f,-1.4000002f,-3.3999987f};
    
    
    
    public static int[] genArray(){
        Random r = new Random();
        arreglo = new int[array_size];
        for(int i=0;i<array_size;i++){
            arreglo[i] = r.nextInt(array_size+100)+1;   
        }
        System.out.println(arreglo.length);
        return arreglo;
    }
    
    public static float[] getDrawPos(){
        return drawPos;
    }
    
    public static int getDelay(){
        return delay;
    }
    
    public static void setDelay(int ms){
        delay = ms;
    }
}
