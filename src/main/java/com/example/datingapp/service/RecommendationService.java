package com.example.datingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.datingapp.model.User;
import com.example.datingapp.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getTopMatches(User user, int topN) {
        List<User> potentialMatches = userRepository.findByGenderNot(user.getGender());

        return potentialMatches.stream()
                .sorted(Comparator.comparingInt((User u) -> Math.abs(u.getAge() - user.getAge()))
                        .thenComparing(u -> getCommonInterestsCount(u, user), Comparator.reverseOrder()))
                .limit(topN)
                .collect(Collectors.toList());
    }

    private int getCommonInterestsCount(User u1, User u2) {
        return (int) u1.getInterests().stream()
                .filter(u2.getInterests()::contains)
                .count();
    }
}