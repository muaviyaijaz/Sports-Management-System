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
public class BasketBallPlayerMatchStats {
    
    private int id;
    private int points;
    private int steals;
    

    public BasketBallPlayerMatchStats(int id,int points, int steals) {
        this.id = id;
        this.points = points;
        this.steals = steals;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getSteals() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }  
}
