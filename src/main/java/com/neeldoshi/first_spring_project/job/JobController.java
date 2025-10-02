package com.neeldoshi.first_spring_project.job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    private List<Jobs> jobs = new ArrayList<>();

    @GetMapping("getAllJobs")
    public List<Jobs> findAll(){
            return jobs;
    }

    @PostMapping("getAllJobs")
    public String createJob(@RequestBody Jobs job){
        jobs.add(job);
        return "Success";
    }
}
