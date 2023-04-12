package com.app.ChhalKayenBinatna.dto;

import com.app.ChhalKayenBinatna.enums.Currency;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WalletDto {
    private Long id;
    private Double total;
    private Currency currency;
}
