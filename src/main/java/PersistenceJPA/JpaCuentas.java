package PersistenceJPA;

import jakarta.persistence.*;

@Entity
@Table(name = "JPAcuentas")
public class JpaCuentas {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, insertable = false)
    private Long id; //AutoGenerado
    //Este es el numero de cuenta que se le asigna al cliente
    private String titular; //Insertar el nombre del cliente
    //Este es el nombre del cliente que posee la cuenta
    private double saldo; //Insertar el saldo inicial de la cuenta
    //Este es el saldo que posee la cuenta
    private static int totalTarjetas;
    //Este es el total de tarjetas que posee el cliente
    private String tipoDeCuenta;
    //Este es el tipo de cuenta que posee el cliente (ahorro, credito, debito o nomina)
    private String firmaUsuario;
    //Esta es la firma del usuario que posee la cuenta
    private String nombre_usuario;


    @Column(name = "numero_de_cuenta", length = 16)
    private String numeroDeCuenta;  // Representación del número de cuenta como cadena de 16 dígitos

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private JpaClientes cliente;
    public JpaCuentas() {
    }


    public JpaCuentas(String numeroDeCuenta , double saldo, String tipoDeCuenta, String firmaUsuario) {
        this.numeroDeCuenta = numeroDeCuenta;
        //this.titular = titular;
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

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
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
