package com.co.diaz.commonservice.models.entity;

import com.co.diaz.commonservice.models.entity.Alumno;
import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @PrePersist
    private void prePersist(){
        this.createAt = new Date();
    }

    @OneToMany(fetch = FetchType.LAZY)
    private List<Alumno> ListaAlumno;

    //empty constructor
    public Curso() {
        this.ListaAlumno = new ArrayList<>();
    }

    //constructor with parameters
    public Curso(Long id, String nombre, Date createAt) {
        this.id = id;
        this.nombre = nombre;
        this.createAt = createAt;
        this.ListaAlumno = new ArrayList<>();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public List<Alumno> getListaAlumno() {
        return ListaAlumno;
    }

    public void setListaAlumno(List<Alumno> listaAlumno) {
        ListaAlumno = listaAlumno;
    }


    public void addAlumno(Alumno alumno){
        this.ListaAlumno.add(alumno);
    }

    public void removeAlumno(Alumno alumno){
        this.ListaAlumno.remove(alumno);
    }



    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", createAt=" + createAt +
                '}';
    }

}
