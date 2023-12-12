/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader;

import user.User;

/**
 *
 * @author annekarolinneds;
 */
public class Reader extends User{
    private int qtdEmpretimos;
    public Reader() {
    }
    
    public Reader(User user){
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
