package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Dto.SkillDTO;
import com.example.demo.entity.Skill;

public interface SkillRepository  extends JpaRepository<Skill, Integer>{
	Optional<Skill> existsBySkill(String skillName);

	

}
