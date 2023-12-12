/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copy;

import book.BookDao;
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
        return "INSERT INTO " + TABLE + "(available, conditionn, acquisition, idbook) VALUES (?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE " + TABLE + " SET available = ?, conditionn = ?, acquisition = ?, idbook = ? WHERE id = ?;";
    }

    @Override
    public String getFindByIdStatement() {
        return "SELECT available, conditionn, acquisition, idbook, FROM " + TABLE + " WHERE id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "SELECT available, conditionn, acquisition, idbook, id FROM " + TABLE;
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
            pstmt.setLong(4, e.getBook().getId());
            if (e.getId() != null) {
                pstmt.setLong(5, e.getId());
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
            copy.setId(rs.getLong("id"));
            copy.setBook(new BookDao().findById(rs.getLong("idbook")));
            copy.getBook().setId(rs.getLong("idbook"));
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
                copies.add(extractObject(rs));
            }
        }catch(Exception ex){
                System.out.println("Ex: " + ex);      
        }   
        return copies;
    }
    
}
