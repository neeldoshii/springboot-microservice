package com.neeldoshi.first_spring_project.job;

import java.util.List;

public interface JobService {

    List<Jobs> findAll();

    void createJob(Jobs job);

    Jobs getJobById(int id);
}
