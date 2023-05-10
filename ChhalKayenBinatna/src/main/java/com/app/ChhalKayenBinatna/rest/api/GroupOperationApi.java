package com.app.ChhalKayenBinatna.rest.api;

import com.app.ChhalKayenBinatna.dto.GroupOperationDto;
import com.app.ChhalKayenBinatna.entity.GroupOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Tag(name = "GroupOperation", description = "REST API for GroupOperation information")
@RequestMapping("/v1/groupOperation")
public interface GroupOperationApi extends BaseApi<GroupOperation, GroupOperationDto>{
}
