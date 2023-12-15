package DAO;

import PersistenceJPA.JpaCuentas;
import PersistenceJPA.JpaLoginUsuarios;
import PersistenceJPA.JpaUtils;
import UserRegistration.Controller5;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class OperacionesDAO {

private EntityManager em = JpaUtils.getEntityManager();

    public String BuscarTarjeta(String tarjeta) {
        tarjeta = Controller5.getNombre();
        String jpql = "SELECT u FROM JPAcuentas u WHERE u.nombre = :nombre";
        TypedQuery<JpaCuentas> query = em.createQuery(jpql, JpaCuentas.class);
        query.setParameter("nombre", tarjeta);
        try {
            JpaCuentas usuario = query.getSingleResult();
            if (usuario.getNombre_usuario() == null){
                throw new RuntimeException("No se encontro el usuario");
            }else {
                System.out.println("Usuario encontrado");
            }
            return usuario.getNombre_usuario();
        } catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el correo dado.
            return null; // Puedes devolver null u otra indicación de que no se encontró el usuario.
        }
    }
}
