package com.example.nunez.usuarios.controller;
import com.example.nunez.usuarios.models.entity.Alumno;
import com.example.nunez.usuarios.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @GetMapping
    public ResponseEntity<?> listarAlumno() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id) {
        Optional<Alumno> ob = service.findById(id);
        if (ob.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(ob.get());
    }

    @PostMapping("/alumnosCrear")
    public ResponseEntity<?> crear(@RequestBody Alumno alumno) {
        Alumno alumnoDb = service.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Alumno alumno) {
        Optional<Alumno> ob = service.findById(id);
        if (ob.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        Alumno alumnoBd = ob.get();
        alumnoBd.setNombre(alumno.getNombre());
        alumnoBd.setApellido(alumno.getApellido());
        alumnoBd.setEmail(alumno.getEmail());
        Alumno updatedAlumno = service.save(alumnoBd);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedAlumno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
