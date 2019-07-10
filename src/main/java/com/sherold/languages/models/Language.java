package com.sherold.languages.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

// Annotation to recognize class as DB entity
@Entity

// Annotation to assign Entity to a table
@Table(name="languages")
public class Language {
	// <----- Attributes ----->
	@Id // designates object id in table
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increments
	private Long id;
	@Size(min = 2, max = 20)
	private String name;
	@Size(min = 2, max = 20)
	private String creator;
	@NotBlank(message = "Version cannot empty") // Text field cannot be blank or whitespace
	private String version;
	@Column(updatable = false) // column data is immutable after creation
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	// <----- Constructors ----->
	public Language() {
		
	}
	
	public Language(String name, String creator, String version) {
		this.name = name;
		this.creator = creator;
		this.version = version;
	}
	
	// <----- Getters/Setters ----->
	// id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// creator
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	// version
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	// createdAt
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	// updatedAt
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	// <----- Methods ----->
	@PrePersist // Annotation to run before object is instantiated
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate // Annotation to run before object is updated
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
