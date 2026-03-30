package com.student.tracker.controller;

import com.student.tracker.model.Achievement;
import com.student.tracker.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/achievements")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080", "https://student-acheivement-tracker-fronten-swart.vercel.app", "https://*.vercel.app"}, allowCredentials = "true")
public class AchievementController {

    @Autowired
    private AchievementService achievementService;

    @PostMapping("/{username}/add")
    public ResponseEntity<Achievement> add(@PathVariable String username, @RequestBody Achievement achievement) {
        Achievement saved = achievementService.addAchievement(username, achievement);
        return saved != null ? ResponseEntity.ok(saved) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/section/{sectionCode}")
    public ResponseEntity<List<Achievement>> getBySection(@PathVariable String sectionCode) {
        return ResponseEntity.ok(achievementService.getAchievementsBySection(sectionCode));
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<Achievement>> getByUsername(@PathVariable String username) {
        return ResponseEntity.ok(achievementService.getAchievementsByUsername(username));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAchievement(@PathVariable Long id) {
        achievementService.deleteAchievement(id);
        return ResponseEntity.ok().build();
    }
}