/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad_project;

import java.util.ArrayList;

/**
 *
 * @author MaViii
 */
public class BasketBallSummary extends Summary {
    
    private int team1Points;
    private int team2Points;
    
    ArrayList<BasketBallPlayerMatchStats> team1Players=new ArrayList<>();
    ArrayList<BasketBallPlayerMatchStats> team2Players=new ArrayList<>();

    public BasketBallSummary(int team1Points, int team2Points) {
        this.team1Points = team1Points;
        this.team2Points = team2Points;
       
    }
    
    public void setteam1Points(int team1Points){
        this.team1Points = team1Points;
    }
    
    public void setteam2Points(int team2Points){
        this.team2Points = team2Points;
    }
    
    
    public int getteam1Points(){
        return team1Points;
    }
    
    public int getteam2Points(){
        return team2Points;
    }
    
    @Override
    public void generateSummary()
    {
        
    }
    
    public void addTeam1PlayerStats(BasketBallPlayerMatchStats stats)
    {
        this.team1Players.add(stats);
    }
    
    public void addTeam2PlayerStats(BasketBallPlayerMatchStats stats)
    {
        this.team2Players.add(stats);
    }
    
    public BasketBallPlayerMatchStats getPlayerMatchStats(int id)
    {
        for(int i=0;i<this.team1Players.size();i++)
        {
            if(this.team1Players.get(i).getId()==id)
            {
                return this.team1Players.get(i);
            }
        }
        
         for(int i=0;i<this.team2Players.size();i++)
        {
            if(this.team2Players.get(i).getId()==id)
            {
                return this.team2Players.get(i);
            }
        }
         return null;
    }
    
    
}
