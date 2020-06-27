package com.ra.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @NotNull
    private String username;
    @NotNull
    private String password;

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
    @Past
    private Date dateOfBirth;
    private String presentAddress;

    public enum Gender {
        MALE, FEMALE, OTHER
    }

}
