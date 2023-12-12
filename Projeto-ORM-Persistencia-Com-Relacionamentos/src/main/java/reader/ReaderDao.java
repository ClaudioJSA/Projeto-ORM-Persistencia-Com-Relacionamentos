/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader;

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
 * @author annekarolinneds;
 */
public class ReaderDao extends Dao<Reader>{
    public final String TABLE = "reader";

    @Override
    public String getSaveStatement() {
        return "INSERT INTO " + TABLE + "(id, qtdemprestimos) VALUES (?, ?)";
    }

    @Override
    public String getUpdateStatement() {
        return "INSERT INTO " + TABLE + " (id, qtdemprestimos) VALUES (?, ?) ON DUPLICATE KEY UPDATE id = ?, qtdemprestimos = ?";
    }

    @Override
    public String getFindByIdStatement() {
        return "SELECT id, qtdemprestimos FROM " + TABLE + " WHERE id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "SELECT id, qtdemprestimos FROM " + TABLE;
    }

    @Override
    public String getDeleteStatement() {
        return "DELETE FROM " + TABLE + " WHERE id = ?";
    }

    @Override
    public void coposeSaveOrUpdateStatement(PreparedStatement pstmt, Reader e) {
        try {
            pstmt.setLong(1, e.getId());
            pstmt.setLong(2, e.getQtdEmpretimos());
            pstmt.setLong(3, e.getId());
            pstmt.setLong(4, e.getQtdEmpretimos());
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Reader extractObject(ResultSet rs) {
        Reader reader = new Reader();
        try{
            reader.setId(rs.getLong("id"));
            reader.setQtdEmpretimos(rs.getInt("qtdemprestimos"));
        }catch(Exception ex){
                System.out.println("Ex: " + ex);      
        }
        return reader;
    }

    @Override
    public List<Reader> extractObjects(ResultSet rs) {
        List<Reader> readers = new ArrayList<>();
        try{
            while(rs.next()){
                Reader reader = new Reader();
                reader.setId(rs.getLong("id"));
                reader.setQtdEmpretimos(rs.getInt("qtdemprestimos"));
                readers.add(reader);
            }
        }catch(Exception ex){
                System.out.println("Ex: " + ex);      
        }   
        return readers;
    }

    public ReaderDao() {
    }

    public String getTABLE() {
        return TABLE;
    }

    public static String getDB() {
        return DB;
    }
    
    
}
