package PersistenceJPA;

import jakarta.persistence.EntityManager;

public class PruebaDaoClientes {

    String nombreUsuario;
    public void ObtenerNombre(long id){

      EntityManager em = JpaUtils.getEntityManager();
      
      nombreUsuario = em.find(JpaClientes.class, id).getNombre();
    };
    
}
