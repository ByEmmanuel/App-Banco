package Seguridad;

import PersistenceJPA.JpaUtils;
import jakarta.persistence.EntityManager;

/*
 * Capa de seguridad
 */
public interface Autenticable {
    EntityManager em = JpaUtils.getEntityManager();

    default EntityManager getEntityManager() {
        return em;
    }
}

