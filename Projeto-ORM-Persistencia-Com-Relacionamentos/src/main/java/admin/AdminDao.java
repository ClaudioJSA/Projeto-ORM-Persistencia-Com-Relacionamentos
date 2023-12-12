/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import reader.ReaderDao;
import repository.Dao;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public class AdminDao extends Dao<Admin>{
    public final String TABLE = "admin";

    @Override
    public String getSaveStatement() {
        return "INSERT INTO " + TABLE + "(id) VALUES (?)";
    }

    @Override
    public String getUpdateStatement() {
        return "INSERT INTO " + TABLE + "(id) VALUES (?) ON DUPLICATE KEY UPDATE id = ?";
    }

    @Override
    public String getFindByIdStatement() {
        return "SELECT id FROM " + TABLE + " WHERE id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "SELECT id FROM " + TABLE;
    }

    @Override
    public String getDeleteStatement() {
        return "DELETE FROM " + TABLE + " WHERE id = ?";
    }

    @Override
    public void coposeSaveOrUpdateStatement(PreparedStatement pstmt, Admin e) {
        try {
            pstmt.setLong(1, e.getId());
            pstmt.setLong(2, e.getId());
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Admin extractObject(ResultSet rs) {
        Admin admin = new Admin();
        try{
            admin.setId(rs.getLong("id"));
        }catch(Exception ex){
                System.out.println("Ex: " + ex);      
        }
        return admin;
    }

    @Override
    public List<Admin> extractObjects(ResultSet rs) {
        List<Admin> admins = new ArrayList<>();
        try{
            while(rs.next()){
                Admin admin = new Admin();
                admin.setId(rs.getLong("id"));
                admins.add(admin);
            }
        }catch(Exception ex){
                System.out.println("Ex: " + ex);      
        }   
        return admins;
    }
}
