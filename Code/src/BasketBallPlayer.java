/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad_project;


public class BasketBallPlayer extends Player  {

    private int TtotalPoints;
    private int totalSteals;
    
    public BasketBallPlayer(int id, String name, String email, String phoneno, String Designation) {
        super(id, name, email, phoneno, Designation);
    
        this.TtotalPoints=0; 
        this.totalSteals=0; 
    }

    public void setTtotalPoints(int TtotalPoints){
        this.TtotalPoints = TtotalPoints;
    }
    
    public void settotalSteals(int totalSteals){
        this.totalSteals = totalSteals;
    }
    
    public int getTtotalPoints() {
        return TtotalPoints;
    }
    
    public void setStats(int points,int steals)
    {
        this.TtotalPoints=points;
        this.totalSteals=steals;
    }

    public int getTotalSteals() {
        return totalSteals;
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
    return TtotalPoints;
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
