 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loan;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import librarian.Librarian;
import reader.Reader;
import repository.Dao;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public class LoanDao extends Dao<Loan>{
    public final String TABLE = "loan";
    
    @Override
    public String getSaveStatement() {
        return "INSERT INTO " + TABLE + "(dataDoEmprestimo, dataDaDevolução, idlibrarian, idreader) VALUES (?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE " + TABLE + " SET dataDoEmprestimo = ?, dataDaDevolução = ?, idlibrarian = ?, idreader = ? WHERE id = ?";
    }

    @Override
    public String getFindByIdStatement() {
        return "SELECT dataDoEmprestimo, dataDaDevolução, idlibrarian, idreader FROM " + TABLE + " WHERE id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "SELECT dataDoEmprestimo, dataDaDevolução, idlibrarian, idreader FROM " + TABLE;
    }

    @Override
    public String getDeleteStatement() {
        return "DELETE FROM " + TABLE + " WHERE id = ?";
    }

    @Override
    public void coposeSaveOrUpdateStatement(PreparedStatement pstmt, Loan e) {
        try {
            pstmt.setDate(1, Date.valueOf(e.getDataDoEmprestimo()));
            pstmt.setDate(2, Date.valueOf(e.getDataDaDevolução()));
            pstmt.setLong(3, e.getLibrarian().getId());
            pstmt.setLong(4, e.getReader().getId());
            if (e.getId() != null) {
                pstmt.setLong(5, e.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Loan extractObject(ResultSet rs) {
        Loan loan = new Loan();
        try{
            loan.setLibrarian(new Librarian());
            loan.setReader(new Reader());
            loan.setDataDoEmprestimo(rs.getDate("dataDoEmprestimo").toLocalDate());
            loan.setDataDaDevolução(rs.getDate("dataDaDevolução").toLocalDate());
            loan.getLibrarian().setId(rs.getLong("idlibrarian"));
            loan.getReader().setId(rs.getLong("idreader"));
        }catch(Exception ex){
                System.out.println("Ex: " + ex);      
        }
        return loan;
    }

    @Override
    public List<Loan> extractObjects(ResultSet rs) {
        List<Loan> loans = new ArrayList<>();
        try{
            while(rs.next()){
                Loan loan = new Loan();
                loan.setLibrarian(new Librarian());
                loan.setReader(new Reader());
                loan.setDataDoEmprestimo(rs.getDate("dataDoEmprestimo").toLocalDate());
                loan.setDataDaDevolução(rs.getDate("dataDaDevolução").toLocalDate());
                loan.getLibrarian().setId(rs.getLong("idlibrarian"));
                loan.getReader().setId(rs.getLong("idreader"));
                loans.add(loan);
            }
        }catch(Exception ex){
                System.out.println("Ex: " + ex);      
        }   
        return loans;
    }
    
}
