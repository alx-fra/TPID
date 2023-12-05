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
import com.mycompany.tpid.Global;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alex-
 */
public class Wrappers {

    private static int obtem_idautor() {
        return Global.id;
    }

    public static String obtem_datamorte() throws IOException {
        String er = "Morte";
        Scanner ler = new Scanner(new FileInputStream("escritores.txt"));
        Pattern p = Pattern.compile(er);
        String linha;
        while (ler.hasNextLine()) {
            linha = ler.nextLine();
            Matcher m = p.matcher(linha);
            if (m.find()) {

                er = ">([0-9]{2} de [a-z]+)<.*>([0-9]{4})<";
                Pattern p2 = Pattern.compile(er);
                ler.nextLine();
                linha = ler.nextLine();
                Matcher m2 = p2.matcher(linha);
                if (m2.find()) {
                    ler.close();
                    String data = m2.group(1) + " de " + m2.group(2);
                    return data;
                }
            }
        }
        ler.close();
        return null;

    }

    private static String obtem_datanascimento() throws FileNotFoundException {
        String er = "Nascimento";
        Scanner ler = new Scanner(new FileInputStream("escritores.txt"));
        Pattern p = Pattern.compile(er);
        String linha;
        while (ler.hasNextLine()) {
            linha = ler.nextLine();
            Matcher m = p.matcher(linha);
            if (m.find()) {

                er = ">([0-9]{2} de [a-z]+)<.*>([0-9]{4})<";
                Pattern p2 = Pattern.compile(er);
                ler.nextLine();
                linha = ler.nextLine();
                Matcher m2 = p2.matcher(linha);
                if (m2.find()) {
                    ler.close();
                    String data = m2.group(1) + " de " + m2.group(2);
                    return data;
                }
            }
        }
        ler.close();
        return null;
    }

    public static String[] obtemurlObras(String nome) throws IOException, SaxonApiException {
        Scanner scanner = new Scanner(System.in);
        nome = nome.replace(" ", "+");
        String[] urlObras = new String[5]; // Declaração do array "irlobras" de strings
        String url = "https://www.bertrand.pt/pesquisa/" + nome;

        HttpRequestFunctions.httpRequest1(url, "", "obras.txt");
        Scanner ler = new Scanner(new FileInputStream("obras.txt"));
        nome = nome.replace("+", " ");

        nome = nome.replaceAll("[^a-zA-Z0-9\\s]", "");
        nome = nome.replace(" ", "-");
        nome = nome.toLowerCase();
        String er = "class=\"track\" href=\"(/livro/[a-z-]*-" + nome + "/[0-9]+)\"";
        Pattern p = Pattern.compile(er);
        String linha;
        int i = 0;
        while (ler.hasNextLine() && i < 5) {
            linha = ler.nextLine();
            Matcher m = p.matcher(linha);
            if (m.find()) {

                String urlobra = m.group(1);
                url = "https://www.bertrand.pt/" + urlobra;
                urlObras[i] = url;
                i++;
            }
        }

        return urlObras;
    }

    public static Obras criaObras(String urlObras, String nome, int i) throws IOException, SaxonApiException {
        Scanner scanner = new Scanner(System.in);

        HttpRequestFunctions.httpRequest1(urlObras, "", "obra.txt");
        String isbn = Wrappers.obtem_isbn();
        String titulo = Wrappers.obtem_titulo();

        String editora = Wrappers.obtem_editora();
        String capa = Wrappers.obtem_capa();

        String preco = Wrappers.obtem_preco();
        Obras obra = new Obras(isbn, titulo, nome, capa, editora, Global.id, preco);

        File arquivo = new File("obra.txt");
        arquivo.delete();
        return obra;

    }

