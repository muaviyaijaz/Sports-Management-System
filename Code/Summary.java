/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad_project;

/**
 *
 * @author MaViii
 */
public abstract class Summary {
    
    Player MVP;
    
    public abstract void generateSummary();
    public void setMVP(Player plyr)
    {
        this.MVP=plyr;
    }
    
}
