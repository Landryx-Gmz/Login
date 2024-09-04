package mypc.login.persistencia;

import java.util.List;
import mypc.login.logica.Usuario;

public class ControladoraPersistencia {
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();

    public List<Usuario> traerUsuarios() {
        return usuJpa.findUsuarioEntities();
        //SELECT *  FROM USUARIOS
    }
    
    
    
    
}
