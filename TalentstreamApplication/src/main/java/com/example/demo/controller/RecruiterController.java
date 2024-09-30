package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.JobPostDetailsDTO;
import com.example.demo.Dto.RecruiterDTO;
import com.example.demo.Dto.RecruiterLoginDTO;
import com.example.demo.Service.RecruiterService;
import com.example.demo.entity.APIResponse;
import com.example.demo.validation.UniqueEmailValidator;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/Recruiter")
public class RecruiterController {
    
@Autowired
 RecruiterService recruiterservice;

   @PostMapping("/Recruiterregistration")
   public ResponseEntity<APIResponse<RecruiterDTO>> createRecruiter(@Valid @RequestBody RecruiterDTO recruiterDTO) {    
       RecruiterDTO savedRecruiter = recruiterservice.createRecruiter(recruiterDTO);
        return new ResponseEntity<>(new APIResponse<>("Recruiter saved successfully", savedRecruiter, HttpStatus.CREATED.value()), HttpStatus.CREATED);
    }
   @PostMapping("/RecruiterLogin")
   public ResponseEntity<APIResponse<RecruiterDTO>> recruiterlogin(@Valid @RequestBody RecruiterLoginDTO logindto) {
     RecruiterDTO recruiterlogin = recruiterservice.loginRecruiter(logindto);
	return new ResponseEntity<>(new APIResponse<>("login success", recruiterlogin,HttpStatus.OK.value()),HttpStatus.OK);
    
   }
   @GetMapping("/Recruiteremail/{email}")
	   public ResponseEntity<APIResponse<RecruiterDTO>> getRecruiterByEmail(@PathVariable String email){
		RecruiterDTO recruiteremail = recruiterservice.getRecruiterByEmail(email);
		return new ResponseEntity<>(new APIResponse<>("recruiter found sucessfully",recruiteremail, HttpStatus.OK.value()), HttpStatus.OK);
   }
   @GetMapping("/Recruiterid/{id}")
   public ResponseEntity<APIResponse<RecruiterDTO>> getRecruiterById(@PathVariable int id){
	RecruiterDTO recruiterdetails = recruiterservice.getRecruiterById(id);
	return new ResponseEntity<>(new APIResponse<>("recruiter found sucessfully",recruiterdetails, HttpStatus.OK.value()), HttpStatus.OK);
}
   @PutMapping("/UpdateRecruiterdetails/{email}")
   public ResponseEntity<APIResponse<RecruiterDTO>> updateRecruiterDetails(@PathVariable String email, @RequestBody RecruiterDTO updateRecruiterDto){
		RecruiterDTO updatedrecruiter = recruiterservice.updateRecruiterDetails(email,updateRecruiterDto);
		return new ResponseEntity<>(new APIResponse<>("details updated sucessfully",updatedrecruiter, HttpStatus.OK.value()), HttpStatus.OK);
	}
  @DeleteMapping("/DeleteRecruiterdetails/{email}")
  public ResponseEntity<APIResponse<RecruiterDTO>> deleteRecruiterBYEmail(@PathVariable String email){
	 String responsemessage  = recruiterservice.deleteRecruiterByEmail(email);
	  return new ResponseEntity<>(new APIResponse<>(responsemessage,null,HttpStatus.OK.value()),HttpStatus.OK);
  } 

  @PostMapping("/postjob/{email}")
  public ResponseEntity<APIResponse<JobPostDetailsDTO>>postJob(@PathVariable  String email, @RequestBody @Valid JobPostDetailsDTO jobPostDetailsDTO) {
      JobPostDetailsDTO createdJob = recruiterservice.postJob(email, jobPostDetailsDTO);
      return new ResponseEntity<>(new APIResponse<>("job created sucessfully",createdJob,HttpStatus.OK.value()), HttpStatus.CREATED);
}
}


        
      

