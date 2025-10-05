package com.neeldoshi.first_spring_project.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    //private List<Jobs> jobs = new ArrayList<>();
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/getAllJobs")
//    @RequestMapping(name = "getAllJobs" , method = RequestMethod.GET)
    public List<Jobs> findAll(){
            return jobService.findAll();
    }

//    @RequestMapping(name = "createJobs" , method = RequestMethod.POST)
    @PostMapping("/createJobs")
    public String createJob(@RequestBody Jobs job){
        jobService.createJob(job);
//        jobs.add(job);
        return "Success";
    }
//    @RequestMapping(name = "getJobsById", params = "{id}", method = RequestMethod.GET)
    @GetMapping("/getJobsById/{id}")
    public ResponseEntity<Jobs> getSpecificJob(@PathVariable Integer id){
        Jobs job = jobService.getJobById(id);
        if (job !=null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(job, HttpStatus.NOT_FOUND);
    }
}