    public static Escritor criaEscritor(String nome) throws IOException, SaxonApiException {
        Scanner scanner = new Scanner(System.in);
        nome = nome.replace(" ", "_");
        String url = "https://pt.wikipedia.org/wiki/";
        HttpRequestFunctions.httpRequest1(url, nome, "escritores.txt");
        String datamorte = Wrappers.obtem_datamorte();
        String datanascimento = Wrappers.obtem_datanascimento();
        String nacionalidade = Wrappers.obtem_nacionalidade();
        String fotografia = Wrappers.obtem_fotografia(nome);
        String genero = Wrappers.obtem_genero();
        String ocupacoes = Wrappers.obtem_ocupacoes();
        String premios = Wrappers.obtem_premios();

        nome = nome.replace("_", " ");

        Escritor escritor = new Escritor(datanascimento, datamorte, nacionalidade, nome, fotografia, genero, ocupacoes, premios, Global.id);

        return escritor;
    }

    private static String obtem_nacionalidade() throws FileNotFoundException {

        String er = "Nacionalidade";
        Scanner ler = new Scanner(new FileInputStream("escritores.txt"));
        Pattern p = Pattern.compile(er);
        String linha;
        while (ler.hasNextLine()) {
            linha = ler.nextLine();
            Matcher m = p.matcher(linha);
            if (m.find()) {

                er = ">([a-zêâéáí-]+)<";
                Pattern p2 = Pattern.compile(er);
                ler.nextLine();
                linha = ler.nextLine();
                Matcher m2 = p2.matcher(linha);
                if (m2.find()) {
                    ler.close();
                    String data = m2.group(1);
                    return data;
                }
            }
        }
        ler.close();
        return null;

    }

    private static String obtem_fotografia(String nome) throws FileNotFoundException {
        nome = nome.replace("_", " ");
        String er = "title=\"" + nome + "\"><img.*src=\\\"([^\\\"]*)\\\"";
        Scanner ler = new Scanner(new FileInputStream("escritores.txt"));
        Pattern p = Pattern.compile(er);
        String linha;
        while (ler.hasNextLine()) {
            linha = ler.nextLine();
            Matcher m = p.matcher(linha);
            if (m.find()) {

                return m.group(1);
            }
        }
        ler.close();
        return null;

    }

    private static String obtem_genero() throws FileNotFoundException {
        String er = "G[êée]nero liter[áa]rio";
        Scanner ler = new Scanner(new FileInputStream("escritores.txt"));
        Pattern p = Pattern.compile(er);
        String linha;
        while (ler.hasNextLine()) {
            linha = ler.nextLine();
            Matcher m = p.matcher(linha);
            if (m.find()) {

                er = ">(.*?)<";
                Pattern p2 = Pattern.compile(er);
                ler.nextLine();
                linha = ler.nextLine();
                Matcher m2 = p2.matcher(linha);
                if (m2.find()) {
                    List<String> conteudos = new ArrayList<>();
                    while (m2.find()) {
                        conteudos.add(m2.group(1));
                    }
                    ler.close();
                    String data = String.join("", conteudos);
                    return data;
                }
            }
        }
        ler.close();
        return null;
    }

    private static String obtem_ocupacoes() throws FileNotFoundException {
        String er = "Ocupação";
        Scanner ler = new Scanner(new FileInputStream("escritores.txt"));
        Pattern p = Pattern.compile(er);
        String linha;
        while (ler.hasNextLine()) {
            linha = ler.nextLine();
            Matcher m = p.matcher(linha);
            if (m.find()) {

                er = ">(.*?)<";
                Pattern p2 = Pattern.compile(er);
                ler.nextLine();
                linha = ler.nextLine();
                Matcher m2 = p2.matcher(linha);
                if (m2.find()) {
                    List<String> conteudos = new ArrayList<>();
                    while (m2.find()) {
                        conteudos.add(m2.group(1));
                    }
                    ler.close();
                    String data = String.join("", conteudos);
                    return data;
                }
            }
        }
        ler.close();
        return null;
    }

