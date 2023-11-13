package Seguridad;

import PersistenceJPA.JPAUtils;
import PersistenceJPA.JPAclientes;
import jakarta.persistence.EntityManager;

public interface Autenticable {
    EntityManager em = JPAUtils.getEntityManager();

}

