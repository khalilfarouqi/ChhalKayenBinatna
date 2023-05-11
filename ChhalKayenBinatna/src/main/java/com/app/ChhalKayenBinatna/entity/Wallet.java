package com.app.ChhalKayenBinatna.entity;

import com.app.ChhalKayenBinatna.enums.Currency;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Wallets")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double total;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;
}
