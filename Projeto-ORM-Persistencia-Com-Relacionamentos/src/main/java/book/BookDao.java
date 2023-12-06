/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

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
public class BookDao extends Dao<Book>{
    public final String TABLE = "book";
    
    @Override
    public String getSaveStatement() {
        return "INSERT INTO " + TABLE + "(title, authors, pages, year, edition) VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE " + TABLE + " SET title = ?, authors = ?, pages = ?, year = ?, edition = ? WHERE id = ?";
    }

    @Override
    public String getFindByIdStatement() {
        return "SELECT title, authors, pages, year, edition FROM " + TABLE + " WHERE id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "SELECT id, title, authors, pages, year, edition FROM " + TABLE;
    }

    @Override
    public String getDeleteStatement() {
        return "DELETE FROM " + TABLE + " WHERE id = ?";
    }

    @Override
    public void coposeSaveOrUpdateStatement(PreparedStatement pstmt, Book e) {
        try {
            pstmt.setString(1, e.getTitle());
            pstmt.setString(2, e.getAuthors());
            pstmt.setShort(3, e.getPages());
            pstmt.setShort(4, e.getYear());
            pstmt.setByte(5, e.getEdition());
            if (e.getId() != null) {
                pstmt.setLong(6, e.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Book extractObject(ResultSet rs) {
        Book book = new Book();
        try{
            book.setTitle(rs.getString("title"));
            book.setAuthors(rs.getString("authors"));
            book.setPages(rs.getShort("pages"));
            book.setYear(rs.getShort("year"));
            book.setEdition(rs.getByte("edition"));
        }catch(Exception ex){
                System.out.println("Ex: " + ex);      
        }
        return book;
    }

    @Override
    public List<Book> extractObjects(ResultSet rs) {
        List<Book> books = new ArrayList<>();
        try{
            while(rs.next()){
                Book book = new Book();
                book.setId(rs.getLong("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthors(rs.getString("authors"));
                book.setPages(rs.getShort("pages"));
                book.setYear(rs.getShort("year"));
                book.setEdition(rs.getByte("edition"));
                books.add(book);
            }
        }catch(Exception ex){
                System.out.println("Ex: " + ex);      
        }   
        return books;
    }
    
    public BookDao() {
    }

    public String getTABLE() {
        return TABLE;
    }
}
