package com.filtermotion.service;

import com.filtermotion.dto.ProdutoDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private final String API_KEY = "YOUR_API_KEY";

    public List<ProdutoDTO> buscarProdutos(String termo, BigDecimal precoMax) {

        List<ProdutoDTO> produtos = new ArrayList<>();

        try {

            String url = "https://serpapi.com/search.json?q="
                    + termo.replace(" ", "+")
                    + "&engine=google_shopping"
                    + "&gl=br"
                    + "&hl=pt"
                    + "&api_key=" + API_KEY;

            RestTemplate restTemplate = new RestTemplate();
            String json = restTemplate.getForObject(url, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(json);

            JsonNode results = root.get("shopping_results");

            if (results == null) {
                System.out.println("Nenhum resultado encontrado");
                return produtos;
            }

            for (JsonNode item : results) {

                ProdutoDTO dto = new ProdutoDTO();

                if (item.has("title"))
                    dto.setNome(item.get("title").asText());

                if (item.has("source"))
                    dto.setLoja(item.get("source").asText());

                if (item.has("product_link"))
                    dto.setUrl(item.get("product_link").asText());
                else if (item.has("link"))
                    dto.setUrl(item.get("link").asText());

                if (item.has("thumbnail"))
                    dto.setImagem(item.get("thumbnail").asText());

                if (item.has("price")) {

                    String precoString = item.get("price").asText()
                            .replaceAll("[^0-9,\\.]", "")
                            .replace(".", "")
                            .replace(",", ".")
                            .trim();

                    try {

                        BigDecimal preco = new BigDecimal(precoString);

                        if (precoMax != null && preco.compareTo(precoMax) > 0)
                            continue;

                        dto.setPreco(preco);

                    } catch (Exception e) {
                        continue;
                    }
                }

                if (dto.getUrl() == null || dto.getPreco() == null)
                    continue;

                produtos.add(dto);
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar produtos:");
            e.printStackTrace();
        }

        return produtos;
    }
}
