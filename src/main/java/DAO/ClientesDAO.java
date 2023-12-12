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

public class ClientesDAO  {

    private EntityManager em = JpaUtils.getEntityManager();

    private String nombreUsuario;
    private long idUsuario;
    private String numeroDeCuenta;

    private static Long[] usuarioRegistrado;


    /**
     *
     * @param nombre
     * @param primerApellido
     * @param segundoApellido
     * @param nacionalidad
     * @param fechaDeNacimiento
     *
     * ESTE METODO O ALGORITMO ES EL QUE HACE LA IMPLEMENTACION DE REGISTROS A
     * LA BASE DE DATOS
     *
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

    ){

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


        



        /*
        JpaLoginUsuarios loginUsuario = new JpaLoginUsuarios();
        loginUsuario.setNombre_usuario(nombre);
        usuario.setLoginUsuario(loginUsuario);
         */

        /**
         * Aqui puedo hacer ultimas validaciones
         * @return
         */
        if (nombre == null){
            //Excepcion por agregar
            throw new RuntimeException();
        }

         // Iniciar una transacción
        em.getTransaction().begin();

        // Persistir la entidad en la base de datos

        em.persist(usuario);

        // Confirmar la transacción
        em.getTransaction().commit();

        Long usuarioId = usuario.getId();

        this.idUsuario = usuarioId;

        mostrarDatosUsuario(usuarioId);
        obtenerNombrePorId(usuarioId);

        for (int i = 0; i < 2; i++) {

        }

        System.out.println("El id del usuario es: " + usuarioId);
        // Cerrar el EntityManager y la fábrica de EntityManager


        /**
         * Esta es una mala practica ya que se esta cerrando el EntityManager solamente
         * cuando hay que hacer un commit
         * de Cierta forma el EntityManager se queda abierto hasta que se haga un commit
         * (En el segundo registro de datos se cierra el EntityManager)
         * y se tiene que cerrar cada que se hace una operacion a la base de datos
         */


        if (em.getTransaction().getRollbackOnly()){
            em.close();
        }


        //Esta es la forma habitual de cerrar el EntityManager
        //em.close();



    }

    public void RegistrarDatosLoginUsuario (
            String email,
            String contraseña,
            String numeroDeTelefono,
            String preguntaDeSeguridad,
            String respuestaDeSeguridad
            //, Long usuarioId // Debes proporcionar el ID del usuario al que deseas asociar los datos de inicio de sesión
    ){

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
        if (email == null){
            //Excepcion por agregar
            throw new RuntimeException();
        }


        //String usuarioAutenticado = BuscarPorNombre(Controller6.getNombre()); // Obtén el usuario autenticado de alguna manera

        // Establece la relación entre JpaClientes y JpaLoginUsuarios
        //loginUsuario.setNombre_usuario(nombreUsuario);

        /*
        String usuarioAutenticado = BuscarPorNombre(Controller4.getCampoNombre());
        loginUsuario.setNombre_usuario(usuarioAutenticado); // Establece el usuario autenticado en la clase JpaLoginUsuarios
        if (usuarioAutenticado == null) {
            throw new RuntimeException("No se encontró el usuario autenticado");
        }

        */



        // Iniciar una transacción
        em.getTransaction().begin();

        // Persistir la entidad en la base de datos

        String nombre_usuario = BuscarPorID(this.idUsuario);

        System.out.println("El nombre de usuario es: " + nombre_usuario);

        loginUsuario.setNombre_usuario(nombre_usuario);



        em.persist(loginUsuario);

        // Confirmar la transacción
        em.getTransaction().commit();



        Long usuarioId = loginUsuario.getId();

        this.idUsuario = usuarioId;
        obtenerNombrePorId(usuarioId);

        // Cerrar el EntityManager y la fábrica de EntityManager


        if(em.getTransaction().getRollbackOnly()){
            em.close();
            // no se si sirve esto xd después lo pruebo
            em.remove(idUsuario);
        }

    }


    public void RegistrarDatosBancariosUsuario (
            //Long numeroDeCuenta,
            String titular,
            double saldo,
            String tipoDeCuenta,
            String firmaUsuario
            //, Long usuarioId // Debes proporcionar el ID del usuario al que deseas asociar los datos de inicio de sesión
    ){

        Cuenta cuenta = new Cuenta();
        numeroDeCuenta = cuenta.setNumeroDeCuenta();

        JpaCuentas cuentasClientes = new JpaCuentas(
                numeroDeCuenta, // Añadido automaticamente
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


        String nombre_usuario = BuscarPorID(this.idUsuario);

        obtenerNombrePorId(this.idUsuario );

        System.out.println("El nombre de usuario es: " + nombre_usuario);

        cuentasClientes.setNombre_usuario(nombre_usuario);

        em.persist(cuentasClientes);

        // Confirmar la transacción
        em.getTransaction().commit();





        // Cerrar el EntityManager y la fábrica de EntityManager


        if(em.getTransaction().getRollbackOnly()){
            // no se si sirve esto xd después lo pruebo
            em.remove(idUsuario);
            em.close();
        }

    }

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
         * controller en especifico
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


    public String BuscarNombrePorTelefono(Pane panel,String numeroDeTelefono) {

        /**
         *
         *   Esto esta desactivado para fines de testeo
         *   ya que si no se carga el controller2
         *   dara error
         *
         *
         */
        //numeroDeTelefono = controller2.getNumeroDeCelular();

        numeroDeTelefono = "11";
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
}
