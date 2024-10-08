package pe.edu.cibertec.sw_t2_pena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.sw_t2_pena.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
}
