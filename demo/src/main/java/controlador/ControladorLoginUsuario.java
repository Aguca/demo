package controlador;


import jakarta.servlet.http.HttpSession;
import modelo.EntidadUsuario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import servicio.ServicioUsuario;

import java.util.Map;

@Controller
@RequestMapping("/index")
public class ControladorLoginUsuario {

    private final ServicioUsuario servicioUsuario;

    public ControladorLoginUsuario(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> login (@RequestBody Map<String, String> loginRequest, HttpSession session) {

        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        EntidadUsuario usuario = servicioUsuario.obtenerUsuarioPorEmail(email);

        if (usuario != null && usuario.getContrasena().equals(password)) {

            session.setAttribute("usuarioSesion", usuario);
            System.out.println("Usuario encontrado: " + usuario.getEmail());
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(401).body("Usuario no encontrado");
        }
    }
}
