package com.app.ChhalKayenBinatna.dto;

import com.app.ChhalKayenBinatna.enums.OperationType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupOperationDto implements Serializable {
    private Long id;
    private String createBy;
    private Date createOn;
    private String updateBy;
    private Date updateOn;
    private String name;
    private OperationType operationType;
    private ParticipantDto participantDto;
}
