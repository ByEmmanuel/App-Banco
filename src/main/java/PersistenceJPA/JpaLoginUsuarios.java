package PersistenceJPA;

import jakarta.persistence.*;

/*
 * Clase que representa la tabla "LoginUsuarios" de la base de datos
 * y se usa para registrar los datos de los logins de los clientes
 */
@Entity
@Table(name = "JPAloginUsuarios")
public class JpaLoginUsuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(updatable = false, insertable = false)
    public Long id;
    public String nombre_usuario;
    private String email;
    private String contraseña;
    private String numeroDeTelefono;
    private String preguntaDeSeguridad;
    private String respuestaDeSeguridad;


    @OneToOne
    @JoinColumn(name = "id_cliente")  // Cambiado de "usuario" a "usuario_id"
    private JpaClientes cliente;

    public JpaLoginUsuarios() {
    }

    public JpaLoginUsuarios(String email, String contraseña, String numeroDeTelefono, String preguntaDeSeguridad, String respuestaDeSeguridad) {
        this.email = email;
        this.contraseña = contraseña;
        this.numeroDeTelefono = numeroDeTelefono;
        this.preguntaDeSeguridad = preguntaDeSeguridad;
        this.respuestaDeSeguridad = respuestaDeSeguridad;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public JpaClientes getUsuario() {
        return cliente;
    }

    public void setUsuario(JpaClientes usuario) {
        this.cliente = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public void setNumeroDeTelefono(String numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
    }

    public String getPreguntaDeSeguridad() {
        return preguntaDeSeguridad;
    }

    public void setPreguntaDeSeguridad(String preguntaDeSeguridad) {
        this.preguntaDeSeguridad = preguntaDeSeguridad;
    }

    public String getRespuestaDeSeguridad() {
        return respuestaDeSeguridad;
    }

    public void setRespuestaDeSeguridad(String respuestaDeSeguridad) {
        this.respuestaDeSeguridad = respuestaDeSeguridad;
    }


}
