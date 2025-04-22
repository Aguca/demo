package repositorio;

import modelo.EntidadUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioServicioUsuario extends JpaRepository<EntidadUsuario, Long> {

    EntidadUsuario findByEmail(String email);
    EntidadUsuario findByDni (String dni);

}
