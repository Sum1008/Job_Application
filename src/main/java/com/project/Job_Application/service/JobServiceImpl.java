package com.project.Job_Application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.Job_Application.entity.Job;
import com.project.Job_Application.repository.JobRepository;
@Service
public class JobServiceImpl implements JobService {


    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    
    public List<Job> findAll(){
        return jobRepository.findAll();
    }

    public void createJob(Job job){
        jobRepository.save(job);
    }

    public Job getJobById(Long id){
        return jobRepository.findById(id).orElse(null);
    }

    public boolean deleteJobById(Long id){
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public boolean updateJob(Long id ,Job updatedJob){
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()){
            Job job =jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;

        
    }

}
