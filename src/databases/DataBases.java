/*
 * ESTA CLASE SE OCUPARA PARA HACER LA CONEXION
A POSTGRESQL 
 */
package databases;

/**
 *
 *
 */
import java.sql.*;
import javax.swing.*;

public class DataBases {

    Connection conexion = null;
    Statement estatus;
    ResultSet resultado;

    public DataBases(String name, String pass) {
        Conectar(name, pass);
    }

    /*este metodo se usa para conectar a la base de datos*/
    public void Conectar(String nombreUsuario, String contrasenia) {

        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TallerDeBD", nombreUsuario, contrasenia);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo conectar a la base de datos.");
        }
    }

    public Connection RegresaConection() {
        return conexion;
    }

    /*
    *Este metodo se utiliza para desconectar la base de datos...
     */
    public void Desconectar() {
        conexion = null;
    }
}
