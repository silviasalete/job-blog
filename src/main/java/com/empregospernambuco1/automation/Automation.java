package com.empregospernambuco1.automation;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Automation {

    private ArrayList<Integer> paginacao = null;
    private List<String> titulos = null;


    public Automation() {
        paginacao = paginar();
        titulos = populaTitulos(paginacao);
    }

    public List<String> getTitulos() {
        return titulos;
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
}
