package com.app.ChhalKayenBinatna.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="Operations")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Operation {
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "groupOperation_id")
    private GroupOperation groupOperation;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "participant_id")
    private Participant participant;
}
