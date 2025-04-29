package com.practice.jointables.controller;

import com.practice.jointables.models.College;
import com.practice.jointables.service.CollegeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class CollegeController {

    private final CollegeService collegeService;

    @GetMapping("/")
    public ResponseEntity<List<College>> getColleges(){
        return ResponseEntity.ok().body(collegeService.getAllColleges());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<College>> getCollegeById(@PathVariable("id") String id){
        return ResponseEntity.ok().body(collegeService.getCollegeById(id));
    }



}
