/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarian;

import user.User;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public class Librarian extends User{

    public Librarian() {
    }
    
    public Librarian(User user){
        try{
            setName(user.getName());
            setEmail(user.getEmail());
            setBirthDate(user.getBirthDate());
            setCredential(user.getCredentical());
            setRole(user.getRole());
            if(user.getId() != null)
                setId(user.getId());
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
    
}
