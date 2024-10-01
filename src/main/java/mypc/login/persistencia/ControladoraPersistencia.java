package mypc.login.persistencia;

import java.util.List;
import mypc.login.logica.Rol;
import mypc.login.logica.Usuario;

public class ControladoraPersistencia {
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();

    public List<Usuario> traerUsuarios() {
        List<Usuario> listaUsuarios = usuJpa.findUsuarioEntities();
        return listaUsuarios;
        //SELECT *  FROM USUARIOS
    }

    public List<Rol> traerRoles() {
        return rolJpa.findRolEntities();
    }

    public void crearUsuario(Usuario usu) {
        usuJpa.create(usu);
    }
    
    
    
    
}
