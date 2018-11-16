package pe.edu.tecsup.apirest.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.tecsup.apirest.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
