package com.example.Projet_APP.controller;

import com.example.Projet_APP.model.Conversation;
import com.example.Projet_APP.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConversationController {
    @Autowired
    private ConversationService conversationService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("conversation", new Conversation());
        return "home";
    }

    @PostMapping("/")
    public String postMessage(@ModelAttribute Conversation conversation, Model model) {
        Conversation savedConversation = conversationService.saveConversation(conversation.getUsername(), conversation.getMessage());
        model.addAttribute("response", savedConversation.getResponse());
        return "home";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("usernames", conversationService.getAllUsernames());
        return "admin";
    }

    @GetMapping("/admin/conversations")
    public String viewConversations(@RequestParam String username, Model model) {
        model.addAttribute("conversations", conversationService.getConversationsByUsername(username));
        return "conversations";
    }
}
