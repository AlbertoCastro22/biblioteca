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
import java.util.ArrayList;
import java.util.List;
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
    public List<Object []> mostrarDatos(String sql)
        
{
    List <Object []> datos = new ArrayList<Object []>();
    //datos[][]= new String [20][4];
    try
    {   
        Statement ps = RegresaConection().createStatement();
        //PreparedStatement ps = getConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);
        //rs.first();
        
        while(rs.next())
        {
            String dat[]= new String [5];
            dat[0]= String.valueOf(rs.getInt(1));
            dat[1]=rs.getString(2);
            dat[2]=rs.getString(3);          
            dat[3]=String.valueOf(rs.getDate(4));          
            dat[4]=rs.getString(5);          
         
            datos.add(dat);
        }
    
    }
    catch(Exception e)
    {
        System.err.println("Error En Tablas  " +e);
    }
    return datos;
}
    /*
    *Este metodo se utiliza para desconectar la base de datos...
     */
    public void Desconectar() {
        conexion = null;
    }
}
