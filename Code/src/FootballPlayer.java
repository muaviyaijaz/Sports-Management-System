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
public class FootballPlayer extends Player {

    private int totalGoals; 
    private int totalAssists;
    
    public FootballPlayer(int id, String name, String email, String phoneno, String Designation) {
        super(id, name, email, phoneno, Designation);
        
        this.totalGoals=0;
        this.totalAssists=0;
    }

   public int getTotalGoals() {
        return totalGoals;
    }

    public int getTotalAssists() {
        return totalAssists;
    }
    
    public void settotalGoals(int totalGoals){
        this.totalGoals = totalGoals;
    }
    
    public void settotalAssists(int totalAssists){
        this.totalAssists = totalAssists;
    }
    
    public void setStats(int goals,int assists)
    {
        this.totalGoals=goals;
        this.totalAssists=assists;
    }
    
     @Override
   public  int getWickets()
   {
     return 0 ;
   }
   @Override
    public  int getRuns()
    {
    return 0;
    }
    @Override
    public  int getPoints()
    {
    return 0;
    }
    @Override
    public int getGoals() 
    {
    return totalGoals;//totalGoals;
    }
    @Override
    public int getAssists()
    {
    return totalAssists;//totalAssists;
    }     
    
    
}
