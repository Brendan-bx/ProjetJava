package com.example.Projet_API.repository;

import com.example.Projet_API.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
