package com.app.ChhalKayenBinatna.rest.controller;

import com.app.ChhalKayenBinatna.dto.GroupOperationDto;
import com.app.ChhalKayenBinatna.entity.GroupOperation;
import com.app.ChhalKayenBinatna.rest.api.GroupOperationApi;
import com.app.ChhalKayenBinatna.service.GroupOperationService;
import com.app.ChhalKayenBinatna.service.impl.IBaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class GroupOperationController extends BaseController<GroupOperation, GroupOperationDto> implements GroupOperationApi {

    private final GroupOperationService groupOperationService;

    @Override
    public IBaseService getService() {
        return groupOperationService;
    }
}
