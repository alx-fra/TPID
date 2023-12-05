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
        Element raiz;
        if (doc == null) {
            raiz = new Element("escritores"); //cria <catalogo>...</catalogo>
            doc = new Document(raiz);
        } else {
            raiz = doc.getRootElement();
        } 
        Element pai = new Element("escritor");
        Attribute a = new Attribute("id", Integer.toString(escritor.getIdautor()));
        pai.setAttribute(a);
        pai.addContent(escritor.getNome());
        
       // Element x = new Element("datanascimento").addContent(escritor.getDatanascimento());
       //  pai.addContent(x);
        
        Element x = new Element("datamorte").addContent(escritor.getDatamorte());
        pai.addContent(x);
        
       //  x = new Element("fotografia").addContent(escritor.getFotografia());
        // pai.addContent(x);

       //  x = new Element("generos").addContent(escritor.getGenero());
        // pai.addContent(x);

       //  x = new Element("ocupacoes").addContent(escritor.getOcupacoes());
       //  pai.addContent(x);

       //  x = new Element("premios").addContent(escritor.getPremios());
       //  pai.addContent(x);

        raiz.addContent(pai);
        return doc;
    }
}
