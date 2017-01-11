package com.niwodai.image.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "ImageRecord")
public class ImageRecord {
	
	@Id  
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long ID;
	
	@Column(name = "owner")
	private String owner;

	@Column(name = "repository")
	private String project;
	
	@Column(name = "tag")
	private String tag;
	
	@Column(name = "create_time")
	private String create_time;
	
	@Column(name = "action_time")
	private String action_time;
	
	public long getID() {
		return ID;
	}
	
	public void setID(long id) {
		ID = id;
	}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getCreate_time() {
		return create_time;
	}
	
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	
	public String getAction_time() {
		return action_time;
	}
	
	public void setAction_time(String action_time) {
		this.action_time = action_time;
	}

	@Override
	public String toString() {
		return "ImageRecord [ID=" + ID + ", owner=" + owner + ", project=" + project + ", tag=" + tag + ", create_time="
				+ create_time + ", action_time=" + action_time + "]";
	}

}
