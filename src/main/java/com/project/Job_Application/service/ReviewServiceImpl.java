package com.project.Job_Application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.Job_Application.entity.Review;
import com.project.Job_Application.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService{

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getALlReviews(Long companyId) {
        // TODO Auto-generated method stub
        List<Review> reviews =reviewRepository.findByCompanyId(companyId);
       return reviews;

    }
    

}
