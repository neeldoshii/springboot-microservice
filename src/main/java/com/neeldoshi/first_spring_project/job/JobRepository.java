package com.neeldoshi.first_spring_project.job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Jobs, Integer> {
}
