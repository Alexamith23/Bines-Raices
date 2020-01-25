/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.Archivo_casas;
import Interfaz.CRUD_casa;
import Interfaz.Panel_crear_casa;
import Objetos.Casa;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Samir Portillo
 */
public class LogicaCasas 
{
    Archivo_casas datos = new Archivo_casas();
    private ArrayList <Casa> listaCasas = new ArrayList<>();
    
    public String llenarCasaLogica(Casa casa)
    {
        String res = "";
        if(datos.insertarCasa(casa))
        {
            res = "El registro se hizo de manera exitosa"; 
        }
        else
        {
            res = "El registro no se pudo hacer";
        }
        return res;
    }    

    public void llenarTablaCasas(DefaultTableModel modelo, JTable jTable1) 
    {    
        listaCasas =  datos.sacarCasa();
        modelo.addColumn("Código");
        modelo.addColumn("Cuartos");
        modelo.addColumn("Baños");
        modelo.addColumn("Mes");
        modelo.addColumn("Depósito");
        modelo.addColumn("Provincia");
        modelo.addColumn("Cantón");
        modelo.addColumn("Barrio");
        modelo.addColumn("Dirección");
        for (Casa casa : listaCasas) 
        {
            Object[]home = new Object[9];
            home[0] = casa.getCodigo();
            home[1] = casa.getCantidad_cuartos();
            home[2] = casa.getCantidad_banos();
            home[3] = casa.getPrecio_x_mes();
            home[4] = casa.getDeposito();
            home[5] = casa.getProvincia();
            home[6] = casa.getCanton();
            home[7] = casa.getBarrio();
            home[8] = casa.getDireccion();
            modelo.addRow(home);
        }
        jTable1.setModel(modelo);
    }


    public void llenar(String codigo, JTextField jTextFieldCuartos, JTextField jTextFieldBanos2, JTextField jTextFieldMes2, JTextField jTextFieldDepo2, JTextField jTextFieldProvi2, JTextField jTextFieldCanton2, JTextField jTextFieldBarrio2, JTextField jTextFieldDireccion2,JCheckBox jCheckBoxCochera2, JCheckBox jCheckBoxPatio2, JCheckBox jCheckBoxAmueblado2, JCheckBox jCheckBoxAgua2, JCheckBox jCheckBoxLuz2, JCheckBox jCheckBoxInternet2, JCheckBox jCheckBoxCable2) 
    {
        listaCasas =  datos.sacarCasa();
        for (Casa casas : listaCasas) 
        {
            if(casas.getCodigo().equals(codigo))
            {
                jTextFieldCuartos.setText(String.valueOf(casas.getCantidad_cuartos()));
                jTextFieldBanos2.setText(String.valueOf(casas.getCantidad_banos()));
                jTextFieldMes2.setText(String.valueOf(casas.getPrecio_x_mes()));
                jTextFieldDepo2.setText(String.valueOf(casas.getDeposito()));               
                jTextFieldProvi2.setText(casas.getProvincia());
                jTextFieldCanton2.setText(casas.getCanton());
                jTextFieldBarrio2.setText(casas.getBarrio());
                jTextFieldDireccion2.setText(casas.getDireccion());                
                jCheckBoxCochera2.setSelected(casas.isCochera());
                jCheckBoxPatio2.setSelected(casas.isPatio());
                jCheckBoxAmueblado2.setSelected(casas.isAmueblado());
                jCheckBoxAgua2.setSelected(casas.isAgua());
                jCheckBoxLuz2.setSelected(casas.isLuz());
                jCheckBoxInternet2.setSelected(casas.isInternet());
                jCheckBoxCable2.setSelected(casas.isCable());             
            }
        }
    }

    public String modificar(Casa casa,String cod) 
    {
        String res = "";
        if(datos.editarCasaDados(casa,cod))
        {
            res = "Se modificó con exito";
        }
        else
        {
            res = "No se pudo modificar";
        }
        return res;
    }

    public String eliminarCasa(String valor) 
    {
        String res = "";
        if(valor.equals(""))
        {
            res = "Por favor seleccione una casa";
        }
        else
        {
            
            int pregunta = Integer.parseInt(JOptionPane.showInputDialog(null,"Desea borrar de forma permanente la casa "+valor+"\n"
                    + "1. Si\n"
                    + "2. No","Eliminar",JOptionPane.WARNING_MESSAGE));
            if(pregunta == 1)
            {
                if(datos.eliminarCasa(valor))
                {
                    res = "Se eliminó con exito";
                }
                else
                {
                    res = "No se pudo eliminar";
                }
                
            }
            else
            {
                res = "Ok";
            }
            
        }
        return res;     
    }

    public String verMas(String valor) 
    {
        String res = "";
        
        
        return res;     
    }

    public String verMas(String valor, JCheckBox jCheckBox1, JCheckBox jCheckBox2, JCheckBox jCheckBox3, JCheckBox jCheckBox4, JCheckBox jCheckBox5, JCheckBox jCheckBox6, JCheckBox jCheckBox7) 
    {
        listaCasas =  datos.sacarCasa();
        String res = "";
        if(valor.equals(""))
        {
            res = "Por favor selecione una casa para poder ver su informacion adicional";
        }
        else
        {
            for (Casa casas : listaCasas) 
            {
                if(casas.getCodigo().equals(valor))
                    {                            
                        jCheckBox1.setSelected(casas.isCochera());
                        jCheckBox2.setSelected(casas.isPatio());
                        jCheckBox3.setSelected(casas.isAmueblado());
                        jCheckBox4.setSelected(casas.isAgua());
                        jCheckBox5.setSelected(casas.isLuz());
                        jCheckBox6.setSelected(casas.isInternet());
                        jCheckBox7.setSelected(casas.isCable());             
                    }
            }
        }
         
         return res;
    }
}
