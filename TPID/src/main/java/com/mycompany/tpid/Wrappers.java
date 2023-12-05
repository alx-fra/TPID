/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpid;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XdmValue;

/**
 *
 * @author alex-
 */
public class Wrappers {

        public static String obtem_datamorte(String autor) throws IOException {
    String url = "https://pt.wikipedia.org/wiki/";
    HttpRequestFunctions.httpRequest1(url, autor, "escritores.txt");
    File file = new File("escritores.txt");

    StringBuilder content = new StringBuilder();
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        content.append(line).append("\n");
    }

    scanner.close();

    String padrao = "\\bAna\s+(\\w+)";
    Pattern pattern = Pattern.compile(padrao);
    Matcher matcher = pattern.matcher(content.toString());

    if (matcher.find()) {
        String dataMorte = matcher.group(1);
        return dataMorte;
    }

    return null;
}
        
        private static String obtem_datanascimento(String nome) throws FileNotFoundException {
            File file = new File("escritores.txt");

    StringBuilder content = new StringBuilder();
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        content.append(line).append("\n");
    }

    scanner.close();

    String padrao = "\\bAna\s+(\\w+)";
    Pattern pattern = Pattern.compile(padrao);
    Matcher matcher = pattern.matcher(content.toString());

    if (matcher.find()) {
        String dataMorte = matcher.group(1);
        return dataMorte;
    }

    return null;
    }

        
    
    public static Escritor criaEscritor(String nome) throws IOException, SaxonApiException {
 Scanner scanner = new Scanner(System.in);

        

        String datamorte = Wrappers.obtem_datamorte(nome);
        //System.out.println(datamorte);
        String datanascimento = Wrappers.obtem_datanascimento(nome);
        
        String nacionalidade = Wrappers.obtem_nacionalidade(nome);
        String fotografia = Wrappers.obtem_fotografia(nome);
        String genero = Wrappers.obtem_genero(nome);
        String ocupacoes = Wrappers.obtem_ocupacoes(nome);
        String premios = Wrappers.obtem_premios(nome);
        String sexo = Wrappers.obtem_sexo(nome);
        int idautor = Wrappers.obtem_idautor(nome);

        //Escritor escritor = new Escritor(datanascimento, datamorte, nacionalidade, nome, fotografia, genero, ocupacoes, premios, sexo, idautor);
                nome = nome.replace("_", " ");

                Escritor escritor = new Escritor(null, datamorte, null, nome, null, null, null, null, null, 1);

        return escritor;
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        /*
    public static String obtem_nome_autor(String autor) throws IOException {
    // Codifique a função para obter o nome do autor do website Wikipedia.pt

    String url = "https://pt.wikipedia.org/wiki/" + autor;
    HttpRequestFunctions.httpRequest1(url, "", "pagina.html");

    String padrao = "<title>(.*?) – Wikipédia, a enciclopédia livre</title>";
    Pattern pattern = Pattern.compile(padrao);

    Scanner ler = new Scanner(new FileInputStream("pagina.html"));
    while (ler.hasNextLine()) {
        String linha = ler.nextLine();
        Matcher matcher = pattern.matcher(linha);
        if (matcher.find()) {
            ler.close();
            return matcher.group(1);
        }
    }
    ler.close();
    return null;
}*/

    private static String obtem_nacionalidade(String nome) throws FileNotFoundException {
File file = new File("escritores.txt");

    StringBuilder content = new StringBuilder();
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        content.append(line).append("\n");
    }

    scanner.close();

    String padrao = "\\bAna\s+(\\w+)";
    Pattern pattern = Pattern.compile(padrao);
    Matcher matcher = pattern.matcher(content.toString());

    if (matcher.find()) {
        String dataMorte = matcher.group(1);
        return dataMorte;
    }

    return null;    }

    private static String obtem_fotografia(String nome) throws FileNotFoundException {
File file = new File("escritores.txt");

    StringBuilder content = new StringBuilder();
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        content.append(line).append("\n");
    }

    scanner.close();

    String padrao = "\\bAna\s+(\\w+)";
    Pattern pattern = Pattern.compile(padrao);
    Matcher matcher = pattern.matcher(content.toString());

    if (matcher.find()) {
        String dataMorte = matcher.group(1);
        return dataMorte;
    }

    return null;    }

    private static String obtem_genero(String nome) throws FileNotFoundException {
File file = new File("escritores.txt");

    StringBuilder content = new StringBuilder();
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        content.append(line).append("\n");
    }

    scanner.close();

    String padrao = "\\bAna\s+(\\w+)";
    Pattern pattern = Pattern.compile(padrao);
    Matcher matcher = pattern.matcher(content.toString());

    if (matcher.find()) {
        String dataMorte = matcher.group(1);
        return dataMorte;
    }

    return null;    }

    private static String obtem_ocupacoes(String nome) throws FileNotFoundException {
File file = new File("escritores.txt");

    StringBuilder content = new StringBuilder();
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        content.append(line).append("\n");
    }

    scanner.close();

    String padrao = "\\bAna\s+(\\w+)";
    Pattern pattern = Pattern.compile(padrao);
    Matcher matcher = pattern.matcher(content.toString());

    if (matcher.find()) {
        String dataMorte = matcher.group(1);
        return dataMorte;
    }

    return null;    }

    private static String obtem_premios(String nome) throws FileNotFoundException {
File file = new File("escritores.txt");

    StringBuilder content = new StringBuilder();
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        content.append(line).append("\n");
    }

    scanner.close();

    String padrao = "\\bAna\s+(\\w+)";
    Pattern pattern = Pattern.compile(padrao);
    Matcher matcher = pattern.matcher(content.toString());

    if (matcher.find()) {
        String dataMorte = matcher.group(1);
        return dataMorte;
    }

    return null;    }

    private static String obtem_sexo(String nome) throws FileNotFoundException {
File file = new File("escritores.txt");

    StringBuilder content = new StringBuilder();
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        content.append(line).append("\n");
    }

    scanner.close();

    String padrao = "\\bAna\s+(\\w+)";
    Pattern pattern = Pattern.compile(padrao);
    Matcher matcher = pattern.matcher(content.toString());

    if (matcher.find()) {
        String dataMorte = matcher.group(1);
        return dataMorte;
    }

    return null;    }

    private static int obtem_idautor(String nome) {
        return id;
    }

    



}
