package com.ra.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "student_performance")
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)
public class StudentPerformance extends BaseEntity {

    @NotNull
    private Integer year;
    @NotNull
    private Integer studentClass;
    @NotBlank
    private String section;
    @NotNull
    private Integer roll;

    @NotBlank
    private String exam;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String marks;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String otherInfo;

}