package pe.edu.tecsup.apirest.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.tecsup.apirest.models.Estado;
@Repository

public interface EstadoRepository extends JpaRepository<Estado, Serializable> {
	
	public abstract Estado findById(Long id);
}
