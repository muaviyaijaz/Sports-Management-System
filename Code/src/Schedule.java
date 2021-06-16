/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad_project;

/**
 *
 * @author MaViii
 */
public class Schedule {
    private int id;
    private Team team1;
    private Team team2;
    private String time;
    private String date;
    private String venue;
    private Summary matchsummary;
    private Organizer offcial;
    
    private boolean status;

    public Schedule(int id, Team team1, Team team2, String time, String date, String venue, boolean status) 
    {
        this.id=id;
        this.team1 = team1;
        this.team2 = team2;
        this.time = time;
        this.date = date;
        this.venue = venue;
        this.status = status;
    }
    
    public int getID(){
        return getId();
    }
    
    public void setID(int id){
        this.setId(id);
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public boolean getStatus() {
        return isStatus();
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public void setSummary(Summary s){
        this.setMatchsummary(s);
    }

    public Organizer getOffcial() {
        return offcial;
    }

    public void setOffcial(Organizer offcial) {
        this.offcial = offcial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Summary getMatchsummary() {
        return matchsummary;
    }

    public void setMatchsummary(Summary matchsummary) {
        this.matchsummary = matchsummary;
    }

    public boolean isStatus() {
        return status;
    }
    
        
}
