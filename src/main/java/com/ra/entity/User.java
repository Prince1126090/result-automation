package com.ra.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "ra_user")
public class User extends BaseEntity {

    @NotBlank
    @Column(unique = true)
    private String username;
    @NotBlank
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
    private String instituteName;
    private String description;
    private String address;

}
