package com.app.ChhalKayenBinatna.dto;

import com.app.ChhalKayenBinatna.enums.Currency;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WalletDto implements Serializable {
    private Long id;
    private Double total;
    private Currency currency;
    private ParticipantDto participantDto;
}
