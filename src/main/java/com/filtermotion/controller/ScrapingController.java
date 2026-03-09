package com.filtermotion.controller;

import com.filtermotion.service.ScrapingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scraping")
@RequiredArgsConstructor
public class ScrapingController {

    private final ScrapingService scrapingService;

    @GetMapping
    public String testarScraping() {

        scrapingService.buscarProduto();

        return "Scraping executado";

    }

}