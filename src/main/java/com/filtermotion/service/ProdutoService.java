package com.filtermotion.service;

import com.filtermotion.dto.ProdutoDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.filtermotion.model.Produto;
import com.filtermotion.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    private final String API_KEY = ;

    public List<ProdutoDTO> buscarProdutos(String termo) {

        List<ProdutoDTO> produtos = new ArrayList<>();

        try {

            String url = "https://serpapi.com/search.json?q="
                    + termo
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
                System.out.println("Nenhum resultado retornado pela API");
                return produtos;
            }

            for (JsonNode item : results) {

                String link = item.has("link") ? item.get("link").asText() : null;

                if (link == null || link.isEmpty()) continue;

                ProdutoDTO dto = new ProdutoDTO();

                if (item.has("title"))
                    dto.setNome(item.get("title").asText());

                if (item.has("source"))
                    dto.setLoja(item.get("source").asText());

                if (item.has("price") && !item.get("price").isNull()) {

                    String precoString = item.get("price").asText()
                            .replace("R$", "")
                            .replace(" ", "")
                            .replace(".", "")
                            .replace(",", ".")
                            .trim();

                    try {
                        BigDecimal preco = new BigDecimal(precoString);
                        dto.setPreco(preco);
                    } catch (Exception ex) {
                        System.out.println("Erro convertendo preço: " + precoString);
                    }
                }

                dto.setUrl(link);

                if (item.has("thumbnail"))
                    dto.setImagem(item.get("thumbnail").asText());

                produtos.add(dto);

                Produto produto = new Produto();
                produto.setNome(dto.getNome());
                produto.setLoja(dto.getLoja());
                produto.setPrecoAtual(dto.getPreco());
                produto.setUrl(dto.getUrl());
                produto.setImagem(dto.getImagem());

                produtoRepository.save(produto);
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar produtos");
            e.printStackTrace();
        }

        return produtos;
    }
}