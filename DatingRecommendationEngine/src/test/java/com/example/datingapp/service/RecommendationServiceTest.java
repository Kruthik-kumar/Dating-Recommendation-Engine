package com.example.datingapp.service;

import com.example.datingapp.model.User;
import com.example.datingapp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RecommendationServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private RecommendationService recommendationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetTopMatches() {
        User user = new User();
        user.setGender("Male");
        user.setAge(27);
        user.setInterests(new HashSet<>(Arrays.asList("Cricket", "Football", "Movies")));

        User match1 = new User();
        match1.setGender("Female");
        match1.setAge(25);
        match1.setInterests(new HashSet<>(Arrays.asList("Cricket", "Chess")));

        User match2 = new User();
        match2.setGender("Female");
        match2.setAge(24);
        match2.setInterests(new HashSet<>(Arrays.asList("Tennis", "Football", "Badminton")));

        when(userRepository.findByGenderNot("Male")).thenReturn(Arrays.asList(match1, match2));

        List<User> matches = recommendationService.getTopMatches(user, 2);

        assertEquals(2, matches.size());
        assertEquals(match1, matches.get(0));
        assertEquals(match2, matches.get(1));
    }
}