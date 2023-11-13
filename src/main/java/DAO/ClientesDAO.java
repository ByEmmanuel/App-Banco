package DAO;


import PersistenceJPA.JPAclientes;
import Seguridad.Autenticable;

public class ClientesDAO implements Autenticable {





    /**
     *
     * @param nombre
     * @param email
     * @param password
     * @param fechaDeNacimiento
     * @param nacionalidad
     * @param telefono
     *
     * ESTE METODO O ALGORITMO ES EL QUE HACE LA IMPLEMENTACION DE REGISTROS A
     * LA BASE DE DATOS
     *
     */
    public void RegistrarUsuario(
            String nombre,
            String email,
            String password,
            String fechaDeNacimiento,
            String nacionalidad,
            String telefono
    ){

        // Ahora puedes usar los valores pasados como parámetros
        JPAclientes usuario = new JPAclientes(
                nombre,
                email,
                password,
                fechaDeNacimiento,
                nacionalidad,
                telefono
        );

        if (email == null){
            //Excepcion por agregar
            throw new RuntimeException();
        }

        // Iniciar una transacción
        em.getTransaction().begin();

        // Persistir la entidad en la base de datos

        em.persist(usuario);

        // Confirmar la transacción
        em.getTransaction().commit();

        // Cerrar el EntityManager y la fábrica de EntityManager
        em.close();

    }



}
