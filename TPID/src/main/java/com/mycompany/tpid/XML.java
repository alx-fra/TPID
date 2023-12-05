/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpid;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author alex-
 */
public class XML {
    public static Document lerDocumentoXML(String caminhoFicheiro) throws IOException {
        try {        
            File file = new File(caminhoFicheiro);
            InputStreamReader stream = new InputStreamReader(new FileInputStream(file), "utf-8");
            Reader reader = new BufferedReader(stream);
            SAXBuilder builder = new SAXBuilder();
            Document anotherDocument = (Document) builder.build(reader);
            return anotherDocument; 
        } catch (JDOMException | IOException ex) {
            FileWriter fileWriter = new FileWriter(caminhoFicheiro);
                fileWriter.close();
                System.out.println("Arquivo criado com sucesso");
            return null;
        }
    }
    
    public static void escreverDocumentoParaFicheiro(Document doc, String caminhoFicheiro) {
        OutputStreamWriter writer = null;
        try {
            //Define o formato de saida
            //O caracter de indentacao pode ser diferente (e.g. \t)
            Format outputFormat = Format.getPrettyFormat();
            outputFormat.setIndent("     ");
            outputFormat.setEncoding("utf-8"); // 
            //Prepara o XMLOutputter
            XMLOutputter outputter = new XMLOutputter(outputFormat);            
            writer = new OutputStreamWriter(new FileOutputStream(caminhoFicheiro), "utf-8");
            outputter.output(doc, writer);
            writer.close();     
        } catch (IOException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
