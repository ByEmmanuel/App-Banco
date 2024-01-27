package Tests;



import DAO.ClientesDAO;
import DAO.OperacionesDAO;
import PersistenceJPA.JpaUtils;
import PersistenceJPA.JpaClientes;
import jakarta.persistence.EntityManager;
import javafx.scene.layout.Pane;

/**
 * Esta clase sera para hacer pruebas directo con la base de datos
 */
public class PruebasBaseDeDatos  {



    public static void main(String[] args) {
/*
        //Este metodo esta asi ya que me permite llamar a la funcion de buscar
        // usuario por numero
        PruebaPanes pruebaPanes = new PruebaPanes();
        buscarUsuarioPorNumero(pruebaPanes.getRoot());
*/

        //eliminarDeLaBaseDedatos();

        /*

        Cuenta cuenta = new Cuenta();
        System.out.println("El numero de tarjeta es; " + cuenta.setNumeroDeCuenta());

        */
        /*
        ClientesDAO clientesDAO = new ClientesDAO();
        clientesDAO.RegistrarDatosBancariosUsuario("Admin", 199, "Ahorro", "miFirma");
         */

        //registrarTodoUnUsuario();
        
        PruebaPanes pruebaPanes = new PruebaPanes();
        //depositar(pruebaPanes.getRoot());
        transferir(pruebaPanes.getRoot());
        
        //OperacionesDAO operacionesDAO = new OperacionesDAO();
        //operacionesDAO.BuscarUsuarioPorNumeroDeCuenta("123456789012345678");
        //operacionesDAO.depositarPruebaDos("0401001790222831", 9);
    }

    private static void buscarUsuarioPorNumero(Pane pane){

        ClientesDAO clientesDAO = new ClientesDAO();
        String nombre = clientesDAO.BuscarNombrePorTelefono(pane,"11111111111");

        System.out.printf("El nombre buscado es: " + nombre);



    }

    public static void registrarUsuario(){

        JpaClientes cliente = new JpaClientes();

        cliente.setNombre("a");
        cliente.setPrimerApellido("a");
        cliente.setSegundoApellido("a");
        cliente.setNacionalidad("a");
        cliente.setFechaDeNacimiento("1/1/99");
        cliente.setEstadoDondeNacio("a");



        //JpaLoginUsuarios loginUsuario = new JpaLoginUsuarios();
        //cliente.setLoginUsuario(loginUsuario);
        //Long idCliente2 = loginUsuario.getId();
        //System.out.println("El id del cliente es: " + idCliente2);




        EntityManager em = JpaUtils.getEntityManager();

        em.getTransaction().begin();
        em.persist(cliente);

        Long obtenerId = cliente.getId();
        System.out.println("El id del cliente es: " + obtenerId);

        em.getTransaction().commit();
    }

    private static void eliminarDeLaBaseDedatos(){

        ClientesDAO clientesDAO = new ClientesDAO();


        String usuario = clientesDAO.BuscarPorID(3L);


        EntityManager em = JpaUtils.getEntityManager();
        //em.remove();

    }

    private static void registrarTodoUnUsuario(){
        ClientesDAO clientesDAO = new ClientesDAO();
        clientesDAO.RegistrarDatosUsuario("Nombre", "Apellido1", "Apellido2", "Nacionalidad", "Fecha", "Estado");
        clientesDAO.RegistrarDatosLoginUsuario("Email", "Contraseña", "Telefono", "Pregunta", "Respuesta");
        clientesDAO.RegistrarDatosBancariosUsuario("", 123, "Ahorro", "Firma");
    }

    private static void depositar(Pane pane){
        OperacionesDAO operacionesDAO = new OperacionesDAO();
        operacionesDAO.Depositar("1000545",200);
        //operacionesDAO.depositarPrueba("1000545", 200);

    }

    private static void transferir(Pane pane){
        OperacionesDAO operacionesDAO = new OperacionesDAO();
        //operacionesDAO.transferir(pane,"", "", 200);
        operacionesDAO.transferir(pane,"", "", 200);
    }
    private static void transferir(Pane pane,String numeroDeCuentaOrigen,String numeroDeCuentaDestino,double cantidad){
        OperacionesDAO operacionesDAO = new OperacionesDAO();
        //operacionesDAO.transferir(pane,"", "", 200);
        operacionesDAO.transferirDOS(pane,numeroDeCuentaOrigen, numeroDeCuentaDestino, cantidad);
    }
    private static void transferir(Pane pane,String numeroDeCuentaOrigen,String numeroDeCuentaDestino,double cantidad,boolean prueba){
        OperacionesDAO operacionesDAO = new OperacionesDAO();
        //operacionesDAO.transferir(pane,"", "", 200);
        operacionesDAO.transferirDOS(pane,numeroDeCuentaOrigen, numeroDeCuentaDestino, cantidad,prueba);
    }

}
