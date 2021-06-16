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
public class FootballSummary extends Summary {

     private int team1Goals;
     private int team2Goals;
    
     ArrayList<FootballPlayerMatchStats> team1Players=new ArrayList<>();
     ArrayList<FootballPlayerMatchStats> team2Players=new ArrayList<>();

    public FootballSummary(int team1Goals, int team2Goals) 
    {
        this.team1Goals = team1Goals;
        this.team2Goals = team2Goals;
    }
    
    public void setteam1Goals(int team1Goals){
        this.team1Goals = team1Goals;
    }
    
    public void setteam2Goals(int team2Goals){
        this.team2Goals = team2Goals;
    }
    
    
    public int getteam1Goals(){
        return team1Goals;
    }
    
    public int getteam2Goals(){
        return team2Goals;
    }
     
    
    @Override
    public void generateSummary() {
    }
    
       public FootballPlayerMatchStats getPlayerMatchStats(int id)
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
    
     public void addTeam1PlayerStats(FootballPlayerMatchStats stats)
    {
        this.team1Players.add(stats);
    }
    
    public void addTeam2PlayerStats(FootballPlayerMatchStats stats)
    {
        this.team2Players.add(stats);
    }
    
}
