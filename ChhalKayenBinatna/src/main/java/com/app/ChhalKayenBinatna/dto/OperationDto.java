package com.app.ChhalKayenBinatna.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OperationDto {
    private Long id;
    private String createBy;
    private Date createOn;
    private String updateBy;
    private Date updateOn;
    private String name;
}
