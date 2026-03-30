package com.student.tracker.service;

import com.student.tracker.model.Achievement;
import com.student.tracker.model.User;
import com.student.tracker.repository.AchievementRepository;
import com.student.tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AchievementService {

    @Autowired
    private AchievementRepository achievementRepository;

    @Autowired
    private UserRepository userRepository;

    public Achievement addAchievement(String username, Achievement achievement) {
        User student = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        achievement.setUser(student);
        return achievementRepository.save(achievement);
    }

    public List<Achievement> getAchievementsByUsername(String username) {
        return achievementRepository.findByUserUsername(username);
    }

    public List<Achievement> getAchievementsBySection(String sectionCode) {
        return achievementRepository.findByUserSectionCode(sectionCode);
    }

    public void deleteAchievement(Long id) {
        achievementRepository.deleteById(id);
    }
}