/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad_project;

import java.util.*;

/**
 *
 * @author MaViii
 */
public class CricketSummary extends Summary{
    
    private int team1Score;
    private int team2Score;
    private int team1Wickets;
    private int team2Wickets;
    private float team1Overs;
    private float team2Overs;
    ArrayList<CricketPlayerMatchStats> team1Players=new ArrayList<>();
    ArrayList<CricketPlayerMatchStats> team2Players=new ArrayList<>();

    public CricketSummary(int team1Score, int team2Score, int team1Wickets, int team2Wickets, float team1Overs, float team2Overs) {
        this.team1Score = team1Score;
        this.team2Score = team2Score;
        this.team1Wickets = team1Wickets;
        this.team2Wickets = team2Wickets;
        this.team1Overs = team1Overs;
        this.team2Overs = team2Overs;
    }
    
    public void setteam1Score(int team1Score){
        this.team1Score = team1Score;
    }
    
    public void setteam2Score(int team2Score){
        this.team2Score = team2Score;
    }
    
    public void setteam1Wickets(int team1Wickets){
        this.team1Wickets = team1Wickets;
    }
    
    public void setteam2Wickets(int team2Wickets){
        this.team2Wickets = team2Wickets;
    }
    
    public void setteam1Overs(float team1Overs){
        this.team1Overs = team1Overs;
    }
    
    public void setteam2Overs(float team2Overs){
        this.team2Overs = team2Overs;
    }
    
    public int getteam1Score(){
        return team1Score;
    }
    
    public int getteam2Score(){
        return team2Score;
    }
    
    public int getteam1Wickets(){
        return team1Wickets;
    }
    
    public int getteam2Wickets(){
        return team2Wickets;
    }
    
    public float getteam1Overs(){
        return team1Overs;
    }
    
    public float getteam2Overs(){
        return team2Overs;
    }
    
    
    @Override
    public void generateSummary()
    {
        
    }
    
    public void addTeam1PlayerStats(CricketPlayerMatchStats stats)
    {
        this.team1Players.add(stats);
    }
    
    public void addTeam2PlayerStats(CricketPlayerMatchStats stats)
    {
        this.team2Players.add(stats);
    }
    
    public CricketPlayerMatchStats getPlayerMatchStats(int id)
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
