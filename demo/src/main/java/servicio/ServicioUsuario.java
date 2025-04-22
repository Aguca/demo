package servicio;


import modelo.EntidadUsuario;

import java.util.List;

public interface ServicioUsuario {
    List<EntidadUsuario> obtenerUsuarios();
    EntidadUsuario obtenerUsuarioPorId(long id);
    EntidadUsuario obtenerUsuarioPorDni (String dni);
    EntidadUsuario obtenerUsuarioPorEmail(String email);
    EntidadUsuario guardarUsuario(EntidadUsuario usuario);
    void eliminarUsuario(Long id);
}
