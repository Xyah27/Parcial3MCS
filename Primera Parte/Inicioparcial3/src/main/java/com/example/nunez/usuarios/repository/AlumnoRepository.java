package com.example.nunez.usuarios.repository;

import com.example.nunez.usuarios.models.entity.Alumno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
    // Los métodos CRUD se generan automáticamente por Spring Data JPA.
}
