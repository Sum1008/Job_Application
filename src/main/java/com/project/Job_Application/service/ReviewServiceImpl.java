package com.project.Job_Application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.Job_Application.entity.Company;
import com.project.Job_Application.entity.Review;
import com.project.Job_Application.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService{

    private ReviewRepository reviewRepository;
    private CompanySerive companySerive;

    public ReviewServiceImpl(ReviewRepository reviewRepository,CompanySerive companySerive) {
        this.reviewRepository = reviewRepository;
        this.companySerive=companySerive;
    }

    // @Override
    // public List<Review> getALlReviews(Long companyId) {
    //     // TODO Auto-generated method stub
    //     List<Review> reviews =reviewRepository.findByCompanyId(companyId);
    //    return reviews;

    // }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        // TODO Auto-generated method stub
        Company company =companySerive.getCompanyById(companyId);
        if(company!=null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }else{
            return false;
        }
       
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review review) {
        Company company = companySerive.getCompanyById(companyId);
        if (company != null && reviewRepository.existsById(reviewId)) {
            review.setId(reviewId);
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if (reviewRepository.existsById(reviewId)) {
            reviewRepository.deleteById(reviewId);
            return true;
        } else {
            return false;
        }
    }

   
    

}
