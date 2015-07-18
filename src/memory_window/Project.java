     /*
  * To change this license header, choose License Headers in Project Properties.
  * To change this template file, choose Tools | Templates
  * and open the template in the editor.
  */
package memory_window;


import data.Entries;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


/**
 *
 * @author zxmds67
 */
public class Project {
    
    
    
    public static HashMap<String,String> posTags = new HashMap<>();
    public static data.Entries myent;
    
    static public JLabel Zeit = new JLabel("00:00"); //Jlabel for the stoppwatch
    static JLabel solvedPairs =new JLabel("0"); // JLabel for the solvedPairs counter
    static JPanel ground = new JPanel();
    static JFrame back = new JFrame();
    
    static long zeit1 =0;
    static long zeit2 =0;
    static long time =0;
    static long min1 =0;
    static long min2 =0;
    static long sec1 =0;
    static long sec2 =0;
    static long milli1 =0;
    static long milli2 =0;
    static boolean start = false;
    
    static int solvedPair =0;
    
    
    /* Compares two Strings if they match key and value in the HashMap,
     * Value independent!
     * IMPORT : HashMap posTags
     */
    public static boolean isPair(String first,String second) throws IOException
    {   
        posTags=Cards.values;
        if(posTags.containsKey(first)){
            if(posTags.get(first).equals(second)){
                solvedPair++;
                solvedPairs.setText("<html>Solved Pairs:<br>"+Integer.toString(solvedPair)+"</html>");
                return true;
            }
        }
        if(posTags.containsValue(first)){
            for(String word: posTags.keySet())
            {
                if (word.equals(second) && posTags.get(word).equals(first)){
                    solvedPair++;
                    solvedPairs.setText(Integer.toString(solvedPair));
                    return true;
                }
            }
        }
        
        
        return false;
    }
    
    /*
     * Displays a stoppuhr as JLabel
     * IMPORT: boolean= true ---> starts Stoppwatch
     */
    public static void myStoppuhr(boolean start) {
        Thread t = new Thread(() -> {
            
            
            
            for (int i=0; i<1000000;){
                while (true) {
                    if (start) {
                        zeit2=System.currentTimeMillis();
                        time=(zeit2-zeit1);
                        milli2 = Math.round((time - Math.round(time/1000)*1000)/100);
                        milli1 = Math.round((time - Math.round(time/100)*100)/10);
                        min1 = Math.round(time/1000/60);
                        sec1 = Math.round(time/1000-min1*60);
                        if (min1 <10){
                            if (sec1<10){
                                Zeit.setText("0"+min1+":0"+sec1);
                            } else {
                                Zeit.setText("0"+min1+":"+sec1);
                            }
                        } else {
                            if (sec1<10){
                                Zeit.setText(min1+":0"+sec1);
                            } else {
                                Zeit.setText(min1+":"+sec1);
                            }
                        }
                    }
                }
            }
        });
        t.start();}
    
}
