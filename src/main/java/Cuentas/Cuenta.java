package Cuentas;

import java.util.Random;


/**
 * Clase que representa las cuentas bancarias
 *
 */
public class Cuenta{
/*
    protected double saldo;
    private Cuenta numeroDeCuenta;
    private JPAclientes titular = new JPAclientes();
    public int getSaldo;
    private static int total;
    //Constructor
    public Cuenta() {

    }

    public Cuenta(Cuenta numero)throws Exception{
        if (numero <= 0){
            throw new Exception();
        }else{
            this.numeroDeCuenta = numero;
        }
        Cuenta.total = Cuenta.this.numeroDeCuenta;

        System.out.println("Aqui se crea la cuenta con numero; " + getTotal() + " Titular; " + titular.getNombre());
    }



    //no retorna valor
    public abstract void Depositar(double valor);

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
            destino.Depositar(valor);
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

    *//*public void setAgencia(int agencia) {
        if (agencia > 0 ){
            this.agencia = agencia;
        }else{
            System.out.println("No estan permitidos valores negativos");
        }
    }
    public int getAgencia(){
        return agencia;
    }
    *//*


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
    }*/

    //public abstract void Depositar(double valor);
    public static String setNumeroDeCuenta() {
        String fixedDigits = "1000"; // Los primeros 4 dígitos que siempre serán los mismos
        Random random = new Random();
        long randomNumber = (long) (Math.pow(4,5) * random.nextDouble());
        //String sixteenDigitNumber =  String.format("%12d", randomNumber)  ;
        String sixteenDigitNumber =   String.valueOf(fixedDigits + randomNumber);
        System.out.println("Numero de cuenta; "+sixteenDigitNumber);
        return sixteenDigitNumber;
    }
    public static String setNumeroCLABE() {
    String CLABE;
    do {
        String fixedDigits = "1000"; // Los primeros 4 dígitos que siempre serán los mismos
        Random random = new Random();
        long randomNumber = (long) (Math.pow(12, 13) * random.nextDouble());
        CLABE = fixedDigits + String.format("%012d", randomNumber);

    } while (CLABE.length() < 17 && CLABE.length() >= 19);
        System.out.println("Numero CLABE; "+ CLABE);
        if (CLABE.length() > 18){
            System.out.println("El numero es mayor a 18");
            CLABE = CLABE.substring(0, 18);
            System.out.println("Nuevo numero CLABE; "+ CLABE);
        }
        return CLABE;
    }
    public  static String setNumeroDeTarjeta() {
        String fixedDigits = "0401"; // Los primeros 4 dígitos que siempre serán los mismos
        Random random = new Random();
        long randomNumber = (long) (Math.pow(10, 11) * random.nextDouble());
        String sixteenDigitNumber = fixedDigits + String.format("%012d", randomNumber);
        System.out.println("Numero de tarjeta; "+sixteenDigitNumber);
        if (sixteenDigitNumber.length() > 16 || sixteenDigitNumber.length() < 16){
            System.out.println("El numero es mayor a 16");
            sixteenDigitNumber = sixteenDigitNumber.substring(0, 16);
            System.out.println("Nuevo numero de tarjeta; "+sixteenDigitNumber);
        }
        return sixteenDigitNumber;
    }


        public static void main(String[] args) {
            //System.out.println(setNumeroDeCuenta());
            //System.out.println(setNumeroDeTarjeta());
            //System.out.println(setNumeroCLABE());
        }
}
