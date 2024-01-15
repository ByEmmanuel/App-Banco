package PersistenceJPA;

import jakarta.persistence.*;

import java.util.List;

/*
 * Clase JPA para la tabla "clientes" de la base de datos
 * con esta clase se crean los objetos que se van a guardar en la base de datos
 */
@Entity
@Table(name = "JPAclientes")
public class JpaClientes {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, insertable = false)
    public Long id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String nacionalidad;
    private String fechaDeNacimiento;
    private String estadoDondeNacio;


    /*@OneToOne(mappedBy = "usuario")
    private CuentaClientes cuenta;*/


    /*
     *APRENDER SOBRE BASE DE DATOS Y RELACIONES
     */
    @OneToOne( mappedBy = "cliente", cascade = CascadeType.ALL)
    //@JoinColumn(name = "usuario_id") // Nombre de la columna que será clave externa (foreign key)
    //@OneToOne(mappedBy = "cliente")  // Cambiado de "usuario" a "usuarios"
    //@JoinColumn(name = "usuario_id")  // Cambiado de "usuario" a "usuario_id"
    private JpaLoginUsuarios loginUsuario;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<JpaCuentas> cuentas;
    public JpaClientes() {}

    public JpaClientes(String nombre, String primerApellido, String segundoApellido, String nacionalidad, String fechaDeNacimiento, String estadoDondeNacio ) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nacionalidad = nacionalidad;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.estadoDondeNacio = estadoDondeNacio;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPrimerApellido() {
        return primerApellido;
    }
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }
    public String getSegundoApellido() {
        return segundoApellido;
    }
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    public String getEstadoDondeNacio() {
        return estadoDondeNacio;
    }
    public void setEstadoDondeNacio(String estadoDondeNacio) {
        this.estadoDondeNacio = estadoDondeNacio;
    }

    public JpaLoginUsuarios getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(JpaLoginUsuarios loginUsuario) {
        this.loginUsuario = loginUsuario;
    }
}


