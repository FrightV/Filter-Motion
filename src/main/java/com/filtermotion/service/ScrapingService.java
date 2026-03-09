package com.filtermotion.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ScrapingService {

    public void buscarProduto() {

        try {

            String url = "https://example.com";

            Document doc = Jsoup.connect(url).get();

            Element titulo = doc.selectFirst("h1");

            if (titulo != null) {
                System.out.println("Título encontrado: " + titulo.text());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}