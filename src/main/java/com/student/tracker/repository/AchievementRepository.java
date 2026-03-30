package com.student.tracker.repository;

import com.student.tracker.model.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
    List<Achievement> findByUserUsername(String username);
    List<Achievement> findByUserSectionCode(String sectionCode);
}