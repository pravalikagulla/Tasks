package com.example.demo.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.JobPostDetailsEntity;
import com.example.demo.entity.Recruiter;
import com.example.demo.entity.Skill;
import com.example.demo.exception.CustomException;
import com.example.demo.repository.JobDetailsRepository;
import com.example.demo.repository.RecruiterRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.Dto.JobPostDetailsDTO;
import com.example.demo.Dto.RecruiterDTO;
import com.example.demo.Dto.RecruiterLoginDTO;
import com.example.demo.Dto.SkillDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecruiterService {
@Autowired  
private  RecruiterRepository recruiterRep; 
@Autowired 
private JobDetailsRepository jobPostRepo;
@Autowired
private SkillRepository skillRepo;


   
   public RecruiterDTO createRecruiter(RecruiterDTO recruiterdto) { 
	   if (recruiterRep.existsByEmail(recruiterdto.getEmail()))
			   {
		   throw new CustomException("email","email already exists");
			   }
	     recruiterRep.save(toEntity(recruiterdto));
	   return recruiterdto;
   }
   
	 public Recruiter toEntity(RecruiterDTO recruiterdto) {
	   Recruiter  recruiter = new Recruiter();
	 recruiter.setCompanyname(recruiterdto.getCompanyname());
	   recruiter.setEmail(recruiterdto.getEmail());
	   recruiter.setMobileNumber(recruiterdto.getMobileNumber());
	   recruiter.setPassword(recruiterdto.getPassword());
	   return recruiter; 
   } 
   public RecruiterDTO toDto(Recruiter recruiter) {
	   RecruiterDTO  recruiterDTO = new RecruiterDTO();
	   recruiterDTO.setCompanyname(recruiter.getCompanyname());
	   recruiterDTO.setEmail(recruiter.getEmail());
	   recruiterDTO.setMobileNumber(recruiter.getMobileNumber());
	   recruiterDTO.setPassword(recruiter.getPassword());
	   return recruiterDTO;
   }
	   
  public RecruiterDTO loginRecruiter(RecruiterLoginDTO loginDTO) {
	    Optional<Recruiter> Recruiter = recruiterRep.findByEmail(loginDTO.getEmail());
	    if (Recruiter.isPresent()) {
	     Recruiter recruiter = Recruiter.get();
	    if (recruiter.getPassword().equals(loginDTO.getPassword())) {
	      return toDto(recruiter);
	        } 
	     else {
	           throw new CustomException("Password", "Incorrect password");
	        }
	    } else {
	        throw new CustomException("Email", "No account found with this email address");
	    }
  }
  public RecruiterDTO getRecruiterByEmail(String email) {
  Recruiter recruiter = recruiterRep.findByEmail(email)
                                     .orElseThrow(() -> new CustomException("Email", "No account found with this email address"));
	  return toDto(recruiter);
	  }
public RecruiterDTO getRecruiterById(int id) {
	Recruiter recruiter = recruiterRep.findById(id)
			                           .orElseThrow(() -> new CustomException("id", "no account found with this id"));
	return toDto(recruiter);
}
public String deleteRecruiterByEmail(String email) {
	 Recruiter recruiter =recruiterRep.findByEmail(email)
                                      .orElseThrow(() -> new CustomException("email", "no account found with this email"));
      recruiterRep.delete(recruiter);
			                        
	return "deleted sucessfully";
}

public RecruiterDTO updateRecruiterDetails(String email, RecruiterDTO updateRecruiterDto) {
	Recruiter existingrecruiter = recruiterRep.findByEmail(email)
			                          .orElseThrow(() -> new CustomException("email", "no account found"));
	if(updateRecruiterDto.getCompanyname()!=null && !updateRecruiterDto.getCompanyname().isEmpty()) {
		existingrecruiter.setCompanyname(updateRecruiterDto.getCompanyname());
	}
	if(updateRecruiterDto.getMobileNumber()!=null && !updateRecruiterDto.getMobileNumber().isEmpty()) {
		existingrecruiter.setMobileNumber(updateRecruiterDto.getMobileNumber());
	}
	if(updateRecruiterDto.getPassword()!=null && !updateRecruiterDto.getPassword().isEmpty()) {
		existingrecruiter.setPassword(updateRecruiterDto.getPassword());
	}
	recruiterRep.save(existingrecruiter);
	return toDto(existingrecruiter);
}

public  JobPostDetailsDTO postJob(String email, JobPostDetailsDTO jobPostDto){
	Recruiter recruiter = recruiterRep.findByEmail(email)
			                           .orElseThrow(() -> new CustomException("email","no account found"));
	List<Skill> getSkills = new ArrayList<Skill>();
	for(SkillDTO skillName: jobPostDto.getSkills()) {
	if(skillRepo.existsBySkill(skillName.getSkill()).isPresent()) {
		getSkills.add(skillRepo.existsBySkill(skillName.getSkill()).get());
		
	}
		else {
			Skill skill = new Skill();
			skill .setSkill(skillName.getSkill());
			skill = skillRepo.save(skill);
			getSkills.add(skill);	
			}
  }
	jobPostDto.setSkills(getSkills());
	JobPostDetailsEntity jobpost = toJobEntity(jobPostDto);
	JobPostDetailsEntity postJob= jobPostRepo.save(jobpost);
	List<JobPostDetailsEntity> jobDetails = recruiter.getJobPosts();
	jobDetails.add(postJob);
	recruiter.setJobPosts(jobDetails);
	recruiterRep.save(recruiter);
	return toJobDto(postJob);
}



public JobPostDetailsEntity toJobEntity(JobPostDetailsDTO jobPostDTO) {
	  JobPostDetailsEntity jobPost = new JobPostDetailsEntity();
jobPost.setJobTitle(jobPostDTO.getJobTitle());
jobPost.setJobDescription(jobPostDTO.getJobDescription());
jobPost.setMinimumExperience(jobPostDTO.getMinimumExperience());
jobPost.setMaximumExperience(jobPostDTO.getMaximumExperience());
jobPost.setMinimumSalary(jobPostDTO.getMinimumSalary());
jobPost.setMaximumSalary(jobPostDTO.getMaximumSalary());
jobPost.setQualification(jobPostDTO.getQualification());
jobPost.setSpecialization(jobPostDTO.getSpecialization());
jobPost.setLocation(jobPostDTO.getLocation());
jobPost.setIndustryType(jobPostDTO.getIndustryType());
jobPost.setJobType(jobPostDTO.getJobType());
jobPost.setSkills(jobPost.getSkills());
return jobPost;
}

public JobPostDetailsDTO toJobDto(JobPostDetailsEntity jobPost){
	JobPostDetailsDTO jobPostdto = new JobPostDetailsDTO();
jobPost.setJobTitle(jobPost.getJobTitle());
jobPost.setJobDescription(jobPost.getJobDescription());
jobPost.setMinimumExperience(jobPost.getMinimumExperience());
jobPost.setMaximumExperience(jobPost.getMaximumExperience());
jobPost.setMinimumSalary(jobPost.getMinimumSalary());
jobPost.setMaximumSalary(jobPost.getMaximumSalary());
jobPost.setQualification(jobPost.getQualification());
jobPost.setSpecialization(jobPost.getSpecialization());
jobPost.setLocation(jobPost.getLocation());
jobPost.setIndustryType(jobPost.getIndustryType());
jobPost.setJobType(jobPost.getJobType());
jobPost.setSkills(jobPost.getSkills());
return jobPostdto;
}

}

