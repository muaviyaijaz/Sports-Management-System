/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad_project;

/**
 *
 * @author hamza khalid
 */
public class CricketPlayer extends Player{
    
    private int totalruns;
    private int totalwickets;
    private int matchesPlayed;
    private float average;

    public CricketPlayer(int id, String name, String email, String phoneno, String Designation) {
        super(id, name, email, phoneno, Designation);
        
        this.totalruns=0;
        this.totalwickets=0;
        this.matchesPlayed=0;
        this.average=0;
    }

    public void settotalruns(int totalruns){
        this.totalruns = totalruns;
    }
    
    public void settotalwickets(int totalwickets){
        this.totalwickets = totalwickets;
    }
    
    public void setmatchesPlayed(int matchesPlayed){
        this.matchesPlayed = matchesPlayed;
    }
    
    public void setaverage(float average){
        this.average = average;
    }
    
    public int getTotalruns() {
        return totalruns;
    }

    public int getTotalwickets() {
        return totalwickets;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public double getAverage() {
        return average;
    }
    
    public void setStats(int matches,int runs, int wickets, float average)
    {
        this.matchesPlayed=matches;
        this.totalruns=runs;
        this.totalwickets=wickets;
        this.average=average;
    }
    
       @Override
   public  int getWickets()
   {
     return totalwickets ;
   }
   @Override
    public  int getRuns()
    {
    return totalruns;
    }
    @Override
    public  int getPoints()
    {
    return 0;
    }
    @Override
    public int getGoals() 
    {
    return 0;
    }
    @Override
    public int getAssists()
    {
    return 0;
    }  
    
}
