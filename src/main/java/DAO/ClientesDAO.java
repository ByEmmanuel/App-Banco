package DAO;


import Cuentas.Cuenta;
import Excepciones.ErrorDesconocido;
import PersistenceJPA.JpaCuentas;
import UserRegistration.Controller5;
import PersistenceJPA.JpaClientes;
import PersistenceJPA.JpaLoginUsuarios;
import PersistenceJPA.JpaUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import javafx.scene.layout.Pane;

import static Interfaces.MainInterfaceLogin.controller2;


/*
 * Esta clase se encarga de hacer las operaciones de la base de datos de parte de
 * registro de usuarios
 */
public class ClientesDAO {

    private EntityManager em = JpaUtils.getEntityManager();

    private String nombreUsuario;
    private long idUsuario;
    private String numeroDeCuenta;
    private String numeroDeTarjeta;
    private String numeroCLABE;
    private static boolean validacion1 = false;
    private static boolean validacion2 = false;

    private static Long[] arrayIdUsuario = new Long[2];
    //private static Long[] arrayIdUsuario2 = new Long[2];


    /**
     * @param nombre
     * @param primerApellido
     * @param segundoApellido
     * @param nacionalidad
     * @param fechaDeNacimiento ESTE METODO O ALGORITMO ES EL QUE HACE LA IMPLEMENTACION DE REGISTROS A
     *                          LA BASE DE DATOS
     */
    /*public void idk( int i ){
        clase clase = new clase(i);

        em.guardar
    }*/
    public void RegistrarDatosUsuario(
            String nombre,
            String primerApellido,
            String segundoApellido,
            //String email,
            //String password,
            String nacionalidad,
            String fechaDeNacimiento,
            String estadoDondeNacio
            //String nacionalidad,
            //String telefono
    ) {
        try {
            // Ahora puedes usar los valores pasados como parámetros
            JpaClientes usuario = new JpaClientes(
                    nombre,
                    primerApellido,
                    segundoApellido,
                    //email,
                    nacionalidad,
                    fechaDeNacimiento,
                    estadoDondeNacio
                    //nacionalidad,
                    //telefono
            );

            // Iniciar una transacción
            em.getTransaction().begin();

            // Persistir la entidad en la base de datos
            em.persist(usuario);

            // Confirmar la transacción
            em.getTransaction().commit();

            arrayIdUsuario[0] = usuario.getId();

            // Mostrar información del usuario
            mostrarDatosUsuario(arrayIdUsuario[0]);
            obtenerNombrePorId(arrayIdUsuario[0]);

            System.out.println("El id del usuario es: " + arrayIdUsuario[0]);

            /*
             * Esta validacion pasa a true para el metodo y poder avanzar con las
             * demas operaciones
             * si es false se deberia de borrar el usuario
             *  DEBERIA
             */
            this.validacion1 = true;
        } catch (Exception e) {
            // Manejar la excepción según tus necesidades
            e.printStackTrace();
        }
    }

    /* 
     * Este metodo registra los datos de inicio de sesion del usuario
     * Si el primer metodo dio error, esto no deberia poder ejecutarse
     * ya que no se podria obtener el id del usuario
     */