    private static String obtem_premios() throws FileNotFoundException {
        String er = "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Pr[êée]mios";
        Scanner ler = new Scanner(new FileInputStream("escritores.txt"));
        Pattern p = Pattern.compile(er);
        String linha;
        while (ler.hasNextLine()) {
            linha = ler.nextLine();
            Matcher m = p.matcher(linha);
            if (m.find()) {
                er = ">(.*?)<";
                Pattern p2 = Pattern.compile(er);
                ler.nextLine();
                linha = ler.nextLine();

                Matcher m2 = p2.matcher(linha);

                List<String> conteudos = new ArrayList<>();
                while (m2.find()) {

                    conteudos.add(m2.group(1));
                }

                ler.close();
                String data = String.join("", conteudos);
                return data;

            }
        }
        ler.close();
        return null;
    }

    private static String obtem_isbn() throws FileNotFoundException {
        String er = "ISBN:";
        Scanner ler = new Scanner(new FileInputStream("obra.txt"));
        Pattern p = Pattern.compile(er);
        String linha;
        while (ler.hasNextLine()) {
            linha = ler.nextLine();
            Matcher m = p.matcher(linha);
            if (m.find()) {

                er = ">([0-9-]+)<";
                Pattern p2 = Pattern.compile(er);
                linha = ler.nextLine();
                Matcher m2 = p2.matcher(linha);
                if (m2.find()) {

                    return m2.group(1);
                }
            }
        }
        ler.close();
        return null;
    }

    private static String obtem_titulo() throws FileNotFoundException {
        String er = "<h1 id=\"productPageRightSectionTop-title-h1\" class=\"col-lg-12 col-xs-12 col-md-12 col-sm-12 no-padding pull-left\">(.*)</h1>";
        Scanner ler = new Scanner(new FileInputStream("obra.txt"));
        Pattern p = Pattern.compile(er);
        String linha;
        while (ler.hasNextLine()) {
            linha = ler.nextLine();
            Matcher m = p.matcher(linha);
            if (m.find()) {

                return m.group(1);

            }
        }
        ler.close();
        return null;
    }

    private static String obtem_capa() throws FileNotFoundException {
        String er = "sizes=\"\\(max-width: 688px\\) 75vw, 25vw\"";
        Scanner ler = new Scanner(new FileInputStream("obra.txt"));
        Pattern p = Pattern.compile(er);
        String linha;
        while (ler.hasNextLine()) {
            
            linha = ler.nextLine();
            Matcher m = p.matcher(linha);
                            System.out.println(linha);

            if (m.find()) {

                er = "srcset=\\\"([^\\\"]*)\\\"";
                Pattern p2 = Pattern.compile(er);
                ler.nextLine();
                linha = ler.nextLine();
                Matcher m2 = p2.matcher(linha);
                if (m2.find()) {
                    ler.close();
                    return m2.group(1);
                }
            }
        }
        ler.close();
        return null;
    }

    private static String obtem_editora() throws FileNotFoundException {
        String er = "Editor:\\s*<div class=\"info\">(.*)</div>";
        Scanner ler = new Scanner(new FileInputStream("obra.txt"));
        Pattern p = Pattern.compile(er);
        String linha;
        while (ler.hasNextLine()) {
            linha = ler.nextLine();
            Matcher m = p.matcher(linha);
            if (m.find()) {

                return m.group(1);

            }
        }
        ler.close();
        return null;
    }

    private static String obtem_preco() throws FileNotFoundException {
        String er = "<div class=\"current\" id=\"productPageRightSectionTop-saleAction-price-current\">(.*)</div>";
        Scanner ler = new Scanner(new FileInputStream("obra.txt"));
        Pattern p = Pattern.compile(er);
        String linha;
        while (ler.hasNextLine()) {
            linha = ler.nextLine();
            Matcher m = p.matcher(linha);
            if (m.find()) {

                return m.group(1);

            }
        }
        ler.close();
        return null;
    }

}
