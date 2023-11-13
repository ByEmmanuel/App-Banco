package PersistenceJPA;

import jakarta.persistence.*;


@Entity
@Table(name = "JPAusuarios")
public class JPAclientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, insertable = false)
    private Long id;

    private String nombre;
    private String email;

    private String contraseña;

    private String fechaDeNacimiento;
    private String nacionalidad;
    private String telefono;

    @OneToOne(mappedBy = "usuario")
    private int cuenta;

    public JPAclientes() {}

    public JPAclientes(String nombre, String Email, String contraseña, String fechaDeNacimiento, String nacionalidad, String telefono) {
        this.nombre = nombre;
        this.email = Email;
        this.contraseña = contraseña;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public String getContraseña() {
        return contraseña;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*public List<Reservas> getReservas() {
        return reservas;
    }*/
}


