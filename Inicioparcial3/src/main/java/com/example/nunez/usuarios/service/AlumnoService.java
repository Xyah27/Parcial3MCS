package com.example.nunez.usuarios.service;

import com.example.nunez.usuarios.models.entity.Alumno;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface AlumnoService {
    Iterable<Alumno> findAll();
    Optional<Alumno> findById(Long id);
    Alumno save(Alumno alumno);
    void deleteById(Long id);
}
