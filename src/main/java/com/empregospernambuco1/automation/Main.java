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

        ArrayList<Integer> paginacao = new ArrayList<Integer>();
        paginacao.add(1);
        paginacao.add(2);
        paginacao.add(3);

        List<String> titulos = new ArrayList<String>();
        List<String>   links = new ArrayList<String>();

        paginacao.forEach(p -> {
            try {
                Document doc = Jsoup.connect("https://www.empregospernambuco.com.br/job-date-archive/page/"+p+"/?time=today&jobs_by_date=1").userAgent("Mozilla/17.0").get();

                Elements elementos = doc.select("div.job-title");

                for (int i = 0;i < elementos.size(); i++) {
                    titulos.add(elementos.get(i).getElementsByTag("a").first().text());
                    links.add(elementos.get(i).getElementsByTag("a").first().attr("href"));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        titulos.forEach(titulo -> {
            System.out.println(titulo);
        });

        links.forEach(link -> {
            System.out.println(link);
        });

        for (int i = 0;i < links.size(); i++) {
            try {
                Document doc = Jsoup.connect(links.get(i)).userAgent("Mozilla/17.0").get();

                Elements     titulo = doc.select("h1.title");
                Elements    empresa = doc.select("span.company");
                String empresaFormt = empresa.get(0).getElementsByTag("a").first().text();

                Elements     cidade = doc.select("span.job-location");
                String  cidadeFormt = cidade.get(0).getElementsByTag("i").first().text();

//                Elements  descricao = doc.select("div.job-title");
//                Elements      email = doc.select("div.job-title");
                System.out.println(links.get(i));
                System.out.println(titulo);
                System.out.println(empresaFormt);
                System.out.println(cidadeFormt);


            } catch (IOException e) {
                e.printStackTrace();
            }
        };

    }
}
