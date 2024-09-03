package mypc.login.persistencia;

import java.util.List;
import mypc.login.logica.Usuario;

public class ControladoraPersistencia {
    UsusarioJpaController usuJpa = new UsusarioJpaController();

    public List<Usuario> traerUsuarios() {
        return usuJpa.findUsusarioEntities();
        //SELECT *  FROM USUARIOS
    }
    
    
    
    
}
