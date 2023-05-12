package com.servicios.publicos.back.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicios.publicos.back.app.domain.models.MaterialCiudad;

@Repository
public interface MaterialCiudadRepository extends JpaRepository<MaterialCiudad, Integer> {

	Long deleteByIdMaterial(int idMaterial);
}
