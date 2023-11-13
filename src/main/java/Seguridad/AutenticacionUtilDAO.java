package Seguridad;

import PersistenceJPA.JPAclientes;
import PersistenceJPA.JPAcuentas;
import jakarta.persistence.TypedQuery;

import java.util.List;

import static Seguridad.Autenticable.em;

public class AutenticacionUtilDAO {


    private String contraseña;

    public boolean iniciarsesion(String contraseña){
        return this.contraseña == contraseña;
    }

    public void setClave(String contraseña){
        this.contraseña = contraseña;
    }

    public List<JPAclientes> buscarPorEmailYContraseña(String email, String contraseña) {
        String jpql = "SELECT u FROM JPAUsuarios u WHERE u.email = :email AND u.contraseña = :contraseña";
        TypedQuery<JPAclientes> query = em.createQuery(jpql, JPAclientes.class);
        query.setParameter("email", email);
        query.setParameter("contraseña", contraseña);
        return query.getResultList();
    }


}


