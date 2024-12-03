package nunez.example.curso.repository;

import org.springframework.data.repository.CrudRepository;
import models.entity.Curso;

public interface CursoRepository  extends CrudRepository<Curso, Long> {
}
