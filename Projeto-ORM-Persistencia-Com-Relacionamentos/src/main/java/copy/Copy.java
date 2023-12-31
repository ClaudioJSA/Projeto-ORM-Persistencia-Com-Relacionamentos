/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copy;

import book.Book;
import entity.Entity;
import java.time.LocalDate;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public class Copy extends Entity{
    private boolean available;
    private String condition;
    private LocalDate acquisition;
    private Book book;

    public Copy() {
    }

    public Copy(boolean available, String condition, LocalDate acquisition, Book book) {
        this.available = available;
        this.condition = condition;
        this.acquisition = acquisition;
        this.book = book;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public LocalDate getAcquisition() {
        return acquisition;
    }

    public void setAcquisition(LocalDate acquisition) throws Exception {
        if(acquisition.isAfter(LocalDate.now())){
            throw new Exception("A data de aquisição não pode ser depois da data atual.");
        }
        this.acquisition = acquisition;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
    
    
    
}
