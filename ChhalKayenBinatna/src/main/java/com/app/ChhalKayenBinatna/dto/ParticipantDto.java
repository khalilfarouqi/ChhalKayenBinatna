package com.app.ChhalKayenBinatna.dto;

import com.app.ChhalKayenBinatna.enums.Country;
import com.app.ChhalKayenBinatna.enums.Roles;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParticipantDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String login;
    private String password;
    private Roles roles;
    private String tel;
    private String email;
    private Country country;
}
