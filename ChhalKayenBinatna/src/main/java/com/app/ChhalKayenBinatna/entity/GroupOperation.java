package com.app.ChhalKayenBinatna.entity;

import com.app.ChhalKayenBinatna.enums.OperationType;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="GroupOperations")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class GroupOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String createBy;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createOn;
    private String updateBy;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date updateOn;
    private String name;
    private OperationType operationType;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "participant_id")
    private Participant participant;
}
