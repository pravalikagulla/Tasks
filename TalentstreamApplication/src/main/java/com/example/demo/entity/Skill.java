package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Skill {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private String skill;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getSkill() {
	return skill;
}

public void setSkill(String skill) {
	this.skill = skill;
}
public Skill() {
}

public Skill(int id, String skill) {
	this.id = id;
	this.skill = skill;
}



}
