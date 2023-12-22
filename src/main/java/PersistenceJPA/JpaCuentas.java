package PersistenceJPA;

import jakarta.persistence.*;

/*
 * Clase que representa la tabla "cuentas" de la base de datos
 * y se usa para registrar los datos de las cuentas de los clientes
 */
@Entity
@Table(name = "JPAcuentas")
public class JpaCuentas {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, insertable = false)
    private Long id; //AutoGenerado
    //Este es el numero de cuenta que se le asigna al cliente
    private double saldo; //Insertar el saldo inicial de la cuenta
    //Este es el saldo que posee la cuenta
    private static int totalTarjetas;
    //Este es el total de tarjetas que posee el cliente
    private String tipoDeCuenta;
    //Este es el tipo de cuenta que posee el cliente (ahorro, credito, debito o nomina)
    private String firmaUsuario;
    //Esta es la firma del usuario que posee la cuenta
    private String nombre_usuario;
    //Este es el nombre del usuario que posee la cuenta y se introduce en el registro
    private String numeroDeTelefono;
    //Este es el numero de telefono que posee el usuario
    private String numeroCLABE;


    @Column(name = "numero_de_cuenta", length = 19)
    private String numeroDeCuenta;  // Representación del número de cuenta como cadena de 16 dígitos
    @Column(name = "numero_de_tarjeta", length = 16)
    private String numeroDeTarjeta;  // Representación del número de cuenta como cadena de 16 dígitos

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private JpaClientes cliente;
    public JpaCuentas() {
    }


    public JpaCuentas(String numeroDeCuenta ,String numeroDeTarjeta, String CLABE, double saldo, String tipoDeCuenta,String firmaUsuario) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.numeroDeTarjeta = numeroDeTarjeta;
        this.numeroCLABE = CLABE;
        this.saldo = saldo;
        this.tipoDeCuenta = tipoDeCuenta;
        this.firmaUsuario = firmaUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public String getNumeroDeTarjeta() {
        return numeroDeTarjeta;
    }

    public String getCLABE() {
        return numeroCLABE;
    }

    public void setCLABE(String CLABE) {
        this.numeroCLABE = CLABE;
    }

    public void setNumeroDeTarjeta(String numeroDeTarjeta) {
        this.numeroDeTarjeta = numeroDeTarjeta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public static int getTotalTarjetas() {
        return totalTarjetas;
    }

    public static void setTotalTarjetas(int totalTarjetas) {
        JpaCuentas.totalTarjetas = totalTarjetas;
    }

    public String getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    public void setTipoDeCuenta(String tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public void setNumeroDeTelefono(String numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
    }

    public String getFirmaUsuario() {
        return firmaUsuario;
    }

    public void setFirmaUsuario(String firmaUsuario) {
        this.firmaUsuario = firmaUsuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public JpaClientes getCliente() {
        return cliente;
    }

    public void setCliente(JpaClientes cliente) {
        this.cliente = cliente;
    }
}
