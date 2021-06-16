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
public class BasketBallTournament extends Tournament{
    
    private String totalPoints;

    public BasketBallTournament( String name, String format, int teamLimit, double fees,String totalPoints) {
        super(name, format, teamLimit, fees);
        this.totalPoints = totalPoints;
        this.setType(3);
        this.teamList=db.getTeamList(this.getType());
        this.schedulelist=db.getScheduleList(this.getType());
    }
    
    public void settotalPoints(String totalPoints){
        this.totalPoints = totalPoints;
    }
    
    public String gettotalPoints(){
        return totalPoints;
    }
    
    @Override
     public boolean AddTeam(Team T)
    {
          this.teamList.add(T);
          return true;
    }
     
     
    @Override
     public boolean AddMatch(Schedule S)
     {
         this.schedulelist.add(S);
     return true;
     }
     
     @Override
      public int getCount()
    {
        if(this.teamList==null)
        {
            return 0;
        }
        else
        {
            return this.teamList.size();
        }
    }
    
    public boolean RemoveTeam(Team T)
    {
          this.teamList.remove(T);
          return true;
    }
      
}
