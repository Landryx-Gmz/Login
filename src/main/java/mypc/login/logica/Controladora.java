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
            //System.out.println("Usuario: " + usu.getNombreUsuario());
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

    public List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }

    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }

    public void crearUsuario(String usuario, String contra, String rolRecibido) {
        
        Usuario usu = new Usuario();
        usu.setNombreUsuario(usuario);
        usu.setContraseña(contra);
        
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        if (rolEncontrado!=null){
            usu.setUnRol(rolEncontrado);
        }
        
        int id = this.buscarUltimaIdUsuarios();
        usu.setId(id+1);
        
        controlPersis.crearUsuario(usu);
        
    }

    private Rol traerRol(String rolRecibido) {
        List<Rol> listaRoles =controlPersis.traerRoles();
        
        for(Rol rol:listaRoles) {
            if (rol.getNombreRol().equals(rolRecibido)) {
                return rol;                
            }
        } 
        return null;
    }

    private int buscarUltimaIdUsuarios() {
        List<Usuario> listaUsuarios = this.traerUsuarios();
        
        Usuario usu = listaUsuarios.get(listaUsuarios.size()-1);        
        return  usu.getId();
        
    }

    public void borrarUsuario(int id_usuario) {
        
        controlPersis.borrarUsuario(id_usuario);
    }

    

    
    
    
}
