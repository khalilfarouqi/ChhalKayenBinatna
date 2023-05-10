package com.app.ChhalKayenBinatna.rest.api;

import com.app.ChhalKayenBinatna.dto.OperationDto;
import com.app.ChhalKayenBinatna.entity.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Tag(name = "Operation", description = "REST API for Operation information")
@RequestMapping("/v1/operation")
public interface OperationApi extends BaseApi<Operation, OperationDto> {
}
