/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpid;

/**
 *
 * @author alex-
 */
public class Escritor {

    String datanascimento, nacionalidade, nome, fotografia, genero, datamorte, ocupacoes, premios, sexo;
    int idautor;
    
    
            public Escritor(String datanascimento, String datamorte,
            String nacionalidade, String nome, String fotografia, String genero, String ocupacoes, String premios, String sexo, int idautor) {
        this.nome = nome;
        this.datanascimento = datanascimento;
        this.datamorte = datamorte;
        this.nacionalidade = nacionalidade;
        this.fotografia = fotografia;
        this.sexo = sexo;
        this.genero = genero;
        this.ocupacoes = ocupacoes;
        this.idautor = idautor;
        this.premios = premios;

    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDatamorte(String datamorte) {
        this.datamorte = datamorte;
    }

    public void setOcupacoes(String ocupacoes) {
        this.ocupacoes = ocupacoes;
    }

    public void setPremios(String premios) {
        this.premios = premios;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setIdautor(int idautor) {
        this.idautor = idautor;
    }
    
    

    

    public String getDatanascimento() {
        return datanascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public String getFotografia() {
        return fotografia;
    }

    public String getGenero() {
        return genero;
    }

    public String getDatamorte() {
        return datamorte;
    }

    public String getOcupacoes() {
        return ocupacoes;
    }

    public String getPremios() {
        return premios;
    }

    public String getSexo() {
        return sexo;
    }

    public int getIdautor() {
        return idautor;
    }


    
}
