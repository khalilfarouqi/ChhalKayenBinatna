package com.app.ChhalKayenBinatna.rest.controller;

import com.app.ChhalKayenBinatna.service.impl.IBaseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public abstract class BaseController<E, D extends Serializable> {
    public abstract IBaseService<E, D> getService();

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public D save(@RequestBody D dto) {
        return getService().save(dto);
    }

    @PutMapping()
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public D update(@RequestBody D dto) {
        return getService().update(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        this.getService().delete(id);
    }

    @GetMapping("/{id}")
    public D getById(@PathVariable("id") Long id) {
        return this.getService().findById(id);
    }

    @GetMapping()
    public List<D> findAll(){
        return this.getService().findAll();
    }
}
