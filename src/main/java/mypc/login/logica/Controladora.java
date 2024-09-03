package mypc.login.logica;

import java.util.List;
import mypc.login.persistencia.ControladoraPersistencia;

public class Controladora {
    
    ControladoraPersistencia controlPersis ;

    public Controladora() {
        controlPersis = new ControladoraPersistencia();
    }
    
    

    public String validarUsuario(String usuario, String contrasenia) {
        
        String mensaje ="";
        List<Usuario>listaUsuario = controlPersis.traerUsuarios();
        
        for(Usuario usu: listaUsuario) {
            System.out.println("Usuario: " + usu.getNombreUsuario());
            if(usu.getNombreUsuario().equals(usuario)) {
                if(usu.getContraseña().equals(contrasenia)) {
                    mensaje = "Usuario y contraseña correctos. Bienvenido/a!";
                    return  mensaje;                    
                }
                else{
                    mensaje = "Contraseña incorrecta";
                    return  mensaje;
                }
            }
            else{
                mensaje = "Usuario no encontrado";
            }
        }
        return  mensaje; 
        
    
    }
    
    
}
