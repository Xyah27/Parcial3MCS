package com.nunez.usuario.repository;

import models.entity.Alumno;

import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
}
