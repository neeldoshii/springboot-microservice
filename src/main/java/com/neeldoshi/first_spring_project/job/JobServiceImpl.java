package com.neeldoshi.first_spring_project.job;

import com.neeldoshi.first_spring_project.companies.CompaniesRepository;
import com.neeldoshi.first_spring_project.companies.CompanyServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService{

    private JobRepository jobRepository;
    private CompaniesRepository companiesRepository;

    public JobServiceImpl(JobRepository jobRepository, CompaniesRepository companiesRepository) {
        this.jobRepository = jobRepository;
        this.companiesRepository = companiesRepository;
    }

    //    List<Jobs> jobs = new ArrayList<>();
//    int id = 1;
    @Override
    public List<Jobs> findAll() {
        return jobRepository.findAll();
//        return jobs;
    }

    @Override
    public void createJob(Jobs job) {


        jobRepository.save(job);
        /*
        System.out.println(job.getId());
        System.out.println(jobs);
        job.setId(id++);
        jobs.add(job);

         */
    }

    @Override
    public Jobs getJobById(Integer id) {

        return jobRepository.findById(id).orElse(null);
        /*for (Jobs job : jobs){
            if (job.getId() == id){
                return job;
            }
        }
        return null;
         */
    }


}
