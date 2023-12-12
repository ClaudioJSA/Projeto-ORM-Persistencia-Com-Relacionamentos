/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loan;

import copy.Copy;
import entity.Entity;
import java.time.LocalDate;
import librarian.Librarian;
import reader.Reader;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public class Loan extends Entity{
    private LocalDate dataDoEmprestimo;
    private LocalDate dataDaDevolução;
    private Copy copy;
    private Librarian librarian;
    private Reader reader;

    public Loan() {
    }

    public Loan(LocalDate dataDoEmprestimo, LocalDate dataDaDevolução, Librarian librarian, Reader reader, Copy copy) {
        this.dataDoEmprestimo = dataDoEmprestimo;
        this.dataDaDevolução = dataDaDevolução;
        this.librarian = librarian;
        this.reader = reader;
        this.copy = copy;
    }

    public LocalDate getDataDoEmprestimo() {
        return dataDoEmprestimo;
    }

    public void setDataDoEmprestimo(LocalDate dataDoEmprestimo) {
        this.dataDoEmprestimo = dataDoEmprestimo;
    }

    public LocalDate getDataDaDevolução() {
        return dataDaDevolução;
    }

    public void setDataDaDevolução(LocalDate dataDaDevolução) {
        this.dataDaDevolução = dataDaDevolução;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Copy getCopies() {
        return copy;
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }
    
    
    
}
