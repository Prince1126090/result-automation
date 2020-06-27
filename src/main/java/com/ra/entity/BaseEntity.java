package com.ra.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@MappedSuperclass
@Data
public class BaseEntity {

	@Id
	@GeneratedValue
	private Long id;

	private String createdBy;
	@CreationTimestamp
	private Date createdOn;

	private String updatedBy;
	@UpdateTimestamp
	private Date updatedOn;

	private String isDeleted;
}