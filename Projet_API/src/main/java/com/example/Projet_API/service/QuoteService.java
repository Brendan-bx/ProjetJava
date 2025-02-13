package com.example.Projet_API.service;

import com.example.Projet_API.model.Quote;
import com.example.Projet_API.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteService {
    @Autowired
    private QuoteRepository quoteRepository;

    public Quote getRandomQuote() {
        List<Quote> quotes = quoteRepository.findAll();
        Random rand = new Random();
        return quotes.get(rand.nextInt(quotes.size()));
    }
}
