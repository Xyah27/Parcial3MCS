package com.co.usuario.service;

import com.example.libreria.service.CommonService;
import com.co.commonservice.models.entity.Alumno;


import java.util.Optional;

public interface AlumnoService extends CommonService<Alumno> {
    public Alumno save(Alumno alumno);
    public void deleteById(Long id);
}