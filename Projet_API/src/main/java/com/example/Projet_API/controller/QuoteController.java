package com.example.Projet_API.controller;

import com.example.Projet_API.model.Quote;
import com.example.Projet_API.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quotes")
public class QuoteController {
    @Autowired
    private QuoteService quoteService;

    @GetMapping("/random")
    public Quote getRandomQuote() {
        return quoteService.getRandomQuote();
    }
}
