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
public class Team {
    
    private int id;
    private String name;
    private final User Captain;
    private int played;
    private int wins;
    private int losses;
    private int ties;
    private int points;
    private boolean paymentStatus;
    ArrayList<Player> playerList=new ArrayList<>();
    dbConnectivity db=dbConnectivity.getInstance();
    
    

    public Team(int id, String name, User Captain,boolean payment) {
        this.id = id;
        this.name = name;
        this.Captain = Captain;
        this.played=0;
        this.wins=0;
        this.losses=0;
        this.ties=0;
        this.points=0;
        this.paymentStatus = payment;
    }

    public void setStats(int played, int wins, int losses,int ties,int points)
    {
        this.played=played;
        this.wins=wins;
        this.losses=losses;
        this.ties=ties;
        this.points=points;
    }
    
    
    
    public int getId() {
        return id;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPlayed(int played){
        this.played = played;
    }
    
    public void setWins(int wins){
        this.wins = wins;
    }
    
    public void setLosses(int losses){
        this.losses = losses;
    }
    
    public void setTies(int ties){
        this.ties = ties;
    }
    
    public void setpoints(int points){
        this.points = points;
    }
    
    public User getCaptain()
    {
        return this.Captain;
    }
    
    public boolean getPaymentStatus()
    {
        return this.paymentStatus;
    }
    
    public void setPaymentStatus(boolean status)
    {
        this.paymentStatus=status;
    }
    
    public String getName() {
        return name;
    }

    public int getPlayed() {
        return played;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getTies() {
        return ties;
    }

    public int getPoints() {
        return points;
    }
    
    public int getCaptainID(){
        return this.Captain.getId();
    } 
    
    public void AddPlayer(Player plyr,int sporttype)
    {
      if(db.AddPlayer(plyr, id, sporttype))
      {
        this.playerList.add(plyr);
      }
    }
    
    public Player getPlayeratindex(int index)
    {
        return this.playerList.get(index);
    }
    
    public void LoadPlayers(ArrayList<Player> plyrlist)
    {
        this.playerList = plyrlist;
    }
    
    
}
