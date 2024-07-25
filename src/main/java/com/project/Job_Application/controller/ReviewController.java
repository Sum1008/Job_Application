package com.project.Job_Application.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Job_Application.entity.Review;
import com.project.Job_Application.service.ReviewService;

@RestController
@RequestMapping("/compaines/{companyId}")
public class ReviewController {

    private ReviewService reviewService;
    
   
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getALlReviews(companyId),HttpStatus.OK);
    }

}
