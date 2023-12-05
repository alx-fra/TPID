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
    String isbn, titulo, autor, capa,editora;
    int codautor;
    double preco;

    public Obras(String isbn, String titulo, String autor, String capa, String editora, int codautor, double preco) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.capa = capa;
        this.editora = editora;
        this.codautor = codautor;
        this.preco = preco;
    }
}
