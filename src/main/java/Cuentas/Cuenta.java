package Cuentas;

import PersistenceJPA.JPAclientes;

public abstract class Cuenta{

    protected double saldo;
    private int numeroDeCuenta;
    private JPAclientes titular = new JPAclientes();
    public int getSaldo;
    private static int total;
    //Constructor
    public Cuenta() {

    }

    public Cuenta(int numero)throws Exception{
        if (numero <= 0){
            throw new Exception();
        }else{
            this.numeroDeCuenta = numero;
        }
        Cuenta.total = Cuenta.this.numeroDeCuenta;

        System.out.println("Aqui se crea la cuenta con numero; " + getTotal() + " Titular; " + titular.getNombre());
    }



    //no retorna valor
    public abstract void depositar(double valor);

    public void retirar(double valor) throws Exception{
        if (this.saldo < valor ) {

            throw new Exception("Saldo disponible; " +  this.saldo + ". saldo a retirar; " + valor);
        }
        this.saldo -= valor;
        System.out.println("Saldo retirado; " + valor);

    }
    public boolean transferir(double valor, Cuenta destino)throws Exception{
        if(this.saldo >= valor){
            this.retirar(valor);
            destino.depositar(valor);
            System.out.println("Nuevo saldo en la cuenta; " + this.saldo );
            return true;
        }else{
            throw new Exception("Saldo disponible; " +  this.saldo + ". saldo a transferir; " + valor);

        }

    }



    public int getnumero(){
        return this.numeroDeCuenta;
    }

    public void setnumero(int numero){
        if (numero > 0){
            this.numeroDeCuenta = numero;
        }
    }

    /*public void setAgencia(int agencia) {
        if (agencia > 0 ){
            this.agencia = agencia;
        }else{
            System.out.println("No estan permitidos valores negativos");
        }
    }
    public int getAgencia(){
        return agencia;
    }
    */


    public void setSaldo(int valor) {
        this.saldo = valor;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public static int getTotal(){
        return Cuenta.total;
    }

    public void saldoDespues(){
        System.out.println(this.saldo );
    }



    @Override
    public boolean equals(Object obj){
        Cuenta cuenta = (Cuenta) obj;
        return this.numeroDeCuenta == getnumero();
    }
}
