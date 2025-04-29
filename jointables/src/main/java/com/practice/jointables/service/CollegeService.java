package com.practice.jointables.service;

import com.practice.jointables.models.College;
import com.practice.jointables.repository.CollegeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CollegeService {

    private final CollegeRepository collegeRepository;

    public List<College> getAllColleges(){
        return collegeRepository.findAll();
    }

    public Optional<College> getCollegeById(String id){
        return collegeRepository.findById(id);
    }
}
