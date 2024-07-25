package com.project.Job_Application.service;

import java.util.List;

import com.project.Job_Application.entity.Review;

public interface ReviewService {

    List<Review> getALlReviews(Long companyId);

}
