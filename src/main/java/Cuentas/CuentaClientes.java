package Cuentas;

public class CuentaClientes {


    private int numeroDeCuenta; //AutoGenerado
    //Este es el numero de cuenta que se le asigna al cliente
    private String titular; //Insertar el nombre del cliente
    //Este es el nombre del cliente que posee la cuenta
    private double saldo; //Insertar el saldo inicial de la cuenta
    //Este es el saldo que posee la cuenta
    private static int totalTarjetas;
    //Este es el total de tarjetas que posee el cliente
    private String tipoDeCuenta;
    //Este es el tipo de cuenta que posee el cliente (ahorro, credito, debito o nomina)

    public CuentaClientes() {
    }

    public CuentaClientes(int numeroDeCuenta, String titular, double saldo, String tipoDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public int getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(int numeroDeCuenta) {
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
        CuentaClientes.totalTarjetas = totalTarjetas;
    }

    public String getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    public void setTipoDeCuenta(String tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }
}
