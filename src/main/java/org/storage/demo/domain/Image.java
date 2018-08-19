package org.storage.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Image")
public class Image {
	
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

	@Override
	public String toString() {
		return "Image [ID=" + ID + ", owner=" + owner + ", project=" + project + ", tag=" + tag + "]";
	}
	
}
