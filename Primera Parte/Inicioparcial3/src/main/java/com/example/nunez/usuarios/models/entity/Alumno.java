package com.example.nunez.usuarios.models.entity;

import jakarta.persistence.*; // Para las anotaciones de JPA como @Entity, @Table, @Id, etc.
import lombok.*; // Para las anotaciones de Lombok como @Getter, @Setter, @NoArgsConstructor, etc.

import java.util.Date; // Para manejar la fecha de creación del registro.

@Getter
@Setter
@Table(name = "alumnos")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Alumno {

    /**
     * Identificador único del registro de la tabla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String email;

    /**
     * Fecha de creación del registro
     */
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    /**
     * Método que se ejecuta antes de que se persista una entidad
     * en la base de datos por primera vez, asignando la fecha actual.
     */
    @PrePersist
    private void prePersist() {
        this.createAt = new Date();
    }
}
