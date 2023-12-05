/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import entity.Entity;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public class Book extends Entity{
    private String title;
    private String authors;
    private Short pages;
    private Short year;
    private Byte edition;
    
///<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws Exception{
        if(title.length() > 150){
            throw new Exception("O titulo não pode ter mais de 150 digitos ou ser nulo");
        }
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) throws Exception {
        if(authors.length() > 250){
            throw new Exception("Os autores não podem ter mais de 250 caracteres ou ser nulo.");
        }
        this.authors = authors;
    }


    public Short getPages() {
        return pages;
    }

    public void setPages(Short pages) throws Exception {
        if(pages < 1){
            throw new Exception("O numero de paginas dever ser pelo menos 1.");
        }
        this.pages = pages;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) throws Exception {
        if(year == null){
            throw new Exception("O ano não pode ser nulo.");
        }
        this.year = year;
    }

    public Byte getEdition() {
        return edition;
    }

    public void setEdition(Byte edition) throws Exception {
        if(edition < 1 || edition == null){
            throw new Exception("A edição não pode ser menor que 1 ou nula.");
        }
        this.edition = edition;
    }
//</editor-fold>

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", authors=" + authors + ", pages=" + pages + ", year=" + year + ", edition=" + edition}';
    }
