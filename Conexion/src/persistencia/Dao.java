package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Dao {

    //Atributos Globales 
    protected Connection conexion = null;// crea una conexion nula a la base de datos
    protected ResultSet resultado = null;
    protected Statement sentencia = null;//Permite crear sentencias mysql

    //Constantes con Datos ncesaria para la conexion con la base
    private final String USUARIO = "root";
    private final String CLAVE = "";
    private final String BASE = "dao";
    private final String DOMINIO = "com.mysql.jdbc.Driver";

    //Metodo para conectarse a la base 
    protected void conectarBase() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(DOMINIO);
            String urlBaseDatos = "jdbc:mysql://localhost:3306/" + BASE + "?useSSl=false";
            conexion = DriverManager.getConnection(urlBaseDatos, USUARIO, CLAVE);
            
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    //Metodo para desconectarse a la base 
    protected void desconectarBase() throws SQLException {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    //metodo para realizar inserciones, eliminar, modificar la base de datos
    protected void insertarEliminarModificar(String consulta) throws ClassNotFoundException, SQLException {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(consulta);

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            desconectarBase();
        }

    }
    
    //Metodo para extraer registros en la base de datos
    protected void consultarBase(String consulta) throws ClassNotFoundException, SQLException {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(consulta);

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            
        }
    }
}
