package com.app.ChhalKayenBinatna.rest.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public interface BaseApi<E, D extends Serializable> {
    @Operation(
            summary = "Entity Get API",
            description = "Entity Get API")
    @ApiResponse(
            responseCode = "200",
            description = "200 IS OK")
    @GetMapping("/{id}")
    D getById(@PathVariable("id") Long id);
}
