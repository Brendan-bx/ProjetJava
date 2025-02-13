package com.example.Projet_APP.service;

import com.example.Projet_API.model.Quote;
import com.example.Projet_APP.model.Conversation;
import com.example.Projet_APP.repository.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConversationService {
    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Conversation saveConversation(String username, String message) {
        Quote quote = restTemplate.getForObject("http://localhost:8081/api/quotes/random", Quote.class);
        Conversation conversation = new Conversation();
        conversation.setUsername(username);
        conversation.setMessage(message);
        conversation.setResponse(quote.getText());
        conversation.setQuoteAuthor(quote.getAuthor());
        conversation.setTimestamp(LocalDateTime.now());
        return conversationRepository.save(conversation);
    }

    public List<Conversation> getConversationsByUsername(String username) {
        return conversationRepository.findByUsername(username);
    }

    public List<String> getAllUsernames() {
        return conversationRepository.findAll().stream()
                .map(Conversation::getUsername)
                .distinct()
                .collect(Collectors.toList());
    }
}
