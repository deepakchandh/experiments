package com.practice.jointables.repository;

import com.practice.jointables.models.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College, String> {
}
