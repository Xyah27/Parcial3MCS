package com.co.usuario.repository;
import com.co.commonservice.models.entity.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
}