    public void RegistrarDatosLoginUsuario(
            String email,
            String contraseña,
            String numeroDeTelefono,
            String preguntaDeSeguridad,
            String respuestaDeSeguridad
            //, Long usuarioId // Debes proporcionar el ID del usuario al que deseas asociar los datos de inicio de sesión
    ) {
        if (verificarTransaccion1()) {
            try {
                JpaLoginUsuarios loginUsuario = new JpaLoginUsuarios(
                        email,
                        contraseña,
                        numeroDeTelefono,
                        preguntaDeSeguridad,
                        respuestaDeSeguridad


                );

                // Obtén la entidad JpaClientes usando el ID proporcionado
                //JpaClientes usuario = em.find(JpaClientes.class, usuarioId);

                /**
                 * Aqui puedo hacer ultimas validaciones
                 */
                if (email == null) {
                    //Excepcion por agregar
                    throw new RuntimeException();
                }

                // Iniciar una transacción
                em.getTransaction().begin();

                // Persistir la entidad en la base de datos

                String nombre_usuario = BuscarPorID(arrayIdUsuario[0]);

                System.out.println("El nombre de usuario es: " + nombre_usuario);

                loginUsuario.setNombre_usuario(nombre_usuario);


                em.persist(loginUsuario);

                // Confirmar la transacción
                em.getTransaction().commit();


                //Long usuarioId = loginUsuario.getId();

                arrayIdUsuario[1] = loginUsuario.getId();
                obtenerNombrePorId(arrayIdUsuario[1]);


                // Cerrar el EntityManager y la fábrica de EntityManager

                /*
                 * esto no se si sirva jaja salu2
                 */
                if (em.getTransaction().getRollbackOnly()) {
                    // no se si sirve esto xd después lo pruebo
                    em.remove(idUsuario);
                    em.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            /*
             * Esta validacion pasa a true para el metodo y poder avanzar con las
             * siguientes operaciones
             *
             */
            this.validacion2 = true;
        } else {
            System.out.println("No se pudo registrar el usuario");
            //Borrar el usuario

        }
    }


    /*
     * Este metodo registra los datos bancarios del usuario
     * Si el segundo metodo dio error, esto no deberia poder ejecutarse 
     * y mucho menos si el segundo dio error
     */

    public void RegistrarDatosBancariosUsuario (
        
            //Long numeroDeCuenta,
            String titular,
            double saldo,
            String tipoDeCuenta,
            String firmaUsuario
            //, Long usuarioId // Debes proporcionar el ID del usuario al que deseas asociar los datos de inicio de sesión
    ){
        if (verificarTransaccion2()){
            try {
                Cuenta cuenta = new Cuenta();
                numeroDeCuenta = cuenta.setNumeroDeCuenta();
                numeroCLABE = cuenta.setNumeroCLABE();
                numeroDeTarjeta = cuenta.setNumeroDeTarjeta();

                JpaCuentas cuentasClientes = new JpaCuentas(
                        numeroDeCuenta, // Añadido automaticamente
                        numeroDeTarjeta,
                        numeroCLABE,
                        //titular, (es añadido automaticamente)
                        saldo, //El usuario debe ingresar un numero no mayor a 200
                        tipoDeCuenta, //El usuario debe ingresar un tipo de cuenta
                        firmaUsuario //El usuario debe ingresar una firma
                );

                // Obtén la entidad JpaClientes usando el ID proporcionado
                //JpaClientes usuario = em.find(JpaClientes.class, usuarioId);



                /**
                 * Aqui puedo hacer ultimas validaciones
                 */
                if (firmaUsuario == null){
                    //Excepcion por agregar
                    throw new RuntimeException();
                }

                // Iniciar una transacción
                em.getTransaction().begin();

                // Persistir la entidad en la base de datos

                // String nombre_usuario = BuscarPorID(arrayIdUsuario[1]);

                // obtenerNombrePorId(arrayIdUsuario[1]);

                // System.out.println("El nombre de usuario es: " + nombre_usuario);

                String nombre_usuario = BuscarPorID(arrayIdUsuario[0]);

                //arrayIdUsuario[1] = cuentasClientes.getId();
                String numeroDeTelefono = BuscarTelefonoPorID(arrayIdUsuario[1]);

                System.out.println("El nombre de usuario es: " + nombre_usuario);
                System.out.println("El Telefono de usuario es: " + numeroDeTelefono);

                cuentasClientes.setNombre_usuario(nombre_usuario);
                cuentasClientes.setNumeroDeTelefono(numeroDeTelefono);

                em.persist(cuentasClientes);

                // Confirmar la transacción
                em.getTransaction().commit();


                // Cerrar el EntityManager y la fábrica de EntityManager

                if(em.getTransaction().getRollbackOnly()){
                    // no se si sirve esto xd después lo pruebo
                    em.remove(idUsuario);
                    em.close();
                }
            obtenerIds();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            System.out.println("No se pudo registrar el usuario");
            //Borrar el usuario

        }

        /*
         * Al final de todos los registros se va a imprimir el id
         * del array donde se guardan los diferentes nombres (por id)
         * de cada registro
         */
    }

    /**
     * Este metodo esta desactualizado
     * @deprecated
     *
     */
    public String BuscarPorNombre(String nombre) {
        nombre = Controller5.getNombre();
        String jpql = "SELECT u FROM JpaClientes u WHERE u.nombre = :nombre";
        TypedQuery<JpaLoginUsuarios> query = em.createQuery(jpql, JpaLoginUsuarios.class);
        query.setParameter("nombre", nombre);
        try {
            JpaLoginUsuarios usuario = query.getSingleResult();
            if (usuario.getNombre_usuario() == null){
                throw new RuntimeException("No se encontro el usuario");
            }else {
                System.out.println("Usuario encontrado");
            }
            return usuario.getNombre_usuario();
        } catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el correo dado.
            return null; // Puedes devolver null u otra indicación de que no se encontró el usuario.
        }
    }

    public String BuscarNombrePorEmail(String email) {
        /*
         * esto se usa para cuando se tenga que utilizar en un
         * controller en especifíco
         */
        //email = Controller5.getNombre();
        String jpql = "SELECT u FROM JpaLoginUsuarios u WHERE u.email = :email";
        TypedQuery<JpaLoginUsuarios> query = em.createQuery(jpql, JpaLoginUsuarios.class);
        query.setParameter("email", email);
        try {
            JpaLoginUsuarios usuario = query.getSingleResult();

            return usuario.getNombre_usuario();
        } catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el correo dado.
            return null;

        }
    }
    public Boolean existeElUsuario(Pane panel,String numeroDeTelefono) {

        /*
         * esto se usa para cuando se tenga que utilizar en un
         * controller en especifico
         */
        //email = Controller5.getNombre();
        String jpql = "SELECT u FROM JpaLoginUsuarios u WHERE u.numeroDeTelefono = :numeroDeTelefono";
        TypedQuery<JpaLoginUsuarios> query = em.createQuery(jpql, JpaLoginUsuarios.class);
        query.setParameter("numeroDeTelefono", numeroDeTelefono);
        try {


            JpaLoginUsuarios usuario = query.getSingleResult();

            if (usuario.getNombre_usuario() == null){
                throw new ErrorDesconocido(panel,"No se encontro el usuario");
            }else {
                return true;
            }
        }catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el correo dado.
            return false;

        }
    }

