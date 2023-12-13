/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import user.User;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public class Admin extends User{
    public Admin() {
    }
    
    public Admin(User user){
        try{
            setName(user.getName());
            setEmail(user.getEmail());
            setBirthDate(user.getBirthDate());
            setCredential(user.getCredentical());
            setRole(user.getRole());
            setId(user.getId());
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
