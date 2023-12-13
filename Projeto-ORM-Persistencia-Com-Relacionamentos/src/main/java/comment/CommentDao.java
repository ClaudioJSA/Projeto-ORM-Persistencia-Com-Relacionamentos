/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comment;

import book.Book;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import reader.Reader;
import repository.Dao;
import repository.DbConnection;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public class CommentDao extends Dao<Comment>{
    public final String TABLE = "comment";
    
    @Override
    public String getSaveStatement() {
        return "INSERT INTO " + TABLE + "(comment, idreader, idbook) VALUES (?, ?, ?)";
    }
    
    @Override
    public String getUpdateStatement() {
        return "UPDATE " + TABLE + " SET comment = ?, idreader = ?, idbook = ? WHERE id = ?";
    }

    @Override
    public String getFindByIdStatement() {
        return "SELECT comment, idreader, idbook FROM " + TABLE + " WHERE id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "SELECT comment, idreader, idbook FROM " + TABLE;
    }

    @Override
    public String getDeleteStatement() {
        return "DELETE FROM " + TABLE + " WHERE id = ?";
    }

    @Override
    public void coposeSaveOrUpdateStatement(PreparedStatement pstmt, Comment e) {
        try {
            pstmt.setString(1, e.getComment());
            pstmt.setLong(2, e.getUser().getId());
            pstmt.setLong(3, e.getBook().getId());
            if (e.getId() != null) {
                pstmt.setLong(4, e.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Comment extractObject(ResultSet rs) {
        Comment comment = new Comment();
        try{
            comment.setUser(new Reader());
            comment.setComment(rs.getString("comment"));
            comment.getUser().setId(rs.getLong("idreader"));
            comment.getBook().setId(rs.getLong("idbook"));
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
                comment.setUser(new Reader());
                comment.setBook(new Book());
                comment.setId(rs.getLong("id"));
                comment.setComment(rs.getString("comment"));
                comment.getUser().setId(rs.getLong("idreader"));
                comment.getBook().setId(rs.getLong("idbook"));
                comments.add(comment);
            }
        }catch(Exception ex){
                System.out.println("Ex: " + ex);      
        }   
        return comments;
    }
    
    public List<Comment> findByBookId(Long idBook){        
        try(PreparedStatement pstmt = DbConnection.getConnection().prepareStatement("SELECT id, comment, idreader, idbook FROM " + TABLE +" WHERE idbook = ?")){
            pstmt.setLong(1, idBook);
            ResultSet resultSet = pstmt.executeQuery();
            System.out.println(pstmt);
            return extractObjects(resultSet);
        }catch(Exception ex){
            System.out.println("Ex: "+ex);
        }
        return null;
    }
}
