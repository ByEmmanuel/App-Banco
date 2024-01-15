package DAO;

import Interfaces.MetodosRegistro;
import Interfaces.MetodosUserDashBoard;
import PersistenceJPA.JpaCuentas;
import PersistenceJPA.JpaUtils;
import UserRegistration.Controller2;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import javafx.scene.layout.Pane;
import org.hibernate.Session;

/*
 * Esta clase se encarga de realizar las operaciones de la base de datos
 * De parte de operaciones de los usuarios
 */

public class OperacionesDAO implements MetodosUserDashBoard, MetodosRegistro {

    private EntityManager em = JpaUtils.getEntityManager();

    /**
     * En la posicion 0 esta el usuario logeado
     * en la posicion 1 esta el usuario al que se le va a transferir
     */
    private final String[] usuario = new String[2];
    /**
     * En la posicion 0 está el número de tarjeta del usuarioOrigen
     * En la posicion 1 esta el número de cuenta del usuario Destino
     * En la posicion 2 esta el concepto del usuarioOrigen
     *
     */
    private String[] datosTransferencia = new String[5];

    public void inicioSesionUsuario(String usuarioLogeado) {
        this.usuario[0] = usuarioLogeado;
        System.out.println(usuario[0]);

    }

    public String BuscarTarjetaPorTelefono(String numeroDeTelefono) {
        numeroDeTelefono = Controller2.controller2.getNumeroDeCelular();
        String jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTelefono = :numeroDeTelefono";
        TypedQuery<JpaCuentas> query = em.createQuery(jpql, JpaCuentas.class);
        query.setParameter("numeroDeTelefono", numeroDeTelefono);
        try {
            JpaCuentas usuario = query.getSingleResult();
            if (usuario.getNumeroDeTarjeta() == null) {
                return "no hay tarjeta registrada";
            } else {
                String numeroDeTarjetaCompleto = usuario.getNumeroDeTarjeta();
                //Variable es redundante pero se usa para que sea más entendible
                String ultimosCuatroDigitos = numeroDeTarjetaCompleto.substring(numeroDeTarjetaCompleto.length() - 4);
                return ultimosCuatroDigitos;
            }
        } catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el correo dado.
            return null;
        }
    }

    /**
     * Este metodo está actualmente en uso y se usa para buscar el saldo
     * @param numeroDeTelefono
     * @return
     */
    public double BuscarSaldoPorTelefono(String numeroDeTelefono) {
        /*
         * esto se usa para cuando se tenga que utilizar en un
         * controller en especifico
         */
        //numeroDeTelefono = Controller2.controller2.getNumeroDeCelular();
        String jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTelefono = :numeroDeTelefono";
        TypedQuery<JpaCuentas> query = em.createQuery(jpql, JpaCuentas.class);
        query.setParameter("numeroDeTelefono", numeroDeTelefono);
        try {
            JpaCuentas usuario = query.getSingleResult();
            System.out.println("El saldo desde la base de datos es : "+usuario.getSaldo());

            return usuario.getSaldo();
        } catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el correo dado.
            System.out.println("no hay saldo, o ocurrio algún error");
            return 0;
        }
    }
    public double BuscarSaldoPorNombre(String nombre_usuario) {
        /*
         * esto se usa para cuando se tenga que utilizar en un
         * controller en especifico
         */
        try {
            // Inicia la transacción
            em.getTransaction().begin();

            String jpql = "SELECT u FROM JpaCuentas u WHERE u.nombre_usuario = :nombre_usuario";
            TypedQuery<JpaCuentas> query = em.createQuery(jpql, JpaCuentas.class);
            query.setParameter("nombre_usuario", nombre_usuario);

            em.flush();


            JpaCuentas usuario = query.getSingleResult();

            em.refresh(usuario);
            System.out.println("El saldo desde la base de datos es: " + usuario.getSaldo());

            // Commit de la transacción
            em.getTransaction().commit();

            return usuario.getSaldo();
        } catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el correo dado.
            System.out.println("No hay saldo o ocurrió algún error");
            return 0;
        } catch (Exception e) {
            // Manejar otras excepciones
            if (em.getTransaction().isActive()) {
                // Rollback en caso de excepción
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return 0;
        }
    }

    public String BuscarNumCuentaPorTelefono(String numeroDeTelefono) {
        /*
         * esto se usa para cuando se tenga que utilizar en un
         * controller en especifico
         */
        numeroDeTelefono = Controller2.controller2.getNumeroDeCelular();
        String jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTelefono = :numeroDeTelefono";
        TypedQuery<JpaCuentas> query = em.createQuery(jpql, JpaCuentas.class);
        query.setParameter("numeroDeTelefono", numeroDeTelefono);
        try {
            JpaCuentas usuario = query.getSingleResult();
            if (usuario.getNumeroDeCuenta() == null) {
                return "no hay tarjeta registrada";
            } else {
                String numeroDeTarjetaCompleto = usuario.getNumeroDeCuenta();
                //Variable es redundante pero se usa para que sea más entendible
                String ultimosCuatroDigitos = numeroDeTarjetaCompleto.substring(numeroDeTarjetaCompleto.length() - 4);
                return ultimosCuatroDigitos;
            }
        } catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el correo dado.
            System.out.println("no hay saldo");
            return "no hay usuario o ocurrio algún error";
        }
    }

    public String BuscarTipoDeCuentaPorTelefono(String numeroDeTelefono) {
        /*
         * esto se usa para cuando se tenga que utilizar en un
         * controller en especifico
         */
        numeroDeTelefono = Controller2.controller2.getNumeroDeCelular();
        String jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTelefono = :numeroDeTelefono";
        TypedQuery<JpaCuentas> query = em.createQuery(jpql, JpaCuentas.class);
        query.setParameter("numeroDeTelefono", numeroDeTelefono);
        try {
            JpaCuentas usuario = query.getSingleResult();
            if (usuario.getNumeroDeCuenta() == null) {
                return "no hay tarjeta registrada";
            } else {
                String tipoDeCuenta = usuario.getTipoDeCuenta();
                String ultimasCuatroLetras = tipoDeCuenta.substring(tipoDeCuenta.length() - 4);
                //Falta añadir los demás tipos de cuenta
                switch (ultimasCuatroLetras) {
                    case "dito":
                        return "CRE";
                    case "orro":
                        return "AH";
                    case "ques":
                        return "CHEQ";
                    case "mina":
                        return "NOM";
                    case "sion":
                        return "INVE";
                    case "teca":
                        return "HIP";
                    case "guro":
                        return "SEG";
                    case "tiro":
                        return "RET";
                    default:
                        return "Ah";
                }
                //return "· " + ultimasCuatroLetras;
            }
        } catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el correo dado.
            System.out.println("no hay saldo");
            return "no hay usuario o ocurrio algún error";
        }
    }

    /**
     * ESTOS METODOS SE USAN PARA BUSCAR USUARIOS CUANDO EL USUARIO
     * QUIERE HACER ALGUNA TRANSFERENCIA A OTRA CUENTA Y USA ALGUNO DE ESTOS
     * METODOS
     *
     * @param numeroDeCuenta
     */
    public String BuscarUsuarioPorNumeroDeCuenta(String numeroDeCuenta) {
        System.out.println(numeroDeCuenta);
        String jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroDeCuenta = :numero_de_cuenta";

        TypedQuery<JpaCuentas> query = em.createQuery(jpql, JpaCuentas.class);
        query.setParameter("numero_de_cuenta", numeroDeCuenta);
        try {
            JpaCuentas usuario = query.getSingleResult();
            if (usuario.getNumeroDeCuenta() == null) {
                return "No hay cuenta o ocurrio algún error";
            } else {
                cargarPaginaImporte();
                String nombreUsuario = usuario.getNombre_usuario();
                importe.setUsuarioDestino(nombreUsuario);

                System.out.println(nombreUsuario);
                datosTransferencia();
                return nombreUsuario;
            }
        } catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el correo dado.
            System.out.println("no hay Numero de cuenta");
            return "no hay usuario o ocurrio algún error";
        }
    }

    public String BuscarUsuarioPorTelefono(String numeroDeTelefono) {
        System.out.println(numeroDeTelefono);
        String jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTelefono = :numeroDeTelefono";

        TypedQuery<JpaCuentas> query = em.createQuery(jpql, JpaCuentas.class);
        query.setParameter("numeroDeTelefono", numeroDeTelefono);
        try {
            JpaCuentas usuario = query.getSingleResult();
            if (usuario.getNumeroDeCuenta() == null) {
                return "No hay cuenta o ocurrio algún error";
            } else {
                cargarPaginaImporte();
                String nombreUsuario = usuario.getNombre_usuario();
                importe.setUsuarioDestino(nombreUsuario);
                System.out.println(nombreUsuario);
                datosTransferencia();
                return nombreUsuario;
            }
        } catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el correo dado.
            System.out.println("no hay Numero de cuenta");
            return "no hay usuario o ocurrio algún error";
        }
    }

    public String BuscarUsuarioPorTarjeta(String numeroDeTarjeta) {
        System.out.println(numeroDeTarjeta);
        String jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTarjeta = :numeroDeTarjeta";

        TypedQuery<JpaCuentas> query = em.createQuery(jpql, JpaCuentas.class);
        query.setParameter("numeroDeTarjeta", numeroDeTarjeta);
        try {
            JpaCuentas usuario = query.getSingleResult();
            if (usuario.getNumeroDeCuenta() == null) {
                return "No hay cuenta o ocurrio algún error";
            } else {
                cargarPaginaImporte();
                String nombreUsuario = usuario.getNombre_usuario();
                importe.setUsuarioDestino(nombreUsuario);
                System.out.println(nombreUsuario);
                datosTransferencia();
                return nombreUsuario;
            }
        } catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el correo dado.
            System.out.println("no hay Numero de cuenta");
            return "no hay usuario o ocurrio algún error";
        }
    }

    public String BuscarUsuarioPorCLABE(String numeroCLABE) {
        System.out.println(numeroCLABE);
        String jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroCLABE = :numeroCLABE";

        TypedQuery<JpaCuentas> query = em.createQuery(jpql, JpaCuentas.class);
        query.setParameter("numeroCLABE", numeroCLABE);
        try {
            JpaCuentas usuario = query.getSingleResult();
            if (usuario.getNumeroDeCuenta() == null) {
                return "No hay cuenta o ocurrio algún error";
            } else {
                cargarPaginaImporte();
                String nombreUsuario = usuario.getNombre_usuario();
                importe.setUsuarioDestino(nombreUsuario);
                System.out.println(nombreUsuario);
                datosTransferencia();
                return nombreUsuario;
            }
        } catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el correo dado.
            System.out.println("no hay Numero de cuenta");
            return "no hay usuario o ocurrio algún error";
        }
    }

    String jpql;
    String jpql2;

    /**
     * ESTE METOD0 SE USA PARA DEPOSITAR SOLAMENTE, TIENE COMO PARAMETROS
     * LOS NOMBRES DE LAS ENTIDADES DE LA CLASE JpaCuentas
     *
     * @param numeroADepositar
     * @param cantidad
     */
    public void Depositar(String numeroADepositar, double cantidad) {
        //Este metodo se usa para Depositar dinero a una cuenta

        String parametro;
        if (numeroADepositar.matches("[0-9].{3,8}")) {
            String numeroDeCuenta = numeroADepositar;
            parametro = "numero_de_cuenta";
            jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroDeCuenta = :numero_de_cuenta";
            //jpql = "SELECT u FROM JpaCuentas u WHERE u."+numeroADepositar+" = :numero_de_cuenta";
        } else if (numeroADepositar.matches("[0-9].{9}")) {
            String numeroDeTelefono = numeroADepositar;
            parametro = "numeroDeTelefono";
            jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTelefono = :numeroDeTelefono";
        } else if (numeroADepositar.matches("[0-9].{15}")) {
            String numeroDeTarjeta = numeroADepositar;
            parametro = "numero_de_tarjeta";
            jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTarjeta = :numero_de_tarjeta";
        } else if (numeroADepositar.matches("[0-9].{17}")) {
            String numeroCLABE = numeroADepositar;
            parametro = "numeroCLABE";
            jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroCLABE = :numeroCLABE";
        } else {
            //throw new ErrorDesconocido(pane,"No se encontro el destinatario");
            throw new RuntimeException();
        }
        TypedQuery<JpaCuentas> query = em.createQuery(jpql, JpaCuentas.class);
        query.setParameter(parametro, numeroADepositar);
        try {
            JpaCuentas usuario = query.getSingleResult();
            if (usuario.getNumeroDeCuenta() == null) {
                System.out.println("No hay cuenta o ocurrio algún error");
            } else {
                double saldoActual = usuario.getSaldo();
                double saldoNuevo = saldoActual + cantidad;
                usuario.setSaldo(saldoNuevo);
                em.getTransaction().begin();
                em.merge(usuario);
                em.getTransaction().commit();
                System.out.println("Se depositaron " + cantidad + " pesos a la cuenta " + numeroADepositar);
            }
        } catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el correo dado.
            System.out.println("no hay Numero de cuenta");
        }
    }

    /**
     * ESTE METODO ES DE PRUEBA POR SI EL METODO DE ARRIBA NO FUNCIONA
     *
     * @param numeroDeTelefono
     * @param cantidad
     */
    public void depositarPrueba(String numeroDeTelefono, double cantidad) {
        //Este metodo se usa para Depositar dinero a una cuenta

        String parametro;

        jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTelefono = :numero_de_cuenta";
        parametro = "numero_de_cuenta";
        //jpql = "SELECT u FROM JpaCuentas u WHERE u."+numeroADepositar+" = :numero_de_cuenta";

        TypedQuery<JpaCuentas> query = em.createQuery(jpql, JpaCuentas.class);
        query.setParameter(parametro, numeroDeTelefono);
        try {
            JpaCuentas usuario = query.getSingleResult();
            if (usuario.getNumeroDeCuenta() == null) {
                System.out.println("No hay cuenta o ocurrio algún error");
            } else {
                double saldoActual = usuario.getSaldo();
                double saldoNuevo = saldoActual + cantidad;
                usuario.setSaldo(saldoNuevo);
                em.getTransaction().begin();
                em.merge(usuario);
                em.getTransaction().commit();
                System.out.println("Se depositaron " + cantidad + " pesos a la cuenta " + numeroDeTelefono);
            }
        } catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el correo dado.
            System.out.println("no hay Numero de cuenta");
        }
    }

    /**
     *  METODO PARA TRANSFERIR DINERO A OTRA CUENTA
     * @param pane
     * @param cuentaOrigen
     * @param cuentaDestino
     * @param cantidad
     * @deprecated 
     * @return
     */
    public boolean transferir(Pane pane, String cuentaOrigen, String cuentaDestino, double cantidad) {
        //String usuarioLogeado = usuario[0];
        cuentaOrigen  = "0001";
        //String numeroDeTarjeta  = "15252730163438050";
        cuentaDestino = "0401026210568342";

        //cuentaOrigen = usuario[0];
        System.out.println(cuentaOrigen);
        String parametro;
        String parametro2;
        double saldoActual = BuscarSaldoPorTelefono("0001");
        //Esto no tiene valores porque el metodo directamente llama a la base de datos y tiene parametros
        //solo por si necesito la funcion en otro metodo
        if (cuentaDestino.matches("[0-9].{3,8}")) {
            String numeroDeCuenta = cuentaDestino;
            parametro = "numero_de_cuenta";
            jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroDeCuenta = :numero_de_cuenta";
            //jpql = "SELECT u FROM JpaCuentas u WHERE u."+numeroADepositar+" = :numero_de_cuenta";
        } else if (cuentaDestino.matches("[0-9].{9}")) {
            String numeroDeTelefono = cuentaDestino;
            parametro = "numeroDeTelefono";
            jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTelefono = :numeroDeTelefono";
        } else if (cuentaDestino.matches("[0-9].{15}")) {
            String numeroDeTarjeta = cuentaDestino;
            parametro = "numero_de_tarjeta";
            jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTarjeta = :numero_de_tarjeta";
        } else if (cuentaDestino.matches("[0-9].{17}")) {
            String numeroCLABE = cuentaDestino;
            parametro = "numeroCLABE";
            jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroCLABE = :numeroCLABE";
        } else {
            //throw new ErrorDesconocido(pane,"No se encontro el destinatario");
            throw new RuntimeException();
        }

        if (cuentaOrigen.matches("[0-9].{1,8}")) {
            String numeroDeCuenta = cuentaOrigen;
            parametro2 = "numero_de_cuenta";
            jpql2 = "SELECT u FROM JpaCuentas u WHERE u.numeroDeCuenta = :numero_de_cuenta";
            //jpql = "SELECT u FROM JpaCuentas u WHERE u."+numeroADepositar+" = :numero_de_cuenta";
        } else if (cuentaOrigen.matches("[0-9].{9}")) {
            String numeroDeTelefono = cuentaOrigen;
            parametro2 = "numeroDeTelefono";
            jpql2 = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTelefono = :numeroDeTelefono";
        } else if (cuentaOrigen.matches("[0-9].{15}")) {
            String numeroDeTarjeta = cuentaOrigen;
            parametro2 = "numero_de_tarjeta";
            jpql2 = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTarjeta = :numero_de_tarjeta";
        } else if (cuentaOrigen.matches("[0-9].{17}")) {
            String numeroCLABE = cuentaOrigen;
            parametro2 = "numeroCLABE";
            jpql2 = "SELECT u FROM JpaCuentas u WHERE u.numeroCLABE = :numeroCLABE";
        } else {
            //throw new ErrorDesconocido(pane,"No se encontro el destinatario");
            throw new RuntimeException();
        }
        TypedQuery<JpaCuentas> query = em.createQuery(jpql, JpaCuentas.class);
        query.setParameter(parametro, cuentaDestino);
        JpaCuentas cuentaDestinoEntity = query.getSingleResult();
        //try {
            if (cuentaDestinoEntity.getNumeroDeCuenta() == null) {
                System.out.println("No hay cuenta o ocurrio algún error");
                return false;
            } else {
                TypedQuery<JpaCuentas> query2 = em.createQuery(jpql2, JpaCuentas.class);
                query2.setParameter(parametro2, cuentaOrigen);
                JpaCuentas cuentaOrigenEntity = query2.getSingleResult();
                if (saldoActual > cantidad &&  saldoActual > 0 && cantidad > 0){
                    // Realizar la transferencia

                    //cuentaOrigenEntity.setSaldo(cuentaOrigenEntity.getSaldo().subtract(cantidad));
                    //cuentaDestinoEntity.setSaldo(cuentaDestinoEntity.getSaldo().add(cantidad));
                    em.getTransaction().begin();

                    cuentaOrigenEntity.setSaldo(cuentaOrigenEntity.getSaldo() - cantidad);
                    cuentaDestinoEntity.setSaldo(cuentaDestinoEntity.getSaldo() + cantidad);

                    // Actualizar las entidades en la base de datos
                    em.merge(cuentaOrigenEntity);
                    em.merge(cuentaDestinoEntity);

                    // Confirmar la transacción
                    em.getTransaction().commit();

                    System.out.println("Transferencia exitosa");
                    return true;
                } else {
                    System.out.println("Fondos insuficientes en la cuenta de origen");
                    return false;
                }
            }
        /*
        } catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el correo dado.
            System.out.println("Ha Ocurrido Algún error");
            return false;
        }
         */

    }

    /**
     * Este metodo es para transferir dinero a otra cuenta
     * @param pane
     * @param cuentaOrigen
     * @param cuentaDestino
     * @param cantidad
     * @return
     */
    public boolean transferirDOS(Pane pane, String cuentaOrigen, String cuentaDestino, double cantidad) {
        //String usuarioLogeado = usuario[0];
        cuentaOrigen = datosTransferencia[0];
        //String numeroDeTarjeta  = "15252730163438050";
        cuentaDestino = datosTransferencia[1];
        //

        if (cuentaOrigen == null || cuentaDestino == null){
            cuentaOrigen = clientesDAO.getNumeroTelefonoUsuario();
        }


        //cuentaOrigen = usuario[0];
        System.out.println(cuentaOrigen);
        String parametro;
        String parametro2;
        /**
         * Buscar saldo por telefono lo tengo que cambiar a buscar saldo usuario por
         * medio de la cuenta origen como parametro :)
         * @deprecated
         */
        double saldoActual = BuscarSaldoPorTelefono(cuentaOrigen);
        //Esto no tiene valores porque el metodo directamente llama a la base de datos y tiene parametros
        //solo por si necesito la funcion en otro metodo
        if (cuentaOrigen.matches("[0-9].{1,8}")) {
            String numeroDeCuenta = cuentaOrigen;
            parametro = "numero_de_cuenta";
            jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroDeCuenta = :numero_de_cuenta";
            //jpql = "SELECT u FROM JpaCuentas u WHERE u."+numeroADepositar+" = :numero_de_cuenta";
        } else if (cuentaOrigen.matches("[0-9].{9}")) {
            String numeroDeTelefono = cuentaOrigen;
            parametro = "numeroDeTelefono";
            jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTelefono = :numeroDeTelefono";
        } else if (cuentaOrigen.matches("[0-9].{15}")) {
            String numeroDeTarjeta = cuentaOrigen;
            parametro = "numero_de_tarjeta";
            jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTarjeta = :numero_de_tarjeta";
        } else if (cuentaOrigen.matches("[0-9].{17}")) {
            String numeroCLABE = cuentaOrigen;
            parametro = "numeroCLABE";
            jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroCLABE = :numeroCLABE";
        } else {
            //throw new ErrorDesconocido(pane,"No se encontro el destinatario");
            throw new RuntimeException();
        }

        /**
         * CUENTA DESTINO
         */

        if (cuentaDestino.matches("[0-9].{3,8}")) {
            String numeroDeCuenta = cuentaDestino;
            parametro2 = "numero_de_cuenta";
            jpql2 = "SELECT u FROM JpaCuentas u WHERE u.numeroDeCuenta = :numero_de_cuenta";
            //jpql = "SELECT u FROM JpaCuentas u WHERE u."+numeroADepositar+" = :numero_de_cuenta";
        } else if (cuentaDestino.matches("[0-9].{9}")) {
            String numeroDeTelefono = cuentaDestino;
            parametro2 = "numeroDeTelefono";
            jpql2 = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTelefono = :numeroDeTelefono";
        } else if (cuentaDestino.matches("[0-9].{15}")) {
            String numeroDeTarjeta = cuentaDestino;
            parametro2 = "numero_de_tarjeta";
            jpql2 = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTarjeta = :numero_de_tarjeta";
        } else if (cuentaDestino.matches("[0-9].{17}")) {
            String numeroCLABE = cuentaDestino;
            parametro2 = "numeroCLABE";
            jpql2 = "SELECT u FROM JpaCuentas u WHERE u.numeroCLABE = :numeroCLABE";
        } else {
            //throw new ErrorDesconocido(pane,"No se encontro el destinatario");
            throw new RuntimeException();
        }

        TypedQuery<JpaCuentas> query = em.createQuery(jpql, JpaCuentas.class);
        query.setParameter(parametro, cuentaOrigen);
        JpaCuentas cuentaOrigenEntity = query.getSingleResult();
        //try {
        if (cuentaOrigenEntity.getNumeroDeCuenta() == null) {
            System.out.println("No hay cuenta o ocurrio algún error");
            return false;
        } else {
            TypedQuery<JpaCuentas> query2 = em.createQuery(jpql2, JpaCuentas.class);
            query2.setParameter(parametro2,cuentaDestino);
            JpaCuentas cuentaDestinoEntity = query2.getSingleResult();
            if (saldoActual > cantidad && saldoActual > 0 && cantidad > 0) {
                // Realizar la transferencia

                //cuentaOrigenEntity.setSaldo(cuentaOrigenEntity.getSaldo().subtract(cantidad));
                //cuentaDestinoEntity.setSaldo(cuentaDestinoEntity.getSaldo().add(cantidad));
                em.getTransaction().begin();

                cuentaOrigenEntity.setSaldo(cuentaOrigenEntity.getSaldo() - cantidad);
                cuentaDestinoEntity.setSaldo(cuentaDestinoEntity.getSaldo() + cantidad);

                // Actualizar las entidades en la base de datos
                em.merge(cuentaOrigenEntity);
                em.merge(cuentaDestinoEntity);

                // Confirmar la transacción
                em.getTransaction().commit();

                System.out.println("Transferencia exitosa");
                return true;
            } else {
                System.out.println("Fondos insuficientes en la cuenta de origen");
                return false;
            }
        }
        /*
        } catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el correo dado.
            System.out.println("Ha Ocurrido Algún error");
            return false;
        }
         */
    }

    /**
     * Este metodo es para transferir dinero a otra cuenta y está actualmente en uso
     * @param pane
     * @param cuentaOrigen
     * @param cuentaDestino
     * @param cantidad
     * @param transferir
     * @return
     */
    public boolean transferirDOS(Pane pane,String cuentaOrigen,String cuentaDestino, double cantidad, Boolean transferir) {
        if (transferir == true){
            // Aqui se obtiene el numero de telefono del usuario logeado
            String numeroDeTelefonoOrigen = clientesDAO.BuscarNombrePorTelefono(mainLayout,cuentaOrigen);

            //cuentaOrigen = usuario[0];
            System.out.println("Cuenta origen = ; "+cuentaOrigen);
            System.out.println("Cuenta destino = ; "+cuentaDestino);
            String parametro;
            String parametro2;
            /**
             * Buscar saldo por telefono lo tengo que cambiar a buscar saldo usuario por
             * medio de la cuenta origen como parametro :)
             * @deprecated
             */
            double saldoActual = BuscarSaldoPorTelefono("0001");
            //Esto no tiene valores porque el metodo directamente llama a la base de datos y tiene parametros
            //solo por si necesito la funcion en otro metodo
            if (cuentaOrigen.matches("[0-9].{0,8}")) {
                String numeroDeCuenta = cuentaOrigen;
                parametro = "numero_de_cuenta";
                jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroDeCuenta = :numero_de_cuenta";
                //jpql = "SELECT u FROM JpaCuentas u WHERE u."+numeroADepositar+" = :numero_de_cuenta";
            } else if (cuentaOrigen.matches("[0-9].{9}")) {
                String numeroDeTelefono = cuentaOrigen;
                parametro = "numeroDeTelefono";
                jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTelefono = :numeroDeTelefono";
            } else if (cuentaOrigen.matches("[0-9].{15}")) {
                String numeroDeTarjeta = cuentaOrigen;
                parametro = "numero_de_tarjeta";
                jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTarjeta = :numero_de_tarjeta";
            } else if (cuentaOrigen.matches("[0-9].{17}")) {
                String numeroCLABE = cuentaOrigen;
                parametro = "numeroCLABE";
                jpql = "SELECT u FROM JpaCuentas u WHERE u.numeroCLABE = :numeroCLABE";
            } else {
                //throw new ErrorDesconocido(pane,"No se encontro el destinatario");
                throw new RuntimeException("No se encontro el destinatario");
            }

            /**
             * CUENTA DESTINO
             */

            if (cuentaDestino.matches("[0-9].{3,8}")) {
                String numeroDeCuenta = cuentaDestino;
                parametro2 = "numero_de_cuenta";
                jpql2 = "SELECT u FROM JpaCuentas u WHERE u.numeroDeCuenta = :numero_de_cuenta";
                //jpql = "SELECT u FROM JpaCuentas u WHERE u."+numeroADepositar+" = :numero_de_cuenta";
            } else if (cuentaDestino.matches("[0-9].{9}")) {
                String numeroDeTelefono = cuentaDestino;
                parametro2 = "numeroDeTelefono";
                jpql2 = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTelefono = :numeroDeTelefono";
            } else if (cuentaDestino.matches("[0-9].{15}")) {
                String numeroDeTarjeta = cuentaDestino;
                parametro2 = "numero_de_tarjeta";
                jpql2 = "SELECT u FROM JpaCuentas u WHERE u.numeroDeTarjeta = :numero_de_tarjeta";
            } else if (cuentaDestino.matches("[0-9].{17}")) {
                String numeroCLABE = cuentaDestino;
                parametro2 = "numeroCLABE";
                jpql2 = "SELECT u FROM JpaCuentas u WHERE u.numeroCLABE = :numeroCLABE";
            } else {
                //throw new ErrorDesconocido(pane,"No se encontro el destinatario");
                throw new RuntimeException();
            }

            TypedQuery<JpaCuentas> query = em.createQuery(jpql, JpaCuentas.class);
            query.setParameter(parametro, cuentaOrigen);
            JpaCuentas cuentaOrigenEntity = query.getSingleResult();
            //try {
            if (cuentaOrigenEntity.getNumeroDeCuenta() == null) {
                System.out.println("No hay cuenta o ocurrio algún error");
                return false;
            } else {
                TypedQuery<JpaCuentas> query2 = em.createQuery(jpql2, JpaCuentas.class);
                query2.setParameter(parametro2,cuentaDestino);
                JpaCuentas cuentaDestinoEntity = query2.getSingleResult();
                if (saldoActual > cantidad && saldoActual > 0 && cantidad > 0) {
                    // Realizar la transferencia

                    //cuentaOrigenEntity.setSaldo(cuentaOrigenEntity.getSaldo().subtract(cantidad));
                    //cuentaDestinoEntity.setSaldo(cuentaDestinoEntity.getSaldo().add(cantidad));
                    em.getTransaction().begin();

                    cuentaOrigenEntity.setSaldo(cuentaOrigenEntity.getSaldo() - cantidad);
                    cuentaDestinoEntity.setSaldo(cuentaDestinoEntity.getSaldo() + cantidad);

                    // Actualizar las entidades en la base de datos
                    em.merge(cuentaOrigenEntity);
                    em.merge(cuentaDestinoEntity);

                    // Confirmar la transacción
                    em.flush();  // Hacer un flush para sincronizar con la base de datos
                    em.getTransaction().commit();

                    System.out.println("Transferencia exitosa");
                    return true;
                } else {
                    System.out.println("Fondos insuficientes en la cuenta de origen");
                    return false;
                }
            }
        /*
        } catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el correo dado.
            System.out.println("Ha Ocurrido Algún error");
            return false;
        }
         */
            /**
             * Este metodo hay que probarlo más ya qué está dentro de un if
             */
        } else {
            System.out.println("Se cancelo la operación");
            return false;
        }
    }

    private void setUsuarioDestino(String usuarioDestino){

    }
    /**
     *  Este metodo es para llamar al tipo de usuario al que quieres obtener el nombre
     *
     * @param usuario
     * @return si es 0 es el usuario logeado, si es 1 es el usuario destino
     */
    public String getUsuario(int usuario) {
        if (usuario == 0) {
            return this.usuario[0];
        } else{
            System.out.println(this.usuario[1]);
            return this.usuario[1];
        }
    }



    /**
     * Este metodo no se ejecuta correectamente
     * @deprecated
     */
    private void datosTransferencia(){
        this.datosTransferencia[0] = controller2.getNumeroDeCelular();
        this.datosTransferencia[1] = nuevoDestinatario.getDatosTransferenciaDestino();
    }
}
