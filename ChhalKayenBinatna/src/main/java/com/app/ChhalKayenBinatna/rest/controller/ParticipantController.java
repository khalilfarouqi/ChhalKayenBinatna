package com.app.ChhalKayenBinatna.rest.controller;

import com.app.ChhalKayenBinatna.dto.ParticipantDto;
import com.app.ChhalKayenBinatna.entity.Participant;
import com.app.ChhalKayenBinatna.rest.api.ParticipantApi;
import com.app.ChhalKayenBinatna.service.ParticipantService;
import com.app.ChhalKayenBinatna.service.impl.IBaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ParticipantController extends BaseController<Participant, ParticipantDto> implements ParticipantApi {

    private final ParticipantService participantService;

    @Override
    public IBaseService<Participant, ParticipantDto> getService() {
        return participantService;
    }
}
