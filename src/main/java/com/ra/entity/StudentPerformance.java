package com.ra.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "studentPerformance",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties(value = "studentPerformance")
    private List<Mark> marks = new ArrayList<>();

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Object otherInfo;

}
