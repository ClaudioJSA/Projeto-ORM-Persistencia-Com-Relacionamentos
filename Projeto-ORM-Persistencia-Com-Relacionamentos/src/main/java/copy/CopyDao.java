/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copy;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.Dao;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public class CopyDao extends Dao<Copy>{
    public final String TABLE = "copy";

    @Override
    public String getSaveStatement() {
        return "INSERT INTO " + TABLE + "(available, conditionn, acquisition, id) VALUES (?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE " + TABLE + " SET available = ?, conditionn = ?, acquisition = ? WHERE id = ?";
    }

    @Override
    public String getFindByIdStatement() {
        return "SELECT available, conditionn, acquisition FROM " + TABLE + " WHERE id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "SELECT available, conditionn, acquisition FROM " + TABLE;
    }

    @Override
    public String getDeleteStatement() {
        return "DELETE FROM " + TABLE + " WHERE id = ?";
    }

    @Override
    public void coposeSaveOrUpdateStatement(PreparedStatement pstmt, Copy e) {
        try {
            pstmt.setBoolean(1, e.isAvailable());
            pstmt.setString(2, e.getCondition());
            pstmt.setDate(3, Date.valueOf(e.getAcquisition()));
            if (e.getId() != null) {
                pstmt.setLong(4, e.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(CopyDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Copy extractObject(ResultSet rs) {
        Copy copy = new Copy();
        try{
            copy.setAvailable(rs.getBoolean("available"));
            copy.setCondition(rs.getString("conditionn"));
            copy.setAcquisition(rs.getDate("acquisition").toLocalDate());
        }catch(Exception ex){
                System.out.println("Ex: " + ex);      
        }
        return copy;
    }

    @Override
    public List<Copy> extractObjects(ResultSet rs) {
        List<Copy> copies = new ArrayList<>();
        try{
            while(rs.next()){
                Copy copy = new Copy();
                copy.setAvailable(rs.getBoolean("available"));
                copy.setCondition(rs.getString("conditionn"));
                copy.setAcquisition(rs.getDate("acquisition").toLocalDate());                
                copies.add(copy);
            }
        }catch(Exception ex){
                System.out.println("Ex: " + ex);      
        }   
        return copies;
    }
    
}
