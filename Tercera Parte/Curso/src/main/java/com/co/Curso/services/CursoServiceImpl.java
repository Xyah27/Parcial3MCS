package com.co.Curso.services;
import com.example.libreria.service.CommonService;
import com.example.libreria.service.CommonServiceImpl;
import com.co.Curso.models.entity.Curso;
import com.co.Curso.repository.CursoRepository;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

}