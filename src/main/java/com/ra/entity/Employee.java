package com.ra.entity;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {

	@NotNull
	private String name;

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^\\+?(88)?0?1[3456789][0-9]{8}\\b")
	private String contactNumber;

	@NotBlank
	@Column(unique = true)
	@Email
	private String email;

	@NotNull
	private Gender gender;

	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@NotNull
	@Past
	private Date dateOfBirth;

	@Lob
	private Byte[] profilePicture;
	
	private ProgrammingLanguage programmingLanguage;
	
	private String presentAddress;

	public enum Gender {
		MALE, FEMALE, OTHER
	}

	public enum ProgrammingLanguage {
		JAVA, PHP, JAVASCRIPT, KOTLIN
	}

}
