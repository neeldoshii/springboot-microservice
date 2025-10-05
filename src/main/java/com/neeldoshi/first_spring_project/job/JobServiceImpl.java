package com.neeldoshi.first_spring_project.job;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService{
    List<Jobs> jobs = new ArrayList<>();
    int id = 1;
    @Override
    public List<Jobs> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Jobs job) {
        System.out.println(job.getId());
        System.out.println(jobs);
        job.setId(id++);
        jobs.add(job);
    }

    @Override
    public Jobs getJobById(int id) {
        for (Jobs job : jobs){
            if (job.getId() == id){
                return job;
            }
        }
        return null;
    }
}
