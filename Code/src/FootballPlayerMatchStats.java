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
public class FootballPlayerMatchStats {
    
    private int id;
    private int goals;
    private int assists;

    public FootballPlayerMatchStats(int id, int goals, int assists) {
        this.id = id;
        this.goals = goals;
        this.assists = assists;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }
    
    
}
