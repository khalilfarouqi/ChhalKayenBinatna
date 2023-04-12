package com.app.ChhalKayenBinatna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseJpaRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
}
