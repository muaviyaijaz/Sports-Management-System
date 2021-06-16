/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad_project;
/**
 *
 * @author Sami
 */
public abstract class User {

private int id;
private String name;
private String email;
private String phoneno;
private String username;
private String Password;

public User()
{
this.id=0;
this.name="";
this.email="";
this.phoneno="";
}
public User(int id, String name, String email, String phoneno) 
{
this.id = id;
this.name = name;
this.email = email;
this.phoneno = phoneno;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

  
    public abstract int getUserType();
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String Password){
        this.Password = Password;
    }
    
    public String getUsername()
    {
        return this.username;
    }

    public String getPassword()
    {
        return this.Password;
    }

    
    
    
}
