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
public class SportsManagement {
    
    ArrayList<User> userList= new ArrayList<>();
    ArrayList<Tournament> tournamentList=new ArrayList<>();
    dbConnectivity db = dbConnectivity.getInstance();
    
    
    public SportsManagement() {
        
        userList = db.getUserList();
        this.tournamentList.add(new CricketTournament("Cricket","T-20",5,2000,"20 Overs"));
        this.tournamentList.add(new FootballTournament("Football-11","5 A-side",5,1000,"20 minutes"));
        this.tournamentList.add(new BasketBallTournament("Volleyball","6 A-side",5,1000,"5 Rounds"));
        
        
        db.getUserCount();
    }
    
    public boolean usernameExists(String str)
    {
        for(int i=0;i<this.userList.size(); i++)
        {
            if(str.equals(userList.get(i).getUsername()) && str.length()==userList.get(i).getUsername().length())
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean passwordExists(String str)
    {
         for(int i=0;i<this.userList.size(); i++)
        {
            if(str.equals(userList.get(i).getPassword()) && str.length()==userList.get(i).getPassword().length())
            {
                return true;
            }
        }
        return false;
    }
    
    public User getUser(String str)
    {
        for(int i=0;i<this.userList.size(); i++)
        {
            if(str.equals(userList.get(i).getUsername()))
            {
                return this.userList.get(i);
            }
        }
        return null;
    }
    
    public boolean CheckSchedule(Schedule S,int sportType)
    {
        return this.tournamentList.get(sportType-1).CheckNewSchedule(S);
    }
    
    public boolean CheckOfficial(Schedule S)
    {
        for(int i=0;i<this.tournamentList.size();i++)
        {
            if(!this.tournamentList.get(i).CheckAllocatedOfficial(S))
            {
                return false;
            }
        }
        return true;
    }
    
    public ArrayList<Team> getTeamList(int sportType)
    {
        return this.tournamentList.get(sportType-1).getTeamList();
    }
    
    public ArrayList<Schedule> getScheduleList(int sportType)
    {
        return this.tournamentList.get(sportType-1).getScheduleList();
    }
    
    public ArrayList<User> getUsersList()
    {
        return this.userList;
    }
    
    
    public Team getTeam(int sporttype,int id)
    {
        return this.tournamentList.get(sporttype-1).getTeam(id);
    }
    
    public Team getCaptainTeam(int sporttype,int id)
    {
        return this.tournamentList.get(sporttype-1).getCaptainTeam(id);
    }
    
    
    
    public Team getTeam(int sporttype,String name)
    {
        return this.tournamentList.get(sporttype-1).getTeam(name);
    }
    
    boolean AddUSer(User U,int type)
    {
        if(db.AddUser(U,type))
        {
            userList.add(U);
            return true;
        }
        return false;
    }
    
    boolean AddTeam(Team T,int sportid)
    {
       if(this.tournamentList.get(sportid-1).AddTeam(T))
       {
               return true;
       }
       return false;
    }
    
    boolean AddMatch(Schedule S,int sportid)
    {
       if(this.tournamentList.get(sportid-1).AddMatch(S))
       {
               return true;
       }
       return false;
    }
    
    boolean UpdateTeam(Team T,int sportid)
    {
       return this.tournamentList.get(sportid-1).updateTeam(T);
    }
    
    
    boolean UpdateSchedule(Schedule S,int sportid)
    {
       return this.tournamentList.get(sportid-1).updateSchedule(S);
    }
    
    int getNewUserId()
    {
       return db.getUserCount()+1;
    }
    
    public Schedule getSchedule(int sportType,int id)
    {
        return this.tournamentList.get(sportType-1).getSchedule(id);
    }
    
   public int getNewTeamID()
    {
        return db.getTeamCount()+1;
    }
   
    public int getNewMatchID()
    {
        return db.getMatchCount()+1;
    }
    
   public int getPlayerLimit(int sportType)
   {
       return this.tournamentList.get(sportType-1).getTeamLimit();
   }
   
   boolean RemoveTeam(Team T,int sportid)
    {
       if(this.tournamentList.get(sportid-1).RemoveTeam(T))
       {
               return true;
       }
       return false;
    }
   

}
