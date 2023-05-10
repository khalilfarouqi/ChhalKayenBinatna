package com.app.ChhalKayenBinatna.rest.api;

import com.app.ChhalKayenBinatna.dto.WalletDto;
import com.app.ChhalKayenBinatna.entity.Wallet;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Tag(name = "Wallet", description = "REST API for Wallet information")
@RequestMapping("/v1/wallet")
public interface WalletApi extends BaseApi<Wallet, WalletDto> {

}
