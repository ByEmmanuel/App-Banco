package PersistenceJPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
/*
 * Clase de la que se obtiene el EntityManager y la conexion a
 * el archivo de la base de datos (Persistance.xml)
 */
public class JpaUtils {
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("AppleBank");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}
