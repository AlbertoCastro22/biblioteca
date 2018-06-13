/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlMulta;

import databases.DataBases;
import java.io.File;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usersone
 */
public class ModeloTable extends AbstractTableModel{
        private String encabezados[] = new String[] { 
     "ID_AUTOR", "NOMBRE", "APELLIDOS","FECHA","NACIONALIDAD"};
    
    private Class tipos[] = new Class[] { Integer.class,
    String.class, Integer.class,String.class,String.class};
     private Object [][] datos;
     
     
   
    public ModeloTable(List<Object[]> d) {
    
    actualizaEstatus(d);
  }


  // implementa los metodos de la interface TableModel
  // solo los metodos getRowCount( ), getColumnCount( ),y  getValueAt( ) son requeridos
  public int getRowCount( ) { return datos.length; }
  public int getColumnCount( ) { return encabezados.length; }
  public String getColumnName(int c) { return encabezados[c]; }
  public Class getColumnClass(int c) { return tipos[c]; }
  public Object getValueAt(int r, int c) { return datos[r][c]; }
  
  
  // metodo que llena a los datos
  
  public void setValueAt(Object d, int r,int c)
  { datos[r][c]=d;
          
  }
 
    // metodo que llena a los datos
  public void actualizaEstatus(List<Object []> da) {
     
       datos= new Object [da.size()+1][encabezados.length];
      
     
      for(int i=0;i<da.size();i++)
      {    datos[i][0]=da.get(i)[0];
           datos[i][1]=da.get(i)[1];
           datos[i][2]=da.get(i)[2];
           datos[i][3]=da.get(i)[3];
           datos[i][4]=da.get(i)[4];
           
      }
      
  fireTableDataChanged();
          
  }  
  
  
  
  public boolean isCellEditable(int r,int c)
  {  if(c==2)
        return true;
    
    return false;
  
  }
  //Actualiza Los datos De la Persona en la base de datos
  
    
  public static void main(String [] args)
  { DataBases db = new DataBases("postgres", "08512164");
    ModeloTable m = new ModeloTable(db.mostrarDatos("Select * from biblioteca.autor"));
    for(int i=0;i<m.getRowCount();i++)   
    { System.out.println(m.getValueAt(i, 0));
      System.out.println(m.getValueAt(i, 1));
      System.out.println(m.getValueAt(i, 2));
      System.out.println(m.getValueAt(i, 3));
      System.out.println(m.getValueAt(i, 4));
    }
  }
      
}
