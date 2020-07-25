package com.ra.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
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
    private StudentPerformance studentPerformance;

    @NotBlank
    private String subjectName;
    @NotNull
    private BigDecimal totalMark;
    @NotNull
    private BigDecimal obtainedMark;

}
