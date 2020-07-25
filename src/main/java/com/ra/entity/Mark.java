package com.ra.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "marks")
public class Mark extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "student_performance_id")
    private StudentPerformance studentPerformance;

    @NotBlank
    private String subjectName;
    @NotNull
    private BigDecimal totalMark;
    @NotNull
    private BigDecimal obtainedMark;

}
