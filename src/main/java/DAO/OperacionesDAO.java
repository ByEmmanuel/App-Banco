package DAO;

import PersistenceJPA.JpaCuentas;
import PersistenceJPA.JpaUtils;
import UserRegistration.Controller2;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

/*
 * Esta clase se encarga de realizar las operaciones de la base de datos
 * De parte de operaciones de los usuarios
 */

public class OperacionesDAO {

private EntityManager em = JpaUtils.getEntityManager();

    public String BuscarTarjetaPorTelefono(String numeroDeTelefono) {
        numeroDeTelefono = Controller2.controller2.getNumeroDeCelular();
    String jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTelefono = :numeroDeTelefono";
    TypedQuery<JpaCuentas> query = em.createQuery(jpql, JpaCuentas.class);
    query.setParameter("numeroDeTelefono", numeroDeTelefono);
    try {
        JpaCuentas usuario = query.getSingleResult();
        if (usuario.getNumeroDeTarjeta() == null) {
            return "no hay tarjeta registrada";
        }else{
            String numeroDeTarjetaCompleto = usuario.getNumeroDeTarjeta();
            String ultimosCuatroDigitos = numeroDeTarjetaCompleto.substring(numeroDeTarjetaCompleto.length() - 4);
            return "· " + ultimosCuatroDigitos;
        }
    } catch (NoResultException e) {
        // Manejar el caso en que no se encontró ningún usuario con el correo dado.
        return null;
    }
}
    public double BuscarSaldoPorTelefono(String numeroDeTelefono) {
        /*
         * esto se usa para cuando se tenga que utilizar en un
         * controller en especifico
         */
    numeroDeTelefono = Controller2.controller2.getContraseña();
        String jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTelefono = :numeroDeTelefono";
        TypedQuery<JpaCuentas> query = em.createQuery(jpql, JpaCuentas.class);
        query.setParameter("numeroDeTelefono", numeroDeTelefono);
        try {
            JpaCuentas usuario = query.getSingleResult();
            return usuario.getSaldo();
        } catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el correo dado.
            System.out.println("no hay saldo, o ocurrio algún error");
            return 0;
        }
    }
    public String BuscarNumCuentaPorTelefono(String numeroDeTelefono) {
        /*
         * esto se usa para cuando se tenga que utilizar en un
         * controller en especifico
         */
        numeroDeTelefono = Controller2.controller2.getContraseña();
        String jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTelefono = :numeroDeTelefono";
        TypedQuery<JpaCuentas> query = em.createQuery(jpql, JpaCuentas.class);
        query.setParameter("numeroDeTelefono", numeroDeTelefono);
        try {
            JpaCuentas usuario = query.getSingleResult();
            if (usuario.getNumeroDeCuenta() == null) {
                return "no hay tarjeta registrada";
            }else {
                String numeroDeTarjetaCompleto = usuario.getNumeroDeCuenta();
                String ultimosCuatroDigitos = numeroDeTarjetaCompleto.substring(numeroDeTarjetaCompleto.length() - 4);
                return "· " + ultimosCuatroDigitos;
            }
        } catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el correo dado.
            System.out.println("no hay saldo");
            return "no hay usuario o ocurrio algún error";
        }
    }
}
