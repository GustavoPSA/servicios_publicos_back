package com.servicios.publicos.back.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicios.publicos.back.app.domain.models.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {

}
