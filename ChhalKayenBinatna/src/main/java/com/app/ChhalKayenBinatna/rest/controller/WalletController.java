package com.app.ChhalKayenBinatna.rest.controller;

import com.app.ChhalKayenBinatna.dto.WalletDto;
import com.app.ChhalKayenBinatna.entity.Wallet;
import com.app.ChhalKayenBinatna.rest.api.WalletApi;
import com.app.ChhalKayenBinatna.service.WalletService;
import com.app.ChhalKayenBinatna.service.impl.IBaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class WalletController extends BaseController<Wallet, WalletDto> implements WalletApi {

    private final WalletService walletService;

    @Override
    public IBaseService getService() {
        return walletService;
    }
}
