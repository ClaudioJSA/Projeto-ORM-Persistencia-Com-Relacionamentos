/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import reader.Reader;
import repository.Dao;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public class CommentDao extends Dao<Comment>{
    public final String TABLE = "comment";
    
    @Override
    public String getSaveStatement() {
        return "INSERT INTO " + TABLE + "(comment, idreader, id) VALUES (?, ?, ?)";
    }
    
    @Override
    public String getUpdateStatement() {
        return "UPDATE " + TABLE + " SET comment = ?, idreader = ? WHERE id = ?";
    }

    @Override
    public String getFindByIdStatement() {
        return "SELECT comment, idreader FROM " + TABLE + " WHERE id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "SELECT comment, idreader FROM " + TABLE;
    }

    @Override
    public String getDeleteStatement() {
        return "DELETE FROM " + TABLE + " WHERE id = ?";
    }

    @Override
    public void coposeSaveOrUpdateStatement(PreparedStatement pstmt, Comment e) {
        try {
            pstmt.setString(1, e.getComment());
            pstmt.setLong(2, e.getReader().getId());
            if (e.getId() != null) {
                pstmt.setLong(3, e.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Comment extractObject(ResultSet rs) {
        Comment comment = new Comment();
        try{
            comment.setReader(new Reader());
            comment.setComment(rs.getString("comment"));
            comment.getReader().setId(rs.getLong("idreader"));
        }catch(Exception ex){
                System.out.println("Ex: " + ex);      
        }
        return comment;
    }

    @Override
    public List<Comment> extractObjects(ResultSet rs) {
        List<Comment> comments = new ArrayList<>();
        try{
            while(rs.next()){
                Comment comment = new Comment();
                comment.setReader(new Reader());
                comment.setComment(rs.getString("comment"));
                comment.getReader().setId(rs.getLong("idreader"));
                comments.add(comment);
            }
        }catch(Exception ex){
                System.out.println("Ex: " + ex);      
        }   
        return comments;
    }
    
}
