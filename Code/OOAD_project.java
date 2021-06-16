/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad_project;

import java.awt.Color;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

/**
 *
 * @author hamza khalid
 */
public class OOAD_project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try { 
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch(Exception ignored){}
      
        JFrame1 F=new JFrame1();
        F.setVisible(true);
    }
    
}
