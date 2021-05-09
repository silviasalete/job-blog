package com.empregospernambuco1.automation;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> paginacao = paginar();
        List<String>          titulos = populaTitulos(paginacao);
        List<String>            links = populaLinks(paginacao);
//        List<JobAutomation> listaJobs = retornaListaJobs(links);
        mostraElementosConsole(titulos);
        mostraElementosConsole(links);
//        mostraJobssConsole(listaJobs);

    }

    private static ArrayList<Integer> paginar() {
        ArrayList<Integer> paginacao = new ArrayList<>();
        paginacao.add(1);
        paginacao.add(2);
        paginacao.add(3);
        return paginacao;
    }

    private static List<String> populaTitulos(ArrayList<Integer> paginacao){
        List<String> titulos = new ArrayList<String>();
        paginacao.forEach(p -> {
            try {
                Document doc = Jsoup.connect("https://www.empregospernambuco.com.br/job-date-archive/page/"+p+"/?time=today&jobs_by_date=1").userAgent("Mozilla/17.0").get();

                Elements elementos = doc.select("div.job-title");

                for (Element elemento : elementos) {
                    titulos.add(elemento.getElementsByTag("a").first().text());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return titulos;
    }

    private static List<String> populaLinks(ArrayList<Integer> paginacao){
        List<String>   links = new ArrayList<String>();
        paginacao.forEach(p -> {

            Document doc = null;
            try {
                doc = Jsoup.connect("https://www.empregospernambuco.com.br/job-date-archive/page/"+p+"/?time=today&jobs_by_date=1").userAgent("Mozilla/17.0").get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Elements elementos = doc.select("div.job-title");

                for (Element elemento : elementos) {
                    links.add(elemento.getElementsByTag("a").first().attr("href"));
                }
        });
        return links;
    }

    private static void mostraElementosConsole(List<String> listaString){
        listaString.forEach(System.out::println);
    }

    private static void mostraJobssConsole(List<JobAutomation> listaJobs){
        listaJobs.forEach(jobAutomation ->  System.out.println(jobAutomation.toString()));
    }

    private static List<JobAutomation> retornaListaJobs(List<String> links){
        List<JobAutomation> listaJobAutomation = new ArrayList<JobAutomation>();

        for (String link : links) {
            JobAutomation jobAutomation = new JobAutomation();
            try {
                Document doc = Jsoup.connect(link).userAgent("Mozilla/17.0").get();
                jobAutomation.setTitle( doc.select("h1.title").get(0).text());
                jobAutomation.setEmpresa(doc.select("span.company").get(0).getElementsByTag("a").first().text());
                jobAutomation.setCidade( doc.select("span.job-location").get(0).getElementsByTag("i").first().text());
                listaJobAutomation.add(jobAutomation);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listaJobAutomation;
    }
}
