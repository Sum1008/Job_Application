package com.project.Job_Application.service;

import java.util.List;

import com.project.Job_Application.entity.Job;

public interface JobService {

    List<Job> findAll();

    void createJob(Job job);

    Job getJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);

    boolean deleteJobById(Long id);

}
