package com.app.ChhalKayenBinatna.rest.controller;

import com.app.ChhalKayenBinatna.dto.OperationDto;
import com.app.ChhalKayenBinatna.entity.Operation;
import com.app.ChhalKayenBinatna.rest.api.OperationApi;
import com.app.ChhalKayenBinatna.service.OperationService;
import com.app.ChhalKayenBinatna.service.impl.IBaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class OperationController extends BaseController<Operation, OperationDto> implements OperationApi {

    private final OperationService operationService;

    @Override
    public IBaseService getService() {
        return operationService;
    }
}
