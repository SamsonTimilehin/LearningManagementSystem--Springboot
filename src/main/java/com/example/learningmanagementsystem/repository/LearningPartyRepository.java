package com.example.learningmanagementsystem.repository;

import com.example.learningmanagementsystem.entity.LearningParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningPartyRepository extends JpaRepository<LearningParty, Long> {
    LearningParty findByEmail(String email);
}
