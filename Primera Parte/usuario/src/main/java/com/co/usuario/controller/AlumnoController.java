package com.co.usuario.controller;

import com.co.commonservice.models.entity.Alumno; // Cambia la referencia al modelo correcto.
import com.co.usuario.service.AlumnoService;
import com.example.libreria.controller.CommonController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoService> {

    @Value("${config.balanceador.test}")
    private String balanceadorTest;

    @GetMapping("/balanceador-test")
    public ResponseEntity<?> balanceadorTest() {
        Map<String, Object> response = new HashMap<>();
        response.put("balanceador", balanceadorTest);
        response.put("alumnos", service.findAll());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id) {
        Optional<Alumno> ob = service.findById(id);
        if (ob.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        Alumno alumnoDb = ob.get();
        alumnoDb.setNombre(alumno.getNombre());
        alumnoDb.setApellido(alumno.getApellido());
        alumnoDb.setEmail(alumno.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
    }
}
