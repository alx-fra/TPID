/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpid;

/**
 *
 * @author alex-
 */
public class Obras {
    String isbn, titulo, autor, capa,editora,preco;
    int codautor;

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCapa() {
        return capa;
    }

    public String getEditora() {
        return editora;
    }

    public int getCodautor() {
        return codautor;
    }

    public String getPreco() {
        return preco;
    }

    public Obras(String isbn, String titulo, String autor, String capa, String editora, int codautor, String preco) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.capa = capa;
        this.editora = editora;
        this.codautor = codautor;
        this.preco = preco;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setCodautor(int codautor) {
        this.codautor = codautor;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
