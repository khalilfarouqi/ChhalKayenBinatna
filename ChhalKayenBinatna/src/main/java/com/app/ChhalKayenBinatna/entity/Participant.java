package com.app.ChhalKayenBinatna.entity;

import com.app.ChhalKayenBinatna.enums.*;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name="Participants")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String login;
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles roles;
    private String tel;
    private String email;
    @Enumerated(EnumType.STRING)
    private Country country;
}
