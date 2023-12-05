/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpid;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author alex-
 */
public class ModeloG {

    public static Document adicionaEscritor(Escritor escritor, Document doc) {
        Global.id++;
        Element raiz;
        if (doc == null) {
            raiz = new Element("escritores");
            doc = new Document(raiz);
        } else {
            raiz = doc.getRootElement();
        }
        Element pai = new Element("escritor");
        Attribute a = new Attribute("id", Integer.toString(escritor.getIdautor()));
        pai.setAttribute(a);
        pai.addContent(escritor.getNome());

        Element x = new Element("datanascimento").addContent(escritor.getDatanascimento());
        pai.addContent(x);
        if (escritor.getDatamorte() != null) {
            x = new Element("datamorte").addContent(escritor.getDatamorte());
            pai.addContent(x);

        }
        if (escritor.getNacionalidade() != null) {
            x = new Element("nacionalidade").addContent(escritor.getNacionalidade());
            pai.addContent(x);
        }
        
        if (escritor.getGenero() != null) {
            x = new Element("generos-literarios").addContent(escritor.getGenero());
            pai.addContent(x);
        }
        if (escritor.getOcupacoes() != null) {
            x = new Element("ocupacoes").addContent(escritor.getOcupacoes());
            pai.addContent(x);
        }
        if (escritor.getPremios() != null) {
            x = new Element("premios").addContent(escritor.getPremios());
            pai.addContent(x);
        }
        
        if (escritor.getFotografia() != null) {
          x = new Element("fotografia").addContent(escritor.getFotografia());
         pai.addContent(x);
        }
        raiz.addContent(pai);
        return doc;
    }

    public static Document adicionaObra(Obras obra, Document doc) {
        Element raiz;
        if (doc == null) {
            raiz = new Element("obras");
            doc = new Document(raiz);
        } else {
            raiz = doc.getRootElement();
        }
        Element pai = new Element("obra");
        pai.addContent(obra.getTitulo());
        System.out.println(obra.getCapa());

        Element x = new Element("isbn").addContent(obra.getIsbn());
        Attribute a = new Attribute("isbn", obra.getIsbn());
        pai.setAttribute(a);
        pai.addContent(x);

        if (obra.getAutor() != null) {
            x = new Element("autor").addContent(obra.getAutor());
            a = new Attribute("id", Integer.toString(obra.getCodautor()));
            x.setAttribute(a);
            pai.addContent(x);
        }

        if (obra.getEditora() != null) {
            x = new Element("editora").addContent(obra.getEditora());
            pai.addContent(x);

        }
if (obra.getCapa() != null) {
            x = new Element("capa").addContent(obra.getCapa());
            pai.addContent(x);

        }
        if (obra.getPreco() != null) {
            x = new Element("Preço").addContent(obra.getPreco());
            pai.addContent(x);

        }
        
        raiz.addContent(pai);
        return doc;
    }

}
