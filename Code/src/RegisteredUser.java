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
public class RegisteredUser extends User {
    
    public RegisteredUser() {
    }

    public RegisteredUser(int id, String name, String username, String password , String email, String phoneno) {
        super(id, name, email, phoneno);
        this.setUsername(username);
        this.setPassword(password);
        
    }
    
    @Override
    public int getUserType()
    {
        return 3; 
    }
       
    
    
}
