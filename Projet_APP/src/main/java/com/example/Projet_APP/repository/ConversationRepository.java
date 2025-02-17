package com.example.Projet_APP.repository;

import com.example.Projet_APP.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    List<Conversation> findByUsername(String username);
}
