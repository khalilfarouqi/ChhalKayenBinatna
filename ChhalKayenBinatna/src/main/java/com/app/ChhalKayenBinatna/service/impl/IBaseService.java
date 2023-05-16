package com.app.ChhalKayenBinatna.service.impl;

import javassist.NotFoundException;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<E, D extends Serializable> extends IRsqlService<E, D> {
    D save(D dto);
    D update(D dto) throws NotFoundException;
    void delete(Long id);
    D findById(Long id);
    List<D> findAll();
}
