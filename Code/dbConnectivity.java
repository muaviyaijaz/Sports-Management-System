/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad_project;


import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author hamza khalid
 */
public class dbConnectivity {
    
    private static final dbConnectivity instance=new dbConnectivity();
    
    Connection con;
    Statement stm;
    
    private dbConnectivity()
    {
        try{
            
        String s = "jdbc:sqlserver://localhost:1433;databaseName=ooad_project";
        con = DriverManager.getConnection(s,"hamzaK" ,"rockabye123");
        
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    
    public static dbConnectivity getInstance()
    {
        return instance;
    }
    
    boolean AddUser(User U,int type)
    {
        try{
            
            String query= " insert into users values (?,?,?,?,?,?,?)";
            PreparedStatement preparedstm= con.prepareStatement(query);
            preparedstm.setInt(1,U.getId());
            preparedstm.setString(2, U.getName());
            preparedstm.setString(3,U.getUsername());
            preparedstm.setString(4, U.getPassword());
            preparedstm.setString(5, U.getEmail());
            preparedstm.setString(6, U.getPhoneno());
            preparedstm.setInt(7,type);
            
            preparedstm.executeUpdate();
            return true;
                    
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }
    
    boolean AddTeam(Team T,int sportType)
    {
        try{
            
            String query= "insert into teams values (?,?,?,?,?,?,?,?,?,?) ";
            PreparedStatement preparedstm= con.prepareStatement(query);
            
            preparedstm.setInt(1, T.getId());
            preparedstm.setString(2, T.getName());
            preparedstm.setInt(3, T.getCaptainID());
            preparedstm.setInt(4, sportType);
            preparedstm.setInt(5, T.getPlayed());
            preparedstm.setInt(6, T.getWins());
            preparedstm.setInt(7, T.getLosses());
            preparedstm.setInt(8, T.getTies());
            preparedstm.setInt(9, T.getPoints());
            boolean pay=T.getPaymentStatus();
            int status=0;
            if(pay==true)
            {
                status=1;
            }
            preparedstm.setInt(10,status);
            
            preparedstm.executeUpdate();
            return true;
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }
    
    boolean AddMatch(Schedule S,int sportType)
    {
        try{
            
            String query= "insert into Schedule values (?,?,?,?,?,?,?,?,?) ";
            PreparedStatement preparedstm= con.prepareStatement(query);
            
            preparedstm.setInt(1, S.getID());
            preparedstm.setInt(2, S.getTeam1().getId());
            preparedstm.setInt(3, S.getTeam2().getId());
            preparedstm.setString(4, S.getDate());
            preparedstm.setString(5, S.getTime());
            preparedstm.setString(6, S.getVenue());
            preparedstm.setInt(7, sportType);
            boolean match_status=S.getStatus();
            int status=0;
            if(match_status==true)
            {
                status=1;
            }
            preparedstm.setInt(8,status);
            preparedstm.setInt(9,S.getOffcial().getId());
            
            preparedstm.executeUpdate();
            return true;
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }
    
    
    boolean AddPlayer(Player P,int teamid,int sportType)
    {
        try{
            String query="Insert into players VALUES (?,?,?,?,?,?)";
            String query2="";
            
            if(sportType==1)
            {
                query2="Insert into CricketPlayer values (?,?,?,?,?)";
            }
            else if(sportType==2)
            {
                query2="Insert into FootballPlayer values (?,?,?)";
            }
            else if(sportType==3)
            {
                query2="Insert into BasketballPlayer values (?,?,?)";
            }
            
            PreparedStatement preparestm=con.prepareStatement(query);
            PreparedStatement preparestm2=con.prepareStatement(query2);
            
            preparestm.setInt(1,P.getId());
            preparestm.setString(2, P.getName());
            preparestm.setString(3, P.getEmail());
            preparestm.setString(4, P.getPhoneno());
            preparestm.setString(5, P.getDesignation());
            preparestm.setInt(6, teamid);
            
            preparestm.executeUpdate();
            
            preparestm2.setInt(1,P.getId());
            
            if(sportType==1)
            {
               preparestm2.setInt(2,0);
               preparestm2.setInt(3,0);
               preparestm2.setInt(4,0);
               preparestm2.setInt(5,0);
            }
            else if(sportType==2)
            {
                preparestm2.setInt(2,0);
                preparestm2.setInt(3,0);
            }
            else if(sportType==3)
            {
                preparestm2.setInt(2,0);
                preparestm2.setInt(3,0);
            }
            
            preparestm2.executeUpdate();
            
            return true;
       }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }
    
    ArrayList<User> getUserList()
    {
        ArrayList<User> temp=new ArrayList<User>();
        
        try{
            
            String query="select * from users";
            PreparedStatement preparestm=con.prepareStatement(query);
            
            ResultSet rs = preparestm.executeQuery();
            
            while(rs.next())
            {
                 if(rs.getInt(7)==3)
                {
                    temp.add(new RegisteredUser(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
                }
                 if(rs.getInt(7)==2)
                {
                    temp.add(new Organizer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
                }
                  if(rs.getInt(7)==1)
                {
                    temp.add(new Admin(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
                } 
                 
            }
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
        return temp;
    }
    
    ArrayList<Team> getTeamList(int sportType)
    {
        try{
            ArrayList<Team> teams = new ArrayList<>();
            String query="Select * from teams where sporttype = ? ";
            PreparedStatement preparestm=con.prepareStatement(query);
            preparestm.setInt(1, sportType);
            
            ResultSet rs = preparestm.executeQuery();
            
            
            
            while(rs.next())
            {
                boolean pay = false;
                if(rs.getInt(10)==1)
                {
                    pay = true;
                }
                Team tempTeam= new Team(rs.getInt(1),rs.getString(2),this.getRegisteredUser(rs.getInt(3)),pay);
                tempTeam.setStats(rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
                tempTeam.LoadPlayers(this.getPlayerList(sportType, rs.getInt(1)));
                
                teams.add(tempTeam);
            }
            
            return teams;
            
        }
        catch(SQLException e)
        {
             System.out.println(e);
             return null;
        }
    }
    
    public RegisteredUser getRegisteredUser(int id)
    {
        try{
            
            String query="Select * from Users where id = ?";
            PreparedStatement preparestm = con.prepareStatement(query);
            preparestm.setInt(1, id);
            
            ResultSet rs = preparestm.executeQuery();
            
            while(rs.next())
            {
                if(rs.getInt(7)==3)
                return new RegisteredUser(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                
               
            }
            
            return null;
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    public Organizer getOrganizer(int id)
    {
        try{
            
            String query="Select * from Users where id = ?";
            PreparedStatement preparestm = con.prepareStatement(query);
            preparestm.setInt(1, id);
            
            ResultSet rs = preparestm.executeQuery();
            
            while(rs.next())
            {
                if(rs.getInt(7)==2)
                return new Organizer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                
            }
            
            return null;
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    public Team getTeam(int id)
    {
        try{
            
            String query = "select * from teams where CaptainId = ?";
            PreparedStatement preparestm=con.prepareStatement(query);
            preparestm.setInt(1, id);
            
            ResultSet rs = preparestm.executeQuery();
            
            while(rs.next())
            {
                boolean payment=false;
                if(rs.getInt(10)==1)
                {
                    payment=true;
                }
               Team T=new Team(rs.getInt(1),rs.getString(2),this.getRegisteredUser(rs.getInt(3)),payment);
               T.LoadPlayers(this.getPlayerList(rs.getInt(4), rs.getInt(1))); 
               T.setStats(rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
                return T;
            }
            
            return null;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    public boolean UpdateTeam(Team T)
    {
        try{
            
            String query="update Teams set name = ?, played = ?, won=?, lost =?, tied=?, points=?, payment=? where id = ?"; 
            PreparedStatement preparestm=con.prepareStatement(query);
            preparestm.setString(1, T.getName());
            preparestm.setInt(2, T.getPlayed());
            preparestm.setInt(3, T.getWins());
            preparestm.setInt(4, T.getLosses());
            preparestm.setInt(5, T.getTies());
            preparestm.setInt(6, T.getPoints());
            if(T.getPaymentStatus()==true)
            {
                preparestm.setInt(7, 1);
            }
            else
            { 
                preparestm.setInt(7, 0);  
            }
            preparestm.setInt(8, T.getId());
            
            preparestm.executeUpdate();
            return true;
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean updatePlayers(Team T,int SportType)
    {
        try{
          for(int i=0;i<T.playerList.size();i++)
          {
            if(SportType==1)
            {    
                CricketPlayer player = (CricketPlayer) T.playerList.get(i);
                String query = "update CricketPlayer set totalruns = ?, totalwickets = ?, matchesplayed = ?, average = ? where id = ? ";
                PreparedStatement preparestm = con.prepareStatement(query);
                preparestm.setInt(1, player.getRuns());
                preparestm.setInt(2, player.getWickets());
                preparestm.setInt(3, player.getMatchesPlayed());
                preparestm.setFloat(4,(float)player.getAverage());
                preparestm.setInt(5, player.getId());
                
                preparestm.executeUpdate();
            }
            
            if(SportType==2)
            {    
                FootballPlayer player = (FootballPlayer) T.playerList.get(i);
                String query = "update FootballPlayer set totalgoals = ?, totalassists = ? where id = ? ";
                PreparedStatement preparestm = con.prepareStatement(query);
                preparestm.setInt(1, player.getGoals());
                preparestm.setInt(2, player.getAssists());
                preparestm.setInt(3, player.getId());
                //preparestm.setFloat(4,player.average);
                //preparestm.setInt(5, player.id);
                
                preparestm.executeUpdate();
            }
            
             if(SportType==3)
            {    
                BasketBallPlayer player = (BasketBallPlayer) T.playerList.get(i);
                String query = "update BasketballPlayer set totalpoints = ?, totalsteals = ? where id = ? ";
                PreparedStatement preparestm = con.prepareStatement(query);
                preparestm.setInt(1, player.getTtotalPoints());
                preparestm.setInt(2, player.getTotalSteals());
                preparestm.setInt(3, player.getId());
                //preparestm.setFloat(4,player.average);
                //preparestm.setInt(5, player.id);
                
                preparestm.executeUpdate();
            }
          }
          return true;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean addPayment(int id,int type,String info)
    {
        try{
            String query = "Insert into Payment values (?,?,?)";
            PreparedStatement preparestm=con.prepareStatement(query);
            preparestm.setInt(1, id);
            preparestm.setInt(2, type);
            preparestm.setString(3, info);
            
            preparestm.executeUpdate();
            return true;
            
        }
        catch(SQLException e)
        {
            System.out.println();
            return false;
        }
    }
    
    public ArrayList<Player> getPlayerList(int sporttype,int teamid)
    {
        try{
            
            ArrayList<Player> list=new ArrayList<>();
            String query="Select * from players where teamid = ? ";
            PreparedStatement preparestm=con.prepareStatement(query);
            preparestm.setInt(1, teamid);
            ResultSet rs=preparestm.executeQuery();
            
            while(rs.next())
            {
                if(sporttype==1)
                {
                    
                    CricketPlayer player = new CricketPlayer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                    
                    String query2="select * from CricketPlayer where id = ?";
                    PreparedStatement preparestm2=con.prepareStatement(query2);
                    preparestm2.setInt(1, rs.getInt(1));
                    
                    ResultSet rs2= preparestm2.executeQuery();
                    
                    while(rs2.next())
                    {
                        player.setStats(rs2.getInt(4), rs2.getInt(2), rs2.getInt(3), rs2.getInt(5));
                    }
                    list.add(player);
                    
                }
                else if(sporttype==2)
                {
                    FootballPlayer player = new FootballPlayer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                    
                    String query2="select * from FootballPlayer where id = ?";
                    PreparedStatement preparestm2=con.prepareStatement(query2);
                    preparestm2.setInt(1, rs.getInt(1));
                    
                    ResultSet rs2= preparestm2.executeQuery();
                    
                    while(rs2.next())
                    {
                        player.setStats(rs2.getInt(2), rs2.getInt(3));
                    }
                    list.add(player);
                }
                else if(sporttype==3)
                {
                     BasketBallPlayer player = new BasketBallPlayer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                    
                    String query2="select * from BasketBallPlayer where id = ?";
                    PreparedStatement preparestm2=con.prepareStatement(query2);
                    preparestm2.setInt(1, rs.getInt(1));
                    
                    ResultSet rs2= preparestm2.executeQuery();
                    
                    while(rs2.next())
                    {
                        player.setStats(rs2.getInt(2),rs2.getInt(3));
                    }
                    list.add(player);
                }
            }
            
            return list;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    public int getUserCount()
    {
        
        int id=0;
        try{
            
            String query="select max(id) from users";
            PreparedStatement preparedstm=con.prepareStatement(query);
            
            ResultSet rs = preparedstm.executeQuery(); 
            
            while(rs.next())
            {
               id= rs.getInt(1);
            }
            return id;
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return 0;
    }
    
    public int getTeamCount()
    {
        int id=0;
         try{
            
            String query="select max(id) from teams";
            PreparedStatement preparedstm=con.prepareStatement(query);
            
            ResultSet rs = preparedstm.executeQuery(); 
            
            while(rs.next())
            {
               id=rs.getInt(1);
            }
            return id;
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return 0;
    }
    
     public int getMatchCount()
    {
        int id=0;
         try{
            
            String query="select max(id) from Schedule";
            PreparedStatement preparedstm=con.prepareStatement(query);
            
            ResultSet rs = preparedstm.executeQuery(); 
            
            while(rs.next())
            {
               id=rs.getInt(1);
            }
            return id;
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return 0;
    }
    
    public int getPlayerCount()
    {
        int id=0;
        try{
            
            String query="select max(id) from players";
            PreparedStatement preparedstm=con.prepareStatement(query);
            
            ResultSet rs = preparedstm.executeQuery(); 
            
            while(rs.next())
            {
               id= rs.getInt(1);
            }
            return id;
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return 0;
    }
    
    ArrayList<Schedule> getScheduleList(int sportType)
    {
        try{
            ArrayList<Schedule> matches = new ArrayList<>();
            String query="Select * from schedule where SportType = ? ";
            PreparedStatement preparestm=con.prepareStatement(query);
            preparestm.setInt(1, sportType);
            
            ResultSet rs = preparestm.executeQuery();
 
            while(rs.next())
            {
                boolean status = false;
                if(rs.getInt(8)==1)
                {
                    status = true;
                }
                
                //System.out.print(rs.getInt(3));
                
                 String query2="Select * from teams where id= "+rs.getInt(2);
                 Team t1 =null;
                 Team t2 =null;
                 PreparedStatement preparestm2=con.prepareStatement(query2);
                 ResultSet rs2 = preparestm2.executeQuery();
                 while(rs2.next())
                 {
                     t1=this.getTeam(rs2.getInt(3));
                 }
                 
                 String query3="Select * from teams where id= "+rs.getInt(3);
                 PreparedStatement preparestm3=con.prepareStatement(query3);
                 ResultSet rs3 = preparestm3.executeQuery();
                 
                 while(rs3.next())
                 {
                     t2=this.getTeam(rs3.getInt("CaptainID"));
                 }
                
                 Schedule tempschedule= new Schedule(rs.getInt(1),t1,t2,rs.getString(5),rs.getString(4),rs.getString(6),status);
                 tempschedule.setMatchsummary(this.getSummary(sportType, tempschedule.getID(), t1, t2));
                 tempschedule.setOffcial(this.getOrganizer(rs.getInt(9)));
                 matches.add(tempschedule);
                 //System.out.println("hello");
            }
            
            return matches;
            
        }
        catch(SQLException e)
        {
             System.out.println(e);
             return null;
        }
    }
    public Summary getSummary(int sportType,int matchid,Team t1,Team t2)
       {
            try{
                
                String query="";
                String query2="";
                
                if(sportType == 1)
                {
                   CricketSummary s = null;
                   query ="Select * from CricketSummary where matchid = ?";
                   PreparedStatement preparestm = con.prepareStatement(query);
                   preparestm.setInt(1, matchid);
                   
                   ResultSet rs = preparestm.executeQuery();
                   
                   while(rs.next())
                   {
                      s = new CricketSummary(rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getFloat(6),rs.getFloat(7));
                       
                      query2 = "select * from CricketPlayerMatchStats where summaryid = ?";
                      PreparedStatement preparestm2 = con.prepareStatement(query2);
                      preparestm2.setInt(1, matchid);
                      
                      ResultSet rs2 = preparestm2.executeQuery();
                      
                      boolean found=false;
                      while(rs2.next())
                      {
                        found=false;  
                        for(int i=0;i<t1.playerList.size();i++)
                        {
                            if(rs2.getInt(2)==t1.playerList.get(i).getId())
                            {
                                s.addTeam1PlayerStats(new CricketPlayerMatchStats(rs2.getInt(2),rs2.getInt(3),rs2.getInt(4),rs2.getInt(5),rs2.getInt(6),rs2.getInt(7)));
                                found=true;
                                break;
                            }   
                        }
                           
                        if(found==false)
                        {
                           
                         s.addTeam2PlayerStats(new CricketPlayerMatchStats(rs2.getInt(2),rs2.getInt(3),rs2.getInt(4),rs2.getInt(5),rs2.getInt(6),rs2.getInt(7)));       
                        }
                      }
                      
                       int MVP_id = rs.getInt(8);
                   
                   for(int i=0;i<t1.playerList.size();i++)
                   {
                       if(t1.playerList.get(i).getId()==MVP_id)
                       {
                           s.setMVP(t1.getPlayeratindex(i));
                           break;
                       }
                       if(t2.playerList.get(i).getId()==MVP_id)
                       {
                           s.setMVP(t2.getPlayeratindex(i));
                           break;
                       }
                       
                   }
                      
                   }
                   
                  
                   
                   return s;
                }       
                else if(sportType==2)
                {
                   FootballSummary s = null;
                   query ="Select * from FootballSummary where matchid = ?";
                   PreparedStatement preparestm = con.prepareStatement(query);
                   preparestm.setInt(1, matchid);
                   
                   ResultSet rs = preparestm.executeQuery();
                   
                   while(rs.next())
                   {
                      s = new FootballSummary(rs.getInt(2),rs.getInt(3));
                       
                      query2 = "select * from FootballPlayerMatchStats where summaryid = ?";
                      PreparedStatement preparestm2 = con.prepareStatement(query2);
                      preparestm2.setInt(1, matchid);
                      
                      ResultSet rs2 = preparestm2.executeQuery();
                      
                      boolean found=false;
                      while(rs2.next())
                      {
                        found=false;  
                        for(int i=0;i<t1.playerList.size();i++)
                        {
                            if(rs2.getInt(2)==t1.playerList.get(i).getId())
                            {
                                s.addTeam1PlayerStats(new FootballPlayerMatchStats(rs2.getInt(2),rs2.getInt(3),rs2.getInt(4)));
                                found=true;
                                break;
                            }   
                        }
                           
                        if(found==false)
                        {
                         s.addTeam2PlayerStats(new FootballPlayerMatchStats(rs2.getInt(2),rs2.getInt(3),rs2.getInt(4)));       
                        }
                        
                      }
                      
                      int MVP_id = rs.getInt(4);
                   
                   for(int i=0;i<t1.playerList.size();i++)
                   {
                       if(t1.playerList.get(i).getId()==MVP_id)
                       {
                           s.setMVP(t1.getPlayeratindex(i));
                           break;
                       }
                       if(t2.playerList.get(i).getId()==MVP_id)
                       {
                           s.setMVP(t2.getPlayeratindex(i));
                           break;
                       }
                       
                   }
                      
                   }
                   return s;
                }
                else if(sportType==3)
                {
                   BasketBallSummary s = null;
                   query ="Select * from BasketballSummary where matchid = ?";
                   PreparedStatement preparestm = con.prepareStatement(query);
                   preparestm.setInt(1, matchid);
                   
                   ResultSet rs = preparestm.executeQuery();
                   
                   while(rs.next())
                   {
                      s = new BasketBallSummary(rs.getInt(2),rs.getInt(3));
                       
                      query2 = "select * from BasketballPlayerMatchStats where summaryid = ?";
                      PreparedStatement preparestm2 = con.prepareStatement(query2);
                      preparestm2.setInt(1, matchid);
                      
                      ResultSet rs2 = preparestm2.executeQuery();
                      
                      boolean found=false;
                      while(rs2.next())
                      {
                        found=false;  
                        for(int i=0;i<t1.playerList.size();i++)
                        {
                            if(rs2.getInt(2)==t1.playerList.get(i).getId())
                            {
                                s.addTeam1PlayerStats(new BasketBallPlayerMatchStats(rs2.getInt(2),rs2.getInt(3),rs2.getInt(4)));
                                found=true;
                                break;
                            }   
                        }
                           
                        if(found==false)
                        {
                         s.addTeam2PlayerStats(new BasketBallPlayerMatchStats(rs2.getInt(2),rs2.getInt(3),rs2.getInt(4)));       
                        }
                      }
                      
                      int MVP_id = rs.getInt(4);
                   
                   for(int i=0;i<t1.playerList.size();i++)
                   {
                       if(t1.playerList.get(i).getId()==MVP_id)
                       {
                           s.setMVP(t1.getPlayeratindex(i));
                           break;
                       }
                       if(t2.playerList.get(i).getId()==MVP_id)
                       {
                           s.setMVP(t2.getPlayeratindex(i));
                           break;
                       }
                       
                   }
                      
                   }
                   return s;
                }
                return null;
            }
            catch(SQLException e)
            {
                System.out.println(e);
                return null;
            }
        }
    
    public boolean AddCricketSummary(Schedule S)
    {
        try{
            
            CricketSummary summary = (CricketSummary) S.getMatchsummary(); 
            String query = "Insert into CricketSummary values (?,?,?,?,?,?,?,?)";
            PreparedStatement preparestm = con.prepareStatement(query);
            
            preparestm.setInt(1, S.getID());
            preparestm.setInt(2, summary.getteam1Score());
            preparestm.setInt(3, summary.getteam2Score());
            preparestm.setInt(4, summary.getteam1Wickets());
            preparestm.setInt(5, summary.getteam2Wickets());
            preparestm.setFloat(6, summary.getteam1Overs());
            preparestm.setFloat(7, summary.getteam2Overs());
            preparestm.setInt(8, summary.MVP.getId());
            
            preparestm.executeUpdate();
            
            this.AddCricketPlayerMatchStats(S);
            
            return true;
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;        
        }
    }
    
    
    
    
    public boolean AddCricketPlayerMatchStats(Schedule S)
    {
        try{
            CricketSummary summary =(CricketSummary) S.getMatchsummary();
            
            for(int i=0; i<summary.team1Players.size(); i++)
            {
            String query = "Insert into CricketPlayerMatchStats values (?,?,?,?,?,?,?)";
            PreparedStatement preparestm = con.prepareStatement(query);
            
            preparestm.setInt(1,S.getID() );
            preparestm.setInt(2, summary.team1Players.get(i).getId());
            preparestm.setInt(3, summary.team1Players.get(i).getScore());
            preparestm.setInt(4, summary.team1Players.get(i).getBalls());
            preparestm.setFloat(5, summary.team1Players.get(i).getOvers());
            preparestm.setInt(6, summary.team1Players.get(i).getRunsConceeded());
            preparestm.setInt(7, summary.team1Players.get(i).getWickets());
            
            preparestm.executeUpdate();
            
            }
            
             for(int i=0; i<summary.team2Players.size(); i++)
            {
            String query = "Insert into CricketPlayerMatchStats values (?,?,?,?,?,?,?)";
            PreparedStatement preparestm = con.prepareStatement(query);
            
            preparestm.setInt(1,S.getID() );
            preparestm.setInt(2, summary.team2Players.get(i).getId());
            preparestm.setInt(3, summary.team2Players.get(i).getScore());
            preparestm.setInt(4, summary.team2Players.get(i).getBalls());
            preparestm.setFloat(5, summary.team2Players.get(i).getOvers());
            preparestm.setInt(6, summary.team2Players.get(i).getRunsConceeded());
            preparestm.setInt(7, summary.team2Players.get(i).getWickets());
            
            preparestm.executeUpdate();
            
            }
            
            return true;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }
        
    public boolean AddFootballSummary(Schedule S)
    {
        try{
            
            FootballSummary summary = (FootballSummary) S.getMatchsummary(); 
            String query = "Insert into FootballSummary values (?,?,?,?)";
            PreparedStatement preparestm = con.prepareStatement(query);
            
            preparestm.setInt(1, S.getID());
            preparestm.setInt(2, summary.getteam1Goals());
            preparestm.setInt(3, summary.getteam2Goals());
            preparestm.setInt(4, summary.MVP.getId());
            //preparestm.setInt(4, summary.team1Wickets);
            //preparestm.setInt(5, summary.team2Wickets);
            //preparestm.setFloat(6, summary.team1Overs);
            //preparestm.setFloat(7, summary.team2Overs);
            
            preparestm.executeUpdate();
            
            this.AddFootballPlayerMatchStats(S);
            
            return true;
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;        
        }
    }
    
    public boolean AddBasketballPlayerMatchStats(Schedule S)
    {
        try{
            BasketBallSummary summary =(BasketBallSummary) S.getMatchsummary();
            
            for(int i=0; i<summary.team1Players.size(); i++)
            {
            String query = "Insert into BasketBallPlayerMatchStats values (?,?,?,?)";
            PreparedStatement preparestm = con.prepareStatement(query);
            
            preparestm.setInt(1,S.getID() );
            preparestm.setInt(2, summary.team1Players.get(i).getId());
            preparestm.setInt(3, summary.team1Players.get(i).getPoints());
            preparestm.setInt(4, summary.team1Players.get(i).getSteals());
            //preparestm.setFloat(5, summary.team1Players.get(i).overs);
            //preparestm.setInt(6, summary.team1Players.get(i).runsConceeded);
            //preparestm.setInt(7, summary.team1Players.get(i).wickets);
            
            preparestm.executeUpdate();
            
            }
            
             for(int i=0; i<summary.team2Players.size(); i++)
            {
            String query = "Insert into BasketBallPlayerMatchStats values (?,?,?,?)";
            PreparedStatement preparestm = con.prepareStatement(query);
            
            preparestm.setInt(1,S.getID() );
            preparestm.setInt(2, summary.team2Players.get(i).getId());
            preparestm.setInt(3, summary.team2Players.get(i).getPoints());
            preparestm.setInt(4, summary.team2Players.get(i).getSteals());
           // preparestm.setFloat(5, summary.team2Players.get(i).overs);
           // preparestm.setInt(6, summary.team2Players.get(i).runsConceeded);
           // preparestm.setInt(7, summary.team2Players.get(i).wickets);
            
            preparestm.executeUpdate();
            
            }
            
            return true;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }
    
     public boolean AddBasketballSummary(Schedule S)
    {
        try{
            
            BasketBallSummary summary = (BasketBallSummary) S.getMatchsummary(); 
            String query = "Insert into BasketballSummary values (?,?,?,?)";
            PreparedStatement preparestm = con.prepareStatement(query);
            
            preparestm.setInt(1, S.getID());
            preparestm.setInt(2, summary.getteam1Points());
            preparestm.setInt(3, summary.getteam2Points());
            preparestm.setInt(4, summary.MVP.getId());
            //preparestm.setInt(4, summary.team1Wickets);
            //preparestm.setInt(5, summary.team2Wickets);
            //preparestm.setFloat(6, summary.team1Overs);
            //preparestm.setFloat(7, summary.team2Overs);
            
            preparestm.executeUpdate();
            
            this.AddBasketballPlayerMatchStats(S);
            
            return true;
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;        
        }
    }
    
    
    public boolean AddFootballPlayerMatchStats(Schedule S)
    {
        try{
            FootballSummary summary =(FootballSummary) S.getMatchsummary();
            
            for(int i=0; i<summary.team1Players.size(); i++)
            {
            String query = "Insert into FootballPlayerMatchStats values (?,?,?,?)";
            PreparedStatement preparestm = con.prepareStatement(query);
            
            preparestm.setInt(1,S.getID());
            preparestm.setInt(2, summary.team1Players.get(i).getId());
            preparestm.setInt(3, summary.team1Players.get(i).getGoals());
            preparestm.setInt(4, summary.team1Players.get(i).getAssists());
            //preparestm.setFloat(5, summary.team1Players.get(i).overs);
            //preparestm.setInt(6, summary.team1Players.get(i).runsConceeded);
            //preparestm.setInt(7, summary.team1Players.get(i).wickets);
            
            preparestm.executeUpdate();
            
            }
            
             for(int i=0; i<summary.team2Players.size(); i++)
            {
            String query = "Insert into FootballPlayerMatchStats values (?,?,?,?)";
            PreparedStatement preparestm = con.prepareStatement(query);
            
            preparestm.setInt(1,S.getID() );
            preparestm.setInt(2, summary.team2Players.get(i).getId());
            preparestm.setInt(3, summary.team2Players.get(i).getGoals());
            preparestm.setInt(4, summary.team2Players.get(i).getAssists());
           // preparestm.setFloat(5, summary.team2Players.get(i).overs);
           // preparestm.setInt(6, summary.team2Players.get(i).runsConceeded);
           // preparestm.setInt(7, summary.team2Players.get(i).wickets);
            
            preparestm.executeUpdate();
            
            }
            
            return true;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }
    
     public boolean updateSchedule(Schedule S)
    {
        try{
            
            String query = "Update schedule set status_ = ?,date_= ?,time_= ?,venue= ? where id = ?";
            PreparedStatement stm = con.prepareStatement(query);
            if(S.getStatus()==true)
            {
                 stm.setInt(1, 1);
            }
            else
            {
                 stm.setInt(1, 0);
            }
            
            stm.setString(2,S.getDate());
            stm.setString(3,S.getTime());
            stm.setString(4,S.getVenue());
            
            stm.setInt(5, S.getID());
            stm.executeUpdate();
            return true;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
                
    }
    
    public int GetNotificationID()
    {
        
        try{
            
            String query="select max(id) from Notifications";
            PreparedStatement preparedstm=con.prepareStatement(query);
            
            ResultSet rs = preparedstm.executeQuery(); 
            
            while(rs.next())
            {
               return rs.getInt(1);
            }
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
             return 0;
        }
       return 0;
    }
    
    public int AddNotification(ArrayList<Integer> userslist,String Subject,String content,int type)
    {
        try{
            
            int id = this.GetNotificationID()+1;
            String query="Insert into Notifications Values (?,?,?,?)";
            PreparedStatement preparedstm=con.prepareStatement(query);
            preparedstm.setInt(1, id);
            preparedstm.setString(2,Subject);
            preparedstm.setString(3, content);
            preparedstm.setInt(4, type);
            
            
            preparedstm.executeUpdate(); 
            
            String query2 = "Insert into NotifiedUsers values (?,?)";
            PreparedStatement preparedstm2=con.prepareStatement(query2);
            
            for(int i=0;i<userslist.size();i++)
            {
                preparedstm2.setInt(1, userslist.get(i));
                preparedstm2.setInt(2, id);
                
                preparedstm2.executeUpdate();
            }
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return 0;
    }
    
    boolean RemoveTeam(Team T)
    {
        
        try{
            String query="delete from Teams where id=?";
            PreparedStatement preparedstm=con.prepareStatement(query);
            preparedstm.setInt(1,T.getId());
            
            preparedstm.executeUpdate(); 
            return true;
            /*if(sportType==1)
            {
             for(int i=0;i<T.playerList.size();i++)   
             {
            String query= "delete from FootballPlayer where id=?";
            PreparedStatement preparedstm=con.prepareStatement(query);
            preparedstm.setInt(1,T.playerList.get(i).getId());
            
            preparedstm.executeUpdate(); 
            
            
             }
             
             //removing players
            String query= "delete from Players where teamid=?";
            PreparedStatement preparedstm=con.prepareStatement(query);
            preparedstm.setInt(1,T.getId());
            preparedstm.executeUpdate(); 
             
             
            }
            if(sportType==2)
            {
            
            }
            if(sportType==3)
            {
            
            }
            
            String query= "delete from teams values where sportType";
            PreparedStatement preparedstm= con.prepareStatement(query);
            
            preparedstm.setInt(1, T.getId());
            preparedstm.setString(2, T.getName());
            preparedstm.setInt(3, T.getCaptainID());
            preparedstm.setInt(4, sportType);
            preparedstm.setInt(5, T.getPlayed());
            preparedstm.setInt(6, T.getWins());
            preparedstm.setInt(7, T.getLosses());
            preparedstm.setInt(8, T.getTies());
            preparedstm.setInt(9, T.getPoints());
            boolean pay=T.getPaymentStatus();
            int status=0;
            if(pay==true)
            {
                status=1;
            }
            preparedstm.setInt(10,status);
            
            preparedstm.executeUpdate();
            return true;
          */  
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }
    
    
    public boolean removeOrganizer(Organizer O)
    {
    try
    {
            String query="delete from users where id= ?" ;
             PreparedStatement preparedstm=con.prepareStatement(query);
             preparedstm.setInt(1, O.getId());
             
              preparedstm.executeUpdate(); 
             
              return true;
    
    }
    catch(SQLException e)
    {
            System.out.println(e);
            return false;
    }

    }
    
    
   
    
    
    
}
