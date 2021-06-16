/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad_project;
import java.util.*;

/**
 *
 * @author hamza khalid
 */
public abstract class Tournament {
    
    private String name;
    private String format;
    private int teamLimit;
    private double fees;
    ArrayList<Schedule> schedulelist=new ArrayList<>();
    ArrayList<Team> teamList=new ArrayList<>();
    dbConnectivity db=dbConnectivity.getInstance();
    private int type;

    public Tournament(String name, String format, int teamLimit, double fees) {
        this.name = name;
        this.format = format;
        this.teamLimit = teamLimit;
        this.fees = fees;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public void setFormat(String format){
        this.format = format;
    }
    
    public void setTeamLimit(int teamLimit){
        this.teamLimit = teamLimit;
    }
    
    public void setFees(double fees){
        this.fees = fees;
    }
    
    public void setType(int type){
        this.type = type;
    }
    
    public Team getTeam(int id)
    {
        for(int i=0;i<this.teamList.size();i++)
        {
            if(this.teamList.get(i).getId()==id)
            {
                return this.teamList.get(i);
            }
        }
        return null;
    }
    
    public Team getCaptainTeam(int id)
    {
        for(int i=0;i<this.teamList.size();i++)
        {
            if(this.teamList.get(i).getCaptain().getId()==id)
            {
                return this.teamList.get(i);
            }
        }
        return null;
    }
    
    public Team getTeam(String name)
    {
        for(int i=0;i<this.teamList.size();i++)
        {
            if(this.teamList.get(i).getName().equals(name))
            {
                return this.teamList.get(i);
            }
        }
        return null;
    }
    
    
    public ArrayList<Team> getTeamList()
    {
        return this.teamList;
    }
    
      public ArrayList<Schedule> getScheduleList()
    {
        return this.schedulelist;
    }
    
    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public int getTeamLimit() {
        return teamLimit;
    }

    public double getFees() {
        return fees;
    }
    
    public int getType(){
        return type;
    }
    
    public boolean updateTeam(Team T)
    {
         for(int i=0;i<this.teamList.size();i++)
         {
             if(this.teamList.get(i).getId()==T.getId())
             {
                 this.teamList.set(i, T);
                 return true;
             }
         }
         return false;
    }
    
    public boolean updateSchedule(Schedule S)
    {
         for(int i=0;i<this.schedulelist.size();i++)
         {
             if(this.schedulelist.get(i).getID()==S.getID())
             {
                 this.schedulelist.set(i, S);
                 return true;
             }
         }
         return false;
    }
    
     public Schedule getSchedule(int id)
    {
        for(int i=0;i<this.schedulelist.size();i++)
        {
            if(this.schedulelist.get(i).getID()==id)
            {
                return this.schedulelist.get(i);
            }
        }
        return null;
    }
    
    public boolean CheckNewSchedule(Schedule S1)
    {
        for(int i=0;i<this.schedulelist.size();i++)
        {
            Schedule S2=this.schedulelist.get(i);
          if(S1.getId()!=S2.getId())
            {
            if(S1.getDate().equals(S2.getDate()) && S1.getTime().equals(S2.getTime()) && S1.getVenue().equals(S2.getVenue()))
            {  
              return false;  
            }
            else if(S1.getDate().equals(S2.getDate()) && S1.getTime().equals(S2.getTime()))
            {
                if(S1.getTeam1().getName().equals(S2.getTeam1().getName()) || S1.getTeam1().getName().equals(S2.getTeam2().getName()) )
                {
                    return false;
                }
                else if(S1.getTeam2().getName().equals(S2.getTeam1().getName()) || S1.getTeam2().getName().equals(S2.getTeam2().getName()) )
                {
                    return false;
                }
            }
            }
        }
        
        return true;
    }
     
    public boolean CheckAllocatedOfficial(Schedule S1)
    {
        for(int i=0;i<this.schedulelist.size();i++)
        {
            Schedule S2=this.schedulelist.get(i);
          if(S1.getId()!=S2.getId())
           {
            if(S1.getDate().equals(S2.getDate()) && S1.getTime().equals(S2.getTime()))
            {  
              if(S1.getOffcial().getId()==S2.getOffcial().getId())
              {
                  return false;
              }
            }
           }
        }
        return true;   
    }
    
    
    
    public abstract boolean AddTeam(Team T);
    public abstract boolean AddMatch(Schedule S);
    public abstract int getCount();
    public abstract boolean RemoveTeam(Team T);
   


    
}
