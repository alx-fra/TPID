/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tpid;

import java.io.IOException;
import java.util.Scanner;
import net.sf.saxon.s9api.SaxonApiException;
import org.jdom2.Document;

/**
 *
 * @author alex-
 */
public class TPID {
    public static void main(String[] args) throws IOException, SaxonApiException {
        /*
        Document doc = XML.lerDocumentoXML("livro.xml");

        doc = XML.lerDocumentoXML("escritores.xml");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um nome:");
        String nome = scanner.nextLine();

        Escritor E = Wrappers.criaEscritor(nome);
        doc = ModeloG.adicionaEscritor(E, doc);
*/
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um nome:");
        String nome = scanner.nextLine();
        nome = nome.replace(" ", "_");
        Escritor E = Wrappers.criaEscritor(nome);

        Document doc = XML.lerDocumentoXML("escritores.xml");
        doc = ModeloG.adicionaEscritor(E, doc);
        XML.escreverDocumentoParaFicheiro(doc, "escritores.xml");
        
        
        
 
    }
}
