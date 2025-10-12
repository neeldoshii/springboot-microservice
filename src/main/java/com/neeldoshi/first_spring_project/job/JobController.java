package com.neeldoshi.first_spring_project.job;

import com.neeldoshi.first_spring_project.companies.Companies;
import com.neeldoshi.first_spring_project.companies.CompanyServices;
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
    private CompanyServices companyServices;

    public JobController(JobService jobService,CompanyServices companyServices ) {
        this.jobService = jobService;
        this.companyServices = companyServices;
    }

    @GetMapping("/getAllJobs")
//    @RequestMapping(name = "getAllJobs" , method = RequestMethod.GET)
    public List<Jobs> findAll(){
            return jobService.findAll();
    }

//    @RequestMapping(name = "createJobs" , method = RequestMethod.POST)
    @PostMapping("/createJobs")
    public String createJob(@RequestBody Jobs jobRequest){
        Companies company = companyServices.getCompanyById(jobRequest.getCompanyId());
        Jobs job = new Jobs();
//        job.setCompanies(jobRequest.getCompanies());
        job.setId(jobRequest.getId());
        job.setTitle(jobRequest.getTitle());
        job.setDescription(jobRequest.getDescription());
        job.setMinSalary(jobRequest.getMinSalary());
        job.setMaxSalary(jobRequest.getMaxSalary());
        job.setCompanies(company);


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
