package mypc.login.logica;

import java.util.List;
import mypc.login.persistencia.ControladoraPersistencia;

public class Controladora {
    
    ControladoraPersistencia controlPersis ;

    public Controladora() {
        controlPersis = new ControladoraPersistencia();
    }
    
    

    public Usuario validarUsuario(String usuario, String contrasenia) {
        
        //String mensaje ="";
        Usuario usr = null ;
        List<Usuario>listaUsuario = controlPersis.traerUsuarios();
        
        for(Usuario usu: listaUsuario) {
            System.out.println("Usuario: " + usu.getNombreUsuario());
            if(usu.getNombreUsuario().equals(usuario)) {
                if(usu.getContrasenia().equals(contrasenia)) {
                    //mensaje = "Usuario y contraseña correctos. Bienvenido/a!";
                    usr = usu;
                    return  usr;                    
                }
                else{
                    //mensaje = "Contraseña incorrecta";
                    usr = null;
                    return  usr;
                }
            }
            else{
                //mensaje = "Usuario no encontrado";
                //return mensaje;
                usr = null;
                //return  usr;
            }
        }
        return  usr; 
        
    
    }

    

    
    
    
}
