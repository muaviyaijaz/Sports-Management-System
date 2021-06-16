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
public class CricketPlayerMatchStats   {

    private int id;
    private int score;
    private int balls;
    private float overs;
    private int runsConceeded;
    private int wickets;

    public CricketPlayerMatchStats(int id,int score, int balls, float overs, int runsConceeded, int wickets) {
        this.id = id;
        this.score = score;
        this.balls = balls;
        this.overs = overs;
        this.runsConceeded = runsConceeded;
        this.wickets = wickets;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public float getOvers() {
        return overs;
    }

    public void setOvers(int overs) {
        this.overs = overs;
    }

    public int getRunsConceeded() {
        return runsConceeded;
    }

    public void setRunsConceeded(int runsConceeded) {
        this.runsConceeded = runsConceeded;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }
    
    
    
}