    public Boolean existeLaContraseña(Pane panel,String contraseña) {

        /*
         * esto se usa para cuando se tenga que utilizar en un
         * controller en especifico
         */
        //email = Controller5.getNombre();
        String jpql = "SELECT u FROM JpaLoginUsuarios u WHERE u.contraseña = :contraseña";
        TypedQuery<JpaLoginUsuarios> query = em.createQuery(jpql, JpaLoginUsuarios.class);
        query.setParameter("contraseña", contraseña);
        try {


            JpaLoginUsuarios usuario = query.getSingleResult();

            if (usuario.getContraseña() == null){
                throw new ErrorDesconocido(panel,"No se encontro el usuario");
            }else {
                return true;
            }
        }catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el correo dado.
            return false;

        }
    }

    String datosUsuario;

    public String getNumeroTelefonoUsuario() {
        return datosUsuario;
    }

    /*
     * este metodo se esta usando actualmente para fines de testeo en la
     * pagina PrincipalDashBoard
     */
    public String BuscarNombrePorTelefono(Pane panel,String numeroDeTelefono) {

        /**
         *
         *   Esto esta desactivado para fines de testeo
         *   ya que si no se carga el controller2
         *   dara error
         *
         *
         */
        numeroDeTelefono = controller2.getNumeroDeCelular();
        datosUsuario = numeroDeTelefono;
        //numeroDeTelefono = "01";
        String jpql = "SELECT u FROM JpaLoginUsuarios u WHERE u.numeroDeTelefono = :numeroDeTelefono";
        TypedQuery<JpaLoginUsuarios> query = em.createQuery(jpql, JpaLoginUsuarios.class);
        query.setParameter("numeroDeTelefono", numeroDeTelefono);

            JpaLoginUsuarios usuario = query.getSingleResult();

            if (usuario.getNombre_usuario() == null){
                throw new ErrorDesconocido(panel,"No se encontro el usuario");
            }else {
                return usuario.getNombre_usuario();
            }

            // Manejar el caso en que no se encontró ningún usuario con el correo dado.



    }
    public boolean coincidenLosDatos(Pane panel,String numeroDeTelefono , String contraseña) {

        /**
         *
         *   Esto esta desactivado para fines de testeo
         *   ya que si no se carga el controller2
         *   dara error
         *
         *
         */
        numeroDeTelefono = controller2.getNumeroDeCelular();
        contraseña = controller2.getContraseña();

        String jpql = "SELECT u FROM JpaLoginUsuarios u WHERE u.numeroDeTelefono = :numeroDeTelefono AND u.contraseña = :contraseña";
        TypedQuery<JpaLoginUsuarios> query = em.createQuery(jpql, JpaLoginUsuarios.class);
        query.setParameter("numeroDeTelefono", numeroDeTelefono);
        query.setParameter("contraseña", contraseña);
        try {
            JpaLoginUsuarios usuario = query.getSingleResult();

            if (usuario.getNombre_usuario() == null){
                throw new ErrorDesconocido(panel,"No se encontro el usuario");
            }else {
                return true;
            }
        }catch (Exception e){
            return false;
        }


    }

    public String BuscarPorID(long id) {
        // No es necesario asignar id = idUsuario; ya que el parámetro id ya tiene el valor correcto

        // Utiliza try-with-resources para asegurar que EntityManager se cierre correctamente
        try {
            // No necesitas instanciar JpaClientes aquí
            String jpql = "SELECT u FROM JpaClientes u WHERE u.id = :id";
            TypedQuery<JpaClientes> query = em.createQuery(jpql, JpaClientes.class);
            query.setParameter("id", id);

            // Siempre maneja las excepciones de manera adecuada
            JpaClientes usuario = query.getSingleResult();

            // Retorna el nombre del usuario encontrado
            return usuario.getNombre();
        } catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el ID dado.
            // Puedes lanzar una excepción personalizada o devolver null según tus necesidades.
            return null;
        }
    }
    public String BuscarTelefonoPorID(long id) {
        // No es necesario asignar id = idUsuario; ya que el parámetro id ya tiene el valor correcto

        // Utiliza try-with-resources para asegurar que EntityManager se cierre correctamente
        try {
            // No necesitas instanciar JpaClientes aquí
            String jpql = "SELECT u FROM JpaLoginUsuarios u WHERE u.id = :id";
            TypedQuery<JpaLoginUsuarios> query = em.createQuery(jpql, JpaLoginUsuarios.class);
            query.setParameter("id", id);

            // Siempre maneja las excepciones de manera adecuada
            JpaLoginUsuarios usuario = query.getSingleResult();

            // Retorna el nombre del usuario encontrado
            return usuario.getNumeroDeTelefono();
        } catch (NoResultException e) {
            // Manejar el caso en que no se encontró ningún usuario con el ID dado.
            // Puedes lanzar una excepción personalizada o devolver null según tus necesidades.
            return null;
        }
    }

    public void mostrarDatosUsuario(Long usuarioId) {
        // Vuelve a abrir el EntityManager
        EntityManager em = JpaUtils.getEntityManager();

        // Busca la entidad JpaClientes por su ID
        JpaClientes usuario = em.find(JpaClientes.class, usuarioId);

        // Comprueba si el usuario se encuentra
        if (usuario != null) {
            // Muestra los datos del usuario
            System.out.println("Datos del Usuario:");
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Primer Apellido: " + usuario.getPrimerApellido());
            System.out.println("Segundo Apellido: " + usuario.getSegundoApellido());
            System.out.println("Nacionalidad: " + usuario.getNacionalidad());
            System.out.println("Fecha de Nacimiento: " + usuario.getFechaDeNacimiento());
            System.out.println("Estado donde Nació: " + usuario.getEstadoDondeNacio());
        } else {
            System.out.println("No se encontró el usuario con ID: " + usuarioId);
        }

        // Cierra el EntityManager
        em.close();
    }


    public void obtenerNombrePorId(long id){

      EntityManager em = JpaUtils.getEntityManager();
      
      nombreUsuario = em.find(JpaClientes.class, id).getNombre();
    }

    public boolean verificarTransaccion1(){
        if(validacion1){
            return true;
        }else {
            return false;
        }
    }
    public boolean verificarTransaccion2(){
        if(validacion2){
            return true;
        }else {
            return false;
        }
    }

    private void obtenerIds(){
        for (int i = 0; i < arrayIdUsuario.length; i++) {
            System.out.println(arrayIdUsuario[i]);
        }


    }
}
