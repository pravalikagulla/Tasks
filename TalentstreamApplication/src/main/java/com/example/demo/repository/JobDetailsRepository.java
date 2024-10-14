package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.JobPost;

public interface JobDetailsRepository  extends JpaRepository <JobPost, Integer>{

	

}
