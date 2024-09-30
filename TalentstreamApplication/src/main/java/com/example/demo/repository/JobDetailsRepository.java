package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.JobPostDetailsEntity;

public interface JobDetailsRepository  extends JpaRepository <JobPostDetailsEntity, Integer>{

	

}
