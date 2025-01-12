package com.example.datingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.datingapp.model.User;
import com.example.datingapp.repository.UserRepository;
import com.example.datingapp.service.RecommendationService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecommendationService recommendationService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}/recommendations")
    public List<User> getRecommendations(@PathVariable Long id, @RequestParam int topN) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return recommendationService.getTopMatches(user, topN);
    }
}