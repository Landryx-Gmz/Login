package mypc.login.persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mypc.login.logica.Rol;
import mypc.login.logica.Usuario;
import mypc.login.persistencia.exceptions.NonexistentEntityException;

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

    public void borrarUsuario(int id_usuario) {
        try {
            usuJpa.destroy(id_usuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    
    
    
}
