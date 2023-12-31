/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package role;

import entity.Entity;

/**
 *
 * @author ev;
 */
public class Role extends Entity{
    private String name;
    
//<editor-fold defaultstate="collapsed" desc="Contructors">
    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }
    
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if(name.length()>20 || name == null){
            throw new Exception("O nome não pode ter mais de 20 caracteres ou ser nulo.");
        }
        this.name = name;
    }
//</editor-fold>

    @Override
    public String toString() {
        return "Role{" + "name=" + name + '}';
    }
}
