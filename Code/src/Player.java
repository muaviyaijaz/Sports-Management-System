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
public abstract class Player{
    
private int id;
private String name;
private String email;
private String phoneno;
private String Designation;

    public Player(int id, String name, String email, String phoneno, String Designation) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneno = phoneno;
        this.Designation = Designation;
    }
    
    public void setid(int id){
        this.id = id;
    }
    
    public void setname(String name){
        this.name = name;
    }
    
    public void setemail(String email){
        this.email = email;
    }
    
    public void setphoneno(String phoneno){
        this.phoneno = phoneno;
    }
    
    public void setDesignation(String Designation){
        this.Designation = Designation;
    }
    

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public String getDesignation() {
        return Designation;
    }

    public int getId() {
        return this.id;
    }
    
    public abstract int getWickets();
    public abstract int getRuns();
    public abstract int getPoints() ;
    public  abstract int getGoals() ;
    public  abstract int getAssists();
    
}
