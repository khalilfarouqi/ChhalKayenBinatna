package com.app.ChhalKayenBinatna.rest.api;

import com.app.ChhalKayenBinatna.dto.ParticipantDto;
import com.app.ChhalKayenBinatna.entity.Participant;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Tag(name = "Participant", description = "REST API for Participant information")
@RequestMapping("/v1/participant")
public interface ParticipantApi extends BaseApi<Participant, ParticipantDto> {
}
